/**
 * 
 */
package mu.maccs.training.ems.model;

import java.util.List;

/**
 * 
 */
public class EmployeeModel {

	private Long id;
	private String name;
	private String email;
	private String department;
	private List<PhoneNumberModel> phoneNumbers;
	
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


    public List<PhoneNumberModel> getPhoneNumbers() { // Updated getter
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumberModel> phoneNumbers) { // Updated setter
        this.phoneNumbers = phoneNumbers;
    }
}
