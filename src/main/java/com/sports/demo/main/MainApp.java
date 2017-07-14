package com.sports.demo.main;

import java.io.IOException;

import com.sports.demo.controller.HomePageController;
import com.sports.demo.stage.PrimeryStage;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Hello world!
 *
 */
public class MainApp extends Application {
	private PrimeryStage primeryStage = PrimeryStage.getInstance();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		/* to remove maximize minimize and close buttton */
		stage.initStyle(StageStyle.UNDECORATED);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SplashScreen.fxml"));
		AnchorPane parentPane = loader.load();
		primeryStage.setStage(stage);
		Scene scene = new Scene(parentPane);

		stage.setScene(scene);
		stage.show();

		Task<Void> sleeper = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				return null;
			}

		};
		sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			public void handle(WorkerStateEvent event) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
				try {
					BorderPane parentPane = loader.load();
					HomePageController controller = loader.getController();
					controller.buildData();	
					Scene scene = new Scene(parentPane);
					primeryStage.getStage().setScene(scene);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		new Thread(sleeper).start();
	}

}
