/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service;

import com.je.spring.rest.master.model.Receiver;
import java.util.List;
/**
 *
 * @author Prasetyo
 */
public interface ReceiverService {
    public List<Receiver> getAll();
    public Receiver getById(int id);
    public long count();
    public void insert(Receiver receiver);
    public void update(Receiver receiver);
    public void delete(Receiver receiver);
}
