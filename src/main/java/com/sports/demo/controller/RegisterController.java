package com.sports.demo.controller;

import com.sports.demo.ui.model.UIUserDetails;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
	@FXML
	private UIUserDetails uiUserDetails;

	@FXML
	private TextField txtUserName;

	
	@FXML
	private PasswordField txtPassword;
	

	@FXML
	private TextField country;

	public UIUserDetails buttonRegisterationAction() {
		
		
		return uiUserDetails;
		

	}

}
