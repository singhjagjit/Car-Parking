package com.example.carparking.service;

import com.example.carparking.dao.AdminDAO;
import com.example.carparking.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AdminService {
    @Autowired
    private AdminDAO adminDAO;

    public Collection<Admin> getAdmins(String username, String password) {
        return adminDAO.getAdmins(username, password);
    }
}
