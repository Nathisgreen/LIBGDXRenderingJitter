package com.me.GDXEngine;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.me.GDXEngine.Engine.ContentManager;
import com.me.GDXEngine.Engine.EntityManager;
import com.me.GDXEngine.Engine.Input;
import com.me.GDXEngine.Engine.Renderer;
import com.me.GDXEngine.Engine.SceneManager;
import com.me.GDXEngine.Engine.SoundManager;

public class Game implements ApplicationListener {
	
	private GameController theGame;
	private float delta;
	
	double t = 0.0;
	double dt = 1/60.0;
	
	double currentTime;
	
	public Game(){
	}
	
	public void create() {
		ContentManager.Init();
		SceneManager.Init();
		SoundManager.Init();
		Input.Init();
		Renderer.Init(800, 480);
		currentTime = System.currentTimeMillis() * 1000;
		theGame= new GameController();
	}

	@Override
	public void dispose() {
		SoundManager.Dispose();
		Renderer.Dispose();
	}
	
	@Override
	public void render() {
		delta = Gdx.graphics.getDeltaTime();
		delta = Math.min(delta, 0.1f);
		Input.Update(delta);
		SceneManager.Update(delta);
		Renderer.Draw();
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void resize(int width, int height) {
		Renderer.resizeRenderer(width, height);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}
}
