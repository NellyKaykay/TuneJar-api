package com.example.tunejarapi.repositories

import com.example.tunejarapi.domain.Song
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TuneJarRepository : JpaRepository<Song, Long>