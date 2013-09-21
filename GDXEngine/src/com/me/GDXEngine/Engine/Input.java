package com.me.GDXEngine.Engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Input {
	
	private static int maxTouches = 5;
	private static int touchCount = 0;
	
	private static Array<Integer> touchIDs = new Array<Integer>();
	
	private static Vector2 tempVector;
	
	private static boolean backButtonDown = false;
	private static boolean backButtonPressed = false;
	
	public static void Init(){
		tempVector = new Vector2();
	}
	
	public static void Update(float dt){
		touchCount = 0;
		touchIDs.clear();
		for (int i = 0; i < maxTouches; i++){
			if (Gdx.input.isTouched(i)){
				touchCount++;
				touchIDs.add(i);
			}
		}
		
		if (Gdx.input.isKeyPressed(Keys.BACK)){
			backButtonDown = true;
		}else{
			if (backButtonDown){
				backButtonPressed = true;
				backButtonDown= false;
			}else{
				backButtonPressed = false;
			}
		}
	}
	
	public static boolean getTouched(){
		if (touchCount > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean getTouched(int i){
		return Gdx.input.isTouched(i);
	}
	
	/**
	 * Returns input position convereted to world space
	 * @return
	 */
	public static Vector2 getTouchedPosition(){
		tempVector.x = (Gdx.input.getX() - Renderer.getWindowOffset().x) / Renderer.getScreenScale().x;
		tempVector.y = (Gdx.input.getY() - Renderer.getWindowOffset().y) / Renderer.getScreenScale().y;
		return tempVector;
	}
	
	public static Vector2 getTouchedPosition(int i){
		tempVector.x = (Gdx.input.getX(i) - Renderer.getWindowOffset().x) / Renderer.getScreenScale().x;
		tempVector.y = (Gdx.input.getY(i) - Renderer.getWindowOffset().y) / Renderer.getScreenScale().y;
		return tempVector;
	}
	
	public static Array<Integer> getTouchIDs(){
		return touchIDs;
	}
	
	/**
	 * 
	 * @return number of touches on screen
	 */
	public static int getTouchNumber(){
		return touchCount;
	}
	
	public static boolean getBackButtonPressed(){
		return backButtonPressed;
	}

}
