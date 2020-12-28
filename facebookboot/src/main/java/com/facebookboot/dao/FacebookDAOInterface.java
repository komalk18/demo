package com.facebookboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.facebookboot.entity.FacebookUser;
import com.sun.xml.bind.v2.model.core.ID;

public interface FacebookDAOInterface extends JpaRepository<FacebookUser,Integer>{
	
	@Query("Select c from FacebookUser c where c.username=:name")
	FacebookUser searchProfileByName(String name);
	
	@Modifying
	@Transactional
	@Query("update FacebookUser c set c.username=:name,c.email=:em,c.password=:pass where c.uid=:id")
	int updateProfile(String name,String em,String pass,int id);
	
	@Transactional
	@Modifying
	@Query("delete from FacebookUser c where c.username=:name")
	int deleteByName(String name);
	
//	public int createProfileDAO(FacebookUser fu);
//	public int deleteProfileDAO(long id);
//	public int editProfileDAO(FacebookUser fu,long id,String name);
//	public List<FacebookUser> viewAllProfileDAO();
//	public List<FacebookUser> viewProfileDAO(long id);
//	public List<FacebookUser> searchProfileDAO(String name);
}
