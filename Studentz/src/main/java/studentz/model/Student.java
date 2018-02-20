package studentz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;


@Entity
@Table(name = "studenttable")

@Data public class Student {
	public Student() {
		
	}
	
	@Id
	@Column(name = "studentid", columnDefinition = "VARCHAR(255) NOT NULL", nullable = false, updatable = true)
	private String studId;
	@Column(name = "first", columnDefinition = "VARCHAR(255) NOT NULL", nullable = false, updatable = true)
	private String firstName;
	@Column(name = "last", columnDefinition = "VARCHAR(255) NOT NULL", nullable = false, updatable = true)
	private String lastName;
	
	
	public Student(String firstName, String lastName, String studId) {
		this.studId = studId;
		this.firstName = firstName;
		this.lastName = lastName;
		

	}
	
	
}
