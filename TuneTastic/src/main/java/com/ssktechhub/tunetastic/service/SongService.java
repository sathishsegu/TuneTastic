package com.ssktechhub.tunetastic.service;

import java.util.List;

import com.ssktechhub.tunetastic.entity.Song;

public interface SongService {

	public void addSong(Song song);
	
	public boolean songExists(Song song);

	public List<Song> fetAllSongs();

	public void updateSong(Song s);

}
