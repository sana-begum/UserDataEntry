package com.userdataentry.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userdataentry.entity.UserDataModel;
import com.userdataentry.error.UserDataEntryNotFoundException;
import com.userdataentry.service.UserDataService;

@RestController
@CrossOrigin("*")
public class UserDataController {

	@Autowired
	UserDataService userDataService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUserData(@RequestBody UserDataModel userDataModel) {
		System.out.println("data save --->> ");
		String message = "hey! " + userDataModel.getFirstName() + " " + userDataModel.getLastName()
				+ ", your data is saved successfully";
		userDataService.saveUserData(userDataModel);
		return message;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteUserData(@PathVariable("id") Long id) {
		System.out.println("data delete --->");
		userDataService.deleteUserData(id);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<UserDataModel> getAllUserData() {
		return userDataService.getAllUserData();
	}

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public UserDataModel getUserDataById(@PathVariable("id") Long id) throws UserDataEntryNotFoundException {
		return userDataService.getUserDataById(id);
	}

	@RequestMapping(value = "/getByName/{firstName}", method = RequestMethod.GET)
	public List<UserDataModel> getUserDataByName(@PathVariable("firstName") String firstName) {
		return userDataService.getUserDataByName(firstName);
	}
}
