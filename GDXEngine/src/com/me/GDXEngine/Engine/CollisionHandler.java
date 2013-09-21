package com.me.GDXEngine.Engine;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class CollisionHandler {
	
	private static Intersector theIntersector;
	public static void Init(){
		theIntersector = new Intersector();
	}
	
	public static boolean checkRectangleCollision(Rectangle _a, Rectangle _b){
		return theIntersector.intersectRectangles(_a, _b);
	}
	
	public static boolean placeMeeting(Rectangle _colRect ,float _x, float _y, String _type){
		Rectangle tempRec = new Rectangle(_colRect.x + _x, _colRect.y + _y, _colRect.width, _colRect.height);
		
		for (BaseEntity aEnt: SceneManager.Scene().getEntityType(_type)){
			RenderableEntity aRent = (RenderableEntity) aEnt;
			if (checkRectangleCollision(tempRec,aRent.getBoundingBox())){
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkLineCollision(Vector2 _LA1, Vector2 _LA2, Vector2 _LB1, Vector2 _LB2){

		return theIntersector.intersectSegments(_LA1, _LA2, _LB1, _LB2, null);
	}
	
	public static boolean checkPointInRectangle(Rectangle _colRect, Vector2 _point){
		return _colRect.contains(_point.x, _point.y);
	}
}
