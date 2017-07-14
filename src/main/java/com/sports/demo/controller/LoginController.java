package com.sports.demo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sports.demo.stage.PrimeryStage;
import com.sports.demo.ui.model.UIUserDetails;
import com.sports.demo.utils.JDBCConnectionUtils;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private UIUserDetails UIUserDetails;

	@FXML
	private TextField txtUsername;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private Label errroLabel;

	private PrimeryStage primeryStage = PrimeryStage.getInstance();

	@FXML
	public UIUserDetails buttonLoginAction() {
		String userName = txtUsername.getText();
		String password = txtPassword.getText();
		JDBCConnectionUtils.openConnection();
		Connection connection = JDBCConnectionUtils.getConnection();
		String query = "Select * from user where username=? and password=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			// boolean rs = preparedStatement.execute();
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				try {

					/*FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
					loader.load();
					HomePageController homePageController = (HomePageController) loader.getController();
					homePageController.buildData(userName);*/
					/*
					 * HomePageController controller = new
					 * FXMLLoader(getClass().getResource("/view/Home.fxml"))
					 * .getController(); controller.buildData(userName);
					 */
					Stage stage = (Stage) txtUsername.getScene().getWindow();
					stage.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				errroLabel.setText("Invalid userrname/password.");
			}

			JDBCConnectionUtils.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UIUserDetails;

	}

	public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titleBar);
		alert.setHeaderText(headerMessage);
		alert.setContentText(infoMessage);
		alert.showAndWait();
	}

}
