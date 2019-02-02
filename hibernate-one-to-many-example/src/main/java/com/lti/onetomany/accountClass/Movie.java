package com.lti.onetomany.accountClass;

import java.sql.Date;
import java.util.Set;

public class Movie {

	public String actors;
	public String actress;
	public String movie_name;
	public Date release_date;

	private Set<Actors> actor;
}

