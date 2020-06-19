/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service;

import com.je.spring.rest.master.model.Status;
import java.util.List;
/**
 *
 * @author Prasetyo
 */
public interface StatusService {
    public List<Status> getAll();
    public Status getById(int id);
    public long count();
   /* public void insert(Status status);
    public void update(Status status);
    public void delete(Status status); */
}
