package com.example.ATM_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ATM_System.Atm.ATM;
import com.example.ATM_System.Dto.AtmDto;
import com.example.ATM_System.service.atmService;

@RestController
@RequestMapping("/Atm")
public class atmController {
	  @Autowired
      private atmService atmservice;
      
	  // Getting all account details
      @GetMapping("/getamount")
      public List<ATM> getcash(){
    	  return atmservice.getAmount();
      }
      
      // withdraw the amount single account
      @PostMapping("/withdraw/{id}")
      public ATM getcashid(@PathVariable Long id,@RequestParam double balance){
    	  return atmservice.getwithdraw(id,balance);
      }
      
      
      // deposit the amount single account
      @PostMapping("/deposit/{id}")
      public ATM getdeposit(@PathVariable Long id,@RequestParam double balance){
    	  return atmservice.getdeposit(id,balance);
      }
      
      
      
      
      // Enter the pin then went to post or get method
      @PostMapping("/login")
      public String getpin(@RequestBody AtmDto atmdto){
    	  return atmservice.verifyPin(atmdto.getId(),atmdto.getPin());
      }
      
      
      // create a new account
      @PostMapping("/create")
      public ATM addcash(@RequestBody ATM atm) {
    	  return atmservice.addNew(atm);
      }
      
      // Update a single account details
      @PatchMapping("/{id}")
      public ATM updateAccount(@PathVariable Long id,@RequestBody ATM atm) {
    	  return atmservice.updateAccount(id,atm);
      }
      
      //un-block the account 
      @PostMapping("/unblock/{id}")
      public String Unlock(@PathVariable Long id) {
    	  return atmservice.UnBlock(id);
      }
}
