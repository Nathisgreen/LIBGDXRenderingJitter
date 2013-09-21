package com.me.GDXEngine;

import com.me.GDXEngine.Engine.RenderableEntity;
import com.me.GDXEngine.Engine.Renderer;

public class TestObj extends RenderableEntity {
	
	public TestObj(){
		super("TestObj", "sprCoinCollectableBronze","data/Atlas/pack1.pack");
		scale.x = 10;
		scale.y = 10;
		
		setOrigin(sourceRectangle.width/2, sourceRectangle.height/2);
	}

	
	public void Update(float dt){
		position.x -= 400 * dt;
		
		if (position.x < -50){
			position.x = Renderer.getCameraSize().x+ 150;
		}
	}
}
