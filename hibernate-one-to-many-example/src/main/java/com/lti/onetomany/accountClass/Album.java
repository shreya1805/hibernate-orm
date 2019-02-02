package com.lti.onetomany.accountClass;

import java.util.Set;

public class Album {

	public String singer;
	public String actor;
	public int alb_no;
	private String album_name;
	public String movie_name;
	
	private Set<Songs> songs;
}
