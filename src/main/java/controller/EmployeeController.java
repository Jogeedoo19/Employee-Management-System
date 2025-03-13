package controller;

import model.Employee;
import service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Display the home page with employee list
    @GetMapping({"/", "/employees"})
    public String viewHomePage(Model model) {
        model.addAttribute("employees", service.getAllEmployees());
        return "index"; // Refers to index.html in the templates folder
    }

    // Handle form submission to add a new employee
    @PostMapping("/employees")
    public String addEmployee(@ModelAttribute Employee employee) {
        service.addEmployee(employee);
        return "redirect:/employees";
    }

    // REST API to fetch all employees (optional)
    @RestController
    @RequestMapping("/api/employees")
    public static class RestEmployeeController {
        @Autowired
        private EmployeeService service;

        @GetMapping
        public List<Employee> getAllEmployees() {
            return service.getAllEmployees();
        }

        @PostMapping
        public Employee addEmployee(@RequestBody Employee employee) {
            return service.addEmployee(employee);
        }
    }
}
