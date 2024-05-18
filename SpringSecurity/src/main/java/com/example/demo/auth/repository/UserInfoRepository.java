package com.example.demo.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.auth.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>,JpaSpecificationExecutor<UserInfo> {

	Optional<UserInfo> findByName(String username);

}
