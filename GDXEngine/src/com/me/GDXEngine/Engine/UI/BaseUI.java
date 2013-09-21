package com.me.GDXEngine.Engine.UI;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.me.GDXEngine.Engine.RenderableEntity;

public class BaseUI extends RenderableEntity{
	
	protected Array<BaseUI> viewComponents = new Array<BaseUI>();
	
	protected Vector2 startPos = new Vector2();
	protected Vector2 scrollChange = new Vector2();
	private Vector2 parentPos = new Vector2();
	private Vector2 localStartPos = new Vector2(); //distance from parent pos
	
	private Vector2 oldPos = new Vector2();
	private Vector2 changePos = new Vector2();
	
	protected Vector2 posOffset = new Vector2();
	
	private boolean hasCreated = false;
	
	/*the size of the boundingbox (use this to change size if dont want it to be auto size of sprite)
	 * or use the same origin as the sprites asset 
	 */
	protected Vector2 boundingSize = new Vector2();
	protected Vector2 boundingOrigin = new Vector2();
	
	public BaseUI(String _type, String _imageName, String _atlasName){
		super( _type, _imageName, _atlasName);
	}
	
	@Override
	public void Update(float dt){
		if (!hasCreated){
			onStart();
			hasCreated = true;
		}
		
		updateBoundingBox(position.x - (boundingOrigin.x * scale.x), position.y - (boundingOrigin.y * scale.y),
				boundingSize.x * scale.x, boundingSize.y * scale.y);
		
		position.x = startPos.x  + scrollChange.x + posOffset.x;
		position.y = startPos.y + scrollChange.y + posOffset.y;
		
		updateComponents(dt);
		
		if (position.x != oldPos.x){
			changePos.x = position.x - oldPos.x;
		}
		
		changePos.x = 0;
		oldPos = position;
	}
	
	/**
	 * Called once on creation after constructor
	 * all entitys should have this in future
	 */
	protected void onStart(){
		startPos = new Vector2(position.x + parentPos.x , position.y + parentPos.y);
		localStartPos.x = startPos.x - parentPos.x;
		localStartPos.y = startPos.y - parentPos.y;
		
		boundingSize.x = size.x;
		boundingSize.y = size.y;
		
		boundingOrigin.x = origin.x;
		boundingOrigin.y = origin.y;
		
		for (BaseUI aUI: viewComponents){
			aUI.setParentViewPos(position);
		}
	}
	
	public void add(BaseUI _aComponent){
		viewComponents.add(_aComponent);
	}
	
	private void updateComponents(float dt){
		for (BaseUI aUI : viewComponents){
			aUI.setHozScroll(scrollChange.x);
			aUI.setVertScroll(scrollChange.y);
			aUI.Update(dt);
		}
	}
	
	public void setHozScroll(float _xAmount){
		scrollChange.x = _xAmount;
	}
	
	public void setVertScroll(float _yAmount){
		scrollChange.y = _yAmount;
	}
	
	//offset the startPos by parent view pos
	public void setParentViewPos(Vector2 _parentPos){
		parentPos = _parentPos;
	}
	
	@Override
	public void Draw(){
		super.Draw();
		for (BaseUI aUI: viewComponents){
			aUI.Draw();
		}
	}
	
	public void setPosOffSet(float _xOffset, float _yOffset){
		posOffset.x = _xOffset;
		posOffset.y = _yOffset;
	}
	
	public Vector2 getStartPos(){
		return startPos;
	}
	
	public void setStartPos(Vector2 _startPos){
		startPos = _startPos;
	}
	
	public Vector2 getLocalStartPos(){
		return localStartPos;
	}
	
	public void removeAllComponents(){
		viewComponents.clear();
	}
	
	@Override
	public void Delete(){
		super.Delete();
		for (BaseUI aUI : viewComponents){
			aUI.Delete();
		}
	}
	
}
