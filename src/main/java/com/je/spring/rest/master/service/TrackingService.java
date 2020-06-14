/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service;

import com.je.spring.rest.master.model.Tracking;
import java.util.List;
/**
 *
 * @author Prasetyo
 */
public interface TrackingService {
    
    public List<Tracking> getAll();
    public Tracking getById(int id);
    public long count();
    public void insert(Tracking tracking);
    
}
