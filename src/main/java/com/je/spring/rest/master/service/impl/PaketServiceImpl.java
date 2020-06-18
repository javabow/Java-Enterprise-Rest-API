/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service.impl;

import com.je.spring.rest.master.dao.PaketDao;
import com.je.spring.rest.master.model.Paket;
import com.je.spring.rest.master.service.PaketService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Prasetyo
 */
@Service("paketService")
public class PaketServiceImpl implements PaketService{
    
    @Autowired
    PaketDao paketDao;
    
    @Override
    public List<Paket> getAll(){
        List<Paket> paketList = new ArrayList<Paket>();
        paketList = paketDao.getAll();
        return paketList;
    }
    
    @Override
    public Paket getById(int id){
        Paket paket = new Paket();
        paket = paketDao.getById(id);
        return paket;
    }
    
    @Override
    public long count(){
        return paketDao.count();
    }
    
    @Override
    public void insert(Paket paket){
        paketDao.insert(paket);
    }
    
    @Override
    public void update(Paket paket){
        paketDao.update(paket);
    }
    
}
