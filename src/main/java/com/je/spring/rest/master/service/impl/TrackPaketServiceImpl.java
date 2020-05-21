/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service.impl;

import com.je.spring.rest.master.model.TrackPaket;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.je.spring.rest.master.dao.TrackPaketDao;
import com.je.spring.rest.master.service.TrackPaketService;
/**
 *
 * @author User
 */
@Service("trackpaketService")
public class TrackPaketServiceImpl implements TrackPaketService{
    
    @Autowired
    TrackPaketDao trackpaketDao;
    
    @Override
    public List<TrackPaket> getAll(){
        List<TrackPaket> trackpaketList = new ArrayList<TrackPaket>();
        trackpaketList = trackpaketDao.getAll();
        return trackpaketList;
    }
    
    @Override
    public TrackPaket getById(int id){
        TrackPaket trackpaket = new TrackPaket();
        trackpaket = trackpaketDao.getById(id);
        return trackpaket;
    }
    
    @Override
    public long count(){
        return trackpaketDao.count();
    }
    
    @Override
    public void insert(TrackPaket trackpaket){
        trackpaketDao.insert(trackpaket);
    }
    
    @Override
    public void update(TrackPaket trackpaket){
        trackpaketDao.update(trackpaket);
    }
    
    @Override
    public void delete(TrackPaket trackpaket){
        trackpaketDao.delete(trackpaket);
    }
}
