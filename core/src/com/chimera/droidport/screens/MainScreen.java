package com.chimera.droidport.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.*;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;

public class MainScreen implements Screen, ActionListener, InputProcessor {
	Game game;
	private SpriteBatch batch, batch2;
    private BitmapFont font;
    public static Music hihihi_Mu = Gdx.audio.newMusic(Gdx.files.internal("Hi Hi Hi.mp3"));
    public static Music krakenSea_Mu = Gdx.audio.newMusic(Gdx.files.internal("Kraken of the Sea.mp3"));
    public static Music machineEncounter_Mu = Gdx.audio.newMusic(Gdx.files.internal("Battle Against a Machine.mp3"));
    public static Music spellLearned_Mu = Gdx.audio.newMusic(Gdx.files.internal("Spell Learned.mp3"));
    public static Music stoneHengeBase_Mu = Gdx.audio.newMusic(Gdx.files.internal("The Stonehenge Base Shuts Down.mp3"));
    private Sound ssuka_So = Gdx.audio.newSound(Gdx.files.internal("Ssuka.mp3"));
    boolean isLooping = true;
    boolean firstRun = true;
    
	public final static int m_Screen_Width = Gdx.graphics.getWidth();
	public final static int m_Screen_Height = Gdx.graphics.getHeight();
	public final static int m_Projection_Matrix_Width = Gdx.graphics.getWidth();
	public final static int m_Projection_Matrix_Height = Gdx.graphics.getHeight();
	
	
	//Data Class for Touch Screen Diagnostics
	class TouchInfo {
        public float touchX = 0;
        public float touchY = 0;
        public boolean touched = false;
    }
	
	//Diagnostic values and storage
	private Map<Integer,TouchInfo> touches = new HashMap<Integer,TouchInfo>();
	private String message = "Touch A Thing...";
    private int w,h;
	
	//Generic polling
	boolean isTouched = Gdx.input.isTouched();
		
	//Multi-touch Polling
	boolean firstFingerTouching = Gdx.input.isTouched(0);
	boolean secondFingerTouching = Gdx.input.isTouched(1);
	boolean thirdFingerTouching = Gdx.input.isTouched(2);
		
	//Mouse InputPolling
	boolean leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);
	boolean rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT);
	
	public MainScreen(Game game){
		this.game = game;
		
		
		/* Diagnostic Setup for Input Processing */
		batch = new SpriteBatch();    
        font = new BitmapFont();
        font.setColor(Color.RED);
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Gdx.input.setInputProcessor(this);
        for(int i = 0; i < 5; i++){
            touches.put(i, new TouchInfo());
        }
        /* End Diagnostic Setup */
	}
	
	public void create(){
		
	}
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch = new SpriteBatch();
		batch.begin();
		
		if(!firstRun){
			message = "";
		}
		
		firstRun = false;
	        for(int i = 0; i < 5; i++){
	            if(touches.get(i).touched)
	                message += "Input: " + Integer.toString(i) + " registered at: " +
	                        Float.toString(touches.get(i).touchX) +
	                        "," +
	                        Float.toString(touches.get(i).touchY) +
	                        "\n";
	                                
	        }
	        TextBounds tb = font.getBounds(message);
	        float x = w/2 - tb.width/2;
	        float y = h/2 + tb.height/2;
	        font.drawMultiLine(batch, message, x, y);
	        
	        batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
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
		batch.dispose();
        font.dispose();
	}
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(pointer < 5){
            touches.get(pointer).touchX = screenX;
            touches.get(pointer).touchY = screenY;
            touches.get(pointer).touched = true;
        }
		return true;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(pointer < 5){
            touches.get(pointer).touchX = 0;
            touches.get(pointer).touchY = 0;
            touches.get(pointer).touched = false;
        }
        return true;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}