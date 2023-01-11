package com.boocrun.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.boocrun.domain.User;
import com.boocrun.repositories.UserRepository;

@Controller
public class NewUserControler {
  
  @Autowired
  private UserRepository userRepo;
  
  @GetMapping("/new-user")
  public String newUser (ModelMap model) {

    User user = new User();
    Iterable<User> allUsers = userRepo.findAll();
    
    model.put("allUsers", allUsers);
    model.put("user", user);
    
    return "new-user";
    
  }
  
  @PostMapping("/new-user")
  public String newUserPost (User user) {
    userRepo.save(user);
    
    return "redirect:/";
  }
  /*
  @GetMapping("/users")
  public String usersView (ModelMap model) {
    Iterable<User> allUsers = userRepo.findAll();
    
    User user = new User();
    
    model.put("allUsers", allUsers);
    model.put("user", user);
    
    return "users";
    
  }*/
  
  
}
