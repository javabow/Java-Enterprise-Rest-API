/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service.impl;

import com.je.spring.rest.master.model.Receiver;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.je.spring.rest.master.dao.ReceiverDao;
import com.je.spring.rest.master.service.ReceiverService;
/**
 *
 * @author User
 */
@Service("receiverService")
public class ReceiverServiceImpl implements ReceiverService{
    
    @Autowired
    ReceiverDao receiverDao;
    
    @Override
    public List<Receiver> getAll(){
        List<Receiver> receiverList = new ArrayList<Receiver>();
        receiverList = receiverDao.getAll();
        return receiverList;
    }
    
    @Override
    public Receiver getById(int id){
        Receiver receiver = new Receiver();
        receiver = receiverDao.getById(id);
        return receiver;
    }
    
    @Override
    public long count(){
        return receiverDao.count();
    }
    
    @Override
    public void insert(Receiver receiver){
        receiverDao.insert(receiver);
    }
    
    @Override
    public void update(Receiver receiver){
        receiverDao.update(receiver);
    }
    
    @Override
    public void delete(Receiver receiver){
        receiverDao.delete(receiver);
    }
}
