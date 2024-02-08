package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AddressEntity;
import com.app.entities.UserEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
	public Optional<AddressEntity> findByUser(UserEntity user);
}
