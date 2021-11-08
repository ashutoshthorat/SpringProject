package com.bridgelabz.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.demo.dto.HelloWorldDTO;
import com.bridgelabz.demo.model.HelloWorld;

@Service
public interface IHelloWorldService {
	public String returnString();

	public HelloWorld adddata(HelloWorldDTO helloworlddto);

	public List<HelloWorld> getalldata();

	public HelloWorld updatedata(Long id, HelloWorldDTO helloworlddto);

	public HelloWorld deletedata(Long id);

}
