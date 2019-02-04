package com.lti.onetomany.test;

import java.util.List;

import org.junit.Test;

import com.lti.onetomany.accountClass.Songs;
import com.lti.onetomany.service.AlbumService;

public class AlbumTest {
	
	@Test
	public void addAlbumTest() {
		AlbumService as = new AlbumService();
		as.addAlbum("Gangaajal", "Gangaajal", "Ajay Devgn");
		as.addAlbum("Kedarnath", "Jaan Nisaar", "Sushant Singh Rajput");
		as.addAlbum("Mirrors", "Mirrors", "Justin TimberLake");
		
	}
	
	@Test
	public void adds() {
		AlbumService as=new AlbumService();
		
		as.addSong("Good days", "Rihanna", "sad", 128);
		as.addSong("Goodbye", "Miley", "sad", 128);
		as.addSong("Qafiraana", "Arijit Singh", "sad", 127);
		as.addSong("Rafta", "Neha kakkar", "dance", 126);
		as.addSong("Mirrors", "Justin Timberlake", "romance", 128);
	}
	
	@Test 
	public void AlbumTest(){
		AlbumService service= new AlbumService();
		List<Songs> song = service.fetchAlbum(128);
		System.out.println("Song Name \t Singer \t\t\t Genre");
		for(Songs songs: song) {
			System.out.println(songs.getName()+"\t\t"+ songs.getSinger() +"\t\t"+songs.getGenre());
		}
	}
}
