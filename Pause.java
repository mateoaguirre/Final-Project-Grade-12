package com.mateoandberg.games;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mateoandberg.games.OurGame.SCREEN;

public class Pause {
	public static SpriteBatch batch;
	public static Texture pmenu;
	public static int mx, my;
	public static boolean mb;
	
	public void create(){
		pmenu = new Texture("pmenu.jpg");
	}
	
	public void render(){
		batch.begin();
		batch.draw(pmenu, 0, 0);
		if (mb == true) {
			if (mx >= 215 && my <= 265 && mx <= 475 && my >= 170) {
				OurGame.screen = SCREEN.menu; 
			}
			if (mx >= 215 && my <= 525 && mx <= 475 && my >= 430) {
				OurGame.screen= SCREEN.level1;
			}

		}
		batch.end();
	}
}
