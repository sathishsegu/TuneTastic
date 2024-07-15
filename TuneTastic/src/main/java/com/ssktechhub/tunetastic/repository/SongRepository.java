package com.ssktechhub.tunetastic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssktechhub.tunetastic.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{

	public Song findByName(String name);
}
