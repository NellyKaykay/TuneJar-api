package com.example.tunejarappi.controllers

import com.example.tunejarappi.domain.Song
import com.example.tunejarappi.repositories.TuneJarRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController





@RestController
class TunejarController(private val tunejarRepository: TuneJarRepository) {
    @GetMapping("/api/songs")
    @ResponseBody
    fun allSongs(): List<Song> = tunejarRepository.findAll()
}