package com.mateoandberg.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mateoandberg.games.OurGame.SCREEN;

public class Lv1 {

	public SpriteBatch batch;
	public static Texture lvl, ext, car, car2, ground, lwall, rwall, lwall2,
			rwall2, redgem, bluegem, door1, door2, win, gear, pmenu, lvwin; // new
	public static int mx, my, sx, sy, x, y, yi, yi2, xmin, xmax, ymin, ymax,
			x2, y2, g1x, g1y, g2x, g2y, d1x, d1y, d2x, d2y; // new
	public static boolean game, other, mb, UP, LEFT, RIGHT, UP2, LEFT2, RIGHT2,
			DOWN, DOWN2, ONGROUND, ONGROUND2, DIR1, DIR2; // edited
	public static boolean gem1, overlapg1, gem2, overlapg2, d1, d2, overlapd1,
			overlapd2, haswon, mouseClicked, ENTER, start; // new
	public static Character char1, char2;
	public static Music m;

	public Lv1() {
		car = new Texture("map/char.png");
		car2 = new Texture("map/char2.png"); // new
		lvl = new Texture("sky.png");
		gear = new Texture("gear.png");
		ground = new Texture("map/island-middle.png");
		lwall = new Texture("map/wall-left.jpg");
		rwall = new Texture("map/wall-right.jpg");
		lwall2 = new Texture("map/wall-left2.jpg");
		rwall2 = new Texture("map/wall-right2.jpg");
		redgem = new Texture("map/redgem.png");
		bluegem = new Texture("map/bluegem.png");
		door1 = new Texture("map/reddoor.png");
		door2 = new Texture("map/bluedoor.png");
		lvwin = new Texture("levelcomplete.png");
		win = new Texture("win.png");
		m = Gdx.audio.newMusic(Gdx.files.internal("song.mp3"));
		char1 = new Character(car, car2, 0, 0);
		char2 = new Character(car, car2, 0, 0);
		DIR1 = DIR2 = false; // new
		gem1 = true;
		gem2 = true;
		haswon = false;
		sx = 20;
		sy = 10;
		x = 0;
		y = 20;
		yi = yi2 = 0;
		xmin = 25;
		ymin = 20;
		xmax = 1000;
		ymax = 720;
		x2 = 600;
		y2 = 100;
		g1x = 350; // new
		g1y = 200; // new
		g2x = 200; // new
		g2y = 200; // new
		d1x = 25;
		d2x = xmax - 74;
		d1y = d2y = 410;
		ONGROUND = ONGROUND2 = false;
		batch = new SpriteBatch();
	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	
		batch.begin();
		batch.draw(lvl, 0, 0);
		batch.draw(lwall, xmin - 95, 0);
		batch.draw(rwall, xmax, 0);
		batch.draw(gear, 950, 675);
		for (int i = 1; i < 100; i += 4) {
			batch.draw(ground, i * 20, 0);
		}

		if (gem1 == true && overlapg1 == false) { // new
			batch.draw(redgem, g1x, g1y); // new
		} else {
			d1 = true;
			batch.draw(door1, d1x, d1y);
		}

		if (gem2 == true && overlapg2 == false) { // new
			batch.draw(bluegem, g2x, g2y); // new
		} else {
			d2 = true;
			batch.draw(door2, d2x, d2y);
		}

		batch.draw(rwall, xmax, 0);
		if (DIR1 == true) {
			batch.draw(car, char1.getx(), char1.gety());
		} else {
			batch.draw(car2, char1.getx(), char1.gety());
		}
		if (DIR2 == true) { // new
			batch.draw(car, char2.getx(), char2.gety());
		} else {
			batch.draw(car2, char2.getx(), char2.gety());
		}

		if (overlapd1 == true && overlapd2 == true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		if (mx >= 625 && my <= 50 && mb == true) {
			OurGame.screen = SCREEN.pmenu;
		}

		// Game Elements
		if (g1x > x + 44 || g1y > y + 50 || x > g1x + 44 || y > g1y + 50) { // new
			overlapg1 = false; // new
		} else { // new
			gem1 = false; // new
		}
		if (gem1 == false) {
			if (d1x > x + 44 || d1y > y + 50 || x > d1x + 44 || y > d1y) {
				overlapd1 = false; // new
			} else {
				overlapd1 = true;
			}

		}

		if (g2x > x2 + 44 || g2y > y2 || x2 > g2x + 44 || y2 > g2y + 50) { // new
			overlapg2 = false; // new
		} else { // new
			gem2 = false; // new
		}
		if (gem2 == false) { // new
			if (d2x > x2 + 44 || d2y > y2 || x2 > d2x + 44 || y2 > d2y) {

				overlapd2 = false; // new
			} else {
				overlapd2 = true;
			}
		}
		if (y == ymin || y == 85 || y == 150 || y == 215 || y == 280
				|| y == 345 || y == 410) {
			char1.isonground();
		}

		if (y2 == ymin || y2 == 85 || y2 == 150 || y2 == 215 || y2 == 280
				|| y2 == 345 || y2 == 410) {
			char2.isonground();
		}

		if (x >= xmin && x <= xmax && y <= ymax && y >= ymin) {
			if (ONGROUND == false) {
				char1.move("fall");
			}
			if (UP == true && ONGROUND) {
				ONGROUND = false;
				char1.move("jump");
			}
			if (LEFT == true) {
				DIR1 = true; // new
				char1.move("mleft");
			}
			if (RIGHT == true) {
				DIR1 = false; // new
				char1.move("mright");
			}
		}
		if (yi > 0 && y < ymax - 20) {
			y += yi;
			yi--;
		} else {
			yi = 0;
		}

		if (DOWN && y != ymin) {
			ONGROUND = false;
		}

		// Character One Limits
		if (x < xmin) {
			x = xmin;
		} else if (y < ymin) {
			y = ymin;
		} else if (x > xmax - 44) {
			x = xmax - 44;
		} else if (y > ymax) {
			y = ymax;
		}

		// Character One ONGROUND

		// Character Two Movements
		if (x2 >= xmin && x2 <= xmax && y2 <= ymax && y2 >= ymin) {
			if (ONGROUND2 == false) {
				char2.move("fall");
			}
			if (UP2 == true && ONGROUND2) {
				ONGROUND2 = false;
				char2.move("jump");
			}
			if (LEFT2 == true) {
				DIR2 = true; // new
				char2.move("mleft");
			}
			if (RIGHT2 == true) {
				DIR2 = false; // new
				char2.move("mright");
			}
		}
		if (yi2 > 0 && y2 < ymax - 20) {
			y2 += yi2;
			yi2--;
		} else {
			yi2 = 0;
		}

		if (DOWN2 && y2 != ymin) {
			ONGROUND2 = false;
		}
		// Character Two Limits
		if (x2 < xmin) {
			x2 = xmin;
		} else if (y2 < ymin) {
			y2 = ymin;
		} else if (x2 > xmax - 44) {
			x2 = xmax - 44;
		} else if (y2 > ymax) {
			y2 = ymax;
		}
		batch.end();

	}

}
