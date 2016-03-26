package com.chimera.droidport;


import com.chimera.droidport.screens.MenuScreen;
import com.chimera.droidport.screens.SplashScreen;
import com.badlogic.gdx.Game;

public class Chimera extends Game {

	@Override
	public void create() {
		setScreen(new SplashScreen(this));
	}
}