package com.chimera.droidport.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PauseScreen extends MainScreen {

	private TextureRegion pause;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private float time = 0;
	private String filePath = "PauseScreen.png";
	
	public PauseScreen(Game game){
		super(game);
		
		//Camera Setup
		camera = new OrthographicCamera();
		camera.setToOrtho(false, m_Projection_Matrix_Width, m_Projection_Matrix_Height);
		
		batch = new SpriteBatch();
	}
	
	@Override
	public void render(float delta) {
		//Set the background color
		Gdx.gl.glClearColor(0,0,0.2f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
				
		//Update Camera and Projection View
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		pause = new TextureRegion(new Texture(Gdx.files.internal(filePath)), 0, 0, m_Screen_Width, m_Screen_Height);
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, m_Projection_Matrix_Width, m_Projection_Matrix_Height);
		
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
