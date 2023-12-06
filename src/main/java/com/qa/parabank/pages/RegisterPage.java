package com.qa.parabank.pages;

import com.microsoft.playwright.Page;
import com.qa.parabank.TestObjects.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RegisterPage extends BasePage{

    private String fName = "#customer\\.firstName";
    private String lName = "#customer\\.lastName";
    private String address = "#customer\\.address\\.street";
    private String city = "#customer\\.address\\.city";
    private String state = "#customer\\.address\\.state";
    private String zipcode = "#customer\\.address\\.zipCode";
    private String phonenum = "#customer\\.phoneNumber";
    private String ssn = "#customer\\.ssn";
    private String username = "#customer\\.username";
    private String password = "#customer\\.password";
    private String reppassword = "#repeatedPassword";
    private String regBtn = "input[value='Register']";
    private String sccsmessage = "h1[class='title']";
    private String userEnding = UUID.randomUUID().toString().substring(0, 8);

    public RegisterPage(Page page) {
        super(page);
    }

    public void registerUser(Customer customer){
        page.locator(this.fName).fill(customer.getFirstName());
        page.locator(this.lName).fill(customer.getLastName());
        page.locator(this.address).fill(customer.getAddress());
        page.locator(this.city).fill(customer.getCity());
        page.locator(this.state).fill(customer.getState());
        page.locator(this.zipcode).fill(customer.getZipcode());
        page.locator(this.phonenum).fill(customer.getPhonenum());
        page.locator(this.ssn).fill(customer.getSsn());
        page.locator(this.username).fill(customer.getUsername()+userEnding);
        page.locator(this.password).fill(customer.getPassword());
        page.locator(this.reppassword).fill(customer.getPassword());
        page.locator(this.regBtn).click();
    }

}
