package com.jbk.springboot;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JasperRunManager;

@RestController
public class TransactionController {

	@Autowired
	Transaction transaction;
	// A a=new A();

	@GetMapping("/jasper")
	public String getReport(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("<<<<<<<<<<<<<<<<<<< Hello Report >>>>>>>>>>>>>>>>>>>>");
		try {
			Connection connection = ConnectionUtils.getConnection();
			File file = new File("Simple_Blue.jasper");
			Map parameter = new HashMap();
			byte[] bytes = JasperRunManager.runReportToPdf(file.getPath(), parameter, connection);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream outStream = response.getOutputStream();
			outStream.write(bytes,0,bytes.length);
			outStream.flush();
			outStream.close();
			System.out.println("Successfully call jasper perort");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}

		return "Hello Jasper";
	}

	@RequestMapping("/transaction/get")
	public Transaction getTransaction() {
		return transaction;
	}

	@RequestMapping("/transaction/first")
	public Transaction getTransaction1() {
		transaction.setTransId("1234");
		transaction.setTransactionDoneBy("Darshit");
		transaction.setTransSource("Amazon");
		return transaction;
	}

	@RequestMapping("/wheater/{city}")
	public String getWeather(@PathVariable("city") String city) {
		System.out.println("Weather of >>> " + city);
		return city + "23f";
	}

	@RequestMapping("/transaction/getAllTrans")
	public List<Transaction> getAllransaction() {
		List<Transaction> listTransactions = new ArrayList<>();
		Transaction trans = new Transaction("123", "Darshit", "Amazon");
		Transaction trans1 = new Transaction("124", "Kiran", "Ebay");
		Transaction trans2 = new Transaction("125", "Kunal", "Flipkart");
		listTransactions.add(trans);
		listTransactions.add(trans1);
		listTransactions.add(trans2);
		return listTransactions;
	}

}
