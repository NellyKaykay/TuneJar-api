package com.example.tunejarappi.controllers

import com.example.tunejarappi.domain.Song
import com.example.tunejarappi.repositories.TuneJarRepository
import org.springframework.web.bind.annotation.*


@RestController
class TunejarController(private val tunejarRepository: TuneJarRepository) {
    @GetMapping("/api/songs")
    @ResponseBody
    fun allSongs(): List<Song?>? {
        return tunejarRepository.findAll()

    }
    @PostMapping("/songs")
    fun addSong(@RequestBody song: Song): Song? {
        return tunejarRepository.save(song)
    }
}