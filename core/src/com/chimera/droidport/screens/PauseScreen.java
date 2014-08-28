package com.chimera.droidport.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PauseScreen extends GameScreen {

	TextureRegion pause;
	SpriteBatch batch;
	float time = 0;
	String filePath = "PauseScreen.png";
	
	public PauseScreen(Game game){
		super(game);
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		pause = new TextureRegion(new Texture(Gdx.files.internal(filePath)), 0, 0, m_Screen_Width, m_Screen_Height);
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, m_Projection_Matrix_Width, m_Projection_Matirx_Height);
		
	}

	@Override
	public void hide() {
		Gdx.app.debug("Chimera", "dispose pause");
		batch.dispose();
		pause.getTexture().dispose();
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
