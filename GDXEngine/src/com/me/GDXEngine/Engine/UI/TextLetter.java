package com.me.GDXEngine.Engine.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.me.GDXEngine.Engine.BaseEntity;
import com.me.GDXEngine.Engine.ContentManager;
import com.me.GDXEngine.Engine.RenderableEntity;
import com.me.GDXEngine.Engine.Renderer;

public class TextLetter extends RenderableEntity {
	
	private String str_Letter;
	
	private boolean fadeIn, fadeOut;
	
	private float fadeOutSpeed;
	private float fadeInSpeed;
	
	private float length;
	
	public TextLetter(Character letter, float alphaStart){
		super();
		visible = true;
		
		str_Letter = letter.toString();
		fadeOutSpeed = 2.5f;
		fadeInSpeed = 10f;
		
		alpha = alphaStart;
	}
	
	public void FadeIn(float speed)
	{
		fadeIn = true;
		fadeOut = false;
		fadeInSpeed = speed;
	}
	
	public void FadeOut(float speed)
	{
		fadeOut = true;
		fadeIn = false;
		fadeOutSpeed = speed;
	}
	
	@Override
	public void Update(float dt) {
		
		if(fadeIn)
		{
			alpha += fadeInSpeed * dt;
			
			if(alpha > 1.0f)
			{
				alpha = 1.0f;
				fadeIn = false;
			}
		}
		
		if(fadeOut)
		{
			alpha -= fadeOutSpeed * dt;
			
			if(alpha < 0.0f)
			{
				alpha = 0.0f;
				fadeOut = false;
			}
		}
	}
	
	public String GetLetter()
	{
		return str_Letter;
	}
	
	public void Draw()
	{
		if(visible)
		{
			Renderer.drawText("ShopTextMeduim", str_Letter,
					position, 1, 1, 1, alpha);
		}
	}	
}
