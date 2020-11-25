package com.kuang.controller;
import com.kuang.dao.DepartmentDao;
import com.kuang.dao.GoodsDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class GoodsController {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/user/emps")
    public String list(Model model){
        Collection<Goods> goods = goodsDao.getAll();
        model.addAttribute("emps", goods);
        return "emp/list";
    }
    @RequestMapping("/user/useremps")
    public String userlist(Model model){
        Collection<Goods> goods = goodsDao.getAll();
        model.addAttribute("emps", goods);
        return "emp/userlist";
    }
    @RequestMapping("/user/shoppingcar")
    public String shoppingCar(Model model){
        Collection<Goods> goods = goodsDao.getAll();
        model.addAttribute("emps", goods);
        return "emp/shoppingCar";
    }
    @RequestMapping("/user/order")
    public String order(Model model){
        Collection<Goods> goods = goodsDao.getAll();
        model.addAttribute("emps", goods);
        return "emp/order";
    }
    @GetMapping("/user/emp")
    public String toAddpage(Model model){
        //查询所有部门的信息
        Collection<Department> departments=departmentDao.getDepartment();
        System.out.println(departments);
        model.addAttribute("departments",departments);
        return "emp/add";
    }
    @PostMapping("/user/emp")
    public String addEmp(Goods goods){
        //添加操作
        System.out.println("save employee:"+ goods);
        goodsDao.save(goods);
        return "redirect:/user/emps";
    }
    //去员工的修改页面
    @GetMapping("/user/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        //查出原来的数据
        Goods goods = goodsDao.getEmployeeById(id);
        System.out.println(goods);
        model.addAttribute("emp", goods);
        //查询所有部门信息
        Collection<Department> departments=departmentDao.getDepartment();
        System.out.println(departments);
        model.addAttribute("departments",departments);
        return "emp/update";
    }
    @PostMapping("/user/updateEmp")
    public String updateEmp(Goods goods){
        goodsDao.save(goods);
        return "redirect:/user/emps";
    }
    @GetMapping("/user/delemp/{id}")
    public String toDeleteEmp(@PathVariable("id")Integer id){
        goodsDao.delete(id);
        return "redirect:/user/emps";
    }
    @RequestMapping("/user/logout")
    public String UserLogout(HttpSession session){
        session.invalidate();
        return "redirect:index.html";
    }
}
