package com.example.ATM_System.Atm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class ATM {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  private String user_name;
  private int acc_num;
  private double balance;
  
  private boolean isblocked;
  private int attempt;
  
  private String pin;
  
  public Long getId() {
	return Id;
  }
  public void setId(Long id) {
	Id = id;
  }
  public String getUser_name() {
	return user_name;
  }
  public void setUser_name(String user_name) {
	this.user_name = user_name;
  }
  public int getAcc_num() {
	return acc_num;
  }
  public void setAcc_num(int acc_num) {
	this.acc_num = acc_num;
  }
  public double getBalance() {
	return balance;
  }
  public void setBalance(double balance) {
	this.balance = balance;
  }
  public boolean isIsblocked() {
	return isblocked;
  }
  public void setIsblocked(boolean isblocked) {
	this.isblocked = isblocked;
  }
  public int getAttempt() {
	return attempt;
  }
  public void setAttempt(int attempt) {
	this.attempt = attempt;
  }
  public String getPin() {
	return pin;
  }
  public void setPin(String pin) {
	this.pin = pin;
  }

  
  
}
