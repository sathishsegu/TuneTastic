package com.ssktechhub.tunetastic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssktechhub.tunetastic.entity.Song;
import com.ssktechhub.tunetastic.service.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songService;
	
	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song) {
		boolean songExists = songService.songExists(song);
		if(songExists == false) {
			songService.addSong(song);
			System.out.println("Song added successfully");
		}else {
			System.out.println("Song already exists");
		}
		return "adminhome";
	}
	
	@GetMapping("/viewsongs")
	public String viewSongs(Model model) {
		List<Song> songList = songService.fetAllSongs();
		model.addAttribute("songs", songList);
		return "displaysongs";
	}
	
	@GetMapping("/playsongs")
	public String playSongs(Model model) {
		boolean premium = false;
		if(premium) {
			List<Song> songList = songService.fetAllSongs();
			model.addAttribute("songs", songList);
			return "displaysongs";
		}else {
			return "subscription";
		}
	}
}
