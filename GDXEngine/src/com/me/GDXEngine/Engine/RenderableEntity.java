package com.me.GDXEngine.Engine;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class RenderableEntity extends BaseEntity{
	
	//logical controls
	protected Vector2 position;
	protected Vector2 origin;
	protected Vector2 scale;
	protected Rectangle boundingBox;
	protected float rotation;
	protected float alpha;
	protected Color color;
	
	//drawing controls
	protected Rectangle sourceRectangle;
	protected String texturePath;
	protected String atlasPath;
	protected Vector2 size;
	protected boolean visible;
	protected String layer;
	
	protected TextureRegion textureRegion;
	
	//-Constructors-//
	protected RenderableEntity(){
		super("Entity");
		initialize();
		visible = false;
		
	}
	
	public RenderableEntity(String _type){
		super(_type);
		initialize();
	}
	
	public RenderableEntity(String _type, String _textureName, String _atlasPath){
		super(_type);
		initialize();
		setUpTexture(_textureName, _atlasPath);
	}
	
	/**
	 * Initalizes the Entity with default values
	 */
	private void initialize(){
		position = new Vector2(0,0);
		origin = new Vector2(0,0);
		scale = new Vector2(1,1);
		boundingBox = new Rectangle();
		sourceRectangle = new Rectangle();
		visible = true;
		active = true;
		rotation = 0;
		alpha = 1;
		layer = "Default";
		color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
		size = new Vector2(0,0);
	}
	
	/**
	 * Set or Change the texture this Entity uses
	 * @param _texturePath path to the texture to use
	 */
	public void setUpTexture(String _textureName, String _AtlasPath){
		if (_textureName != "" && _AtlasPath != null){
			texturePath = _textureName;
			atlasPath = _AtlasPath;
			textureRegion = ContentManager.getTextureAtlas(_AtlasPath).findRegion(_textureName);
			textureRegion.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
			//textureRegion.getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
			//size = new Vector2(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
			size.x = textureRegion.getRegionWidth();
			size.y = textureRegion.getRegionHeight();
			boundingBox.width = size.x;
			boundingBox.height = size.y;
			sourceRectangle.width = size.x;
			sourceRectangle.height =size.y;
			
		}else{
			size.x = 0;
			size.y = 0;
			boundingBox.width = size.x;
			boundingBox.height = size.y;
			sourceRectangle.width = size.x;
			sourceRectangle.height =size.y;
		}
	}
	
	/**
	 * Create renderableEntity using a texture (WARNING: using separate textures is bad for rendering
	 * and should be in a textureAtlas if possible i.e use setUpTexture when possible)
	 * @param _type			the entitys type
	 * @param _filePath		the file path to texture
	 */
	public void createFromSprite(String _type,String _filePath ){
		initialize();
		type = _type;
		texturePath = _filePath;
		changeSpriteFromTexture(texturePath);
	}
	
	/**
	 * Used to change a sprite at some point after initialisation
	 * @param _filePath
	 */
	public void changeSpriteFromTexture(String _filePath){
		textureRegion = new TextureRegion(ContentManager.getTexture(_filePath));
		//textureRegion.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//size = new Vector2(ContentManager.getTexture(_filePath).getWidth(),ContentManager.getTexture(_filePath).getHeight());
		size.x = ContentManager.getTexture(_filePath).getWidth();
		size.y = ContentManager.getTexture(_filePath).getHeight();
		boundingBox.width = size.x;
		boundingBox.height = size.y;
		sourceRectangle.width = size.x;
		sourceRectangle.height =size.y;
	}
	
	//position
	public void setPosition(float _x, float _y){ position.x = _x; position.y = _y;}// = new Vector2(_x,_y);}
	public void setPosition(Vector2 _pos){position = _pos;}
	public Vector2 getPosition(){return position;}
	//BoundingBox
	public void setBoundingBox(int _x, int _y, int _width, int _height){boundingBox = new Rectangle(_x,_y,_width,_height);}
	public void setBoundingBox(Rectangle _rec){boundingBox = _rec;}
	public Rectangle getBoundingBox(){return boundingBox;}
	//SourceRectangle
	public void setSourceRectangle(int _x, int _y, int _width, int _height){sourceRectangle = new Rectangle(_x,_y,_width,_height);}
	public void setSourceRectangle(Rectangle _rec){sourceRectangle  = _rec;}
	public Rectangle getSourceRectangle(){return sourceRectangle ;}
	//Size
	public void setSize(int _x, int _y){ size = new Vector2(_x, _y);}
	public Vector2 getSize(){return size;}
	//Rotation
	public void setRotation(float _rot){ rotation = _rot;}
	public float getRotation(){return rotation;}
	//Origin
	public void setOrigin(Vector2 _org){ origin = _org;}
	public void setOrigin(float _xOrg, float _yOrg){origin = new Vector2(_xOrg,_yOrg);}
	public Vector2 getOrigin(){return origin;}
	//Scale
	public void setScale(float _Scale){scale.x = _Scale; scale.y = _Scale;}
	public void setScale(float _xScale, float _yScale){scale.x = _xScale; scale.y = _yScale;} 
	public Vector2 getScale(){ return scale;}
	public void setXScale(float _xScale){ scale.x = _xScale;}
	public void setYScale(float _yScale){ scale.y = _yScale;} 
	public float getXScale(){ return scale.x;}
	public float getYScale(){ return scale.y;} 
	
	public void setAlpha(float _alpha){alpha = _alpha;}
	public float getAlpha(){return alpha;}
	
	public void setColor(Color _color){color = _color;}
	public Color getColor(){return color;}
	
	//Draw
	public boolean getDraw(){return visible;}
	
	public void setDraw(boolean _aBool){
		visible = _aBool;
	}
	
	//Texture
	public String getTexturePath(){return texturePath;}
	public String getAtlasPath(){return atlasPath;}
	
	//Layer
	public String getLayer(){return layer;}
	public void setLayer(String layerName){layer = layerName;}
	
	@Override
	public void Update(float dt){
		//If you don't want your boundingBox auto size of sprite don't call super and
		//call this method in your update with the values you want
		
		updateBoundingBox(position.x - (origin.x * scale.x), position.y - (origin.y * scale.y),
			size.x * scale.x, size.y * scale.y);
	}
	
	@Override
	public void Draw(){	
		if (visible){
			Renderer.drawSprite(textureRegion, position, getSourceRectangle(),
					size, rotation, origin, scale.x, scale.y, alpha, color, layer);
		}
	}
	
	protected void updateBoundingBox(float _xPos,float _yPos,float _Width,float _Height){
		boundingBox.x = _xPos;
		boundingBox.y = _yPos; 
		boundingBox.width = _Width;
		boundingBox.height = _Height;
	}
}
