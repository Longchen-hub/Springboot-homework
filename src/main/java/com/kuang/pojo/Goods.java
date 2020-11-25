package com.kuang.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Goods {
    private Integer id;
    private String name;
    private String price;
    private String num;
    private Department department;


    public Goods(Integer id, String name, String price, String num, Department department) {
        this.id = id;
        this.name=name;
        this.price = price;
        this.num=num;
        this.department = department;


    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Department getDepartment() {
        return department;
    }
}
