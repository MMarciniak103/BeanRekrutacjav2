package com.mmarciniak.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import sun.rmi.runtime.Log;

public class LoginScreen implements Screen,InputProcessor {

    private BeanGame game;
    Stage loginStage;
    TextField login;
    TextField password;
    Table table1;
    TextButton loginButton;

    public LoginScreen(final BeanGame game){
        this.game=game;
        loginStage=new Stage(new ScreenViewport());
        login=new TextField("LOGIN",game.skin);
        password=new TextField("PASSWORD",game.skin);
        loginButton=new TextButton("START",game.skin);
        loginButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(login.getText().equals("mm") && password.getText().equals("123")){
                    game.setScreen(new CharacterScreen(game));
                }
                event.stop();
            }
        });
        table1=new Table();
        table1.setWidth(Gdx.graphics.getWidth());
        table1.align(Align.center | Align.top);
        game.skin.getFont("default-font").getData().setScale(2f);
        table1.setPosition(0,Gdx.graphics.getHeight());
        table1.padTop(30);
        table1.add(login).width(Gdx.graphics.getWidth()/5).height(200).padBottom(50);
        table1.row();
        table1.add(password).width(Gdx.graphics.getWidth()/5).height(200).padBottom(50);
        table1.row();
        table1.add(loginButton).width(Gdx.graphics.getWidth()/5).height(200).padBottom(50);

        loginStage.addActor(table1);

        InputMultiplexer im=new InputMultiplexer();
        im.addProcessor(loginStage);
        Gdx.input.setInputProcessor(im);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        game.batch.begin();
        game.bg.draw(game.batch);
        game.batch.end();

        loginStage.act();
        loginStage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
