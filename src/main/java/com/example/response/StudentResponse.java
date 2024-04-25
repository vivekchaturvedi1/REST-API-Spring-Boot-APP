package com.example.response;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.Student;
import com.example.entity.Subject;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Setter
@Getter
public class StudentResponse {

	private static final String SPACE = " ";

	private long id;

	@JsonProperty("first_name")
	private String firstName;

	private String lastName;

	private String email;

	private int addressId;

	private String street;

	private String city;

	private String fullName;
	
	private List<SubjectResponse> learningSubjects;
	
	public StudentResponse (Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.addressId = student.getAddress().getId().intValue();
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
		this.fullName=getFullName(student);
		if (student.getLearningSubjects() != null) {
			learningSubjects = new ArrayList<SubjectResponse>();
			for (Subject subject: student.getLearningSubjects()) {
				learningSubjects.add(new SubjectResponse(subject));
			}
		}


	}

	private String getFullName (Student student) {
		String fullNameResponse = student.getFirstName() + SPACE  + student.getLastName();
		return fullNameResponse;
	}

}
