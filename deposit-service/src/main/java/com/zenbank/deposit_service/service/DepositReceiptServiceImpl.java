package com.zenbank.deposit_service.service;

import java.io.File;
import java.nio.file.Path;
import java.util.Optional;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.time.LocalDateTime;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import com.zenbank.deposit_service.entity.DepositReceipt;
import com.zenbank.deposit_service.entity.DepositTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.zenbank.deposit_service.dto.DepositReceiptResponseDto;
import com.zenbank.deposit_service.exception.DepositReceiptNotFound;
import com.zenbank.deposit_service.repository.DepositReceiptRepository;
import com.zenbank.deposit_service.repository.DepositTransactionRepository;
import com.zenbank.deposit_service.exception.DepositTransactionFailedException;
import com.zenbank.deposit_service.exception.ReceiptAlreadyGeneratedException;


//DepositReceipt

@Service
public class DepositReceiptServiceImpl implements IDepositReceiptService {

	@Autowired
	private DepositReceiptRepository depositReceiptRepository;

	@Autowired
	private DepositTransactionRepository depositTransactionRepository;

	@Override
	public DepositReceiptResponseDto createDepositReceipt(Long depositId) throws Exception {

		// Step 1 : Validate Deposit Transaction

		DepositTransaction transaction = depositTransactionRepository.findById(depositId)
				.orElseThrow(() -> new DepositReceiptNotFound("Deposit transaction not found."));

		// Step 2 : Check Transaction Status

		if (!"SUCCESS".equalsIgnoreCase(transaction.getTransactionStatus())) {

			throw new DepositTransactionFailedException("Receipt can be generated only for successful transactions.");
		}

		// Step 3 : Check Receipt Already Generated

		Optional<DepositReceipt> existingReceipt = depositReceiptRepository
				.findByDepositTransactionDepositId(depositId);

		if (existingReceipt.isPresent()) {

			throw new ReceiptAlreadyGeneratedException("Receipt already generated for this transaction.");
		}

		// Step 4 : Generate Receipt Number

		String receiptNumber = generateReceiptNumber();

		// Step 5 : Create Receipt Entity

		DepositReceipt receipt = new DepositReceipt();

		receipt.setReceiptNumber(receiptNumber);
		receipt.setGeneratedDate(LocalDateTime.now());

		receipt.setContent("Deposit Receipt");

		receipt.setDepositTransaction(transaction);

		// Step 6 : Generate PDF

		String filePath = generateReceiptPdf(transaction, receipt);

		receipt.setFilePath(filePath);
		System.out.println("Generated File Path = " + filePath);
		
		System.out.println("PDF Absolute Path = "
		        + new File(filePath).getAbsolutePath());

		// Step 7 : Save Receipt

		DepositReceipt savedReceipt = depositReceiptRepository.save(receipt);

		// Step 8 : Update Deposit Transaction

		transaction.setDepositReceipt(savedReceipt);

		depositTransactionRepository.save(transaction);

		// Step 9 : Return DTO

		return DepositReceiptResponseDto.fromEntity(savedReceipt, transaction);

	}

	@Override
	public byte[] downloadReceipt(Long depositId) throws IOException {

		// 1. Validate deposit

		DepositTransaction transaction = depositTransactionRepository.findById(depositId)
				.orElseThrow(() -> new DepositReceiptNotFound("Deposit transaction not found."));

		// 2. Find receipt

		DepositReceipt receipt = depositReceiptRepository.findByDepositTransactionDepositId(depositId)
				.orElseThrow(() -> new DepositReceiptNotFound("Receipt has not been generated."));

		// 3. Get PDF location

		String filePath = receipt.getFilePath();

		if (filePath == null) {

			throw new DepositReceiptNotFound("Receipt file not available.");

		}

		// 4. Read PDF

		Path path = Paths.get(filePath);

		return Files.readAllBytes(path);

	}

	private String generateReceiptNumber() {

		return "RCP" + System.currentTimeMillis();
	}

	private String generateReceiptPdf(DepositTransaction transaction, DepositReceipt receipt) throws Exception {

		String folder = "receipts";

		File directory = new File(folder);

		if (!directory.exists()) {
			directory.mkdirs();
		}

		String filePath = folder + File.separator + receipt.getReceiptNumber() + ".pdf";

		Document document = new Document();

		PdfWriter.getInstance(document, new FileOutputStream(filePath));

		document.open();

		document.add(new Paragraph("                ZEN DIGITAL BANK"));
		document.add(new Paragraph(" "));
		document.add(new Paragraph("Deposit Transaction Receipt"));
		document.add(new Paragraph("------------------------------------------------"));

		document.add(new Paragraph("Receipt Number      : " + receipt.getReceiptNumber()));

		document.add(new Paragraph("Transaction Ref     : " + transaction.getTransactionReference()));

		document.add(new Paragraph("Customer ID         : " + transaction.getCustomerId()));

		document.add(new Paragraph("Account ID          : " + transaction.getAccountId()));

		document.add(new Paragraph("Deposit Type        : " + transaction.getDepositType().getTypeName()));

		document.add(new Paragraph("Deposit Amount      : ₹" + transaction.getAmount()));

		document.add(new Paragraph("Transaction Status  : " + transaction.getTransactionStatus()));

		document.add(new Paragraph("Branch              : " + transaction.getBranchName()));

		document.add(new Paragraph("Transaction Date    : " + transaction.getTransactionDate()));

		document.add(new Paragraph("Generated On        : " + receipt.getGeneratedDate()));

		document.add(new Paragraph("------------------------------------------------"));
		document.add(new Paragraph("Thank You For Banking With Us"));

		document.close();

		return filePath;
	}
		
}