package com.yash.cal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.cal.entity.Calculator;
import com.yash.cal.repository.CalculatorRepository;

@Service
public class CalculatorService {

	@Autowired
	private CalculatorRepository calRepo;
	
	
	public Calculator saveHistory(Calculator cal) {
		return calRepo.save(cal);
	}

	public List<Calculator> historyList() {
		List<Calculator> history = new ArrayList<>();
		calRepo.findAll().forEach(history::add);
		return history;

	}
}
