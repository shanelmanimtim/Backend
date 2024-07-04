package com.Appchara.co.APPchara.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Appchara.co.APPchara.Model.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);

}
