package com.bridgelabz.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.demo.model.HelloWorld;

public interface IHelloWorldRepo extends JpaRepository<HelloWorld,Long> {

}
