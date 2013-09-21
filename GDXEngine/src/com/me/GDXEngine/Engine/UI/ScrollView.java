package com.me.GDXEngine.Engine.UI;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.me.GDXEngine.Engine.Input;
import com.me.GDXEngine.Engine.Renderer;

public class ScrollView extends Button {
	
	private Vector2 clickDownPos = new Vector2();
	public Vector2 scrolledAmount = new Vector2();
	
	protected Vector2 minScroll = new Vector2();
	protected Vector2 maxScroll = new Vector2();
	public ScrollView(String _imageName, String _atlasName) {
		super(_imageName, _atlasName);
		setType("ScrollView");
		minScroll.x = 0;
		minScroll.y = 0;
		maxScroll.x = size.x;
		maxScroll.y = -size.y;
	}
	
	public ScrollView() {
		super("", "");
		setType("ScrollView");
		setDraw(false);
	}
	
	@Override
	public void Update(float dt){
		super.Update(dt);
		//stop scrollView from...scrolling
		position.y = startPos.y;
		position.x = startPos.x;
	}
	
	@Override
	public void Draw(){
		super.Draw();
		//Renderer.drawRectangle(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
	}
	
	@Override
	public void TouchedEnter(){
		clickDownPos = new Vector2(Input.getTouchedPosition().x,Input.getTouchedPosition().y) ;
	}
	
	@Override
	public void TouchedHeld(){
		float diff = (Input.getTouchedPosition().y - clickDownPos.y);
		scrollChange.y = scrolledAmount.y + diff;
		
		if(scrollChange.y >= minScroll.y){
			scrollChange.y = minScroll.y;
		}
		
		if (scrollChange.y <= maxScroll.y){
			scrollChange.y = maxScroll.y;
		}
	}
	
	@Override
	public void TouchedReleased(){
		scrolledAmount.x = scrollChange.x;
		scrolledAmount.y = scrollChange.y;
	}
	
	@Override
	public void TouchedLeave(){
		scrolledAmount.x = scrollChange.x;
		scrolledAmount.y = scrollChange.y;
	}
	
	public void setMaxScrollVert(int _maxScroll){
		maxScroll.y = _maxScroll;
	}
	
	public void setMinScrollVert(int _minScroll){
		minScroll.y = _minScroll;
	}

}
