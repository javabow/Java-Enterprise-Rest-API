/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao;

import java.util.List;
import com.je.spring.rest.master.model.Paket;

/**
 *
 * @author Prasetyo
 */
public interface PaketDao {
    
    public List<Paket>getAll();
    public Paket getById(int id);
    public long count();
    public void insert(Paket pengirim);
    
}
