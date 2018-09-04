package com.cg.mypaymentapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.mypaymentapp.beans.Customer;

@Controller
public class URIController {

	@RequestMapping(value="/")
	public String getIndexPage(){
		return "indexPage";
	}

	@RequestMapping(value="/login")
	public String getLoginPage()
	{
		return "loginPage";
	}

	@RequestMapping(value="/registration")
	public String getRegistrationPage()
	{
		return "registrationPage";
	}


	@RequestMapping(value="/deposit")
	public String getDepositPage()
	{
		return "depositAmount";
	}

	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}

}
