package com.me.GDXEngine.Engine;

public class Scene extends EntityManager {

	private String sceneName;
	
	private boolean pause;
	
	public Scene(String _sceneName){
		super();
		sceneName = _sceneName;
		pause = false;
	}
	
	public void SceneBegin(){
	}
	
	public void SceneEnd(){
		reset();
	}

	public String getSceneName(){
		return sceneName;
	}
	
	@Override
	public void Update(float dt){
		if (pause){
			dt = 0;
		}
			
		super.Update(dt);
	}
	
	public void setScenePause(boolean _aBool){
		pause = _aBool;
	}
	
		
		
}
