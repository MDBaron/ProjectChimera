package com.chimera.droidport.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SplashScreen extends MainScreen {

	private TextureRegion splash;
	private Texture splashTexture;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private float time = 0;
	private String filePath = "Free_Hugs.png";
	
	public SplashScreen(Game game){
		super(game);
		hihihi_Mu = Gdx.audio.newMusic(Gdx.files.internal("Hi Hi Hi.mp3"));
		batch = new SpriteBatch();
		//hihihi_Mu.setLooping(isLooping);
		//hihihi_Mu.play();
	}
	
	@Override
	public void create(){
		
	}
	
	@Override
	public void render(float delta) {
		//Set the background color
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(splash, splash.getRegionWidth()/2, splash.getRegionHeight()/2);
        batch.end();
				
		
		time += delta;
		if(time > 1.5){
			if( isTouched || Gdx.input.isKeyPressed(Keys.ANY_KEY) || Gdx.input.justTouched())
				
				game.setScreen(new MenuScreen(game));
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		splashTexture = new Texture(Gdx.files.internal(filePath));
		splash = new TextureRegion(splashTexture, 0, 0, splashTexture.getWidth(), splashTexture.getHeight());
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, splash.getRegionWidth()*2, splash.getRegionHeight()*2);
		
	}

	@Override
	public void hide() {
		Gdx.app.debug("Chimera", "dispose splash");
		batch.dispose();
		splash.getTexture().dispose();
		
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
		Gdx.app.debug("Chimera", "dispose splash");
		batch.dispose();
		splash.getTexture().dispose();
		
		
	}

}
