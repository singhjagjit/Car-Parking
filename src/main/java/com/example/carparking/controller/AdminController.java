package com.example.carparking.controller;

import com.example.carparking.entity.Admin;
import com.example.carparking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/{username}/{password}")
    public Collection<Admin> getEmptyLots(@PathVariable("username") String username, @PathVariable("password") String password) {
        return adminService.getAdmins(username, password);
    }
}
