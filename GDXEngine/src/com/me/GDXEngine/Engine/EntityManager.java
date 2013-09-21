package com.me.GDXEngine.Engine;

import java.util.HashMap;

import com.badlogic.gdx.utils.Array;

public class EntityManager {

	private Array<BaseEntity> entityList;
	private Array<BaseEntity> toAddList;
	private HashMap<String, Array<BaseEntity>> typeMap;
	
	private static Array<BaseEntity> errorArray;
	
	public EntityManager(){
		entityList = new Array<BaseEntity>();
		toAddList = new Array<BaseEntity>();
		typeMap = new HashMap<String, Array<BaseEntity>>();
		errorArray = new Array<BaseEntity>();
	}
	
	public void Update(float dt){
		
		for(BaseEntity aEnt : toAddList){
			entityList.add(aEnt);
		}
		
		toAddList.clear();		
		
		for (int i = entityList.size-1; i >= 0; i--){
			BaseEntity aEnt = entityList.get(i);
			if (!aEnt.getDelete())
			{
				if (aEnt.getActive()){
					aEnt.Update(dt);
					aEnt.Draw();
				}
			}
			else
			{
				entityList.removeIndex(i);
				typeMap.get(aEnt.getType()).removeValue(aEnt, true);
			}
		}
		
		/*System.out.println("all" + " : " + entityList.size);
		System.out.println("--------");
		for (String key: typeMap.keySet()){
			System.out.println(key + " : " + typeMap.get(key).size);
		}
		System.out.println("//////////////");*/
	}
	
	public void addEntity(BaseEntity _Ent){
		toAddList.add(_Ent);
		
		if (typeMap.containsKey(_Ent.getType())){
			typeMap.get(_Ent.getType()).add(_Ent);
		}else{
			Array<BaseEntity> temp = new Array<BaseEntity>();
			temp.add(_Ent);
			typeMap.put(_Ent.getType(), temp);
		}
	}
	
	public Array<BaseEntity> getAllEntities(){
		return entityList;
	}
	
	public Array<BaseEntity> getEntityType(String _type){
		if (typeMap.get(_type) != null){
			return typeMap.get(_type);	
		}else{
			return errorArray;
		}
	}
	
	/**
	 * You should probably never use this method, if you do, be sure to clean up the 
	 * entity your removing here manually
	 * @param _Ent
	 */
	public void RemoveEntity(BaseEntity _Ent){
		entityList.removeValue(_Ent, true);
		typeMap.get(_Ent.getType()).removeValue(_Ent, true);
	}
	
	protected void reset(){
		for (int i = entityList.size-1; i >= 0; i--){
			BaseEntity aEnt = entityList.get(i);
			aEnt.Delete();
			entityList.removeIndex(i);
			typeMap.get(aEnt.getType()).removeValue(aEnt, true);
			aEnt = null;
		}
		
		for (BaseEntity aEnt: getAllEntities()){
			aEnt.Delete();
		}
		toAddList.clear();
		typeMap.clear();
		entityList.clear();
	}
	
	
}
