package com.example.tunejarapi.domain;

import org.springframework.data.jpa.repository.JpaRepository

interface SongRepository : JpaRepository<Song, Long>