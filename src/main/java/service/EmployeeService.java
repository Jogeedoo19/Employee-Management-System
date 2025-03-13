package service;
import model.Employee;
import repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
@Autowired
private EmployeeRepository repository;
public List<Employee> getAllEmployees() {
return repository.findAll();
}
public Employee addEmployee(Employee employee) {
return repository.save(employee);
}
}
