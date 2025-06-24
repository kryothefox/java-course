package com.core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.core.interfaces.cat;
import com.core.interfaces.feline;

import models.Music.Album;
import models.Music.Artist;
import models.Music.Song;

public class init {

    // **** FUNCTIONAL INTERFACES ****
    public static void main(String[] args) {

        /*
         * int x = 0;
         * cat newCat = new cat();
         */
        // System.out.println(newCat.meow("meow", 4));

        // feline<String,Integer> theFeline = (b,a) -> b.repeat(a);

        // **** ANONYMOUS FUNCTIONS / LAMBDA EXPRESSIONS

        /*
         * feline<String,Integer> aFeline = (word, repeatCount) ->
         * word.repeat(repeatCount);
         * //params
         * 
         * List<String> someList = new ArrayList<String>();
         * someList.add(aFeline.meow("meow",5));
         * 
         * 
         * List<Integer> nums = new ArrayList<>(List.of(4,2,1,5,2));
         * nums.sort((a,b) -> b-a);
         * nums.forEach(System.out::println);
         * nums.removeIf(n -> n%2==0);
         * System.out.println(nums.toString());
         * 
         * nums.forEach(n -> System.out.println(n));
         * 
         * Stream.generate(() -> Math.random()*500);
         * 
         * ArrayList<Integer> randomList = new ArrayList<>();
         * randomList.add(420);randomList.add(3020);randomList.add(103);
         * Stream<Integer> stream = randomList.stream();
         * //stream.allMatch((int x) -> x%2 == 0);
         */

        /* Artist Metallica = new Artist("Metallica", 1981, 11, true);
        Album killEmAll = new Album("Kill 'Em All", 10, true, 1983, Metallica);
        Album rideTheLightning = new Album("Ride the Lightning", 8, true, 1984, Metallica);
        Album masterOfPuppets = new Album("Master of Puppets", 8, true, 1986, Metallica);
        Album andJusticeForAll = new Album("Ride the Lightning", 9, true, 1988, Metallica);

        List<Song> songsKillEmAll = new ArrayList<>(List.of(
                new Song("Hit the Lights", killEmAll, Metallica,
                        new String[] { "Megaforce Records", "Elektra Records" }, "Thrash Metal",
                        1983, 217,
                        "US-7A3-83-00001"),
                new Song("The Four Horsemen", killEmAll, Metallica,
                        new String[] { "Megaforce Records", "Elektra Records" }, "Thrash Metal",
                        1983, 262,
                        "US-7A3-83-00002"),
                new Song("Motorbreath", killEmAll, Metallica, new String[] {
                        "Megaforce Records", "Elektra Records" },
                        "Thrash Metal", 1983, 194, "US-7A3-83-00003"),
                new Song("Jump in the Fire", killEmAll, Metallica,
                        new String[] { "Megaforce Records", "Elektra Records" }, "Thrash Metal",
                        1983, 258,
                        "US-7A3-83-00004"),
                new Song("Anesthesia (Pulling Teeth)", killEmAll, Metallica,
                        new String[] { "Megaforce Records", "Elektra Records" }, "Thrash Metal",
                        1983, 258,
                        "US-7A3-83-00005"),
                new Song("Whiplash", killEmAll, Metallica, new String[] {
                        "Megaforce Records", "Elektra Records" },
                        "Thrash Metal", 1983, 249, "US-7A3-83-00006"),
                new Song("Phantom Lord", killEmAll, Metallica, new String[] {
                        "Megaforce Records", "Elektra Records" },
                        "Thrash Metal", 1983, 292, "US-7A3-83-00007"),
                new Song("No Remorse", killEmAll, Metallica, new String[] {
                        "Megaforce Records", "Elektra Records" },
                        "Thrash Metal", 1983, 263, "US-7A3-83-00008"),
                new Song("Seek & Destroy", killEmAll, Metallica,
                        new String[] { "Megaforce Records", "Elektra Records" }, "Thrash Metal",
                        1983, 258,
                        "US-7A3-83-00009"),
                new Song("Metal Militia", killEmAll, Metallica, new String[] {
                        "Megaforce Records", "Elektra Records" },
                        "Thrash Metal", 1983, 266, "US-7A3-83-00010")));

        List<Song> songsRideTheLightning = new ArrayList<>(List.of(
                new Song("Fight Fire with Fire", rideTheLightning, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 259, "US-7A3-84-00001"),
                new Song("Ride the Lightning", rideTheLightning, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 396, "US-7A3-84-00002"),
                new Song("For Whom the Bell Tolls", rideTheLightning, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 330, "US-7A3-84-00003"),
                new Song("Fade to Black", rideTheLightning, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 341, "US-7A3-84-00004"),
                new Song("Trapped Under Ice", rideTheLightning, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 249, "US-7A3-84-00005"),
                new Song("Escape", rideTheLightning, Metallica, new String[] { "Elektra Records" }, "Thrash Metal",
                        1984, 245, "US-7A3-84-00006"),
                new Song("Creeping Death", rideTheLightning, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1984, 396, "US-7A3-84-00007"),
                new Song("The Call of Ktulu", rideTheLightning, Metallica, new String[] { "Elektra Records" },
                        "Instrumental", 1984, 508, "US-7A3-84-00008")));

        List<Song> songsMasterOfPuppets = new ArrayList<>(List.of(
                new Song("Battery", masterOfPuppets, Metallica, new String[] { "Elektra Records" }, "Thrash Metal",
                        1986, 252, "US-7A3-86-00001"),
                new Song("Master of Puppets", masterOfPuppets, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1986, 395, "US-7A3-86-00002"),
                new Song("The Thing That Should Not Be", masterOfPuppets, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1986, 402, "US-7A3-86-00003"),
                new Song("Welcome Home (Sanitarium)", masterOfPuppets, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1986, 336, "US-7A3-86-00004"),
                new Song("Disposable Heroes", masterOfPuppets, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1986, 357, "US-7A3-86-00005"),
                new Song("Leper Messiah", masterOfPuppets, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1986, 277, "US-7A3-86-00006"),
                new Song("Orion", masterOfPuppets, Metallica, new String[] { "Elektra Records" }, "Instrumental", 1986,
                        328, "US-7A3-86-00007"),
                new Song("Damage, Inc.", masterOfPuppets, Metallica, new String[] { "Elektra Records" }, "Thrash Metal",
                        1986, 317, "US-7A3-86-00008")));

        List<Song> songsAndJusticeForAll = new ArrayList<>(List.of(
                new Song("Blackened", andJusticeForAll, Metallica, new String[] { "Elektra Records" }, "Thrash Metal",
                        1988, 292, "US-7A3-88-00001"),
                new Song("…And Justice for All", andJusticeForAll, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1988, 408, "US-7A3-88-00002"),
                new Song("Eye of the Beholder", andJusticeForAll, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1988, 305, "US-7A3-88-00003"),
                new Song("One", andJusticeForAll, Metallica, new String[] { "Elektra Records" }, "Thrash Metal", 1988,
                        257, "US-7A3-88-00004"),
                new Song("The Shortest Straw", andJusticeForAll, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1988, 292, "US-7A3-88-00005"),
                new Song("Harvester of Sorrow", andJusticeForAll, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1988, 360, "US-7A3-88-00006"),
                new Song("The Frayed Ends of Sanity", andJusticeForAll, Metallica, new String[] { "Elektra Records" },
                        "Thrash Metal", 1988, 360, "US-7A3-88-00007"),
                new Song("To Live Is to Die", andJusticeForAll, Metallica, new String[] { "Elektra Records" },
                        "Instrumental", 1988, 408, "US-7A3-88-00008"),
                new Song("Dyers Eve", andJusticeForAll, Metallica, new String[] { "Elektra Records" }, "Thrash Metal",
                        1988, 205, "US-7A3-88-00009"))); */

        // System.out.println(killEmAll.getNumberOfSongs() ==
        // songsKillEmAll.toArray().length);

        Artist pinkFloyd = new Artist("Pink Floyd", 1973, 3, false);
        Album darkSideOfTheMoon = new Album("The Dark Side of the Moon", 10, false, 197, pinkFloyd);

        /* List<Song> songsDarkSideOfTheMoon = new ArrayList<>(List.of(
                new Song("Speak to Me", darkSideOfTheMoon, pinkFloyd, new String[] { "Harvest Records", "EMI" },
                        "Progressive Rock", 1973, 90, "GBAYE7300001"),

                new Song("Breathe", darkSideOfTheMoon, pinkFloyd, new String[] { "Harvest Records", "EMI" },
                        "Progressive Rock", 1973, 163, "GBAYE7300002"),

                new Song("On the Run", darkSideOfTheMoon, pinkFloyd, new String[] { "Harvest Records", "EMI" },
                        "Progressive Rock", 1973, 216, "GBAYE7300003"),

                new Song("Time", darkSideOfTheMoon, pinkFloyd, new String[] { "Harvest Records", "EMI" },
                        "Progressive Rock", 1973, 258, "GBAYE7300004"),

                new Song("The Great Gig in the Sky", darkSideOfTheMoon, pinkFloyd,
                        new String[] { "Harvest Records", "EMI" },
                        "Progressive Rock", 1973, 268, "GBAYE7300005"),

                new Song("Money", darkSideOfTheMoon, pinkFloyd, new String[] { "Harvest Records", "EMI" },
                        "Progressive Rock", 1973, 382, "GBAYE7300006"),

                new Song("Us and Them", darkSideOfTheMoon, pinkFloyd, new String[] { "Harvest Records", "EMI" },
                        "Progressive Rock", 1973, 472, "GBAYE7300007"),

                new Song("Any Colour You Like", darkSideOfTheMoon, pinkFloyd, new String[] { "Harvest Records", "EMI" },
                        "Progressive Rock", 1973, 212, "GBAYE7300008"),

                new Song("Brain Damage", darkSideOfTheMoon, pinkFloyd, new String[] { "Harvest Records", "EMI" },
                        "Progressive Rock", 1973, 266, "GBAYE7300009"),

                new Song("Eclipse", darkSideOfTheMoon, pinkFloyd, new String[] { "Harvest Records", "EMI" },
                        "Progressive Rock", 1973, 123, "GBAYE7300010"))); */

       /*  try (FileOutputStream fileOut = new FileOutputStream("metallica.txt")) {
            OutputStreamWriter streamOut = new OutputStreamWriter(fileOut);

            for (Song song : songsKillEmAll) {
                streamOut.write(song.toString());
            }
            streamOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        } */
        //System.out.println(findByGenre(songsDarkSideOfTheMoon, "Progressive Rock", 3));
        //System.out.println(getSongByCountry(songsDarkSideOfTheMoon, "US"));
        //System.out.println(filterByArtistAndYear(songsDarkSideOfTheMoon, "Pink Floyd", 1973));
        
    }



    public static List<Song> findByGenre(List<Song> songs, String genre, int limit) {
        List<Song> genreList = songs.stream()
                .filter((Song s) -> s.getGenre() == genre)
                .limit(limit)
                .toList();
        return genreList;
    }

    public static List<Song> getSongByCountry(List<Song> songs, String countryCode){
        List<Song> countryList = songs.stream()
            .filter( (Song s) -> s.getISRCCode().startsWith(countryCode)).toList();
        
        
        return countryList;
    }

    public static List<Song> filterByArtistAndYear(List<Song> songs, String artist, int year){

        List<Song> filteratedList = songs.stream()
        .filter((Song s) -> s.getYearPublished()==year).filter((Song s) -> s.getAlbumArtist().getName() == artist).toList();

        return filteratedList;

    }

    static String implementation(int n, String text) {
        return text.repeat(n);
    }

    static void meowTest(feline<String, Integer> aFeline, int count) {
        System.out.println(aFeline.meow("meow", count));
    }

}
