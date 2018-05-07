/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Depart;
import entity.Staff;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author ADMIN
 */
@Transactional
@Controller
@RequestMapping("/staff")
public class StaffController {
@Autowired
	SessionFactory factory;

@RequestMapping()
	public String index(ModelMap model) {
		model.addAttribute("staff", new Staff());
		model.addAttribute("staffs", getStaffs());
		return "staff";
	}
	
	@RequestMapping(params="btnInsert")
	public String insert(ModelMap model, @ModelAttribute("staff") Staff staff) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(staff);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công !");
		} 
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại !");
		}
		finally {
			session.close();
		}
		model.addAttribute("staffs", getStaffs());
		return "staff";
	}
	
	@RequestMapping(params="btnUpdate")
	public String update(ModelMap model, @ModelAttribute("staff") Staff staff) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(staff);
			t.commit();
			model.addAttribute("message", "Cập nhật thành công !");
		} 
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Cập nhật thất bại !");
		}
		finally {
			session.close();
		}
		model.addAttribute("staffs", getStaffs());
		return "staff";
	}
	
	@RequestMapping(params="btnDelete")
	public String delete(ModelMap model, Staff staff) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(staff);
			t.commit();
			model.addAttribute("message", "Xóa thành công !");
		} 
		catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xóa thất bại !");
		}
		finally {
			session.close();
		}
		model.addAttribute("staff", new Staff());
		model.addAttribute("staffs", getStaffs());
		return "staff";
	}
	
	@RequestMapping("{id}")
	public String edit(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.getCurrentSession();
		Staff staff = (Staff) session.get(Staff.class, id);

		model.addAttribute("staff", staff);
		model.addAttribute("staffs", getStaffs());
		return "staff";
	}
	
	@SuppressWarnings("unchecked")
	public List<Staff> getStaffs() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;
	}
    


@ModelAttribute("departs")
    @SuppressWarnings("unchecked")
    public List<Depart> getDeparts() {
        Session session = factory.getCurrentSession();
        String hql = "FROM Depart";
        Query query = session.createQuery(hql);
        List<Depart> list = query.list();
        return list;
    }
}
