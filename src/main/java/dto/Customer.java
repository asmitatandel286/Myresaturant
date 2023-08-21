package dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
//	@Column(unique = false)
	private String email;
	private long phone;
	private String pass;
	private LocalDate dob;
	private String gender;
	private String country;
	private int age;
	@Lob
	private byte[] pic;

	
}
