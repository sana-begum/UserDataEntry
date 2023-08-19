package com.userdataentry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userdataentry.entity.UserDataModel;
import com.userdataentry.error.UserDataEntryNotFoundException;
import com.userdataentry.repository.UserDataRepo;

@Service
public class UserDataServiceImpl implements UserDataService {
	
	@Autowired
	UserDataRepo repository;

	@Override
	public void saveUserData(UserDataModel userDataModel) {
		// TODO Auto-generated method stub
		repository.save(userDataModel);
	}

	@Override
	public void deleteUserData(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<UserDataModel> getAllUserData() {
		// TODO Auto-generated method stub
		List<UserDataModel> list = repository.findAll();
		return list;
	}

	@Override
	public UserDataModel getUserDataById(Long id) throws UserDataEntryNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserDataModel> userId = repository.findById(id);
		if(!userId.isPresent()) {
			throw new UserDataEntryNotFoundException("user not found");
		}
		return userId.get();
	}

	@Override
	public List<UserDataModel> getUserDataByName(String name) {
		// TODO Auto-generated method stub
		return repository.getAllUserDataByName(name);
		
	}
	
	
	
	
}
