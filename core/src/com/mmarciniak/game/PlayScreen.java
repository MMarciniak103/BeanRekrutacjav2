package com.mmarciniak.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class PlayScreen implements Screen, InputProcessor {

    private BeanGame game;
    private int gamestate; //0-w8 for player move, 1-active game,2-gameover
    private Tube tube;
    private int score;
    private int scoringTube;
    private Random random;
    private ShapeRenderer shapeRenderer;
    private BitmapFont font1,font2;
    private Texture gameover;

    public PlayScreen(final BeanGame game) {
        this.game = game;
        this.gamestate = 0;
        this.tube = new Tube();
        this.score = 0;
        this.scoringTube = 0;
        this.random = new Random();
        this.shapeRenderer = new ShapeRenderer();
        this.font1=new BitmapFont();
        font1.setColor(Color.WHITE);
        font1.getData().setScale(10);
        this.font2=new BitmapFont();
        font2.setColor(Color.RED);
        font2.getData().setScale(5);
        gameover=new Texture("flappybirdOver.png");

        startGame();

    }

    public void startGame() {

        game.bird.setBirdY(Gdx.graphics.getHeight() / 2 - game.bird.getBirdTexture().getHeight() / 2);
        game.bg.setTexture(new Texture(Gdx.files.internal("bg.png")));

        for (int i = 0; i < tube.getTubeNumber(); i++) {
            tube.TubeGap[i] = random.nextInt(500) + 300;
            tube.TubeX[i] = Gdx.graphics.getWidth() * 3 / 4 + i * tube.getTubeDistance();
            tube.topTubeY[i] = Gdx.graphics.getHeight() / 2 + tube.TubeGap[i] / 2;
            tube.botTubeY[i] = Gdx.graphics.getHeight() / 2 - tube.TubeGap[i] / 2 - tube.getBotTube().getHeight();
            tube.topTubeRect[i] = new Rectangle();
            tube.botTubeRect[i] = new Rectangle();
        }

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        if(score>2) game.bg.setTexture(new Texture("mariobg.png"));
        else game.bg.setTexture(new Texture("bg.png"));
        if (gamestate == 0) {
            game.batch.begin();
            game.bg.draw(game.batch);
            game.batch.draw(game.bird.getBirdTexture(), game.bird.getBirdX(), game.bird.getBirdY());
            if (Gdx.input.justTouched()) {
                gamestate = 1;
            }
            game.batch.end();
        } else if (gamestate == 1) {
            game.batch.begin();
            game.bg.draw(game.batch);
            if (Gdx.input.justTouched()) {
                game.bird.setVelocity(-20);
            }
            if (game.bird.getBirdY() > 0) {

                game.bird.setVelocity(game.bird.getVelocity() + game.bird.getGravity());
                game.bird.setBirdY(game.bird.getBirdY() - game.bird.getVelocity());

            } else {
                game.bird.setBirdY(0);
                gamestate = 2;
            }

            for (int i = 0; i < tube.getTubeNumber(); i++) {
                tube.TubeGap[i] = random.nextInt(500) + 300;
                if (tube.TubeX[i] < -tube.getTopTube().getWidth()) {
                    tube.TubeX[i] += tube.getTubeNumber() * tube.getTubeDistance();
                    tube.topTubeY[i] = Gdx.graphics.getHeight() / 2 + tube.TubeGap[i] / 2;
                } else {
                    tube.TubeX[i] -= tube.getVelocity();
                }

                game.batch.draw(tube.getTopTube(), tube.TubeX[i], tube.topTubeY[i]);
                game.batch.draw(tube.getBotTube(), tube.TubeX[i], tube.botTubeY[i]);

                tube.topTubeRect[i] = new Rectangle(tube.TubeX[i], tube.topTubeY[i], tube.getTopTube().getWidth(), tube.getTopTube().getHeight());
                tube.botTubeRect[i] = new Rectangle(tube.TubeX[i], tube.botTubeY[i], tube.getBotTube().getWidth(), tube.getBotTube().getHeight());

                game.bird.birdCircle.set(Gdx.graphics.getWidth() / 2, game.bird.getBirdY() + game.bird.getBirdTexture().getHeight() / 2, game.bird.getBirdTexture().getWidth() / 2);

                if (Intersector.overlaps(game.bird.birdCircle, tube.topTubeRect[i]) || Intersector.overlaps(game.bird.birdCircle, tube.botTubeRect[i])) {
                    gamestate = 2;
                }
                if (tube.TubeX[scoringTube] < Gdx.graphics.getWidth() / 2 - game.bird.getBirdTexture().getWidth()) {
                    score++;
                    if (scoringTube < tube.getTubeNumber() - 1) {
                        scoringTube++;
                    } else {
                        scoringTube = 0;
                    }
                }
            }
            game.batch.draw(game.bird.getBirdTexture(),game.bird.getBirdX(),game.bird.getBirdY());
            font1.draw(game.batch,String.valueOf(score),200,200);
            game.batch.end();
        }else if(gamestate==2){
            game.batch.begin();
            game.bg.draw(game.batch);
            game.batch.draw(gameover, Gdx.graphics.getWidth() / 2 - gameover.getWidth() / 2, Gdx.graphics.getHeight() / 2 - gameover.getHeight() / 2);
            font2.draw(game.batch, "YOUR SCORE: " + String.valueOf(score), Gdx.graphics.getWidth() / 5, Gdx.graphics.getHeight() * 3 / 4);

            if (Gdx.input.justTouched()) {
                gamestate = 0;
                startGame();
                game.bird.setVelocity(0);
                score = 0;
                scoringTube = 0;
            }
            game.batch.end();

        }

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

    @Override
    public void show() {

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
        this.dispose();
    }

    @Override
    public void dispose() {

    }
}
