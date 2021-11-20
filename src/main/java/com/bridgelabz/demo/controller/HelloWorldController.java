package com.bridgelabz.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.demo.dto.HelloWorldDTO;
import com.bridgelabz.demo.exception.ExceptionHandle;
import com.bridgelabz.demo.exception.RegisterException;
import com.bridgelabz.demo.model.HelloWorld;
import com.bridgelabz.demo.response.Response;
import com.bridgelabz.demo.service.IHelloWorldService;
import com.bridgelabz.demo.util.TokenUtil;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
	

	@Autowired
	IHelloWorldService helloworldservice;
	
    @Autowired
    TokenUtil tokenutil;
	
	
	@PostMapping("/adduser")
	public Response adddata(@RequestBody HelloWorldDTO helloworlddto) {
		HelloWorld helloworld=helloworldservice.createuser(helloworlddto);
		
		return new Response("user added succesfully",(long) 200,tokenutil.createToken(helloworld.getId()));
		
	}
	
	@PutMapping("/updatedata")
	public Response updatedata(@RequestHeader String token,@RequestBody HelloWorldDTO helloworlddto) throws RegisterException {

		HelloWorld helloworld=helloworldservice.updateuser(token,helloworlddto);
		return new Response("data updated succefully",(long) 200,helloworld);
		
	}
	
	
	
	
	
	
	
	@GetMapping("/hello")
	public String helloworld() {
		return null;
//		return service.returnString();
		
	}
	@GetMapping("/param")
	public String helloworldbyparam(@RequestParam(name="firstname") String name) {
		System.out.println(name);
		return "hello "+name;
		
	}
	@GetMapping("/parameters/{name}")
	public String helloworldbypathvarible(@PathVariable String name) {
		System.out.println(name);
		return "hello "+name;
		
	}
	@GetMapping("/parametersbyheader")
	public String helloworldbyheaders(@RequestHeader(name="firstname") String name) {
		System.out.println(name);
		return "hello from Requestheader API "+name;
		
	}
	
	@GetMapping("/parametersbybody")
	public String helloworldbyrequestbody(@RequestBody HelloWorldDTO helloworlddto) {
		System.out.println(helloworlddto.getFirstName());
		return "Body Data->FirstName: "+helloworlddto.getFirstName()+" Last name: "+helloworlddto.getLastName();
		
	}
	
	
	
	@GetMapping("/readdata")
	public Response redadata(@RequestHeader(name="token") String token) throws ExceptionHandle
	{
		List<HelloWorld>  helloworld = null;
		//		List<HelloWorld> helloworld=service.getalldata(token);
		if(helloworld.size()>0) {
			return new Response("all user fetched succesfully",(long) 200,helloworld);	
		}
		else {
			throw new ExceptionHandle(400);
		}
		
	}
	
//	@PutMapping("/updatedata/{id}")
//	public HelloWorld updatedata(@PathVariable Long id,@RequestBody HelloWorldDTO helloworlddto) {
//HelloWorld helloworld = null;
//		//		HelloWorld helloworld=service.updatedata(id,helloworlddto);
//		return helloworld;
//		
//	}
	
	@DeleteMapping("/deleteuser/{id}")
	public HelloWorld deletedata(@PathVariable Long id) {
//		HelloWorld helloworld=service.deletedata(id);
		HelloWorld helloworld = null;
		return helloworld;
		
	}
 
	
	
	
	

}
