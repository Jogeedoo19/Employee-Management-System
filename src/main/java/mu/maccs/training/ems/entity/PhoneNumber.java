/**
 * 
 */
package mu.maccs.training.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * 
 */
@Entity
public class PhoneNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phoneNumber;
	
	@ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
	
	// Constructors
    public PhoneNumber() {}

    public PhoneNumber(String phoneNumber, Employee employee) {
        this.phoneNumber = phoneNumber;
        this.employee = employee;
    }
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	  public Employee getEmployee() {
	        return employee;
	    }

	public void setEmployee(Employee employee) {
	    this.employee = employee;
	}

}
