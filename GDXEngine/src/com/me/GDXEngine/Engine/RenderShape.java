package com.me.GDXEngine.Engine;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class RenderShape {
	public enum Shapes{Rectangle,Line}
	
	private Vector2 position;
	private Vector2 size;
	
	private Vector2 l1;
	private Vector2 l2;
	
	private float r;
	private float g;
	private float b;
	
	private Vector2 tPoint0;
	private Vector2 tPoint1;
	private Vector2 tPoint2;
	
	public void setPosition(Vector2 _aPos){position = _aPos;}
	public Vector2 getPosition(){ return position;}
	
	public void setSize(Vector2 _aSize){ size = _aSize;}
	public Vector2 getSize(){return size;}
	
	public void setLine(Vector2 _l1, Vector2 _l2){l1 = _l1; l2 = _l2;}
	public Vector2 getL1(){return l1;}
	public Vector2 getL2(){return l2;}
	
	public void setColor(float _r, float _g, float _b){
		r = _r;
		g = _g;
		b = _b;
	}
	
	public float getRed(){
		return r;
	}
	
	public float getGreen(){
		return g;
	}
	
	public float getBlue(){
		return b;
	}
	
	public void setTrianglePoints(Vector2 _point0, Vector2 _point1, Vector2 _point2){
		tPoint0 = _point0;
		tPoint1 = _point1;
		tPoint2 = _point2;
	}
	
	public Vector2 getPoint0(){
		return tPoint0;
	}
	
	public Vector2 getPoint1(){
		return tPoint1;
	}
	
	public Vector2 getPoint2(){
		return tPoint2;
	}
		
}
