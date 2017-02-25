package com.company;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by addisonulhaq on 2/25/17.
 */


public class KaraokeCLI {

    private static final String SONG_MENU_SEE_ALL_SONGS = "Select a Song";
    private static final String SONG_MENU_CHOOSE_ARTIST = "Choose a different Artist";
    private static final String[] SONG_MENU = new String[] {SONG_MENU_SEE_ALL_SONGS,SONG_MENU_CHOOSE_ARTIST};

    private SongDAO songDAO;
    private Menu menu;

    public static void main(String[] args){

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/songlyrics");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        KaraokeCLI application = new KaraokeCLI(dataSource);
        application.run();

    }

    public KaraokeCLI(DataSource datasource) {
        songDAO = new JDBCSongDAO(datasource);
        this.menu = new Menu(System.in, System.out);

    }

    public void run(){

        System.out.println("Karaoke Machine 4000");
        System.out.println("");
        startUp:
            while(true) {
                System.out.println("Please enter in Artist Name");
                String artistName = menu.getUserInputToString();
                System.out.println("Searching .... ");
                List<Song> songList = songDAO.getAllSongsByArtist(artistName);
                if (songList.size() == 0) {
                    System.out.println("Sorry, there are No Artists matching that name");
                    continue startUp;
                }
                else{
                    System.out.println(songList.size()+" Songs Found");
                }

                handleSongs(songList);
            }



    }

    private void handleSongs(List songList){

        while(true) {
            String choice = (String) menu.getChoiceFromOptions(SONG_MENU);

            if (choice.equals(SONG_MENU_SEE_ALL_SONGS)) {
                displaySongs(songList.toArray());

            } else if (choice.equals(SONG_MENU_CHOOSE_ARTIST)) {
                return;
            } else if (choice.equals("RETURN_TO_PREVIOUS")) {
                return;
            }

        }
    }

    private void displaySongs(Object[] songlist){
        while(true)
            try {
                Song songChoice = (Song) menu.getChoiceFromOptions(songlist);
                handleSelectedSong(songChoice);
            }
            catch(ClassCastException e){
                break;
            }

    }

    private void handleSelectedSong(Song songChoice){
        System.out.println(songChoice.getLyrics());
        System.exit(1);
    }




}


