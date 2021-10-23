package com.example.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.votingsystem.entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen,Integer> {
public Citizen findByName(String name);
public Citizen findById(String id);

}
