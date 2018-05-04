package com.mmarciniak.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Tube {
    private Texture topTube,botTube;
    private float velocity;
    private float tubeDistance;
    public float[] TubeX,topTubeY,botTubeY,TubeGap;
    private int tubeNumber;
    public Rectangle[] topTubeRect,botTubeRect;

    public Tube() {
        this.topTube = new Texture("toptube.png");
        this.botTube = new Texture("bottomtube.png");
        this.velocity = 3;
        this.tubeNumber=4;
        this.tubeDistance= Gdx.graphics.getWidth()*3/4;
        TubeX = new float[tubeNumber];
        topTubeY = new float[tubeNumber];
        botTubeY=new float[tubeNumber];
        TubeGap=new float[tubeNumber];
        this.topTubeRect=new Rectangle[tubeNumber];
        this.botTubeRect=new Rectangle[tubeNumber];
    }

    public float[] getTopTubeY() {
        return topTubeY;
    }

    public void setTopTubeY(float[] topTubeY) {
        this.topTubeY = topTubeY;
    }

    public float[] getBotTubeY() {
        return botTubeY;
    }

    public void setBotTubeY(float[] botTubeY) {
        this.botTubeY = botTubeY;
    }

    public Rectangle[] getTopTubeRect() {
        return topTubeRect;
    }

    public void setTopTubeRect(Rectangle[] topTubeRect) {
        this.topTubeRect = topTubeRect;
    }

    public Rectangle[] getBotTubeRect() {
        return botTubeRect;
    }

    public void setBotTubeRect(Rectangle[] botTubeRect) {
        this.botTubeRect = botTubeRect;
    }

    public float getTubeDistance() {
        return tubeDistance;
    }

    public void setTubeDistance(float tubeDistance) {
        this.tubeDistance = tubeDistance;
    }



    public Texture getTopTube() {
        return topTube;
    }

    public void setTopTube(Texture topTube) {
        this.topTube = topTube;
    }

    public Texture getBotTube() {
        return botTube;
    }

    public void setBotTube(Texture botTube) {
        this.botTube = botTube;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public float[] getTubeX() {
        return TubeX;
    }

    public void setTubeX(float[] tubeX) {
        TubeX = tubeX;
    }



    public float[] getTubeGap() {
        return TubeGap;
    }

    public void setTubeGap(float[] tubeGap) {
        TubeGap = tubeGap;
    }

    public int getTubeNumber() {
        return tubeNumber;
    }

    public void setTubeNumber(int tubeNumber) {
        this.tubeNumber = tubeNumber;
    }
}

