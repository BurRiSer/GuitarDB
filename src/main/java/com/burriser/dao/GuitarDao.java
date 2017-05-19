package com.burriser.dao;

import com.burriser.model.Guitar;

import java.util.List;

/**
 * Created by BurRiSer on 17.05.2017.
 */
public interface GuitarDao {
    public void addGuitar(Guitar guitar);

    public void updateGuitar(Guitar guitar);

    public void removeGuitar(int id);

    public Guitar getGuitarById(int id);

    public List<Guitar> listGuitars();
}
