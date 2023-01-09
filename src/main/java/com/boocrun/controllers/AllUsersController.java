package com.boocrun.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.boocrun.domain.User;
import com.boocrun.repositories.UserRepository;

@Controller
public class AllUsersController {

  @Autowired
  private UserRepository userRepo;
  
  @GetMapping("/users")
  public String usersView (ModelMap model) {
    Iterable<User> allUsers = userRepo.findAll();
    
    User user = new User();
    
    model.put("allUsers", allUsers);
    model.put("user", user);
    
    return "users";
    
  }
}
