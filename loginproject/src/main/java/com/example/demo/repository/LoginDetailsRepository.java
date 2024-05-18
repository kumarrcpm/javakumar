package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.LoginDetailsEntity;

public interface LoginDetailsRepository extends JpaRepository<LoginDetailsEntity, Integer>, JpaSpecificationExecutor<LoginDetailsEntity> {

	LoginDetailsEntity findByUserName(String userName);

}
