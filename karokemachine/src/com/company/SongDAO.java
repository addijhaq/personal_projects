package com.company;

import java.util.List;

/**
 * Created by addisonulhaq on 2/25/17.
 */
public interface SongDAO {
   public List<Song> getAllSongsByArtist(String artistName);

}
