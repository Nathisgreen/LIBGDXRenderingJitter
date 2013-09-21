package com.me.GDXEngine.Engine;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public final class ContentManager {
	
	private static AssetManager assetManager;
	
	private static HashMap<String, BitmapFont > fontMap;
	private ContentManager(){}
	
	public static void Init(){
		assetManager = new AssetManager();
		fontMap = new HashMap<String, BitmapFont>();
	}
	
	public static Texture getTexture(String _path){
		if (assetManager.isLoaded(_path)){
			return assetManager.get(_path, Texture.class);
		}
		else{
			assetManager.load(_path, Texture.class);
			assetManager.finishLoading();
			return assetManager.get(_path, Texture.class);
		}
	}
	
	public static void loadAtlas(String _path){
		if (!assetManager.isLoaded(_path)){
			assetManager.load(_path, TextureAtlas.class);
			assetManager.finishLoading();
		}
	}
	
	public static TextureAtlas getTextureAtlas(String _path){
		if (assetManager.isLoaded(_path)){
			return assetManager.get(_path, TextureAtlas.class);
		}else{
			System.out.println("Error: Trying to get non existant TextureAtlas");
			return new TextureAtlas();
		}
	}
	
	public static void addFont(String _fontName, String _fntPath, String _pngPath, Boolean _flipped ){
		BitmapFont tempFont = new BitmapFont(Gdx.files.internal(_fntPath),Gdx.files.internal(_pngPath),_flipped);
		fontMap.put(_fontName, tempFont);	
	}
	
	public static BitmapFont getFont(String _fontName){
		return fontMap.get(_fontName);
	}
	

}
