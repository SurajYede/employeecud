package com.microservices.employeeappcrudop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class EmployeeappcrudopApplicationTests {

	@Test
	void contextLoads() {
	}
	// postman
	//url type --> request body -->http method --> send/ hit -->response 200/201 -->Ok created success
	// fail

	@Test
	public void findAllEmployeesTest() throws URISyntaxException {
		System.out.println("Test Started");
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/findAllEmp";
		URI uri=new URI(url);
		ResponseEntity<String>response=
		restTemplate.getForEntity(uri,String.class);
		Assertions.assertEquals(200,response.getStatusCodeValue());
		System.out.println("Test Ended");
	}

}
