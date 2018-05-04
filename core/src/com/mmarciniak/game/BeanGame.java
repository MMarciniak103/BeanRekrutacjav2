package com.mmarciniak.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class BeanGame extends Game{
	public SpriteBatch batch;
	public Sprite bg;
	public Skin skin;
	public Bird bird;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.skin=new Skin(Gdx.files.internal("data/uiskin.json"));
		setScreen(new LoginScreen(this));
		bg=new Sprite(new Texture("bg.png"));
		bg.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        bird=new Bird();

	}

	@Override
	public void render () {

		super.render();

	}
	
	@Override
	public void dispose () {
	    batch.dispose();

	}
}
