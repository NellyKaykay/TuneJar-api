package com.example.tunejarappi

import com.example.tunejarappi.domain.Song
import com.example.tunejarappi.repositories.TuneJarRepository
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TunejarAppiApplicationTests {
    @Autowired
    private lateinit var api:TestRestTemplate
    @Autowired
    private lateinit var tuneJarRepository: TuneJarRepository
    @BeforeEach
    fun setUp(){
        tuneJarRepository.deleteAll()
    }

    @Test
    fun contextLoads() {
    }
    @Test
    fun `Devuelve una lista de songs`() {
        val songs = listOf(
            Song("Astra", "Asia", "Voice of America ", 1985, "Progressive Rock", "https://open.spotify.com/track/24uVC7odXve5T6bmx0qlUW", "https://i.scdn.co/image/ab67616d0000b2731f7c4da2d7c136970044523e"),
            Song("From Fear to Eternity", "Iron Maiden", "El dorado", 2011, "Heavy Metal", "https://open.spotify.com/track/24uVC7odXve5T6bmx0qlUW", "img/iron_maiden.jpg"),
            Song("Dangerous", "Michael Jackson", "Dangerous", 1991, "Pop", "https://open.spotify.com/track/3u4RKvwDT3CKeYbjxqXEye", "https://i1.wp.com/www.audiograma.com.br/wp-content/uploads/2019/06/michaeljackson-dangerous-cover.jpg?fit=1500%2C1000"),
            Song("In Utero", "Nirvana", "Rape Me", 1993, "Grunge", "https://open.spotify.com/track/2i5K0EdMY5zFs9t7KfYK3k", "https://images.genius.com/8d86b37becd527f7ab8d8fc7de94ce25.1000x1000x1.jpg"),
            Song("yellow submarine", "The Beatles", "Yellow Submarine", 1996, "Rock", "https://open.spotify.com/track/1tdltVUBkiBCW1C3yB4zyD", "https://2.bp.blogspot.com/-EVBA4xZ7wUo/VKAByMPWbvI/AAAAAAAAPOA/uZQ5uRWXsx8/s1600/yelsub_lp.jpg"),
            Song("1984", "Van Halen", "Hot for teacher", 2015, "Metal", "https://open.spotify.com/track/6QDbGdbJ57Mtkflsg42WV5", "https://th.bing.com/th/id/OIP.uVNWvEK7KgKruAuxhuhSXQHaHa?pid=ImgDet&rs=1"),
            Song("Starboy", "The weeknd", "Starboy", 2016, "Pop", "https://open.spotify.com/track/7MXVkk9YMctZqd1Srtv4MB", "https://static.toiimg.com/thumb/msid-55727891,width-800,height-600,resizemode-75,imgsize-63735,pt-32,y_pad-40/55727891.jpg")
        ).let {tuneJarRepository.saveAll(it) }
        val response = api.getForEntity("/api/songs", Array<Song>::class.java)

        assertThat(response.statusCode, `is`(HttpStatus.OK))
        assertThat(response.body?.toList(), equalTo((songs)))


    }

}
