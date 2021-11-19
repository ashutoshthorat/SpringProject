package com.bridgelabz.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.demo.model.HelloWorld;

public interface IHelloWorldRepo extends JpaRepository<HelloWorld,Long> {

	@Query(value="select * from userdb.hello_world",nativeQuery=true)
	public List<HelloWorld> getdata();

	public Optional<HelloWorld> findByFirstName(String firstName);
}
