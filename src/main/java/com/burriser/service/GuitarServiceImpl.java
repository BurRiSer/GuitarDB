package com.burriser.service;

import com.burriser.dao.GuitarDao;
import com.burriser.model.Guitar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by BurRiSer on 17.05.2017.
 */

@Service
public class GuitarServiceImpl implements GuitarService{
    private GuitarDao guitarDao;

    public void setGuitarDao(GuitarDao guitarDao) {
        this.guitarDao = guitarDao;
    }

    @Override
    @Transactional
    public void addGuitar(Guitar guitar) {
            this.guitarDao.addGuitar(guitar);
    }

    @Override
    @Transactional
    public void updateGuitar(Guitar guitar) {
            this.guitarDao.updateGuitar(guitar);
    }

    @Override
    @Transactional
    public void removeGuitar(int id) {
            this.guitarDao.removeGuitar(id);
    }

    @Override
    @Transactional
    public Guitar getGuitarById(int id) {
        return this.guitarDao.getGuitarById(id);
    }

    @Override
    @Transactional
    public List<Guitar> listGuitars() {
        return this.guitarDao.listGuitars();
    }
}
