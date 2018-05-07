/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.jms.Session;
import javax.servlet.http.HttpSession;
import entity.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pc01
 */
@Transactional
@Controller
@RequestMapping()
public class SQL {
    
    @Autowired
	SessionFactory factory;
    
    

	@RequestMapping("login")
	public String login() {
		return "login";
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(ModelMap model, 
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			HttpSession httpSession) {
		org.hibernate.Session session = factory.getCurrentSession();
		try {
			User user = (User) session.get(User.class, id);
			if(!user.getPassword().equals(password)){
				model.addAttribute("message", "Sai tên mật khẩu !");
			  
                        }
                        else if(user.getId().equals(id)&&user.getPassword().equals(password)){
				model.addAttribute("message", "OK !");
			  return"admin";
                        }
                        
		} 
		catch (Exception e) {
			model.addAttribute("message", "Đăng nhập không thành công !");
		}
		
		return "login";
	}

	
    @SuppressWarnings("unchecked")
	public List<User> getUsers() {
		org.hibernate.Session session = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		return list;
	}    
    
      
    
    @RequestMapping("record")
    public String Record(HttpServletRequest request, ModelMap model) {
        return "record";
    }
  
}
