package com.yash.cal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.cal.entity.Calculator;
import com.yash.cal.repository.CalculatorRepository;

@SpringBootTest
class CalculatorApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	CalculatorRepository calRepo;

	@Test
	public void addition() {
		Calculator objnum = new Calculator();
		objnum.setInserted("22+2");
		objnum.setSign("+");
		double sum = 0;
		String s = objnum.getInserted();
		String[] ss = s.split(Pattern.quote(objnum.getSign()));
		int i = 1;
		while (i < ss.length) {
			System.out.println(ss[i]);
			i = i + 1;
		}

		double numOne = Double.parseDouble(ss[0]);
		double numTwo = Double.parseDouble(ss[1]);
		String check = objnum.getSign();
		char che = check.charAt(0);
		System.out.println(objnum.getSign());
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
		} else if (che == '%') {
			sum = numOne * numTwo / 100;
		} else if (che == '√') {
			sum = Math.sqrt(numOne);
		} else if (che == '/') {
			sum = 1 / (numTwo);
		}
		objnum.setResult(sum);
		Calculator objnum2 = calRepo.save(objnum);
		assertNotNull(objnum2, "working");
	}

	

}
