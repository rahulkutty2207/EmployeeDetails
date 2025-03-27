package Employee.EmployeeDetails.EmployeeService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Employee.EmployeeDetails.Employee.Employee;
@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
