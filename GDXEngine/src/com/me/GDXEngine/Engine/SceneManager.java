package com.me.GDXEngine.Engine;

import java.util.HashMap;

import com.badlogic.gdx.utils.Array;

public final class SceneManager {
	
	private static Scene activeScene;
	private static HashMap<String, Scene> sceneMap;
	
	private static boolean switchScene;
	private static String nextScene;
	
	private SceneManager(){}
	
	public static void Init(){
		sceneMap = new HashMap<String, Scene>();
		switchScene = false;
	}
	
	public static void Update(float dt){
		
		if (switchScene){
			doSwitchScene(nextScene);
			nextScene = "";
			switchScene = false;
		}
		
		if (activeScene != null){
			activeScene.Update(dt);
		}
	}

	public static void addScene(Scene _aScene){
		if (!sceneMap.containsKey(_aScene.getSceneName())){
			sceneMap.put(_aScene.getSceneName(), _aScene);
		}else{
			System.out.println("Error in scene createScene: Trying to add scene that already exists");
		}
	}
	
	public static void switchScene(String _sceneName){
		if (!switchScene){
			switchScene = true;
			nextScene = _sceneName;
		}
	}
	
	private static void doSwitchScene(String _sceneName){
		if (sceneMap.containsKey(_sceneName)){
			
			if(activeScene != null){
				activeScene.SceneEnd();
			}
			
			activeScene = sceneMap.get(_sceneName);
			activeScene.SceneBegin();
		}else{
			System.out.println("Error in SceneManager switchScene: Trying to load non existant scene");
		}
	}
	
	public static Scene Scene(){
		if (activeScene != null){
			return activeScene;
		}else{
			System.out.println("Error in Scene Scene()");
			return null;
		}
	}
}
