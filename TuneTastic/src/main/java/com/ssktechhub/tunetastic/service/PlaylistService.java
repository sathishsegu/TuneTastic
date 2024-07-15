package com.ssktechhub.tunetastic.service;

import java.util.List;

import com.ssktechhub.tunetastic.entity.Playlist;

public interface PlaylistService {

	public void addplaylist(Playlist playlist);

	public List<Playlist> fetchAllPlayLists();

	public Playlist findById(Integer id);

	public boolean playlistExists(Playlist playlist);

}
