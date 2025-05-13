package com.duung.connectors;

import com.duung.model.Employee;
import com.duung.model.ListEmployee;

public class EmployeeConnector {
    public Employee login(String usr, String pwd) {
        ListEmployee le = new ListEmployee();  // Khởi tạo ListEmployee
        le.generate_sample_dataset();  // Tạo dữ liệu mẫu

        Employee e = null;  // Khai báo Employee mặc định là null
        for (Employee employee : le.getEmployees()) {  // Duyệt qua danh sách employees
            if (employee.getUsername().equalsIgnoreCase(usr) && employee.getPassword().equals(pwd)) {
                e = employee;  // Lưu đối tượng Employee nếu tìm thấy khớp
                break;  // Dừng vòng lặp khi tìm thấy kết quả
            }
        }
        return e;  // Trả về Employee sau khi duyệt hết danh sách
    }
}
