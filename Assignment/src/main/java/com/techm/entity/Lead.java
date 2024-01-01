package com.techm.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAlias;

@Entity
@Table(name = "lead")
public class Lead {

	@NotNull(message = "LeadId is mandatory")
	@Id
	private Long leadId;

	@NotBlank(message = "First Name is mandatory")
	@Pattern(regexp = "^[a-zA-Z]*$")
	private String firstName;

	@Pattern(regexp = "^[a-zA-Z]*$")
	private String middleName;

	@NotBlank(message = "Last Name is mandatory")
	@Pattern(regexp = "^[a-zA-Z]*$")
	private String lastName;

	@NotBlank(message = "Mobile Number is mandatory")
	@Size(min = 10, max = 10)
	@Pattern(regexp = "^[5-9]\\d{9}$")
	private String mobileNumber;

	@NotBlank(message = "Gender is mandatory")
	@JsonAlias({ "Gender" })
	@Pattern(regexp = "^Male|Female|Other$")
	private String gender;

	@NotNull(message = "DOB is mandatory")
	@JsonAlias({ "DOB" })
	private LocalDate dob;

	@NotBlank(message = "Email is mandatory")
	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
	private String email;

	public Long getLeadId() {
		return leadId;
	}

	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob.toString();
	}

	public void setDob(String dob) {
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dob = LocalDate.parse(dob, sdf);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
