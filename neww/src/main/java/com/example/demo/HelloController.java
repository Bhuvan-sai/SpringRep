package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping(method=RequestMethod.GET)
	public void sayHello() {
		System.out.println("Welcome to Spring MVC...");
	}
	@RequestMapping(value="hello2",method=RequestMethod.GET)
	public String sayHello2() {
		System.out.println("sayHello2 method is called");
		return "welcome2";
	}
	@RequestMapping(value="hello3",method=RequestMethod.GET)
	public ResponseEntity<String> sayHello3() {
		return ResponseEntity.ok("Welcome from Hello3");
	}
	@RequestMapping(value="hello4",method=RequestMethod.GET)
	public ModelAndView sayHello4(ModelAndView mandv) {
		mandv.addObject("myKey","Welcome from hello4");
		mandv.setViewName("welcome2");
		return mandv;
	}
	@RequestMapping(value="hello6",method=RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("myKey","Welcome from hello6");
		mandv.setViewName("welcome2");
		request.setAttribute("hello","Hello world Hello world Hello world");
		return mandv;
	}
	@RequestMapping(value="repeat",method=RequestMethod.GET)
	public ModelAndView repeat(ModelAndView mandv, HttpServletRequest request) {
		System.out.println("repeat method is called..");
		mandv.addObject("myKey","welcome to spring mvc.....repeat repeat repeat...");
		mandv.setViewName("welcome2");
		request.setAttribute("hello","this is from repeat..");
		return mandv;
	}
	@RequestMapping(value="hello7/{name}",method=RequestMethod.GET)
	public ModelAndView sayHello7(@PathVariable String name,ModelAndView mandv, HttpServletRequest request) {
		System.out.println("hello7 method is called..");
		
		mandv.addObject("myKey",name);
		mandv.setViewName("welcome2");
		request.setAttribute("hello","Path variable.....");
		return mandv;
	}
	@RequestMapping(value="hello8",method=RequestMethod.GET)
	public ModelAndView sayHello8(@RequestParam("uname") String name,ModelAndView mandv, HttpServletRequest request) {
		System.out.println("hello8 method is called..");
		
		mandv.addObject("myKey",name);
		mandv.setViewName("welcome2");
		request.setAttribute("hello","repeat"+name);
		return mandv;
	}
	@RequestMapping(value="hello9",method=RequestMethod.GET)
	public ResponseEntity<User> sayHello9(){
		User user= new User();
		user.setUid(100);
		user.setUname("ramu");
		System.out.println("hello9 method is called..");
		return ResponseEntity.ok(user);
	}
	@RequestMapping(value="hello10",method=RequestMethod.GET)
	public ResponseEntity<User> sayHello12(@RequestBody User user){
		
		user.setUid(200);
		user.setUname("java");
		
		return ResponseEntity.ok(user);
	}
	@RequestMapping(value="hello11",method=RequestMethod.GET)
	public ResponseEntity<User> sayHello11(@RequestBody User user){
		System.out.println("hello11 method is called..");
		user.setUid(19988);
		user.setUname("spring boot");
		
		return User;
	}
}

class User{
	int uid;
	String uname;
	public void setUid(int uid) {
		this.uid=uid;
	}
	public void setUname(String uname) {
		this.uname=uname;
	}
	public int getUid() {
		return uid;
	}
	public String getUname() {
		return uname;
	}
}


