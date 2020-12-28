package com.facebookboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.facebookboot.dao.FacebookDAOInterface;
import com.facebookboot.entity.FacebookUser;
import com.sun.xml.bind.v2.model.core.ID;
@RestController
public class FacebookController {
	
	@Autowired
	private FacebookDAOInterface fd;
	
	@PostMapping("createprofilefacebook")
	public String createProfile(@RequestBody FacebookUser fu) {
		String str="Registration Fail";
//		int i=fd.createProfileDAO(fu);
//		if(i>0) {
//			str="Registration Success";
//		}
		fd.save(fu);
		return str;
	}
	@DeleteMapping("deleteprofilefacebook")
	public String deleteProfile(@PathParam("id") int id) {
		String str="not deleted";
//		int i=fd.deleteProfileDAO(id);
//		if(i>0) {
//			str="Deleted successfully"
//		}
		fd.deleteById(id);
		return str;
	}
	@PutMapping("editprofilefacebook")
	public int editProfile(@PathParam("id") int id,@PathParam("name") String name,@PathParam("em") String em,@PathParam("pass") String pass) {
		return fd.updateProfile(name,em,pass,id);
		
	}
	@GetMapping("viewAllprofilefacebook")
	public List<FacebookUser> viewallProfile() {
//		List<FacebookUser> l=fd.viewAllProfileDAO();
//		return l;
		return fd.findAll();
	}
	@GetMapping("viewprofilefacebook")
	public Optional viewProfile(@PathParam("id") int id) {
//		List<FacebookUser> l=fd.viewProfileDAO(id);
//		return l;
		return fd.findById(id);
	}
	@GetMapping("searchprofilefacebook")
	public FacebookUser searchProfile(@PathParam("name") String name) {
		//List<FacebookUser> l=fd.searchProfileDAO(name);
	   return fd.searchProfileByName(name);
	}
	@DeleteMapping("deleteByName")
	public int deleteProfile(@PathParam("name") String name) {
		return fd.deleteByName(name);
		
	}

}
