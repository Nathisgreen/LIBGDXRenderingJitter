package com.me.GDXEngine.Engine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimatedEntity extends RenderableEntity {
	
	private Array<TextureRegion> animationRegions = new Array<TextureRegion>();
	
	protected int frameIndex = 0;
	protected int frameNumber;
	
	private float animationTime = 0;
	protected float animationSpeed = 0;
	
	public AnimatedEntity(String _type, String _textureName, String _atlasPath, float _animationSpeed){
		super(_type,_textureName,_atlasPath);
		setUpAnimations(_atlasPath, texturePath);
		animationSpeed = _animationSpeed;
	}
	
	public void setUpAnimations(String _atlasPath, String _texturePath){
		texturePath = _texturePath;
		animationRegions.clear();
		for (AtlasRegion aAtlas : ContentManager.getTextureAtlas(_atlasPath).findRegions(texturePath)){
			animationRegions.add(aAtlas);
		}
		frameNumber =  animationRegions.size;
	}
	
	public void SetAnimationSpeed(float new_Speed)
	{
		animationSpeed = new_Speed;
	}
	
	@Override
	public void Update(float dt){

		if (animationTime < animationSpeed){
			animationTime += 100 * dt;
		}else{
			animationTime %= animationSpeed;

			if (frameIndex < frameNumber-1){
				frameIndex++;
			}else{
				frameIndex = 0;
			}
		}
	}
	
	@Override
	public void Draw(){	
		if (visible){
			Renderer.drawSprite(animationRegions.get(frameIndex), position, getSourceRectangle(),
					size, rotation, origin, scale.x, scale.y, alpha, color, layer);
		}
	}
	
	public int getFrameNumber(){
		return frameNumber;
	}
	
	public int getFrameIndex(){
		return frameIndex;
	}
	
	public void setFrameIndex(int _frame){
		frameIndex = _frame;
	}
}
