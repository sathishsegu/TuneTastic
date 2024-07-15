package com.ssktechhub.tunetastic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssktechhub.tunetastic.entity.Playlist;
import com.ssktechhub.tunetastic.entity.Song;
import com.ssktechhub.tunetastic.service.PlaylistService;
import com.ssktechhub.tunetastic.service.SongService;

@Controller
public class PlaylistController {

	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	SongService songService;
	
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		List<Song> songList = songService.fetAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylist";
	}
	
	
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		
		boolean playlistExists = playlistService.playlistExists(playlist);
		
		if(playlistExists == false) {
			
			//updating the playlist table
			playlistService.addplaylist(playlist);
			
			//Updating the song table here songs will be mapped to playlist
			List<Song> songList = playlist.getSongs();
			for(Song s : songList) {
				s.getPlaylists().add(playlist);
				
				//this is added to update songs_playlists table to identify which song belongs to which playlist
				songService.updateSong(s);
			}
		}else {
			System.out.println("Playlist already exists");
		}
		return "adminhome";
	}
	
	
	@GetMapping("/viewplaylists")
	public String viewplaylists(Model model) {
		List<Playlist> allplaylists = playlistService.fetchAllPlayLists();
		model.addAttribute("playlists", allplaylists);
		return "displayplaylists";
	}
	
	
	@GetMapping("/viewplaylist/{id}")
	public String viewPlaylistSongs(@PathVariable("id") Integer id, Model model) {
		Playlist playlist = playlistService.findById(id);
		model.addAttribute("playlist", playlist);
		return "viewplaylistsongs";
	}
	
	
	
}







//Model is used to render the data from the database to front end of the application
//@ModelAtrribute is used to store the data from front end to database