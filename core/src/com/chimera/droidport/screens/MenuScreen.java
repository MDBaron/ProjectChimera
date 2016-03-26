package com.chimera.droidport.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MenuScreen extends MainScreen {

	private TextureRegion menu;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private float time = 0;
	final private float scale = 10;
	private String filePath = "standby.png";
	
	//Table configuration
	final private float padTop = 10;
	final private float padBottom = 10;
	final private float padLeft = 10;
	final private float padRight = 10;
	
	//Stage Setup for Main Menu Buttons
	Stage MenuStage;
	TextButton play, options, about;
    TextButtonStyle textButtonStyle;
    BitmapFont buttonFont;
    Skin buttonSkin;
    TextureAtlas buttonAtlas;
	
	//Button Dimensions Will Be Consistent
	private static final float m_ButtonWidth = 300f;
	private static final float m_ButtonHieght = 60f;
	private static final float m_ButtonSpace = 10f;
	
	public MenuScreen(Game game){
		super(game);
		
		//Camera Setup
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		
		    //Stage Setup
		    MenuStage = new Stage();
	        Gdx.input.setInputProcessor(MenuStage);
	    
	        buttonSkin = new Skin();
	        buttonSkin.add("logo", new Texture("button.png"));
	        
	        //Set "white" parameters as a texture
	        Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
            pixmap.setColor(Color.WHITE);
            pixmap.fill();
            buttonSkin.add("white", new Texture(pixmap));
	     
	        /* Set default font style for button Actors */
	        buttonSkin.add("default", new BitmapFont());

	        /* Skin the buttonStyle with background textures */
	        textButtonStyle = new TextButtonStyle();
	        textButtonStyle.up = buttonSkin.newDrawable("white", Color.BLUE);
	        textButtonStyle.down = buttonSkin.newDrawable("white", Color.DARK_GRAY);
	        textButtonStyle.checked = buttonSkin.newDrawable("white", Color.BLUE);
	        textButtonStyle.font = buttonSkin.getFont("default");
	        buttonSkin.add("default", textButtonStyle);
	        
	        /* Details for button Actors */
	        play = new TextButton("Main", textButtonStyle);
	        options = new TextButton("Options", textButtonStyle);
	        about = new TextButton("-About-", textButtonStyle);
	        
	        play.setTouchable(Touchable.enabled);
	        options.setTouchable(Touchable.enabled);
	        about.setTouchable(Touchable.enabled);
	        
	        //Create Table to hold Stage and Actors
	        Table table = new Table();
            table.setFillParent(true);
            table.debug();
            //table.debugTable();
            table.bottom();
            table.pad(padTop,padLeft,padBottom,padRight);
            MenuStage.addActor(table);
	       
	        
	        //Add the button Actors to Table
            table.add(play).width(m_Projection_Matrix_Width/4).height(m_Projection_Matrix_Height/10);
            //table.row();
            table.add(options).width(m_Projection_Matrix_Width/4).height(m_Projection_Matrix_Height/10);
            //table.row();
            table.add(about).width(m_Projection_Matrix_Width/4).height(m_Projection_Matrix_Height/10);
            
        

            //table.add(new Image(buttonSkin.newDrawable("white", Color.BLUE))).size(128);
	        
	}
	
	
	@Override
	public void render(float delta) {
		//Set the background color
		Gdx.gl.glClearColor(0,0,0.2f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        batch.draw(menu, menu.getRegionWidth(), menu.getRegionHeight());
        batch.end();
				
        MenuStage.act(Gdx.graphics.getDeltaTime());
        MenuStage.draw();
        
		//Update Camera and Projection View
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		
			if(play.isPressed()){
				hihihi_Mu.stop();
				krakenSea_Mu.isLooping();
				krakenSea_Mu.play();
				game.setScreen(new MainScreen(game));
			} else if(options.isPressed()){
				hihihi_Mu.stop();
				krakenSea_Mu.isLooping();
				krakenSea_Mu.play();
				//game.setScreen(new PauseScreen(game));
				game.setScreen(new MainScreen(game));
			} else if(about.isPressed()){
				//game.setScreen(new SplashScreen(game));
				game.setScreen(new MainScreen(game));
			}
		
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		final float buttonX = (width - m_ButtonWidth) / 2;
		float currentY = 280f;
		
		//Welcome Label
		//Label welcomeLabel = new Label("Enter Label Here", buttonSkin);
		//welcomeLabel.setX(((width - welcomeLabel.getWidth())/2));
		//welcomeLabel.setY(currentY + 100);
		//MenuStage.addActor( welcomeLabel );
		//camera.viewportWidth = width;
		//camera.viewportHeight = height;
		
		
		camera.update();
	}

	@Override
	public void show() {
		menu = new TextureRegion(new Texture(Gdx.files.internal(filePath)), 0, 0, m_Projection_Matrix_Width, m_Projection_Matrix_Height);
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, menu.getRegionWidth()*2, menu.getRegionHeight()*2);//m_Projection_Matrix_Width, m_Projection_Matrix_Height);
		
	}

	@Override
	public void hide() {
		Gdx.app.debug("Chimera", "dispose menu");
		batch.dispose();
		menu.getTexture().dispose();
		
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
