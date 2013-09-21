package com.me.GDXEngine.Engine;

import com.badlogic.gdx.utils.Array;
import com.me.GDXEngine.Engine.Renderer;

public class Layer {
	public String layerName;
	public Array<RenderSprite> objects;
	public Array<RenderShape> filledTriangles;
	public Boolean isActive;
	
	Layer(String name, Boolean active)
	{
		layerName = name;
		isActive = active;
		objects = new Array<RenderSprite>();
		filledTriangles = new Array<RenderShape>();
	}
	
	void Stop()
	{
		isActive = false;
	}
	
	void Start()
	{
		isActive = true;
	}
	
	void addSprite(RenderSprite sprite)
	{
		objects.add(sprite);
	}
	
	void addFilledTriangle(RenderShape aShape)
	{
		filledTriangles.add(aShape);
	}
}
