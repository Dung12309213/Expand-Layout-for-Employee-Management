package com.duung.connectors;

import com.duung.model.Employee;
import com.duung.model.ListEmployee;

public class EmployeeConnector {
    public Employee login(String usr, String pwd) {
        ListEmployee le = new ListEmployee();
        le.generate_sample_dataset();

        Employee e = null;
        for (Employee employee : le.getEmployees()) {
            if (employee.getUsername().equalsIgnoreCase(usr) && employee.getPassword().equals(pwd)) {
                e = employee;
                break;
            }
        }
        return e;
    }
}
