/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service;

import com.je.spring.rest.master.model.Paket;
import java.util.List;
/**
 *
 * @author Prasetyo
 */
public interface PaketService {
    
    public List<Paket> getAll();
    public Paket getById(int id);
    public long count();
    public void insert(Paket paket);
    
}
