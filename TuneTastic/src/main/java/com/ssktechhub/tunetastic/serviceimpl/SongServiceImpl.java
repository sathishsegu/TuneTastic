package com.ssktechhub.tunetastic.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssktechhub.tunetastic.entity.Song;
import com.ssktechhub.tunetastic.repository.SongRepository;
import com.ssktechhub.tunetastic.service.SongService;

@Service
public class SongServiceImpl implements SongService{

	@Autowired
	SongRepository songRepository;
	
	@Override
	public void addSong(Song song) {
		songRepository.save(song);
	}

	public boolean songExists(Song song) {
		String name = song.getName();
		song.setName(name.toLowerCase());
		Song byName = songRepository.findByName(name);
		
		if(byName == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<Song> fetAllSongs() {
		return songRepository.findAll();
	}

	@Override
	public void updateSong(Song s) {
		songRepository.save(s);
	}
}

