package com.kakao.review.service;

import com.kakao.review.domain.Employee;

public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public Employee createEmployee(String empId, String fname, String sname) {
        Employee emp = Employee.builder()
                .empId(empId)
                .firstName(fname)
                .secondName(sname)
                .build();
        return emp;
    }
}
