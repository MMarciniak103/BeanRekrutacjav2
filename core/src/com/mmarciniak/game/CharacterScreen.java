package com.mmarciniak.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class CharacterScreen implements Screen,InputProcessor {

    private BeanGame game;
    Sprite bg;
    Stage characterStage;
    Bird bird;
    Table table;
    TextButton yellowBird;
    TextButton blueBird;
    TextButton playButton;

    public CharacterScreen(final BeanGame game) {
        this.game = game;
        this.characterStage=new Stage(new ScreenViewport());
        this.bird = new Bird();
        this.table = new Table();
        table.setWidth(Gdx.graphics.getWidth());
        table.align(Align.center | Align.top);
        this.yellowBird =new TextButton("YELLOW",game.skin);
        yellowBird.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                bird.setBirdTexture(new Texture("bird.png"));
                event.stop();
            }
        });
        this.blueBird = new TextButton("BLUE",game.skin);
        blueBird.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                bird.setBirdTexture(new Texture("bluebird.png"));
            }
        });
        this.playButton =new TextButton("PLAY",game.skin);
        table.setPosition(0,Gdx.graphics.getHeight());
        table.padTop(30);
        table.add(yellowBird).width(Gdx.graphics.getWidth()/5).height(200).padBottom(50);
        table.row();
        table.add(blueBird).width(Gdx.graphics.getWidth()/5).height(200).padBottom(50);
        table.row();
        table.add(playButton).width(Gdx.graphics.getWidth()/5).height(200).padBottom(50);

        characterStage.addActor(table);

        InputMultiplexer im=new InputMultiplexer();
        im.addProcessor(characterStage);
        Gdx.input.setInputProcessor(im);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(bird.getBirdTexture(),bird.getBirdX(),bird.getBirdY());
        game.batch.end();

        characterStage.act();
        characterStage.draw();
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
