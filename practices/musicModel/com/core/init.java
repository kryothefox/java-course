package musicModel.com.core;

import musicModel.com.core.Models.Song;

public class init {
    public static void main(String[] args) {

        Song song1 = new Song("nostalgic sunset", new String[] { "Skeinn" },
                new String[] { "Drum N' Base", "Breakcore" }, "2022");
        Song song2 = new Song("Spiraling", new String[] { "Purity Filter", "5ubaruu", "Catastrophi", "Sigmatus" },
                new String[] { "Drum N' Base", "Breakcore" }, "2022");

                
        Song[] songList = { song1, song2 };

        
        for (int i = 0; i < songList.length; i++) {
            System.out.println("Song " + (i+1) + "\n" + songList[i].toString().concat("\n") + "_".repeat(40));
        }

    }
}
