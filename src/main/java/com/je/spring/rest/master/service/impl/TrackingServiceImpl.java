/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service.impl;

import com.je.spring.rest.master.dao.TrackingDao;
import com.je.spring.rest.master.model.Tracking;
import com.je.spring.rest.master.service.TrackingService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Prasetyo
 */
@Service("trackingService")
public class TrackingServiceImpl implements TrackingService{
    
    @Autowired
    TrackingDao trackingDao;
    
    @Override
    public List<Tracking> getAll(){
        List<Tracking> trackingList = new ArrayList<Tracking>();
        trackingList = trackingDao.getAll();
        return trackingList;
    }
    
    @Override
    public Tracking getById(int id){
        Tracking tracking = new Tracking();
        tracking = trackingDao.getById(id);
        return tracking;
    }
    
    @Override
    public long count(){
        return trackingDao.count();
    }
    
    @Override
    public void insert(Tracking tracking){
        trackingDao.insert(tracking);
    }
    
    @Override
    public void update(Tracking tracking){
        trackingDao.update(tracking);
    }
}
