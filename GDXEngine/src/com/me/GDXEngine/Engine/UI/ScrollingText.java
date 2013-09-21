package com.me.GDXEngine.Engine.UI;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.me.GDXEngine.Engine.BaseEntity;
import com.me.GDXEngine.Engine.ContentManager;
import com.me.GDXEngine.Engine.RenderableEntity;
import com.me.GDXEngine.Engine.Renderer;
import com.me.GDXEngine.Engine.SceneManager;

public class ScrollingText extends RenderableEntity {

	private Array<TextLetter> letters;
	
	private float textSpacing;
	
	private float xSpeed;
	
	private Vector2 startingPos;
	private Vector2 endingPos;
	
	private boolean tooLong;
	
	private int fadeSpacing;
	
	private float fadeOutSpeed;
	private float fadeInSpeed;
	
	private Vector2 textPosition;
	
	public ScrollingText(int xSpacing, float speed)
	{
		super("Text", "sprScrollingTextLarge", "data/Atlas/Menu.pack");
		
		textSpacing = xSpacing;
		
		startingPos = new Vector2(0,0);
		endingPos = new Vector2(0, 0);
		
		xSpeed = speed;
		
		letters = new Array<TextLetter>();
		
		tooLong = false;
		
		fadeInSpeed = fadeOutSpeed = 0;
	}
	
	public void SetFading(int amount, float fadeOut_Speed, float fadeIn_Speed)
	{
		fadeSpacing = amount;
		fadeOutSpeed = fadeOut_Speed;
		fadeInSpeed = fadeIn_Speed;
	}
	
	public void SetUpText(String text)
	{
		letters.clear();
		
		Vector2 letterPos = new Vector2(startingPos.x,
				getPosition().y);
		
		for(int i = 0; i < text.length(); i++)
		{
			TextLetter letter = new TextLetter(text.charAt(i), 1f);
			SceneManager.Scene().addEntity(letter);
			
			if (i != 0 ){
				letter.setPosition(letterPos.x + getLength("" + text.charAt(i-1))+
						textSpacing, getPosition().y + 3);
				letterPos.x += getLength("" + text.charAt(i-1)) + textSpacing;
			}else{
				letter.setPosition(letterPos.x
						+ getLength("" + text.charAt(i)) + textSpacing, getPosition().y + 3);
				letterPos.x += getLength("" + text.charAt(i))+ textSpacing;
			}
			
			if(letter.getPosition().x > endingPos.x)
			{
				tooLong = true;
				letter.setAlpha(0);
			}
			
			letters.add(letter);
		}
		
		textPosition = new Vector2(getPosition().x + 10,
				getPosition().y + 3);
	}
	
	public void SetSpeed(float speed)
	{
		xSpeed = speed;
	}
	
	public void SetEndPos(int xPos)
	{
		endingPos = new Vector2(xPos, getPosition().y);
	}
	
	public void SetStartPos(int xPos)
	{
		startingPos = new Vector2(xPos, getPosition().y);
	}
	
	@Override
	public void Update(float dt) {
		
		for(int i = 0; i < letters.size; i++)
		{
			letters.get(i).setPosition(letters.get(i).getPosition().x 
					+ xSpeed * dt, getPosition().y + 3);
			
			if(fadeSpacing > 0)
			{
				if(letters.get(i).getPosition().x < startingPos.x +
						fadeSpacing)
				{
					letters.get(i).FadeOut(fadeOutSpeed);
				}
				else if(letters.get(i).getPosition().x < endingPos.x)
				{
					letters.get(i).FadeIn(fadeInSpeed);
				}
			}
			
			if(letters.get(i).getPosition().x < startingPos.x)
			{	
				if(tooLong)
				{
					if(i == 0)
					{
						letters.get(i).setPosition(letters.get(letters.size - 1).getPosition().x 
								+ getLength(letters.get(letters.size - 1).GetLetter()) + textSpacing,
								getPosition().y + 3);
					}
					else
					{	
						letters.get(i).setPosition(letters.get(i - 1).getPosition().x 
								+ getLength(letters.get(i-1).GetLetter()) + textSpacing,
								getPosition().y + 3);
					}
				}
				else
				{
					letters.get(i).setPosition(endingPos.x,
							getPosition().y + 3);
				}
			}
			
			if(letters.get(i).getPosition().x > endingPos.x)
			{
				letters.get(i).setDraw(false);
			}
			else
			{
				letters.get(i).setDraw(true);
			}
		}
		
	}
	
	@Override
	public void Draw()
	{
		super.Draw();
		Renderer.drawText("ShopTextMeduim", 
				"Tip:", textPosition, 1, 1, 1, 1);
	}
	
	private float getLength(String _aLetter){
			return ContentManager.getFont("ShopTextMeduim").getBounds(_aLetter).width;
	}
	
	@Override
	public void Delete(){
		super.Delete();
		for (TextLetter aLetter : letters){
			aLetter.Delete();
		}
	}
}
