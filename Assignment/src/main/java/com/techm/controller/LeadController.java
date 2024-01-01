package com.techm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.dto.ErrorResponse;
import com.techm.dto.GetLeadResponse;
import com.techm.dto.LeadResponse;
import com.techm.entity.Lead;
import com.techm.repository.LeadRepository;

@RestController
public class LeadController {

	@Autowired
	LeadRepository repository;

	@PostMapping("/createLead")
	private LeadResponse createLead(@Valid @RequestBody Lead lead) {
		LeadResponse lr = new LeadResponse();

		try {
			repository.save(lead);
			lr.setStatus("success");
			lr.setData("Created Leads Successfully");
		} catch (DataIntegrityViolationException e) {
			lr.setStatus("error");
			ErrorResponse er = new ErrorResponse();
			er.setCode("E10010");
			List<String> ls = new ArrayList<>();
			ls.add("Lead Already Exists in the database with the lead id : " + lead.getLeadId());
			er.setMessages(ls);
			lr.setErrorResponse(er);
		}

		return lr;
	}

	@GetMapping("/getLead/mob={mob}")
	private GetLeadResponse getLead(@PathVariable String mob) {
		GetLeadResponse lr = new GetLeadResponse();

		List<Lead> leads = repository.findByMobileNumber(mob);
		if (!leads.isEmpty()) {
			lr.setStatus("success");
			lr.setData(leads);
		} else {
			lr.setStatus("error");
			ErrorResponse er = new ErrorResponse();
			er.setCode("E10010");
			List<String> ls = new ArrayList<>();
			ls.add("No Lead found with the Mobile Number");
			er.setMessages(ls);
			lr.setErrorResponse(er);
		}

		return lr;
	}
}
