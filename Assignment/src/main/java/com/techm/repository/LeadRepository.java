package com.techm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.entity.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

	public List<Lead> findByMobileNumber(String mobileNumber);

}
