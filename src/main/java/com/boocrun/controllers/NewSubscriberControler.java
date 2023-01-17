package com.boocrun.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.boocrun.domain.Subscriber;
import com.boocrun.repositories.SubscriberRepository;


@Controller
public class NewSubscriberControler {
  
  @Autowired
  private SubscriberRepository subRepo ;
  
  @GetMapping("/newsub")
  //@RequestMapping(value="/newsub", method=RequestMethod.GET)
  public String root (ModelMap model) {

    Subscriber subscriber = new Subscriber();
    //Iterable<Subscriber> allSubscribers = subRepo.findAll();
    
    //model.put("allSubscribers", allSuvcsribers);
    model.put("subscriber", subscriber);
    
    return "/newsub";
  }
  
  @PostMapping("/newsub")
  //@RequestMapping(value="/newsub", method=RequestMethod.POST)
  public String rootPost (Subscriber subscriber) {
    System.out.println(subscriber.toString());
    subRepo.save(subscriber);
    //userRepo.flush();
    
    return "redirect:/confirm";
  }
  /*
  @GetMapping("/users")
  public String usersView (ModelMap model) {
    Iterable<Subscriber> allUsers = userRepo.findAll();
    
    Subscriber user = new Subscriber();
    
    model.put("allUsers", allUsers);
    model.put("user", user);
    
    return "users";
    
  }*/
  
  
}
