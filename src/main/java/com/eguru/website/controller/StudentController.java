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
import com.eguru.website.classobject.student;
import com.eguru.website.dao.CourseRepo;
import com.eguru.website.dao.GuruRepo;
import com.eguru.website.dao.StudentRepo;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepo studrepo;
	
	@Autowired
	GuruRepo gururepo;
	
	@Autowired
	CourseRepo courserepo;
	
	@RequestMapping("/studlogin")
	public String studlogin() {
		return "desktop2.jsp";
	}
	
	@RequestMapping("/studregister")
	public ModelAndView studregister(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("uname", 1);
		String s = "Student Register";
		return new ModelAndView("desktop3.jsp","heading",s);
	}
	
	@RequestMapping("/studforgotpassword")
	public ModelAndView studforgotpass(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("uname", 2);
		String s = "Retrieve Account";
		return new ModelAndView("desktop3.jsp","heading",s);
	}
	
	@RequestMapping("/studverifymail")
	public ModelAndView studverifymail(String email, @RequestParam("wrongcredential") Optional<Boolean> wrongcredential, HttpServletRequest request) {
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
			s="Student Register";
		}else {
			s="Retrieve Account";
		}
		return new ModelAndView("desktop4.jsp","heading",s);
	}
	
	@PostMapping("/studhome")
	public String studhome(String uname, String pass, HttpServletRequest request) {
		List<student> studs = studrepo.findByUsername(uname);
		for(student stud : studs) {
			if(pass.equals(stud.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("stud", stud);
				return "redirect:/studhome";
			}
		}
		return "redirect:/studlogin?wrongcredential=true";
	}
	
	@PostMapping("/studprofile")
	public ModelAndView studprofile(String otp,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String s = (String) session.getAttribute("otp");
		String uname = (String) session.getAttribute("email");
		if(s.equals(otp)) {
			List<student> studs = studrepo.findByEmailid(uname);
			student stud = new student(uname);
			if(studs.size()!=0) {
				stud = studs.get(0);
			}
			session.setAttribute("stud", stud);
			return new ModelAndView("desktop8.jsp","stud",stud);
		}
		return new ModelAndView("redirect:/studverifymail?email="+uname+"&wrongcredential=true");
	}
	
	@PostMapping("/studsaveprofile")
	public String studsaveprofile(String name, String uname, String email,String pass, String hline, String imgurl, String linkedin, String github, HttpServletRequest request) {
		HttpSession session = request.getSession();
		student stud = (student) session.getAttribute("stud");
		student save;
		if(stud.getStudid()==0) {
			List<student> studs = (List<student>) studrepo.findAll();
			int studid = 0;
			for(student temp : studs) {
				if(studid<temp.getStudid()) {
					studid=temp.getStudid();
				}
			}
			studid++;
			save = new student(studid,name,uname,pass,hline,imgurl,linkedin,github,"","",email);
		}else {
			save = new student(stud.getStudid(),name,uname,pass,hline,imgurl,linkedin,github,stud.getCoursenroll(),stud.getLast2course(),email);
		}
		studrepo.save(save);
		session.setAttribute("stud", save);
		return "redirect:/studhome";
	}
	
	@RequestMapping("/studhome")
	public ModelAndView studhome(HttpServletRequest request) {
		HttpSession session = request.getSession();
		student stud = (student) session.getAttribute("stud");
		if(stud==null) {
			return new ModelAndView("redirect:/joinus");
		}
		List<course> crs = new ArrayList<>();
		List<course> courses = (List<course>) courserepo.findAll();
		List<course> cres = new ArrayList<>();
		String s = stud.getCoursenroll();
		List<Integer> a = new ArrayList<>();
		int temp = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='#') {
				a.add(temp);
				temp=0;
				continue;
			}
			temp=temp*10+Character.getNumericValue(s.charAt(i));
			System.out.println("temp ="+temp);
		}
		if(temp!=0) {
			a.add(temp);
		}
		
		if(a.size()!=courses.size()) {
			crs = (List<course>) courserepo.findAll();
			for(int i=0;i<a.size();i++) {
				for(int j=0;j<crs.size();j++) {
					if(crs.get(j).getCourseid()==a.get(i)) {
						crs.remove(crs.get(j));
						break;
					}
				}
			}
			if(crs.size()>5){
				List<course> temp1 = new ArrayList<>();
				for(int i=0;i<4;i++) {
					Random rnd = new Random();
			    	int number = rnd.nextInt(crs.size());
			    	temp1.add(crs.get(number));
				}
				crs = temp1;
			}
		}
		
		s = stud.getLast2course();
		List<Integer> b = new ArrayList<>();
		temp = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='#') {
				b.add(temp);
				temp=0;
				continue;
			}
			temp=temp*10+Character.getNumericValue(s.charAt(i));
			System.out.println("temp ="+temp);
		}
		if(temp!=0) {
			b.add(temp);
		}
		
		for(int i=0;i<b.size();i++) {
			for(course cr:courses) {
				if(cr.getCourseid()==b.get(i)) {
					cres.add(cr);
				}
			}
		}
		
		ModelAndView mv = new ModelAndView("desktop10.jsp");
		mv.addObject("cres",cres);
		mv.addObject("crs", crs);
		return mv;
	}
	
	@RequestMapping("/editstudprofile")
	public String editstudprofile(HttpServletRequest request) {
		return "desktop8.jsp";
	}
	
	@RequestMapping("/studlogout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("stud", null);
		return "redirect:/joinus";	
	}
	
	@RequestMapping("/viewenrolledcourse")
	public ModelAndView viewenrolledcourse(HttpServletRequest request) {
		HttpSession session = request.getSession();
		student stud = (student) session.getAttribute("stud");
		List<course> courses = (List<course>) courserepo.findAll();
		List<course> crs = new ArrayList<>();
		String s = stud.getCoursenroll();
		List<Integer> a = new ArrayList<>();
		int temp = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='#') {
				a.add(temp);
				temp=0;
				continue;
			}
			temp=temp*10+Character.getNumericValue(s.charAt(i));	
		}
		a.add(temp);
		for(int i=0;i<a.size();i++) {
			for(course cr: courses) {
				if(cr.getCourseid()==a.get(i)) {
					crs.add(cr);
					break;
				}
			}
		}
		return new ModelAndView("desktop12.jsp","crs",crs);
	}
	
	@PostMapping("/coursecontent")
	public ModelAndView coursecontent(int courseid, String topic, HttpServletRequest request) {
		System.out.println(topic);
		course cr = courserepo.findById(courseid).orElse(null);
		List<String> a = new ArrayList<String>();
		List<String> b = new ArrayList<String>();
		List<String> c = new ArrayList<String>();
		String d = "";
		String e = "";
		String f = "";
		String s = cr.getPgtitle();
		String temp="";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='#') {
				a.add(temp);
				temp="";
				continue;
			}
			temp+=s.charAt(i);
		}
		if(!temp.equals("")) {
			a.add(temp);
		}
		s = cr.getVideolink();
		temp="";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='#') {
				b.add(temp);
				temp="";
				continue;
			}
			temp+=s.charAt(i);
		}
		if(!temp.equals("")) {
			b.add(temp);
		}
		s = cr.getVideodesc();
		temp="";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='#') {
				c.add(temp);
				temp="";
				continue;
			}
			temp+=s.charAt(i);
		}
		if(!temp.equals("")) {
			c.add(temp);
		}
		ModelAndView mv = new ModelAndView("desktop15.jsp","cr",cr);
		mv.addObject("a", a);
		if(topic==null) {
			d = a.get(0);
			e = b.get(0);
			f = c.get(0);
		}else {
			d = topic;
			e = b.get(a.indexOf(topic));
			f = c.get(a.indexOf(topic));
		}
		mv.addObject("d", d);
		mv.addObject("e", e);
		mv.addObject("f", f);
		return mv;
	}
	
	@PostMapping("/courseintro")
	public ModelAndView courseintro(int courseid, HttpServletRequest request) {
		course cr = courserepo.findById(courseid).orElse(null);
		guru sir = gururepo.findById(cr.getGuruid()).orElse(null);
		ModelAndView mv = new ModelAndView("desktop14.jsp","cr",cr);
		mv.addObject("sir", sir);
		return mv;
	}
	
	@PostMapping("/coursereg")
	public String coursereg(int courseid, HttpServletRequest request) {
		HttpSession session = request.getSession();
		student stud = (student) session.getAttribute("stud");
		String s = stud.getCoursenroll();
		stud.setCoursenroll(s+"#"+courseid);
		s = stud.getLast2course();
		stud.setLast2course(s.substring(2, s.length())+"#"+courseid);
		studrepo.save(stud);
		return "redirect:/viewenrolledcourse";
	}
}
