package com.Appchara.co.APPchara.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Appchara.co.APPchara.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
}
