package com.boocrun.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.boocrun.domain.Subscriber;
import com.boocrun.repositories.SubscriberRepository;

@Controller
public class AllSubscribersController {

  @Autowired
  private SubscriberRepository subRepo;
  
  @GetMapping("/subs")
  public String subView (ModelMap model) {
    Iterable<Subscriber> allSubscribers = subRepo.findAll();
    System.out.println(allSubscribers.toString());
    Subscriber subscriber = new Subscriber();
    
    model.put("allSubscribers", allSubscribers);
    model.put("subscriber", subscriber);
    
    return "subs";
    
  }
}
