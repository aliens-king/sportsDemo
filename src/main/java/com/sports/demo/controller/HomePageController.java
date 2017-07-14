package com.sports.demo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sports.demo.stage.PrimeryStage;
import com.sports.demo.utils.Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomePageController implements Initializable {

	private PrimeryStage primeryStage = PrimeryStage.getInstance();

	@FXML
	private ListView<String> dashboardListView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void buildData() {
		ObservableList<String> items = FXCollections.observableArrayList("Home", "Games", "About", "Contact");
		dashboardListView.setItems(items);
		dashboardListView.getFocusModel().focus(0);
	}

	@FXML
	private void loadLoginPopup() {
		// System.out.println("Login button clicked.");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
		try {
			AnchorPane loginPane = loader.load();
			Stage stage = Utils.getStage();
			Scene scene = new Scene(loginPane);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
