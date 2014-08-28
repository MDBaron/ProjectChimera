package com.chimera.droidport.desktopinstance;

import com.chimera.droidport.ChimeraCore;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class ChimeraDesktop {
	public static void main (String[] argv) {
		new LwjglApplication(new ChimeraCore(), "Chimera", 720, 540);

		// After creating the Application instance we can set the log level to
		// show the output of calls to Gdx.app.debug
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
	}
}
