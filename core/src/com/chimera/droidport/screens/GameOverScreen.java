package com.chimera.droidport.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameOverScreen extends GameScreen {
	TextureRegion gameOver;
	SpriteBatch batch;
	float time = 0;
	String filePath = "GameOverScreen.png";
	
	public GameOverScreen(Game game){
		super(game);
	}//Constructor
	
	@Override
	public void show(){
		gameOver = new TextureRegion(new Texture(Gdx.files.internal(filePath)), 0, 0, m_Screen_Width, m_Screen_Height);
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, m_Projection_Matrix_Width, m_Projection_Matirx_Height);
	}//show
	
	@Override
	public void render(float delta){
		
	}//render
	
	@Override
	public void hide(){
		Gdx.app.debug("Chimera", "dispose gameover");
		batch.dispose();
		gameOver.getTexture().dispose();
	}//hide
}
