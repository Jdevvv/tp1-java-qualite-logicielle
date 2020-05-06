package com.tactfactory.monprojetsb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojetsb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User getUserById(Long id);
}
