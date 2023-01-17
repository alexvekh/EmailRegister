package com.boocrun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boocrun.domain.Subscriber;




@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{
  
}

