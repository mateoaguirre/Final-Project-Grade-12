package com.mateoandberg.games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OurGame extends ApplicationAdapter {
	public Start menu;
	public Lv1 level1;
	public Pause pmenu;
	public static SCREEN screen;
	
	public enum SCREEN{
		menu,level1,pmenu
	}
	
	
	

	

	@Override
	public void create() {	
		menu = new Start();
		level1 = new Lv1();
		screen = SCREEN.menu; 
		
		
		;
	}

	@Override
	
	public void render() {
		
		if (screen == SCREEN.menu) {
			menu.render();
		}else if(screen == SCREEN.level1){
			level1.render();
		}else if(screen ==  SCREEN.pmenu){
			pmenu.render();
		}
		

		

	}

	
	
}
