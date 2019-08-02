package com.ashwin.jpa.hiberante.jpaapp.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public  class PartTimeEmployee extends Employee {

    private BigDecimal hourlyWage;


    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(BigDecimal hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(String name,BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}
