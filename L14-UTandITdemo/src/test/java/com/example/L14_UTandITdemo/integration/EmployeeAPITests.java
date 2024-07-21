package com.example.L14_UTandITdemo.integration;

import com.example.L14_UTandITdemo.dto.EmployeeDetailReq;
import com.example.L14_UTandITdemo.entity.Address;
import com.example.L14_UTandITdemo.entity.Branch;
import com.example.L14_UTandITdemo.entity.Employee;
import com.example.L14_UTandITdemo.repo.BranchRepo;
import com.example.L14_UTandITdemo.repo.EmployeeRepo;
import com.example.L14_UTandITdemo.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = ("classpath:application-it.properties")
)
public class EmployeeAPITests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private BranchRepo branchRepo;

    private Branch branch;

    private EmployeeDetailReq employeeDetailReq;

    @BeforeEach
    public void setUp(){
        branch = Branch.builder()
                .name("Noida Branch")
                .build();
        branch = branchRepo.save(branch);

        employeeDetailReq = EmployeeDetailReq.builder()
                .email("rahul002@yopmail.com")
                .name("rahul")
                .line1("A-1")
                .line2("Sector-10")
                .city("New Delhi")
                .branchId(branch.getId())
                .build();
    }

    @Test
    public void testCreateEmpAPI() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonData = objectMapper.writeValueAsString(employeeDetailReq);

        mockMvc.perform(post("/emp")
                .contentType("application/json")
                .content(jsonData))
                .andDo(print()).andExpect(status().isOk());

        Employee employeeFromDb = employeeRepo.findByEmail("rahul002@yopmail.com");
        assertThat(employeeFromDb).isNotNull();

    }

//    @Test
//    public void testCreateEmpAPIWithSameData() throws Exception {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        String jsonData = objectMapper.writeValueAsString(employeeDetailReq);
//
//        mockMvc.perform(post("/emp")
//                        .contentType("application/json")
//                        .content(jsonData))
//                .andDo(print()).andExpect(status().is5xxServerError());
//
//    }
}
