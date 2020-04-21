package com.ytj.mybatisgenerator.model;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String companyCode;

    private String orderContact;

    private String companyName;

    private String orderContactNumber;

    private String orderConsigneeAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getOrderContact() {
        return orderContact;
    }

    public void setOrderContact(String orderContact) {
        this.orderContact = orderContact == null ? null : orderContact.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getOrderContactNumber() {
        return orderContactNumber;
    }

    public void setOrderContactNumber(String orderContactNumber) {
        this.orderContactNumber = orderContactNumber == null ? null : orderContactNumber.trim();
    }

    public String getOrderConsigneeAddress() {
        return orderConsigneeAddress;
    }

    public void setOrderConsigneeAddress(String orderConsigneeAddress) {
        this.orderConsigneeAddress = orderConsigneeAddress == null ? null : orderConsigneeAddress.trim();
    }

    public enum Column {
        id("id", "id", "INTEGER", false),
        username("username", "username", "VARCHAR", false),
        password("password", "password", "VARCHAR", false),
        companyCode("company_code", "companyCode", "VARCHAR", false),
        orderContact("order_contact", "orderContact", "VARCHAR", false),
        companyName("company_name", "companyName", "VARCHAR", false),
        orderContactNumber("order_contact_number", "orderContactNumber", "VARCHAR", false),
        orderConsigneeAddress("order_consignee_address", "orderConsigneeAddress", "VARCHAR", false);

        private static final String BEGINNING_DELIMITER = "\"";

        private static final String ENDING_DELIMITER = "\"";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}