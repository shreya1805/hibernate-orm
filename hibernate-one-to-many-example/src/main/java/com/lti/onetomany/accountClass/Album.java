package com.lti.onetomany.accountClass;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Album {

	@Id
	@GeneratedValue
	public int album_id;
	
	@Column(name="actor")
	public String actor;
	
	@Column(name="album_name")
	private String album_name;
	
	@Column(name="movie_name")
	public String movie_name;
	
	@OneToMany(mappedBy="album")
	private Set<Songs> songs;

	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public Set<Songs> getSongs() {
		return songs;
	}

	public void setSongs(Set<Songs> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Album [album_id=" + album_id + ", actor=" + actor + ", album_name=" + album_name + ", movie_name="
				+ movie_name + ", songs=" + songs + "]";
	}

	
	
	}

	

