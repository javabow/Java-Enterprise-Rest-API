/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao;

import java.util.List;
import com.je.spring.rest.master.model.Sender;
/**
 *
 * @author Prasetyo
 */
public interface SenderDao {
    public List<Sender>getAll();
    public Sender getById(int id);
    public long count();
    public void insert(Sender sender);
    public void update(Sender sender);
    public void delete(Sender sender);
}
