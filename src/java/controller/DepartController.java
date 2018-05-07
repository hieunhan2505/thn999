/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Depart;
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
@RequestMapping("/depart")
public class DepartController {
    @Autowired
	SessionFactory factory;
	
	@RequestMapping()
	public String index(ModelMap model) {
		model.addAttribute("depart", new Depart());
		model.addAttribute("departs", getDeparts());
		return "depart";
	}
        
        @RequestMapping(params="btnInsert")
	public String insert(ModelMap model, @ModelAttribute("depart") Depart depart) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(depart);
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
		model.addAttribute("departs", getDeparts());
		return "depart";
	}
        
        @RequestMapping(params="btnUpdate")
	public String update(ModelMap model, @ModelAttribute("depart") Depart depart) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(depart);
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
		model.addAttribute("departs", getDeparts());
		return "depart";
	}
        
        @RequestMapping(params="btnDelete")
	public String delete(ModelMap model, Depart depart) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(depart);
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
		model.addAttribute("depart", new Depart());
		model.addAttribute("departs", getDeparts());
		return "depart";
	}
        
        @RequestMapping("{id}")
	public String edit(ModelMap model, @PathVariable("id") String id) {
		Session session = factory.getCurrentSession();
		Depart depart = (Depart) session.get(Depart.class, id);

		model.addAttribute("depart", depart);
		model.addAttribute("departs", getDeparts());
		return "depart";
	}
        
        @SuppressWarnings("unchecked")
	public List<Depart> getDeparts() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Depart";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		return list;
	}
}
