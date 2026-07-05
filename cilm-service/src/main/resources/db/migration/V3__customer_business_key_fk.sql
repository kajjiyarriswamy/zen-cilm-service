-- Convert child-table foreign keys from customer primary key to customer.business key.
-- Target shape:
--   customer.customer_id          = business key (VARCHAR)
--   child_table.customer_id       = FK to customer.customer_id

-- customer_contact
SET @fk_name := (
    SELECT CONSTRAINT_NAME
    FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
    WHERE TABLE_SCHEMA = DATABASE()
      AND TABLE_NAME = 'customer_contact'
      AND COLUMN_NAME = 'customer_pk_id'
      AND REFERENCED_TABLE_NAME = 'customer'
    LIMIT 1
);
SET @sql := IF(
    @fk_name IS NULL,
    'SELECT 1',
    CONCAT('ALTER TABLE `customer_contact` DROP FOREIGN KEY `', @fk_name, '`')
);
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

ALTER TABLE `customer_contact`
    ADD COLUMN `customer_id_new` VARCHAR(20) NULL;

UPDATE `customer_contact` cc
JOIN `customer` c ON c.id = cc.customer_pk_id
SET cc.customer_id_new = c.customer_id;

ALTER TABLE `customer_contact`
    DROP COLUMN `customer_pk_id`;

ALTER TABLE `customer_contact`
    CHANGE COLUMN `customer_id_new` `customer_id` VARCHAR(20) NOT NULL;

ALTER TABLE `customer_contact`
    ADD CONSTRAINT `fk_customer_contact_customer`
    FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`);

-- customer_address
SET @fk_name := (
    SELECT CONSTRAINT_NAME
    FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
    WHERE TABLE_SCHEMA = DATABASE()
      AND TABLE_NAME = 'customer_address'
      AND COLUMN_NAME = 'customer_pk_id'
      AND REFERENCED_TABLE_NAME = 'customer'
    LIMIT 1
);
SET @sql := IF(
    @fk_name IS NULL,
    'SELECT 1',
    CONCAT('ALTER TABLE `customer_address` DROP FOREIGN KEY `', @fk_name, '`')
);
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

ALTER TABLE `customer_address`
    ADD COLUMN `customer_id_new` VARCHAR(20) NULL;

UPDATE `customer_address` ca
JOIN `customer` c ON c.id = ca.customer_pk_id
SET ca.customer_id_new = c.customer_id;

ALTER TABLE `customer_address`
    DROP COLUMN `customer_pk_id`;

ALTER TABLE `customer_address`
    CHANGE COLUMN `customer_id_new` `customer_id` VARCHAR(20) NOT NULL;

ALTER TABLE `customer_address`
    ADD CONSTRAINT `fk_customer_address_customer`
    FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`);

-- customer_audit
SET @fk_name := (
    SELECT CONSTRAINT_NAME
    FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
    WHERE TABLE_SCHEMA = DATABASE()
      AND TABLE_NAME = 'customer_audit'
      AND COLUMN_NAME = 'customer_pk_id'
      AND REFERENCED_TABLE_NAME = 'customer'
    LIMIT 1
);
SET @sql := IF(
    @fk_name IS NULL,
    'SELECT 1',
    CONCAT('ALTER TABLE `customer_audit` DROP FOREIGN KEY `', @fk_name, '`')
);
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

ALTER TABLE `customer_audit`
    ADD COLUMN `customer_id_new` VARCHAR(20) NULL;

UPDATE `customer_audit` ca
JOIN `customer` c ON c.id = ca.customer_pk_id
SET ca.customer_id_new = c.customer_id;

ALTER TABLE `customer_audit`
    DROP COLUMN `customer_pk_id`;

ALTER TABLE `customer_audit`
    CHANGE COLUMN `customer_id_new` `customer_id` VARCHAR(20) NOT NULL;

ALTER TABLE `customer_audit`
    ADD CONSTRAINT `fk_customer_audit_customer`
    FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`);

-- customer_document
SET @fk_name := (
    SELECT CONSTRAINT_NAME
    FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
    WHERE TABLE_SCHEMA = DATABASE()
      AND TABLE_NAME = 'customer_document'
      AND COLUMN_NAME = 'customer_pk_id'
      AND REFERENCED_TABLE_NAME = 'customer'
    LIMIT 1
);
SET @sql := IF(
    @fk_name IS NULL,
    'SELECT 1',
    CONCAT('ALTER TABLE `customer_document` DROP FOREIGN KEY `', @fk_name, '`')
);
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

ALTER TABLE `customer_document`
    ADD COLUMN `customer_id_new` VARCHAR(20) NULL;

UPDATE `customer_document` cd
JOIN `customer` c ON c.id = cd.customer_pk_id
SET cd.customer_id_new = c.customer_id;

ALTER TABLE `customer_document`
    DROP COLUMN `customer_pk_id`;

ALTER TABLE `customer_document`
    CHANGE COLUMN `customer_id_new` `customer_id` VARCHAR(20) NOT NULL;

ALTER TABLE `customer_document`
    ADD CONSTRAINT `fk_customer_document_customer`
    FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`);

-- customers_kyc
SET @fk_name := (
    SELECT CONSTRAINT_NAME
    FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
    WHERE TABLE_SCHEMA = DATABASE()
      AND TABLE_NAME = 'customers_kyc'
      AND COLUMN_NAME = 'customer_pk_id'
      AND REFERENCED_TABLE_NAME = 'customer'
    LIMIT 1
);
SET @sql := IF(
    @fk_name IS NULL,
    'SELECT 1',
    CONCAT('ALTER TABLE `customers_kyc` DROP FOREIGN KEY `', @fk_name, '`')
);
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

ALTER TABLE `customers_kyc`
    ADD COLUMN `customer_id_new` VARCHAR(20) NULL;

UPDATE `customers_kyc` ck
JOIN `customer` c ON c.id = ck.customer_pk_id
SET ck.customer_id_new = c.customer_id;

ALTER TABLE `customers_kyc`
    DROP COLUMN `customer_pk_id`;

ALTER TABLE `customers_kyc`
    CHANGE COLUMN `customer_id_new` `customer_id` VARCHAR(20) NOT NULL;

ALTER TABLE `customers_kyc`
    ADD CONSTRAINT `fk_customers_kyc_customer`
    FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`);

-- customer_nominee
SET @fk_name := (
    SELECT CONSTRAINT_NAME
    FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
    WHERE TABLE_SCHEMA = DATABASE()
      AND TABLE_NAME = 'customer_nominee'
      AND COLUMN_NAME = 'customer_pk_id'
      AND REFERENCED_TABLE_NAME = 'customer'
    LIMIT 1
);
SET @sql := IF(
    @fk_name IS NULL,
    'SELECT 1',
    CONCAT('ALTER TABLE `customer_nominee` DROP FOREIGN KEY `', @fk_name, '`')
);
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

ALTER TABLE `customer_nominee`
    ADD COLUMN `customer_id_new` VARCHAR(20) NULL;

UPDATE `customer_nominee` cn
JOIN `customer` c ON c.id = cn.customer_pk_id
SET cn.customer_id_new = c.customer_id;

ALTER TABLE `customer_nominee`
    DROP COLUMN `customer_pk_id`;

ALTER TABLE `customer_nominee`
    CHANGE COLUMN `customer_id_new` `customer_id` VARCHAR(20) NOT NULL;

ALTER TABLE `customer_nominee`
    ADD CONSTRAINT `fk_customer_nominee_customer`
    FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`);

-- customer_preferences
SET @fk_name := (
    SELECT CONSTRAINT_NAME
    FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
    WHERE TABLE_SCHEMA = DATABASE()
      AND TABLE_NAME = 'customer_preferences'
      AND COLUMN_NAME = 'customer_pk_id'
      AND REFERENCED_TABLE_NAME = 'customer'
    LIMIT 1
);
SET @sql := IF(
    @fk_name IS NULL,
    'SELECT 1',
    CONCAT('ALTER TABLE `customer_preferences` DROP FOREIGN KEY `', @fk_name, '`')
);
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

ALTER TABLE `customer_preferences`
    ADD COLUMN `customer_id_new` VARCHAR(20) NULL;

UPDATE `customer_preferences` cp
JOIN `customer` c ON c.id = cp.customer_pk_id
SET cp.customer_id_new = c.customer_id;

ALTER TABLE `customer_preferences`
    DROP COLUMN `customer_pk_id`;

ALTER TABLE `customer_preferences`
    CHANGE COLUMN `customer_id_new` `customer_id` VARCHAR(20) NOT NULL;

ALTER TABLE `customer_preferences`
    ADD CONSTRAINT `fk_customer_preferences_customer`
    FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`);
