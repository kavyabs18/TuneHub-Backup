package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService {
	@Autowired
	SongRepository songRepository;
	
	public String addSong(Song song) {
		songRepository.save(song);
		return "home";
	}

	public boolean songExists(String songs) {
		if (songRepository.findByName(songs) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public  List<Song> fetchAllSongs() {
		return songRepository.findAll();
	}

	@Override
	public void updateSong(Song s) {
		songRepository.save(s);
	}

}
