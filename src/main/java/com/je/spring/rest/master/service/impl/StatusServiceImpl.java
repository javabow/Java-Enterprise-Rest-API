/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service.impl;

import com.je.spring.rest.master.model.Status;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.je.spring.rest.master.dao.StatusDao;
import com.je.spring.rest.master.service.StatusService;
/**
 *
 * @author Prasetyo
 */
@Service("statusService")
public class StatusServiceImpl implements StatusService{
    
    @Autowired
    StatusDao statusDao;
    
    @Override
    public List<Status> getAll(){
        List<Status> statusList = new ArrayList<Status>();
        statusList = statusDao.getAll();
        return statusList;
    }
    
    @Override
    public Status getById(int id){
        Status status = new Status();
        status = statusDao.getById(id);
        return status;
    }
    
    @Override
    public long count(){
        return statusDao.count();
    }
    
  /*  @Override
    public void insert(Status status){
        statusDao.insert(status);
    }
    
    @Override
    public void update(Status status){
        statusDao.update(status);
    }
    
    @Override
    public void delete(Status status){
        statusDao.delete(status);
    } */
}
