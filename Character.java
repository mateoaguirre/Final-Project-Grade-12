package com.mateoandberg.games;

import java.util.ArrayList;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Character {
	private ArrayList<Boolean> keys;
	private boolean ableToMove, alive, lmove, rmove, umove, dmove, onground;
	private Texture left, right;
	private int posx, posy, jump;

	public Character(Texture l, Texture r, int x, int y) {
		ableToMove = true;
		alive = true;
		left = l;
		right = r;
		jump = 0;
		posx = x;
		posy = y;
	}

	public void move(String m) {
		if (ableToMove = true) {
			if (m == "fall") {
				posy -= 5;
			}
			if (m == "jump") {
				jump = 20;
				posy += jump;
				jump--;
			}
			if (m == "mright") {
				posx += 5;
			}
			if (m == "mleft") {
				posx -= 5;
			}
		}
	}

	public int getx() {
		return (posx);
	}

	public int gety() {
		return (posy);
	}

	public Texture getleft() {
		return (left);
	}

	public Texture getright() {
		return (right);
	}

	public void isonground() {
		onground = true;
	}

	public void isnotonground() {
		onground = false;
	}
}
