package models.Music;

import models.Music.Album;
import models.Music.Artist;
import models.Music.Song;
import java.util.ArrayList;
import java.util.List;

public class listofsongs {

    public List<Song> songs;

    public List<Song> getSongs() {

        List<Song> songs = new ArrayList<>(List.of(
                new Song("Whiplash", new Album("Kill 'Em All", 10, true, 1983, new Artist("Metallica", 1981, 11, true)),
                        new Artist("Metallica", 1981, 11, true),
                        new String[] { "Megaforce Records", "Elektra Records" }, "Thrash Metal", 1983, 249,
                        "US-7A3-83-00006"),
                new Song("Enter Sandman",
                        new Album("Metallica", 12, true, 1991, new Artist("Metallica", 1981, 11, true)),
                        new Artist("Metallica", 1981, 11, true), new String[] { "Elektra Records" }, "Heavy Metal",
                        1991, 331, "US-7A3-91-00007"),
                new Song("Back in Black",
                        new Album("Back in Black", 10, true, 1980, new Artist("AC/DC", 1973, 6, true)),
                        new Artist("AC/DC", 1973, 6, true), new String[] { "Albert Productions", "Atlantic Records" },
                        "Hard Rock", 1980, 255, "AU-7A3-80-00008"),
                new Song("Smoke on the Water",
                        new Album("Machine Head", 10, true, 1972, new Artist("Deep Purple", 1968, 8, true)),
                        new Artist("Deep Purple", 1968, 8, true), new String[] { "Warner Bros. Records" }, "Rock", 1972,
                        300, "GB-7A3-72-00009"),
                new Song("Sweet Child o' Mine",
                        new Album("Appetite for Destruction", 12, true, 1987,
                                new Artist("Guns N' Roses", 1985, 6, true)),
                        new Artist("Guns N' Roses", 1985, 6, true), new String[] { "Geffen Records" }, "Hard Rock",
                        1987, 356, "US-7A3-87-00010"),
                new Song("Billie Jean",
                        new Album("Thriller", 9, true, 1982, new Artist("Michael Jackson", 1964, 13, true)),
                        new Artist("Michael Jackson", 1964, 13, true), new String[] { "Epic Records" }, "Pop", 1982,
                        294, "US-7A3-82-00011"),
                new Song("Smells Like Teen Spirit",
                        new Album("Nevermind", 12, true, 1991, new Artist("Nirvana", 1987, 3, true)),
                        new Artist("Nirvana", 1987, 3, true), new String[] { "DGC Records" }, "Grunge", 1991, 301,
                        "US-7A3-91-00012"),
                new Song("Rolling in the Deep", new Album("21", 11, true, 2011, new Artist("Adele", 1988, 3, true)),
                        new Artist("Adele", 1988, 3, true), new String[] { "XL Recordings", "Columbia Records" }, "Pop",
                        2011, 228, "GB-7A3-11-00013"),
                new Song("Shape of You",
                        new Album("÷ (Divide)", 12, true, 2017, new Artist("Ed Sheeran", 1991, 3, true)),
                        new Artist("Ed Sheeran", 1991, 3, true), new String[] { "Asylum Records", "Atlantic Records" },
                        "Pop", 2017, 263, "GB-7A3-17-00014"),
                new Song("Wonderwall",
                        new Album("What's the Story Morning Glory?", 10, true, 1995,
                                new Artist("Oasis", 1991, 5, true)),
                        new Artist("Oasis", 1991, 5, true), new String[] { "Creation Records" }, "Britpop", 1995, 258,
                        "GB-7A3-95-00015"),
                new Song("Fight Fire with Fire",
                        new Album("Ride the Lightning", 8, true, 1984, new Artist("Metallica", 1981, 11, true)),
                        new Artist("Metallica", 1981, 11, true),
                        new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 259, "US-7A3-84-00001"),
                new Song("Ride the Lightning",
                        new Album("Ride the Lightning", 8, true, 1984, new Artist("Metallica", 1981, 11, true)),
                        new Artist("Metallica", 1981, 11, true), new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 396, "US-7A3-84-00002"),
                new Song("For Whom the Bell Tolls",
                        new Album("Ride the Lightning", 8, true, 1984, new Artist("Metallica", 1981, 11, true)),
                        new Artist("Metallica", 1981, 11, true), new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 330, "US-7A3-84-00003"),
                new Song("Fade to Black",
                        new Album("Ride the Lightning", 8, true, 1984, new Artist("Metallica", 1981, 11, true)),
                        new Artist("Metallica", 1981, 11, true), new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 341, "US-7A3-84-00004"),
                new Song("Trapped Under Ice",
                        new Album("Ride the Lightning", 8, true, 1984, new Artist("Metallica", 1981, 11, true)),
                        new Artist("Metallica", 1981, 11, true), new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 249, "US-7A3-84-00005"),
                new Song("Escape",
                        new Album("Ride the Lightning", 8, true, 1984, new Artist("Metallica", 1981, 11, true)),
                        new Artist("Metallica", 1981, 11, true), new String[] { "Elektra Records" }, "Thrash Metal",
                        1984, 245, "US-7A3-84-00006"),
                new Song("Creeping Death",
                        new Album("Ride the Lightning", 8, true, 1984, new Artist("Metallica", 1981, 11, true)),
                        new Artist("Metallica", 1981, 11, true), new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 396, "US-7A3-84-00007"),
                new Song("The Call of Ktulu",
                        new Album("Ride the Lightning", 8, true, 1984, new Artist("Metallica", 1981, 11, true)),
                        new Artist("Metallica", 1981, 11, true), new String[] { "Elektra Records" },
                        "Instrumental", 1984, 508, "US-7A3-84-00008")));
        return songs;

    }

}
