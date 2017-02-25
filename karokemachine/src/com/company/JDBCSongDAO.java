package com.company;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


/**
 * Created by addisonulhaq on 2/25/17.
 */
public class JDBCSongDAO implements SongDAO {

    private JdbcTemplate jdbcTemplate;
    public JDBCSongDAO(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<Song> getAllSongsByArtist(String artistName) {
        List<Song> songList = new ArrayList<>();
        String sqlQuery = "SELECT * from songs WHERE artist = ? ORDER BY songs ASC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery,artistName);

        while(results.next()){
            Song song = new Song(results.getString("artist"), results.getString("song"), results.getString("text"));
            songList.add(song);

        }
        return songList;
    }

}
