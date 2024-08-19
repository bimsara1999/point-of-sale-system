package com.springbootacademy.batch7.pos.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "cutomer")
@TypeDefs({
        @TypeDef( name = "json" , typeClass = JsonType.class)
})

public class Customer {

    @Id
    @Column(name = "customer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name" , length = 100 , nullable = false)
    private String customerName;

    @Column(name = "customer_address" , length = 255)
    private String customerAddress;


    @Type(type = "json")
    @Column(name = "contact_numbers", columnDefinition = "json")
      private ArrayList contactNumber;

    @Column(name = "nic")
    private String nic;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Column(name = "active_state" , columnDefinition = "TINYINT default 0")
    private  boolean active;

    public Customer(){


    }


    public Customer(int customerId, boolean active, String nic, ArrayList contactNumber,double customerSalary, String customerAddress, String customerName) {
        this.customerId = customerId;
        this.active = active;
        this.nic = nic;
        this.contactNumber = contactNumber;
        this.customerAddress = customerAddress;
        this.customerName = customerName;
        this.customerSalary = customerSalary;

    }



    public int getCustomerId() {
        return customerId;
    }

    public boolean isActive() {
        return active;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public String getNic() {
        return nic;
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumber=" + contactNumber +
                ", nic='" + nic + '\'' +
                ", customerSalary=" + customerSalary +
                ", active=" + active +
                '}';
    }
}
