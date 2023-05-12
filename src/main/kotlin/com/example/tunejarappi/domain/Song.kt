package com.example.tunejarappi.domain

import jakarta.persistence.*

//class Song {

//}

@Entity
@Table(name = "songs")
data class Song(
    var disc: String,
    var author: String,
    var title: String,
    var releaseYear: Int,
    var genre: String,
    var link: String,
    var cover: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}