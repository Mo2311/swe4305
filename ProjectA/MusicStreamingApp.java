package ProjectA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicStreamingApp {

    // Song class inside MusicStreamingApp class
    static class Song {
        private final String title;
        private final String artist;
        private final int playCount;

        // Constructor
        public Song(String title, String artist, int playCount) {
            this.title = title;
            this.artist = artist;
            this.playCount = playCount;
        }

        // Getter methods
        public String getTitle() {
            return title;
        }

        public int getPlayCount() {
            return playCount;
        }

        // Override toString() for easy printing
        @Override
        public String toString() {
            return "Song: " + title + ", Artist: " + artist + ", Play Count: " + playCount;
        }
    }

    private static final List<Song> songs = new ArrayList<>();

    public static void main(String[] args) {
        // Sample initial songs
        songs.add(new Song("Lose Yourself", "Eminem", 500));
        songs.add(new Song("Shape of You", "Ed Sheeran", 200));
        songs.add(new Song("Blinding Lights", "The Weeknd", 220));
        songs.add(new Song("Someone Like You", "Adele", 170));
        songs.add(new Song("Havana", "Camila Cabello", 100));
        songs.add(new Song("Bad Guy", "Billie Eilish", 100));
        songs.add(new Song("Uptown Funk", "Mark Ronson feat. Bruno Mars", 120));
        songs.add(new Song("Shallow", "Lady Gaga & Bradley Cooper", 130));
        songs.add(new Song("Rolling in the Deep", "Adele", 150));
        songs.add(new Song("God's Plan", "Drake", 140));

        // Scanner to get user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main program loop
        while (running) {
            System.out.println("\nMusic Streaming App");
            System.out.println("1. Add a new song");
            System.out.println("2. Remove a song");
            System.out.println("3. Print all songs");
            System.out.println("4. Print songs with play count above a given threshold");
            System.out.println("5. Exit");

            System.out.print("\nPlease choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    // Add a new song
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter play count: ");
                    int playCount = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    songs.add(new Song(title, artist, playCount));
                    System.out.println("Added: " + title);
                    break;

                case 2:
                    // Remove a song by title
                    System.out.print("Enter the title of the song to remove: ");
                    String removeTitle = scanner.nextLine();
                    boolean removed = songs.removeIf(song -> song.getTitle().equalsIgnoreCase(removeTitle));
                    if (removed) {
                        System.out.println("Removed song with title: " + removeTitle);
                    } else {
                        System.out.println("No song found with the title: " + removeTitle);
                    }
                    break;

                case 3:
                    // Print all songs
                    printAllSongs();
                    break;

                case 4:
                    // Print songs with play count above a given threshold
                    System.out.print("Enter play count threshold: ");
                    int threshold = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    printSongsOverPlayCount(threshold);
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting application...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Print all songs in the list
    private static void printAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs in the library.");
        } else {
            System.out.println("\nAll songs in the library:");
            for (Song song : songs) {
                System.out.println(song);
            }
        }
    }

    // Print songs with play count greater than a given number
    private static void printSongsOverPlayCount(int threshold) {
        System.out.println("\nSongs with play count greater than " + threshold + ":");
        for (Song song : songs) {
            if (song.getPlayCount() > threshold) {
                System.out.println(song);
            }
        }
    }
}

