
package com.zenbank.cilm.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_address")
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId ;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	@JsonBackReference
	private Customer customer;

	@Enumerated(EnumType.STRING)
    @Column(name = "address_type", nullable = false)
    private AddressType addressType;
    
    @Column(name = "door_number", nullable = false)
    private String doorNumber;
    
    @Column(name = "street", nullable = false)
    private String street;
    
    @Column(name = "area", nullable = false)
    private String area;
    
    @Column(name = "city", nullable = false)
    private String city;
    
    @Column(name = "district", nullable = false)
    private String district;
    
    @Column(name = "state", nullable = false)
    private String state;
    
    @Column(name = "country", nullable = false)
    private String country;
    
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
    
    @Column(name = "is_primary", nullable = false)
    private Boolean isPrimary ;

	public CustomerAddress() {
		super();
	}

	public CustomerAddress(Long addressId, Customer customer, AddressType addressType, String doorNumber, String street,
			String area, String city, String district, String state, String country, String postalCode,
			Boolean isPrimary) {
		super();
		this.addressId = addressId;
		this.customer = customer;
		this.addressType = addressType;
		this.doorNumber = doorNumber;
		this.street = street;
		this.area = area;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.isPrimary = isPrimary;
	}

	public Long getAddressId() {

		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getDoorDumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

}