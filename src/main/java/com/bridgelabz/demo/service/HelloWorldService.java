package com.bridgelabz.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.demo.dto.HelloWorldDTO;
import com.bridgelabz.demo.exception.RegisterException;
import com.bridgelabz.demo.model.HelloWorld;
import com.bridgelabz.demo.repository.IHelloWorldRepo;
import com.bridgelabz.demo.response.Response;

@Service
public class HelloWorldService implements IHelloWorldService{

	@Autowired
	IHelloWorldRepo helloworldrepo;
	
	
	
	public HelloWorld createuser(HelloWorldDTO helloworlddto) {

		HelloWorld helloworld=new HelloWorld(helloworlddto);
		System.out.println(helloworld.toString());
		helloworldrepo.save(helloworld);
		// TODO Auto-generated method stub
		return helloworld;
	}



	@Override
	public HelloWorld updateuser(Long id, HelloWorldDTO helloworlddto) throws RegisterException {
		Optional<HelloWorld> isuserPresent=helloworldrepo.findById(id);
		if(isuserPresent.isPresent()) {
			isuserPresent.get().setFirstName(helloworlddto.getFirstName());
			isuserPresent.get().setLastName(helloworlddto.getLastName());
			isuserPresent.get().setAddress(helloworlddto.getAddress());
			isuserPresent.get().setUpdatedDate(LocalDateTime.now());
			helloworldrepo.save(isuserPresent.get());
			return isuserPresent.get();
		}
		throw new RegisterException("user not present",400);
	}

}
