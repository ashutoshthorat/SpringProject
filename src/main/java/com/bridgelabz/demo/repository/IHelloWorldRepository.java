package com.bridgelabz.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.demo.model.HelloWorld;

public interface IHelloWorldRepository extends JpaRepository<HelloWorld,Long> {

	
}
