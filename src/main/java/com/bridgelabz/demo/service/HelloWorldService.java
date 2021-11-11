package com.bridgelabz.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.demo.dto.HelloWorldDTO;
import com.bridgelabz.demo.model.HelloWorld;
import com.bridgelabz.demo.repository.IHelloWorldRepository;
import com.bridgelabz.demo.util.TokenUtil;
import com.fasterxml.jackson.databind.util.BeanUtil;
@Service
public class HelloWorldService implements IHelloWorldService {
	
	@Autowired
	IHelloWorldRepository helloworldrepository;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Autowired
	TokenUtil tokenutil;
	
	public String returnString() {
		return "Hello World";
		
	}

	@Override
	public HelloWorld adddata(HelloWorldDTO helloworlddto) {
		HelloWorld helloworld=new HelloWorld(helloworlddto);
//		modelmapper.map(helloworlddto,helloworld);
		System.out.println(helloworld.getFirstName()+" "+helloworld.getId());
		helloworldrepository.save(helloworld);
		return helloworld;
	}

//	@Override
//	public List<HelloWorld> getalldata() {
//		List<HelloWorld> helloworldlist=helloworldrepository.findAll();
//		return helloworldlist;
//	}

	@Override
	public HelloWorld updatedata(Long id, HelloWorldDTO helloworlddto) {
		Optional<HelloWorld> helloworld=helloworldrepository.findById(id);
		if(helloworld.isPresent()) {
			System.out.println(helloworld.get());
			helloworld.get().setFirstName(helloworlddto.getFirstName());
			helloworld.get().setLastName(helloworlddto.getLastName());
			helloworld.get().setAddress(helloworlddto.getAddress());
			helloworldrepository.save(helloworld.get());
			return helloworld.get();
		}
		return null;
		
	}

	@Override
	public HelloWorld deletedata(Long id) {
		Optional<HelloWorld> helloworld=helloworldrepository.findById(id);
		if(helloworld.isPresent()) {
			helloworldrepository.delete(helloworld.get());
			return helloworld.get();
		}
		return null;
	}

	@Override
	public List<HelloWorld> getalldata(String token) {
		Long id=tokenutil.decodeToken(token);
		Optional<HelloWorld> helloworld=helloworldrepository.findById(id);
		if(helloworld.isPresent()) {
			List<HelloWorld> helloworldlist=helloworldrepository.findAll();
			return helloworldlist;
		}
		return null;
	}

}
