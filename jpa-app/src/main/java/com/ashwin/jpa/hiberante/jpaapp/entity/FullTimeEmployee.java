package com.ashwin.jpa.hiberante.jpaapp.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
public  class FullTimeEmployee extends Employee {

    private BigDecimal salary;


    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal hourlyWage) {
        this.salary = salary;
    }

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }


}
