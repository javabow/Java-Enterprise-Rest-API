/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao;

import java.util.List;
import com.je.spring.rest.master.model.Status;
/**
 *
 * @author User
 */
public interface StatusDao {
    public List<Status>getAll();
    public Status getById(int id);
    public long count();
    /*public void insert(Status status);
    public void update(Status status);
    public void delete(Status status);*/
}
