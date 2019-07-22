package com.johnpank.chapter6;

import javax.sql.DataSource;
import java.util.List;

public interface MorrNpcDAO {

    public void setDataSource(DataSource dataSource);

    public void createMorrowindNPC(String name, String race, Integer friendly);

    public MorrowindNPC getMorrowindNPCById(Integer id);

    public List listMorrowindNPC();

    public void removeMorrowindNPC(Integer id);

    public void updateMorrowindNPC(Integer id, String name, String race, Integer friendly);
}
