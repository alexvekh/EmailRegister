package com.boocrun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boocrun.domain.User;




@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  
}

