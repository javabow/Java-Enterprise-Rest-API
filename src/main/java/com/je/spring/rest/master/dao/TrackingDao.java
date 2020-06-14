/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao;

import java.util.List;
import com.je.spring.rest.master.model.Tracking;

/**
 *
 * @author Prasetyo
 */
public interface TrackingDao {
    
    public List<Tracking>getAll();
    public Tracking getById(int id);
    public long count();
    public void insert(Tracking sender);
    public void update(Tracking sender);
    
}
