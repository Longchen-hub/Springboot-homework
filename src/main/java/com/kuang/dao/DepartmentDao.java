package com.kuang.dao;


import com.kuang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departments=null;
    static{
        departments=new HashMap<Integer, Department>();//创建一个种类表
        departments.put(101,new Department(101,"日用品"));
        departments.put(102,new Department(102,"数码产品"));
        departments.put(103,new Department(103,"食品"));
        departments.put(104,new Department(104,"衣服"));
        departments.put(105,new Department(105,"鞋子"));
    }
    //获得所有部门信息
    public Collection<Department> getDepartment(){
        return departments.values();
    }
    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

}
