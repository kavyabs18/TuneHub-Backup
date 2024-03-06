package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.service.SongService;

@Controller
public class SongController {
	@Autowired
	SongService songService;
	
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song) {
		String songs = song.getName();

		// Checking if email as entered in registration from is present in DB or not
		boolean status = songService.songExists(songs);

		if (status==false) {
			songService.addSong(song);
			System.out.println("Song Added Successfully");

		} else {
			System.out.println("Song already Exists");
		}
		return "adminhome";
	}
	
	@GetMapping("/viewsong")
	public String viewSong(Model model) {
		List<Song> songList = songService.fetchAllSongs();
		model.addAttribute("Songs", songList);
		return "displaysongs";
	}
	
	@GetMapping("/playsongs")
	public String playSongs(Model model) {
		boolean premium = false;
		if(premium) {
			List<Song> songList = songService.fetchAllSongs();
			model.addAttribute("Songs", songList);
			return "displaysongs";
			
		}else {
			return "subscription";
		}
	}
}
