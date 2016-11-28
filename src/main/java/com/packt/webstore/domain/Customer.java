package com.packt.webstore.domain;


import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "user", schema = "webstore")
public class Customer implements Serializable {

    @Transient
    private static final long  serialVersionUID =
            2284040482222162898L;

    @Id
    @GeneratedValue
    private int userID;
    @Transient
    private String customerId;
    private String name;
    @Embedded
    private Address billingAddress;
    private String phoneNumber;
    //private boolean noOrdersMade;
    private String email;



    public Customer() {
        super();
        this.billingAddress = new Address("1","20","3","4","5","6");
    }

    public Customer(String customerId, String name) {
        this();
        this.customerId = customerId;
        this.name = name;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public boolean isNoOrdersMade() {
        return noOrdersMade;
    }*/

    /*public void setNoOrdersMade(boolean noOrdersMade) {
        this.noOrdersMade = noOrdersMade;
    }*/

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customers name: " + name + ", address: " + billingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return getCustomerId().equals(customer.getCustomerId());
    }

    @Override
    public int hashCode() {
        int result = getCustomerId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getBillingAddress().hashCode();
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        //result = 31 * result + (isNoOrdersMade() ? 1 : 0);
        return result;
    }
}
