package com.dpronto.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dpronto.domain.Login;
@Repository
public interface UserRepository  extends JpaRepository<Login, Integer> {

	Login findByUsernameAndPassword(String username, String password);

}
