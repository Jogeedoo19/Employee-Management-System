package mu.maccs.training.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mu.maccs.training.ems.model.EmployeeModel;
import mu.maccs.training.ems.service.EmployeeService;

@RestController
//@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Display the home page with employee list
	@GetMapping("/api/listAllEmployees")
	public List<EmployeeModel> listAllEmployees() {
		return this.employeeService.listAllEmployees();
	}
	// Create a new employee
   
    @PostMapping("/api/createOrUpdateEmployee")
    public EmployeeModel createOrUpdateEmployee(@RequestBody EmployeeModel employeeModel) {
        return employeeService.createOrUpdateEmployee(employeeModel);
    }
    
    @DeleteMapping("/api/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
    	employeeService.deleteEmployee(id);
    }
}
