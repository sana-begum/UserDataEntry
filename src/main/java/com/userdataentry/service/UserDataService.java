package com.userdataentry.service;


import java.util.List;
import java.util.Optional;

import com.userdataentry.entity.UserDataModel;
import com.userdataentry.error.UserDataEntryNotFoundException;

public interface UserDataService {
	
	void saveUserData(UserDataModel userDataModel);

	void deleteUserData(Long id);

	List<UserDataModel> getAllUserData();
	
	UserDataModel getUserDataById(Long id) throws UserDataEntryNotFoundException;
	
	List<UserDataModel> getUserDataByName(String name);
}
