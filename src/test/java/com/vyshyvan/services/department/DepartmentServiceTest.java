package com.vyshyvan.services.department;

import com.vyshyvan.model.Department;
import com.vyshyvan.model.Platoon;
import com.vyshyvan.model.Soldier;
import com.vyshyvan.repositories.department.DepartmentDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DepartmentServiceTest {
    @Mock
    private DepartmentDAO repository;

    @InjectMocks
    private DepartmentServiceImpl service;

    private List<Department> departmentList;

    private Department department;

    @Before
    public void setUp() throws Exception {
        departmentList = Arrays.asList(
                new Department("DPT1", "Department 1", new Platoon(), new Soldier()),
                new Department("DPT2", "Department 2", new Platoon(), new Soldier()),
                new Department("DPT3", "Department 3", new Platoon(), new Soldier())
        );

        department = new Department("DPT4", "Department 4", new Platoon(), new Soldier());
        int departmentId = 1;
        department.setId(departmentId);

        Mockito.when(repository.findAll()).thenReturn(departmentList);
        Mockito.when(repository.save(department)).thenReturn(department);

    }

    @Test
    public void insertDepartment() throws Exception {
        Department actualDepartment = service.insertDepartment(department);

        assertEquals(department, actualDepartment);
    }

    @Test
    public void getDepartment() throws Exception {
        int id = 1;

        Department expectedDepartment = department = new Department("DPT5", "Department 5", new Platoon(), new Soldier());
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedDepartment));

        Department actualDepartment = service.getDepartment(id);

        assertEquals(expectedDepartment, actualDepartment);
    }

    @Test
    public void updateDepartment() throws Exception {
        Department actualDepartment = service.insertDepartment(department);

        assertEquals(department, actualDepartment);
    }

    @Test
    public void getAll() throws Exception {
        List<Department> actualDepartments = service.getAll();

        assertEquals(departmentList, actualDepartments);
    }

}