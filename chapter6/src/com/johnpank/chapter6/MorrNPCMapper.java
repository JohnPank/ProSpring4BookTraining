package com.johnpank.chapter6;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MorrNPCMapper implements RowMapper {
    public MorrowindNPC mapRow(ResultSet resultSet, int i) throws SQLException {
        MorrowindNPC npc = new MorrowindNPC();
        npc.setId(resultSet.getInt(DBContract.ID_COLUMN));
        npc.setName(resultSet.getString(DBContract.NAME_COLUMN));
        npc.setRace(resultSet.getString(DBContract.RACE_COLUMN));
        npc.setFriendly(resultSet.getInt(DBContract.FRIENDLY_COLUMN));
        return npc;
    }
}
