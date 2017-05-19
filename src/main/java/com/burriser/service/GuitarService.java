package com.burriser.service;

import com.burriser.model.Guitar;

import java.util.List;

/**
 * Created by BurRiSer on 17.05.2017.
 */
public interface GuitarService {
    public void addGuitar(Guitar guitar);

    public void updateGuitar(Guitar guitar);

    public void removeGuitar(int id);

    public Guitar getGuitarById(int id);

    public List<Guitar> listGuitars();
}
