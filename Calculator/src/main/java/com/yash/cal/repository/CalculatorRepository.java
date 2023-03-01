package com.yash.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.cal.entity.Calculator;

public interface CalculatorRepository extends JpaRepository<Calculator, Integer>{

}
