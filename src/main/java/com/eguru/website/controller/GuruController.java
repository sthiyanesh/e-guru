package com.eguru.website.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eguru.website.classobject.Mailing;
import com.eguru.website.classobject.course;
import com.eguru.website.classobject.guru;
import com.eguru.website.dao.CourseRepo;
import com.eguru.website.dao.GuruRepo;

@Controller
public class GuruController {
	
	@Autowired
	GuruRepo gururepo;
	
	@Autowired
	CourseRepo courserepo;

	@RequestMapping("/gurulogin")
	public String gurulogin() {
		return "desktop5.jsp";
	}
	
	@RequestMapping("/gururegister")
	public ModelAndView gururegister(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("uname", 1);
		String s = "Guru Register";
		return new ModelAndView("desktop6.jsp","heading",s);
	}
	
	@RequestMapping("/guruforgotpassword")
	public ModelAndView guruforgotpass(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("uname", 2);
		String s = "Retrieve Account";
		return new ModelAndView("desktop6.jsp","heading",s);
	}
	
	@RequestMapping("/guruverifymail")
	public ModelAndView guruverifymail(String email, @RequestParam("wrongcredential") Optional<Boolean> wrongcredential, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int a = (int) session.getAttribute("uname");
		if(!(wrongcredential.isPresent())) {
			try {
				String s = Mailing.mail(email,a);
				session.setAttribute("otp", s);
				session.setAttribute("email", email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String s;
		if(a==1) {
			s="Guru Register";
		}else {
			s="Retrieve Account";
		}
		return new ModelAndView("desktop7.jsp","heading",s);
	}
	
	@PostMapping("/guruhome")
	public String guruhome(String uname, String pass, HttpServletRequest request) {
		List<guru> gurus = gururepo.findByUsername(uname);
		for(guru sir : gurus) {
			if(pass.equals(sir.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("sir", sir);
				return "redirect:/guruhome";
			}
		}
		return "redirect:/gurulogin?wrongcredential=true";
	}
	
	@PostMapping("/guruprofile")
	public ModelAndView studprofile(String otp,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String s = (String) session.getAttribute("otp");
		String uname = (String) session.getAttribute("email");
		if(s.equals(otp)) {
			List<guru> gurus = gururepo.findByEmailid(uname);
			guru sir = new guru(uname);
			if(gurus.size()!=0) {
				sir = gurus.get(0);
			}
			session.setAttribute("sir", sir);
			return new ModelAndView("desktop9.jsp","sir",sir);
		}
		return new ModelAndView("redirect:/guruverifymail?email="+uname+"&wrongcredential=true");
	}
	
	@PostMapping("/gurusaveprofile")
	public String gurusaveprofile(String name, String uname, String email,String pass, String hline, String imgurl, String linkedin, String github, HttpServletRequest request) {
		HttpSession session = request.getSession();
		guru sir = (guru) session.getAttribute("sir");
		guru save;
		if(sir.getGuruid()==0) {
			List<guru> gurus = (List<guru>) gururepo.findAll();
			int guruid = 0;
			for(guru temp : gurus) {
				if(guruid<temp.getGuruid()) {
					guruid=temp.getGuruid();
				}
			}
			guruid++;
			save = new guru(guruid,name,uname,email,pass,hline,imgurl,linkedin,github);
		}else {
			save = new guru(sir.getGuruid(),name,uname,email,pass,hline,imgurl,linkedin,github);
		}
		gururepo.save(save);
		session.setAttribute("sir", save);
		return "redirect:/guruhome";
	}
	
	@RequestMapping("/guruhome")
	public ModelAndView guruhome(HttpServletRequest request) {
		HttpSession session = request.getSession();
		guru sir = (guru) session.getAttribute("sir");
		if(sir==null) {
			return new ModelAndView("redirect:/joinus");
		}
		List<course> crs = courserepo.findByGuruid(sir.getGuruid());
		ModelAndView mv = new ModelAndView("desktop11.jsp");
		if(crs.size()<5) {
			mv.addObject("crs", crs);
		}else {
			List<course> cres = new ArrayList<>();
			for(int i=0;i<4;i++) {
				Random rnd = new Random();
		    	int number = rnd.nextInt(crs.size());
		    	cres.add(crs.get(number));
			}
			mv.addObject("crs", cres);
		}
		return mv;
	}
	
	@RequestMapping("/createdcourses")
	public ModelAndView createdcourse(HttpServletRequest request) {
		HttpSession session = request.getSession();
		guru sir = (guru) session.getAttribute("sir");
		if(sir==null) {
			return new ModelAndView("redirect:/joinus");
		}
		List<course> crs = courserepo.findByGuruid(sir.getGuruid());
		return new ModelAndView("desktop13.jsp","crs",crs);
	}
	
	@RequestMapping("/editguruprofile")
	public String editstudprofile(HttpServletRequest request) {
		return "desktop9.jsp";
	}
	
	@RequestMapping("/gurulogout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("sir", null);
		return "redirect:/joinus";	
	}
}
