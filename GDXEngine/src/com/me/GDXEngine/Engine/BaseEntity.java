package com.me.GDXEngine.Engine;

public abstract class BaseEntity{

	protected boolean active = true;
	protected String type;
	protected boolean doDelete;
	
	protected BaseEntity(String _type)
	{
		type = _type;
		active = true;
		doDelete = false;
	}	
	
	abstract public void Update(float dt);

	void Draw(){}
	
	public boolean getActive(){ return active;}
	public void setActive(boolean _aBool){active = _aBool;}

	public String getType(){return type;}
	public void setType(String _type){ type = _type;}
	
	public void Delete(){
		doDelete = true;
	}
	
	public boolean getDelete(){
		return doDelete;
	}
}
