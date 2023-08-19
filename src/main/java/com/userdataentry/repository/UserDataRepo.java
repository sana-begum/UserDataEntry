package com.userdataentry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.userdataentry.entity.UserDataModel;

@Repository
public interface UserDataRepo extends JpaRepository<UserDataModel, Long> {
	
	@Query("From UserDataModel where firstName=?1")
	public List<UserDataModel> getAllUserDataByName(String name);
	
}
