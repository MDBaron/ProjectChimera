package com.chimera.droidport.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.chimera.droidport.Chimera;
import com.chimera.droidport.Deprecated_ChimeraCore;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Sandbox";
		
		new LwjglApplication(new Chimera(), config);
	}
}
