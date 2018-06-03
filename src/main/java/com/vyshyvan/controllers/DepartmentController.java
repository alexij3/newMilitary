package com.vyshyvan.controllers;

import com.vyshyvan.model.Department;
import com.vyshyvan.model.Platoon;
import com.vyshyvan.model.Soldier;
import com.vyshyvan.services.department.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    DepartmentServiceImpl departmentService;

    @RequestMapping("/showall")
    public List<Department> showDepartments(){
        return departmentService.getAll();
    }

    @RequestMapping("/insert")
    public Department create(@RequestParam("platoonId") int platoonId, @RequestParam("captainId") int captainId,
                             @RequestBody Department department){
        Platoon platoon = new Platoon();
        Soldier soldier = new Soldier();

        platoon.setId(platoonId);
        soldier.setId(captainId);

        department.setPlatoon(platoon);
        department.setCaptain(soldier);

        return departmentService.insertDepartment(department);
    }

    @RequestMapping("/update")
    public Department update(@RequestParam("id") int id, @RequestParam("platoonId") int platoonId, @RequestParam("captainId") int captainId,
                             @RequestBody Department department){
        Platoon platoon = new Platoon();
        Soldier soldier = new Soldier();

        platoon.setId(platoonId);
        soldier.setId(captainId);

        department.setId(id);
        department.setPlatoon(platoon);
        department.setCaptain(soldier);

        return departmentService.updateDepartment(department);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam int id){
        departmentService.deleteDepartment(id);
    }
}
