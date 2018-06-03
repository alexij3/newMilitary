package com.vyshyvan.services.department;

import com.vyshyvan.model.Department;
import com.vyshyvan.repositories.department.DepartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDAO departmentDAO;

    @Override
    public Department insertDepartment(Department department) {
        return departmentDAO.save(department);
    }

    @Override
    public Department getDepartment(int id) {
        return departmentDAO.findById(id).get();
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentDAO.save(department);
    }

    @Override
    public void deleteDepartment(int id) {
        departmentDAO.deleteById(id);
    }

    @Override
    public List<Department> getAll() {
        return (List<Department>) departmentDAO.findAll();
    }
}