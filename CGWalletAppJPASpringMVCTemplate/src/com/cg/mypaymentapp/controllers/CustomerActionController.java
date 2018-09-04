package com.cg.mypaymentapp.controllers;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.service.WalletService;

@Controller
public class CustomerActionController {

	@Autowired
	private WalletService walletServices;

	@RequestMapping(value="/registerCustomer")
	public ModelAndView registerCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult result){
		try {
			if(result.hasErrors())return new ModelAndView("registrationPage");
			customer = walletServices.createAccount(customer);
		} catch (Exception e) {
			return new ModelAndView("errorPage");
		}
		return new ModelAndView("registrationSuccessPage", "customer", customer);
	}

	@RequestMapping(value="/getCustomer")
	public ModelAndView getCustomer(@ModelAttribute("customer")Customer customer, BindingResult result){

		try {
			if(result.hasErrors())return new ModelAndView("loginPage");
			customer = walletServices.showBalance(customer.getMobileNo());
		} catch (Exception e) {
			return new ModelAndView("errorPage");
		}
		return new ModelAndView("loginSuccessPage","customer", customer);
	}

	@RequestMapping(value="/depositAmount")
	public ModelAndView depositAmount(@RequestParam("mobileNo")String mobileNo, @RequestParam("amount")BigDecimal amount){


		//			if(result.hasErrors())return new ModelAndView("depositAmount");
		Customer customer = walletServices.depositAmount(mobileNo, amount);

		return new ModelAndView("depositSuccessPage","customer", customer);
	}

}
