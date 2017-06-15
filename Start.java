package com.mateoandberg.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mateoandberg.games.OurGame.SCREEN;

public class Start {
	
	public static SpriteBatch batch;
	public static Texture img;
	
	public Start(){
		
		
		batch = new SpriteBatch();
		img = new Texture("newmenu.png");;
		
	}
		public void render() {
			batch.begin();
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);			
			batch.draw(img, 0, 0);
			if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				OurGame.screen = SCREEN.level1;
			}
			batch.end();
	
	
	
	}
}

	
