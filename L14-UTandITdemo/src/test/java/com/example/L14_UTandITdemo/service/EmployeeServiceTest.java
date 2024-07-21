package com.example.L14_UTandITdemo.service;

import com.example.L14_UTandITdemo.dto.EmployeeDetailReq;
import com.example.L14_UTandITdemo.entity.Address;
import com.example.L14_UTandITdemo.entity.Branch;
import com.example.L14_UTandITdemo.entity.Employee;
import com.example.L14_UTandITdemo.repo.EmployeeRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EmployeeServiceTest {

    private AutoCloseable autoCloseable;

    private EmployeeService employeeService;

    @Mock
    private EmployeeRepo employeeRepoMock;

    @Mock
    private BranchService branchServiceMock;

    private Employee employee;

    private Branch branch;

    private EmployeeDetailReq employeeDetailReq;


    @BeforeEach
    public void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeService(employeeRepoMock,branchServiceMock);

        Address address = Address.builder()
                .id(1l)
                .line1("A-1")
                .line2("Sector-10")
                .city("New Delhi")
                .build();

        branch = Branch.builder()
                .id(11l)
                .name("Noida Branch")
                .build();

        employee = Employee.builder()
                .id(10l)
                .email("rahul@yopmail.com")
                .name("rahul")
                .address(address)
                .branch(branch)
                .build();

         employeeDetailReq = EmployeeDetailReq.builder()
                .email("rahul@yopmail.com")
                .name("rahul")
                .line1("A-1")
                .line2("Sector-10")
                .city("New Delhi")
                .branchId(11l)
                .build();


    }

    @AfterEach
    public void tearDown() throws Exception {
        autoCloseable.close();;
    }


    @Test
    public void testCreateEmp(){
        when(employeeRepoMock.save(any())).thenReturn(employee);
        when(branchServiceMock.get(11l)).thenReturn(branch);

        Employee actualEmp = employeeService.createEmp(employeeDetailReq);

        assertThat(actualEmp).isEqualTo(employee);

    }

}
