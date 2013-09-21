package com.me.GDXEngine;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;


public class MainActivity extends AndroidApplication {

	
	public MainActivity(){

	}
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		cfg.useGL20 = true;
		initialize(new Game(), cfg);
		
	}
	
	  @Override
	    public void onStart(){
	    	super.onStart();
	    }
	    
	    @Override
	    public void onStop(){
	    	super.onStop();
	    }
	    
	    @Override
	    public void onActivityResult(int request, int response, Intent data) {
	        super.onActivityResult(request, response, data);
	    }
}