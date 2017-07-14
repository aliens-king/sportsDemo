package com.sports.demo.stage;

import java.io.Serializable;

import javafx.stage.Stage;

public class PrimeryStage implements Serializable, Cloneable {

	private static final long serialVersionUID = -7604766932017737115L;

	private Stage stage;

	private PrimeryStage() {
	}
	private static class PrimeryStageHelper {

		private static final PrimeryStage instance = new PrimeryStage();
	}

	public static PrimeryStage getInstance() {
		return PrimeryStageHelper.instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return PrimeryStageHelper.instance;
	}

	protected Object readResolve() {
		return PrimeryStageHelper.instance;
	}

	/**
	 * @return the stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * @param stage the stage to set
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	
}
