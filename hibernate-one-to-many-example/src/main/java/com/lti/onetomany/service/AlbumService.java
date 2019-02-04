package com.lti.onetomany.service;

import java.util.List;

import com.lti.AlbumDao.AlbumDao;
import com.lti.onetomany.accountClass.Album;
import com.lti.onetomany.accountClass.Songs;

public class AlbumService {
	
	public void addAlbum(String name, String movie_name, String actor) {
		Album ab = new Album();
		ab.setAlbum_name(name);
		ab.setMovie_name(movie_name);
		ab.setActor(actor);
		
		AlbumDao dao = new AlbumDao();
		dao.store(ab);
	}
	
	public List<Songs> fetchAlbum(int album_id) {
		Album ab = new Album();
		AlbumDao dao = new AlbumDao();
		
		return dao.fetchSong(album_id);
		
	}
	
	public void addSong(String name,String singer,String genre, int album_id) {
		Songs sg=new Songs();
		AlbumDao ad=new AlbumDao();
		
		//Fetch the album id using dao object 'ad'
		Album ab = ad.fetchById(Album.class, album_id);
		
		//Using setters set the value in songs object 'sg'
		sg.setAlbum(ab);		
		sg.setName(name);
		sg.setSinger(singer);
		sg.setGenre(genre);
		
		ad.store(sg);
		
	}

	public List<Songs> song(int song_id){
		AlbumDao ad =  new AlbumDao();
		return ad.fetchSong(song_id);
		
		
		
		
	}
}
