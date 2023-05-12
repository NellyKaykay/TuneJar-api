package com.songs.backend.repositories

import com.example.tunejarappi.domain.Song
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TuneJarRepository : JpaRepository<Song, Long>