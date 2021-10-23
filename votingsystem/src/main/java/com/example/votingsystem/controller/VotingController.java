package com.example.votingsystem.controller;



import java.util.List;


import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.votingsystem.entity.Candidate;
import com.example.votingsystem.entity.Citizen;
import com.example.votingsystem.entity.authorities;
import com.example.votingsystem.repositories.AuthoritiesRepo;
import com.example.votingsystem.repositories.CandidateRepo;
import com.example.votingsystem.repositories.CitizenRepo;
import org.springframework.security.core.Authentication;


@Controller
public class VotingController {
	
	public final Logger logger = Logger.getLogger(VotingController.class);
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@Autowired
	AuthoritiesRepo authoritiesRepo;
	
	@RequestMapping("/")
	public String goToVote(){
		logger.info("Returning vote.html file");
		return "vote.html";
	}
	
	
	@RequestMapping("/doLogin")
	public String doLogin( Model model, HttpSession session) {
		
		logger.info("getting citizen from database");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Citizen citizen=citizenRepo.findById(currentPrincipalName);
		
		logger.info("putting citizen into session");
		session.setAttribute("citizen", citizen);
		if(!citizen.isHasVoted()) {
			
			logger.info("putting candidates into model");
			List<Candidate> candidates = candidateRepo.findAll();
			model.addAttribute("candidates",candidates);
			return "/performVote.html";
		}
		else {
			return "/alreadyVoted.html";
		}
	}
	
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id, HttpSession session){
		
		Citizen citizen =(Citizen)session.getAttribute("citizen");
		
		
		
		if(!citizen.isHasVoted()) {
			citizen.setHasVoted(true);
		Candidate c = candidateRepo.findById((long)id);
		logger.info("voting for candidate"+c.getName());
		c.setNumberofvotes(c.getNumberofvotes()+1);
		candidateRepo.save(c);
		citizenRepo.save(citizen);
		return "voted.html";
		}
		
		return "/alreadyVoted.html";
		
	}
	
	
	@RequestMapping("/electionresults")
	public String ElectionResults( Model model, HttpSession session) {
		
		List<Candidate> candidates = candidateRepo.findAll();
		model.addAttribute("candidates",candidates);
		
		return "/Results.html";
		
	}
	
	@RequestMapping("/userregistration")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("citizen", new Citizen());
	     
	    return "signup_form";
	}
	
	@RequestMapping("/process_register")
	public String processRegister(Citizen user) {
		user.setEnabled(true);
		user.setHasVoted(false);
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    citizenRepo.save(user);
	     
	    
	    String x=user.getId();
	    authorities userrole = new authorities(x,"ROLE_USER");
	    authoritiesRepo.save(userrole);
	    
	     
	    return "register_success";
	}

	@RequestMapping("/candidateregistration")
	public String showcandiRegistrationForm(Model model) {
	    model.addAttribute("candidate", new Candidate());
	     
	    return "candidate_form";
	}
	
	@RequestMapping("/candidate_process_register")
	public String processcandiRegister(Candidate user1) {
		
	user1.setNumberofvotes(0);
	    candidateRepo.save(user1);
	     
	    return "register_success";
	}
}
