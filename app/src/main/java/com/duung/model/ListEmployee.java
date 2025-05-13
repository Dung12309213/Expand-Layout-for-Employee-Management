package com.duung.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class ListEmployee {
    private List<Employee> employees;

    public ListEmployee(){
        employees=new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void generate_sample_dataset() {
        Employee e1 = new Employee();
        e1.setName("John");
        e1.setEmail("john@gmail.com");
        e1.setUsername("John");
        e1.setPassword("123");  // Sửa lại thành setPassword

        employees.add(e1);  // Thêm employee vào danh sách
        Employee e2 = new Employee();
        e2.setName("Jim");
        e2.setEmail("Jim@gmail.com");
        e2.setUsername("Jim");
        e2.setPassword("1234");  // Sửa lại thành setPassword

        employees.add(e2);  // Thêm employee vào danh sách
    }
}
