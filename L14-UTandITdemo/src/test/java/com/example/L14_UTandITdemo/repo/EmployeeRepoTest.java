package com.example.L14_UTandITdemo.repo;

import com.example.L14_UTandITdemo.entity.Address;
import com.example.L14_UTandITdemo.entity.Branch;
import com.example.L14_UTandITdemo.entity.Employee;
import com.example.L14_UTandITdemo.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest(
        properties = {
                "spring.datasource.url=jdbc:h2:mem:testdb",
                "spring.jpa.hibernate.ddl-auto=create-drop"
        }
)
public class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private BranchRepo branchRepo;

    private Employee employee;

    @BeforeEach
    public void setUp() {

        Address address = Address.builder()
                .id(1l)
                .line1("A-1")
                .line2("Sector-10")
                .city("New Delhi")
                .build();



        Branch branch = Branch.builder()
                .id(11l)
                .name("Noida Branch")
                .build();

        branch = branchRepo.save(branch);

        employee = Employee.builder()
                .email("rahul@yopmail.com")
                .name("rahul")
              //  .address(address)
                .branch(branch)
                .build();
        employee = employeeRepo.save(employee);
    }

    @Test
    public void testFindByEmail(){
        Employee actual = employeeRepo.findByEmail("rahul@yopmail.com");
        //assertThat(actual.getId()).isEqualTo(employee.getId());
        assertThat(actual).isEqualTo(employee);
    }


    @Test
    public void testFindByEmailNotFound(){
        Employee actual = employeeRepo.findByEmail("random@yopmail.com");
        //assertThat(actual.getId()).isEqualTo(employee.getId());
        assertThat(actual).isEqualTo(null);
    }

}
