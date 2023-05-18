package com.example.tunejarapi

import com.example.tunejarapi.domain.Song
import com.example.tunejarapi.domain.SongRepository
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class SongLikesTest {
    @Autowired
    private lateinit var songRepository: SongRepository

    @Autowired
    private lateinit var api: TestRestTemplate

    @BeforeEach
    fun setUp() {
        songRepository.deleteAll()
    }

    @Test
    fun `allows to like a song`() {
        val song = songRepository.save(
            Song(
                disc = "From Fear to Eternity",
                author = "Iron Maiden",
                title = "El dorado",
                releaseYear = 2011,
                genre = "Heavy Metal",
                link = "https://open.spotify.com/track/24uVC7odXve5T6bmx0qlUW",
                cover = "https://m.media-amazon.com/images/I/91ToMjRTEmL._SL1500_.jpg",
                favorite = false
            )
        )

        api.put("/api/songs/${song.id}/like", Unit::class.java)

        assertThat(songRepository.findById(song.id!!).get().favorite, equalTo(true))
    }

    @Test
    fun `allows to dislike a song`() {
        val song = songRepository.save(
            Song(
                disc = "From Fear to Eternity",
                author = "Iron Maiden",
                title = "El dorado",
                releaseYear = 2011,
                genre = "Heavy Metal",
                link = "https://open.spotify.com/track/24uVC7odXve5T6bmx0qlUW",
                cover = "https://m.media-amazon.com/images/I/91ToMjRTEmL._SL1500_.jpg",
                favorite = true
            )
        )

        api.put("/api/songs/${song.id}/dislike", Unit::class.java)

        assertThat(songRepository.findById(song.id!!).get().favorite, equalTo(false))
    }
}