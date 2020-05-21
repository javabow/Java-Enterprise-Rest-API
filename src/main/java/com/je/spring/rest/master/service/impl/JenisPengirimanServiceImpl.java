/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service.impl;

import com.je.spring.rest.master.model.JenisPengiriman;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.je.spring.rest.master.dao.JenisPengirimanDao;
import com.je.spring.rest.master.service.JenisPengirimanService;
/**
 *
 * @author Prasetyo
 */
@Service("jenisPengirimanService")
public class JenisPengirimanServiceImpl implements JenisPengirimanService{
    
    @Autowired
    JenisPengirimanDao jenisPengirimanDao;
    
    @Override
    public List<JenisPengiriman> getAll(){
        List<JenisPengiriman> jenisPengirimanList = new ArrayList<JenisPengiriman>();
        jenisPengirimanList = jenisPengirimanDao.getAll();
        return jenisPengirimanList;
    }
    
    @Override
    public JenisPengiriman getById(int id){
        JenisPengiriman jenisPengiriman = new JenisPengiriman();
        jenisPengiriman = jenisPengirimanDao.getById(id);
        return jenisPengiriman;
    }
    
    @Override
    public long count(){
        return jenisPengirimanDao.count();
    }
    
    @Override
    public void insert(JenisPengiriman jenisPengiriman){
        jenisPengirimanDao.insert(jenisPengiriman);
    }
    
    @Override
    public void update(JenisPengiriman jenisPengiriman){
        jenisPengirimanDao.update(jenisPengiriman);
    }
    
    @Override
    public void delete(JenisPengiriman jenisPengiriman){
        jenisPengirimanDao.delete(jenisPengiriman);
    }
    
}
