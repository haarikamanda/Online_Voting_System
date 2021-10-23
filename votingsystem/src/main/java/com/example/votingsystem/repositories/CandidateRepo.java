package com.example.votingsystem.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.votingsystem.entity.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Integer> {
	
	
	public Candidate findById(long id);

}
