package com.johnpank.chapter6;

import javax.sql.DataSource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class MorrNpcDAOIimpl implements MorrNpcDAO{

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createMorrowindNPC(String name, String race, Integer friendly) {
        String SQL = "INSERT INTO " + DBContract.TABLE_NAME + " (" + DBContract.NAME_COLUMN + ", " + DBContract.RACE_COLUMN + ", " + DBContract.FRIENDLY_COLUMN + ") VALUES (?,?,?)";
        jdbcTemplate.update(SQL, name, race, friendly);
        System.out.println("NPC successfully created.\nName: " + name + ";\nRace: " +
                race + ";\nFriendly: " + friendly + "\n");

    }

    public MorrowindNPC getMorrowindNPCById(Integer id) {
        String SQL = "SELECT * FROM " + DBContract.TABLE_NAME + " WHERE " + DBContract.ID_COLUMN + " = ?";
        MorrowindNPC morrowindNPC = (MorrowindNPC) jdbcTemplate.queryForObject(SQL, new Object[]{id}, new MorrNPCMapper());
        return morrowindNPC;
    }

    public List listMorrowindNPC() {
        String SQL = "SELECT * FROM " + DBContract.TABLE_NAME;
        List morrNPCs = jdbcTemplate.query(SQL, new MorrNPCMapper());
        return morrNPCs;
    }

    public void removeMorrowindNPC(Integer id) {
        String SQL = "DELETE FROM " + DBContract.TABLE_NAME + " WHERE " + DBContract.ID_COLUMN + " = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("MorrowindNPC with id: " + id + " successfully removed");
    }

    public void updateMorrowindNPC(Integer id, String name, String race, Integer friendly) {
        String SQL = "UPDATE " + DBContract.TABLE_NAME + " SET "
                + DBContract.NAME_COLUMN + " = ?, "
                + DBContract.RACE_COLUMN + " = ?, "
                + DBContract.FRIENDLY_COLUMN + " = ?" +
                " WHERE " + DBContract.ID_COLUMN + " = ?";
        jdbcTemplate.update(SQL, name, race, friendly, id);
        System.out.println("MorrowindNPC with id: " + id + " successfully updated.");
    }
}
