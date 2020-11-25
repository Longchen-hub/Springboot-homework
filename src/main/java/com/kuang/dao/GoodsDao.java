package com.kuang.dao;


import com.kuang.pojo.Department;
import com.kuang.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class GoodsDao {
    //模拟数据库的信息
    private static Map<Integer, Goods> GoodsMap=null;
    //员工所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        GoodsMap=new HashMap<Integer, Goods>();
        GoodsMap.put(1001,new Goods(1001,"沐浴露","￥30","80",new Department(101,"日用品")));
        GoodsMap.put(1002,new Goods(1002,"iphone12","￥7000","15",new Department(102,"数码产品")));
        GoodsMap.put(1003,new Goods(1003,"康师傅方便面","￥5","400",new Department(103,"食品")));
        GoodsMap.put(1004,new Goods(1004,"时尚卫衣","￥150","130",new Department(104,"衣服")));
        GoodsMap.put(1005,new Goods(1005,"vans pro","￥400","80",new Department(105,"鞋子")));

    }
    //主键自增
    private static Integer initId=1006;
    //增加一个商品
    public void save(Goods goods){
        if(goods.getId()==null){
            goods.setId(initId++);
        }
        goods.setDepartment(departmentDao.getDepartmentById(goods.getDepartment().getId()));
        GoodsMap.put(goods.getId(), goods);
    }
    //查询全部商品信息
    public Collection<Goods> getAll(){
        return GoodsMap.values();
    }
    //通过id查询商品
    public Goods getEmployeeById(Integer id){
        return  GoodsMap.get(id);
    }
    //删除商品通过id
    public void delete(Integer id){
        GoodsMap.remove(id);
    }
}
