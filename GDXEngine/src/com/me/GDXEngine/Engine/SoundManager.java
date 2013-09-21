package com.me.GDXEngine.Engine;

import java.util.ArrayList;
import java.util.Hashtable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {
	private static Hashtable<String, Sound> sounds;
	private static Hashtable<String, Music> music;
	private static ArrayList<String> names;
	private static ArrayList<String> musicNames;
	
	private static boolean sfxOn = true;
	private static boolean bgmOn = true;
	
	public static void Init()
	{
		sounds = new Hashtable<String, Sound>();
		music = new Hashtable<String, Music>();
		names = new ArrayList<String>();
		musicNames = new ArrayList<String>();
	}
	
	public static void AddSound(String path, String soundName)
	{
		Sound newSound = Gdx.audio.newSound(Gdx.files.internal(path));
		newSound.stop();
		sounds.put(soundName, newSound);
		names.add(soundName);
	}
	
	public static void AddMusic(String path, String musicName)
	{
		Music newSound = Gdx.audio.newMusic(Gdx.files.internal(path));
		music.put(musicName, newSound);
		musicNames.add(musicName);
	}
	
	public static void PlaySound(String soundName, boolean loop)
	{
		if (sfxOn){
			if(sounds.containsKey(soundName))
			{
				if (!loop){
					sounds.get(soundName).play();
				}else{
					sounds.get(soundName).loop();
				}
			}
		}
	}
	
	public static void PlayMusic(String soundName, boolean loop)
	{
		if (bgmOn){
			if(music.containsKey(soundName))
			{
				music.get(soundName).play();
				music.get(soundName).setLooping(loop);
			}	
		}
	}
	
	public static boolean MusicIsPlaying(String musicName){
		
		if (bgmOn){
			if(music.containsKey(musicName))
			{
				return music.get(musicName).isPlaying();
			}
			
			System.out.println("Trying to acces non existant musicIsPlaying:" +musicName);
			return false;
		}else{
			return false;
		}
	}
	
	public static void StopSound(String soundName)
	{
		if (bgmOn){
			if(sounds.containsKey(soundName))
			{
				sounds.get(soundName).stop();
			}
		}
	}
	
	public static void Mute()
	{
		bgmOn = false;
		sfxOn = false;
		
		for(int i = 0; i < names.size(); i++)
		{
			sounds.get(names.get(i)).stop();
		}
		
		for(int i = 0; i < musicNames.size(); i++)
		{
			music.get(musicNames.get(i)).stop();
		}
	}
	
	public static void UnMute()
	{
		bgmOn = true;
		sfxOn = true;
	}
	
	public static void StopMusic(String musicName)
	{
		if (bgmOn){
			if(music.containsKey(musicName))
			{
				music.get(musicName).stop();
			}
		}
	}
	
	public static void Dispose()
	{
		for(int i = 0; i < names.size(); i++)
		{
			sounds.get(names.get(i)).dispose();
		}
		
		sounds.clear();
		names.clear();
		musicNames.clear();
	}
}
