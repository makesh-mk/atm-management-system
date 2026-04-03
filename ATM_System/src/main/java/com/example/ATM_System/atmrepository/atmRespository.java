package com.example.ATM_System.atmrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ATM_System.Atm.ATM;

public interface atmRespository extends JpaRepository<ATM, Long> {


}
