package com.yash.cal.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.cal.entity.Calculator;
import com.yash.cal.repository.CalculatorRepository;
import com.yash.cal.service.CalculatorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CalculatorController {

	@Autowired
	CalculatorRepository calRepo;

	@Autowired
	CalculatorService calService;

	@PostMapping("/add")
	public Calculator addition(@RequestBody Calculator objCal) {
		double sum = 0;
		String s = objCal.getInserted();
		String[] ss = s.split(Pattern.quote(objCal.getSign()));
		int i = 1;
		while (i < ss.length) {
			System.out.println(ss[i]);
			i = i + 1;
		}

		double numOne = Double.parseDouble(ss[0]);
		double numTwo = Double.parseDouble(ss[1]);
		String check = objCal.getSign();
		char che = check.charAt(0);
		System.out.println(objCal.getSign());
		System.out.println(che);
		if (che == '+') {
			sum = numOne + numTwo;
		} else if (che == '-') {
			sum = numOne - numTwo;
		} else if (che == 'x') {
			sum = numOne * numTwo;
		} else if (che == '÷') {
			sum = numOne / numTwo;
		} else if (che == '^') {
			sum = Math.pow(numOne, numTwo);
		}

		else if (che == '%') {
			sum = numOne * numTwo / 100;
		} else if (che == '√') {
			sum = Math.sqrt(numOne);
		} else if (che == '/') {
			sum = 1 / (numTwo);
		}
		objCal.setResult(sum);
		Calculator objnum2 = calRepo.save(objCal);
		return objnum2;
	}

	@PostMapping("/test")
	public String test(@RequestBody Calculator objnum) {
		Calculator objnum2 = calRepo.save(objnum);
		objnum2.setInserted(objnum.getInserted());
		calService.saveHistory(objnum2);
		return objnum.getInserted();

	}

	@GetMapping("/history")
	public List<Calculator> history() {
		List<Calculator> history = calRepo.findAll();
		return history;
	}

	@PostMapping("/drop")
	public int drop() {
		calRepo.deleteAll();
		return 1;
	}

}
