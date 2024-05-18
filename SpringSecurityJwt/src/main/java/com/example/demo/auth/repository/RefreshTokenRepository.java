package com.example.demo.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.auth.entity.RefreshTokenEntity;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Integer> {

	RefreshTokenEntity findByrefreshValue(String refreshValue);



}
