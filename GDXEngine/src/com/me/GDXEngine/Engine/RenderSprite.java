package com.me.GDXEngine.Engine;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RenderSprite {

	private Vector2 position;
	private Vector2 origin;
	private Vector2 size;
	private Rectangle sourceRectangle;
	private TextureRegion textureRegion;
	private float rotation;
	private float xScale;
	private float yScale;
	private float alpha;	
	private Color color;
	
	float depth;
	
	RenderSprite(){reset();}
	
	void setTextureRegion(TextureRegion _aRegion){textureRegion = _aRegion;} 
	TextureRegion getTextureRegion(){return textureRegion;}
	
	void setPosition(Vector2 _aPos){ position = _aPos;}
	Vector2 getPosition(){return position;}
	
	void setSourceRectangle(Rectangle _aRec){sourceRectangle = _aRec;}
	Rectangle getSourceRectangle(){return sourceRectangle;}
	
	void setSourceSize(Vector2 _aSize){size = _aSize;}
	Vector2 getSourceSize(){return size;}
	
	void setRotation(float _rot){rotation = _rot;}
	float getRotation(){ return rotation;}
	
	void setOrigin(Vector2 _org){origin = _org;}
	Vector2 getOrigin(){return origin;}
	
	void setDepth(float _depth){depth = _depth;}
	float getDepth(){ return depth;}
	
	void setAlpha(float _alpha){alpha = _alpha;}
	float getAlpha(){return alpha;}
	
	void setScale(float _xScale, float _yScale){xScale = _xScale; yScale = _yScale;}
	float getXScale(){return xScale;}
	float getYScale(){return yScale;}
	
	Color getColor(){return color;}
	void setColor(Color _color){color = _color;}
	
	void reset(){
		position = new Vector2(0,0);
		origin = new Vector2(0,0);
		sourceRectangle = new Rectangle();
		rotation = 0 ;
		depth = 0;	
		size = new Vector2();
		xScale = 1;
		yScale = 1;
		alpha = 1;
	}
	
}
