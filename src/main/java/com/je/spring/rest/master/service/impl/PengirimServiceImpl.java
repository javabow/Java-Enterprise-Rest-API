/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service.impl;

import com.je.spring.rest.master.model.Pengirim;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.je.spring.rest.master.dao.PengirimDao;
import com.je.spring.rest.master.service.PengirimService;
/**
 *
 * @author User
 */
@Service("pengirimService")
public class PengirimServiceImpl implements PengirimService{
    
    @Autowired
    PengirimDao pengirimDao;
    
    @Override
    public List<Pengirim> getAll(){
        List<Pengirim> pengirimList = new ArrayList<Pengirim>();
        pengirimList = pengirimDao.getAll();
        return pengirimList;
    }
    
    @Override
    public Pengirim getById(int id){
        Pengirim pengirim = new Pengirim();
        pengirim = pengirimDao.getById(id);
        return pengirim;
    }
    
    @Override
    public long count(){
        return pengirimDao.count();
    }
    
    @Override
    public void insert(Pengirim pengirim){
        pengirimDao.insert(pengirim);
    }
    
    @Override
    public void update(Pengirim pengirim){
        pengirimDao.update(pengirim);
    }
    
    @Override
    public void delete(Pengirim pengirim){
        pengirimDao.delete(pengirim);
    }
}
