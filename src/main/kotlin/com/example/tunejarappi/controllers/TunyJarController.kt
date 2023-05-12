package com.songs.backend.controllers

import com.songs.backend.domain.Song
import com.songs.backend.repositories.SongRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
class SongController(private val songRepository: SongRepository) {
    @GetMapping("/api/songs")
    @ResponseBody
    fun allSongs(): List<Song> = songRepository.findAll()
}