package com.example.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.votingsystem.entity.authorities;


@Repository
public interface AuthoritiesRepo extends JpaRepository<authorities,Integer> {
	

}
