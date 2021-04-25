package com.example.carparking.dao;

import com.example.carparking.entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;

public interface AdminRepository extends MongoRepository<Admin, Integer> {
    @Query("{ 'username' : ?0, 'password' : ?1 }")
    Collection<Admin> getAdmins(String username, String password);
}
