package com.me.GDXEngine;


import Scenes.GameScene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import com.me.GDXEngine.Engine.AnimatedEntity;
import com.me.GDXEngine.Engine.BaseEntity;
import com.me.GDXEngine.Engine.ContentManager;
import com.me.GDXEngine.Engine.SceneManager;
import com.me.GDXEngine.Engine.SoundManager;

public class GameController {
	
	public GameController(){
		
		ContentManager.loadAtlas("data/Atlas/pack1.pack");	
		GameScene gameScene = new GameScene();
		SceneManager.addScene(gameScene);	
		SceneManager.switchScene("GameScene");
	}
}
