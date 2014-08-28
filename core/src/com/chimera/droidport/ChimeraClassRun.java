package com.chimera.droidport;


import com.chimera.droidport.screens.GameScreen;
import com.badlogic.gdx.Game;

public class ChimeraClassRun extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen(this));
	}
}