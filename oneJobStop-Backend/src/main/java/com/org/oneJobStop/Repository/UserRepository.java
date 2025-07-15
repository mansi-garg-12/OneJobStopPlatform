package com.org.oneJobStop.Repository;

import com.org.oneJobStop.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<User, Long> {

    boolean findByEmail(String email);
    boolean findByPhoneNo(String phoneNo);

}
