package mu.maccs.training.ems.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mu.maccs.training.ems.entity.Employee;
import mu.maccs.training.ems.entity.PhoneNumber;
import mu.maccs.training.ems.model.EmployeeModel;
import mu.maccs.training.ems.model.PhoneNumberModel;
import mu.maccs.training.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeModel> listAllEmployees() {
		List<Employee> allEmployees = employeeRepository.findAll();
		List<EmployeeModel> allEmployeeModels = this.convertListEmployeesToListEmployeeModels(allEmployees);
		return allEmployeeModels;
	}

	// TODO Geeshikah
	private List<EmployeeModel> convertListEmployeesToListEmployeeModels(List<Employee> allEmployees) {
		List<EmployeeModel> allEmployeeModels = new ArrayList<>();
	    
	    for (Employee employee : allEmployees) {
	        EmployeeModel employeeModel = new EmployeeModel();
	        // Assuming EmployeeModel has setters or a constructor to set these fields
	        employeeModel.setId(employee.getId());
	        employeeModel.setName(employee.getName());
	        employeeModel.setDepartment(employee.getDepartment());
	        employeeModel.setEmail(employee.getEmail());
	        //employeeModel.setPhoneNumbers(employee.getPhoneNumbers());
	        
	        // Convert only the first phone number (if available)
	        if (employee.getPhoneNumbers() != null && !employee.getPhoneNumbers().isEmpty()) {
	            PhoneNumber phoneNumber = employee.getPhoneNumbers().get(0); // Get the first phone number
	            PhoneNumberModel phoneNumberModel = new PhoneNumberModel();
	            phoneNumberModel.setId(phoneNumber.getId());
	            phoneNumberModel.setPhoneNumber(phoneNumber.getPhoneNumber());

	            // Set the single phone number in the EmployeeModel
	            List<PhoneNumberModel> phoneNumberModels = new ArrayList<>();
	            phoneNumberModels.add(phoneNumberModel);
	            employeeModel.setPhoneNumbers(phoneNumberModels);
	        }

	        
	        
	        allEmployeeModels.add(employeeModel);
	    }
	    
	    return allEmployeeModels;
	}
	
	//Create or Update Employee
	public EmployeeModel createOrUpdateEmployee(EmployeeModel employeeModel) {
	    Employee employee = new Employee();
	    
	    employee.setId(employeeModel.getId());


	    // Set fields for the employee entity
	    employee.setName(employeeModel.getName());
	    employee.setDepartment(employeeModel.getDepartment());
	    employee.setEmail(employeeModel.getEmail());

	    // Handle phone numbers
	    if (employeeModel.getPhoneNumbers() != null) {
	    	if (employee.getPhoneNumbers() == null) {
	        employee.setPhoneNumbers(new ArrayList<>());
	    	}
	        for (PhoneNumberModel phoneNumberModel : employeeModel.getPhoneNumbers()) {
	            PhoneNumber phoneNumber = new PhoneNumber();
	            phoneNumber.setId(phoneNumber.getId());
	            phoneNumber.setPhoneNumber(phoneNumberModel.getPhoneNumber());
	            phoneNumber.setEmployee(employee);
	            employee.getPhoneNumbers().add(phoneNumber); // Add to the existing collection
	        }
	        //employee.setPhoneNumbers(phoneNumbers);
	    }

	    // Save the employee (either new or updated)
	    Employee savedEmployee = employeeRepository.save(employee);

	    // Convert back to EmployeeModel and return
	    return convertEmployeeToEmployeeModel(savedEmployee);
	}


	// Conversion method (to keep it DRY)
	private EmployeeModel convertEmployeeToEmployeeModel(Employee employee) {
	    EmployeeModel employeeModel = new EmployeeModel();
	    employeeModel.setId(employee.getId());
	    employeeModel.setName(employee.getName());
	    employeeModel.setDepartment(employee.getDepartment());
	    employeeModel.setEmail(employee.getEmail());
	    
	    // Convert phone numbers
	    List<PhoneNumberModel> phoneNumberModels = new ArrayList<>();
	    for (PhoneNumber phoneNumber : employee.getPhoneNumbers()) { 
	        PhoneNumberModel phoneNumberModel = new PhoneNumberModel();
	        phoneNumberModel.setId(phoneNumber.getId());
	        phoneNumberModel.setPhoneNumber(phoneNumber.getPhoneNumber());
	        phoneNumberModels.add(phoneNumberModel);
	    }

	    // Correctly set the phone numbers list
	    employeeModel.setPhoneNumbers(phoneNumberModels);

	    return employeeModel;
	}

	
	
	

	// create employee
/*	public List<EmployeeModel> createEmployees(List<EmployeeModel> employeeModels) {
	    List<EmployeeModel> savedEmployeeModels = new ArrayList<>();

	    for (EmployeeModel employeeModel : employeeModels) {
	        Employee employee = new Employee();
	        employee.setName(employeeModel.getName());
	        employee.setDepartment(employeeModel.getDepartment());
	        employee.setEmail(employeeModel.getEmail());

	        Employee savedEmployee = employeeRepository.save(employee);
	        savedEmployeeModels.add(convertEmployeeToEmployeeModel(savedEmployee));
	    }

	    return savedEmployeeModels;
	}

	// Conversion method (to keep it DRY)
	private EmployeeModel convertEmployeeToEmployeeModel(Employee employee) {
	    EmployeeModel employeeModel = new EmployeeModel();
	    employeeModel.setId(employee.getId());
	    employeeModel.setName(employee.getName());
	    employeeModel.setDepartment(employee.getDepartment());
	    employeeModel.setEmail(employee.getEmail());
	    return employeeModel;
	 */
	
	//delete employee
	public void deleteEmployee(Long id) {
		if (!employeeRepository.existsById(id)) {
			throw new IllegalArgumentException("Employee with ID"+id+"does not exist.");
			
		}
		employeeRepository.deleteById(id);
	}
}



