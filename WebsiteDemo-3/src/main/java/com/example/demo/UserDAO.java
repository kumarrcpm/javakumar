package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserDAO  extends CrudRepository<User, Long>{

}
