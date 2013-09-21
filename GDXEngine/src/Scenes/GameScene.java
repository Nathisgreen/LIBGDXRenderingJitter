package Scenes;


import com.me.GDXEngine.TestObj;
import com.me.GDXEngine.Engine.Renderer;
import com.me.GDXEngine.Engine.Scene;
import com.me.GDXEngine.Engine.SoundManager;

public class GameScene extends Scene {

	public GameScene() {
		super("GameScene");
	}
	
	@Override
	public void SceneBegin(){
		
		SoundManager.StopMusic("TitlePart1");
		SoundManager.StopMusic("TitlePart2");
		TestObj atest = new TestObj();
		addEntity(atest);
		atest.setPosition(100, Renderer.getCameraSize().y/2);
	}
	
	
	@Override
	public void SceneEnd(){
		reset();
	}
	

}
