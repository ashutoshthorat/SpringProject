package com.bridgelabz.demo.service;

import com.bridgelabz.demo.dto.HelloWorldDTO;
import com.bridgelabz.demo.exception.RegisterException;
import com.bridgelabz.demo.model.HelloWorld;

public interface IHelloWorldService {

	HelloWorld createuser(HelloWorldDTO helloworlddto);

	HelloWorld updateuser(Long id, HelloWorldDTO helloworlddto) throws RegisterException;

}
