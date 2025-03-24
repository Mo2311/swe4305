package ProjectA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MusicStreamingAppTest {

    private List<MusicStreamingApp.Song> songs;

    @BeforeEach
    void setUp() {
        songs = new ArrayList<>();
        songs.add(new MusicStreamingApp.Song("Lose Yourself", "Eminem", 500));
        songs.add(new MusicStreamingApp.Song("Shape of You", "Ed Sheeran", 200));
        songs.add(new MusicStreamingApp.Song("Blinding Lights", "The Weeknd", 220));
    }

    @Test
    void testAddSong() {
        MusicStreamingApp.Song newSong = new MusicStreamingApp.Song("New Song", "New Artist", 50);
        songs.add(newSong);
        assertTrue(songs.contains(newSong));
    }

    @Test
    void testRemoveSong() {
        String removeTitle = "Shape of You";
        boolean removed = songs.removeIf(song -> song.getTitle().equalsIgnoreCase(removeTitle));
        assertTrue(removed);
        assertFalse(songs.stream().anyMatch(song -> song.getTitle().equalsIgnoreCase(removeTitle)));
    }

    @Test
    void testPrintSongsOverPlayCount() {
        int threshold = 200;
        List<MusicStreamingApp.Song> filteredSongs = new ArrayList<>();
        for (MusicStreamingApp.Song song : songs) {
            if (song.getPlayCount() > threshold) {
                filteredSongs.add(song);
            }
        }
        assertEquals(2, filteredSongs.size());
    }
}
