package Employee.EmployeeDetails.EmployeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Employee.EmployeeDetails.Employee.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository er;

	public Employee saveEmployee(Employee emp) {
		return er.save(emp);
	}

	public List<Employee> getAllEmployee() {
		return er.findAll();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return er.findById(id);

	}

	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Optional<Employee> existingEmployeeOptional = er.findById(id);
		if (existingEmployeeOptional.isPresent()) {
			Employee ee= existingEmployeeOptional.get();
			ee.setName(updatedEmployee.getName());
			ee.setDepartment(updatedEmployee.getDepartment());
			ee.setSalary(updatedEmployee.getSalary());
			return er.save(ee);
		} else {
			throw new RuntimeException("Employee not found with id: " + id);
		}
	}

	public void deleteEmployee(Long id) {
		er.deleteById(id);
	}

}
