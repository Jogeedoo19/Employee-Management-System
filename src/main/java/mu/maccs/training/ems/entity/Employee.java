package mu.maccs.training.ems.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import mu.maccs.training.ems.model.PhoneNumberModel;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String department;
 
	 
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    // Constructors
    public Employee() {}

    public Employee(String name, String department, String email, List<PhoneNumber> phoneNumbers) {
        this.name = name;
        this.department = department;
        this.email = email;
        this.phoneNumbers =  (phoneNumbers != null) ? phoneNumbers : new ArrayList<>();
    }

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public List<PhoneNumber> getPhoneNumbers() { // Match the field type
	    return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) { // Match the field type
	    this.phoneNumbers = (phoneNumbers != null) ? phoneNumbers : new ArrayList<>();
	}


}