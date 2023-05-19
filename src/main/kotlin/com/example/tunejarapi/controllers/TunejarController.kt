package com.example.tunejarapi.controllers

import com.example.tunejarapi.domain.Song
import com.example.tunejarapi.repositories.TuneJarRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
class TunejarController(private val tunejarRepository: TuneJarRepository) {
    @GetMapping("/api/songs")
    @ResponseBody
    fun allSongs(): List<Song?>? {
        return tunejarRepository.findAll()

    }
  /*  @PostMapping("/songs")
    fun addSong(@RequestBody song: Song): Song? {
        return tunejarRepository.save(song)
    }
    @PutMapping("/songs")
    fun addFavorite(@RequestBody song: Song): Song? {
        return tunejarRepository.save(song.favorite)
    }*/
  @PutMapping("/api/songs/{id}/like")
  fun likeSong(@PathVariable id: Long): ResponseEntity<Song> {
      val songOptional = tunejarRepository.findById(id)
      if (songOptional.isPresent) {
          val song = songOptional.get()
          song.favorite = true
          tunejarRepository.save(song)
          return ResponseEntity.ok(song)
      }
      return ResponseEntity.notFound().build()
  }

    @PutMapping("/api/songs/{id}/dislike")
    fun dislikeSong(@PathVariable id: Long): ResponseEntity<Song> {
        val songOptional = tunejarRepository.findById(id)
        if (songOptional.isPresent) {
            val song = songOptional.get()
            song.favorite = false
            tunejarRepository.save(song)
            return ResponseEntity.ok(song)
        }
        return ResponseEntity.notFound().build()
    }


}