package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findById(long id);

	User save(long id);
}
