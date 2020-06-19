/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service.impl;

import com.je.spring.rest.master.model.Kota;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.je.spring.rest.master.dao.KotaDao;
import com.je.spring.rest.master.service.KotaService;
/**
 *
 * @author Prasetyo
 */
@Service("kotaService")
public class KotaServiceImpl implements KotaService{
    
    @Autowired
    KotaDao kotaDao;
    
    @Override
    public List<Kota> getAll(){
        List<Kota> kotaList = new ArrayList<Kota>();
        kotaList = kotaDao.getAll();
        return kotaList;
    }
    
    @Override
    public Kota getById(int id){
        Kota kota = new Kota();
        kota = kotaDao.getById(id);
        return kota;
    }
    
    @Override
    public long count(){
        return kotaDao.count();
    }
    
  /*  @Override
    public void insert(Kota kota){
        kotaDao.insert(kota);
    }
    
    @Override
    public void update(Kota kota){
        kotaDao.update(kota);
    }
    
    @Override
    public void delete(Kota kota){
        kotaDao.delete(kota);
    } */
}
