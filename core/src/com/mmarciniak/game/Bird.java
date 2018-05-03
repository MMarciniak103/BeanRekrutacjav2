package com.mmarciniak.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bird extends Actor {
    private Texture birdTexture;
    private float birdY;
    private float gravity;
    private float birdX;
    private float velocity;
    public Circle birdCircle;

    public Bird() {
        this.birdTexture = new Texture("bird.png");
        this.birdY = Gdx.graphics.getHeight()/2-birdTexture.getHeight()/2;
        this.gravity = 2;
        this.birdX = Gdx.graphics.getWidth()/2-birdTexture.getWidth()/2;
        this.velocity = 0;
        this.birdCircle = new Circle();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public float getBirdX() {
        return birdX;
    }

    public void setBirdX(float birdX) {
        this.birdX = birdX;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public Circle getBirdCircle() {
        return birdCircle;
    }

    public void setBirdCircle(Circle birdCircle) {
        this.birdCircle = birdCircle;
    }

    public Texture getBirdTexture() {
        return birdTexture;
    }

    public void setBirdTexture(Texture birdTexture) {
        this.birdTexture = birdTexture;
    }

    public float getBirdY() {
        return birdY;
    }

    public void setBirdY(float birdY) {
        this.birdY = birdY;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }
}

