package com.example.votingsystem.controller;

import javax.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController

{
    @RolesAllowed("USER")
    @RequestMapping("/*")
    public String getUser()
    {
        return "Sorry,you do not have access";
    }

    @RolesAllowed({"ADMIN"})
    @RequestMapping("/admin")
    public String getAdmin()
    {
        return "Welcome Admin";
    }
}
