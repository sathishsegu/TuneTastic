package com.ssktechhub.tunetastic.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssktechhub.tunetastic.entity.Playlist;
import com.ssktechhub.tunetastic.repository.PlaylistRepository;
import com.ssktechhub.tunetastic.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addplaylist(Playlist playlist) {
		playlistRepository.save(playlist);
		
	}

	@Override
	public List<Playlist> fetchAllPlayLists() {
		return playlistRepository.findAll();
	}

	@Override
	public Playlist findById(Integer id) {
		return playlistRepository.findById(id).orElse(null);
	}

	@Override
	public boolean playlistExists(Playlist playlist) {
		String name = playlist.getName();
		playlist.setName(name.toLowerCase());
		Playlist byName = playlistRepository.findByName(name);
		
		if(byName == null) {
			return false;
		}else
			return true;
	}
}
