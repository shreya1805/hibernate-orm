package com.lti.onetomany.accountClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Songs {
 
	@Id
	@GeneratedValue
	private int song_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="singer_name")
	public String singer;
	
	@Column(name="genre")
	public String genre;
	
	@ManyToOne
	@JoinColumn(name="album_id")
	private Album album;

	public int getSong_id() {
		return song_id;
	}

	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Songs [song_id=" + song_id + ", name=" + name + ", singer=" + singer + ", genre=" + genre + ", album="
				+ album + "]";
	}
	
	
}
