/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service;

import com.je.spring.rest.master.model.Sender;
import java.util.List;
/**
 *
 * @author Prasetyo
 */
public interface SenderService {
    public List<Sender> getAll();
    public Sender getById(int id);
    public long count();
    public void insert(Sender sender);
    public void update(Sender sender);
    public void delete(Sender sender);
}
