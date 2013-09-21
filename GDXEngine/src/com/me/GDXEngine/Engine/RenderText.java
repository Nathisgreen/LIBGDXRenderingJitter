package com.me.GDXEngine.Engine;

import com.badlogic.gdx.math.Vector2;

public class RenderText {
	
	private String text;
	private float red;
	private float green;
	private float blue;
	private float alpha;
	private String font;
	private Vector2 position;
	
	public void setText(String _text){text = _text;}
	public void setColor(float _r, float _g, float _b , float _a){red = _r; green = _g; blue = _b; alpha = _a;}
	public void setfont(String _font){ font = _font;}
	public void setPosition(float _x, float _y){ position = new Vector2(_x, _y);}
	public void setPosition(Vector2 _aPos){ position = _aPos;}
	
	public String getText(){ return text;}
	public float getRed(){ return red;}
	public float getGreen(){ return green;}
	public float getBlue(){return blue;}
	public float getAlpha(){return alpha;}
	public String getFont(){return font;}
	public Vector2 getPosition(){return position;}
}
