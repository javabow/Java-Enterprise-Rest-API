/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service.impl;

import com.je.spring.rest.master.model.Sender;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.je.spring.rest.master.dao.SenderDao;
import com.je.spring.rest.master.service.SenderService;
/**
 *
 * @author Prasetyo
 */
@Service("senderService")
public class SenderServiceImpl implements SenderService{
    
    @Autowired
    SenderDao senderDao;
    
    @Override
    public List<Sender> getAll(){
        List<Sender> senderList = new ArrayList<Sender>();
        senderList = senderDao.getAll();
        return senderList;
    }
    
    @Override
    public Sender getById(int id){
        Sender sender = new Sender();
        sender = senderDao.getById(id);
        return sender;
    }
    
    @Override
    public long count(){
        return senderDao.count();
    }
    
    @Override
    public void insert(Sender sender){
        senderDao.insert(sender);
    }
    
    @Override
    public void update(Sender sender){
        senderDao.update(sender);
    }
    
    @Override
    public void delete(Sender sender){
        senderDao.delete(sender);
    }
}
