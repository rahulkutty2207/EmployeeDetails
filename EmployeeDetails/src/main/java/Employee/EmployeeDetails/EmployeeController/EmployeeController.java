package Employee.EmployeeDetails.EmployeeController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Employee.EmployeeDetails.Employee.Employee;
import Employee.EmployeeDetails.EmployeeService.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService es;

	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		return es.saveEmployee(emp);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return es.getAllEmployee();
	}

	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Long id) {
		return es.getEmployeeById(id);

	}
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
		return es.updateEmployee(id, updatedEmployee);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		es.deleteEmployee(id);
		return "Employee deleted:" + id;

	}
}