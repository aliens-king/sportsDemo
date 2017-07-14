package com.sports.demo.utils;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Utils {
	
	
	public static Stage getStage(){
		
		Stage stage = new Stage();
		stage.initStyle(StageStyle.UNDECORATED);
		return stage;
	}

}
