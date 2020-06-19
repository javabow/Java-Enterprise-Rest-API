/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service;

import com.je.spring.rest.master.model.Kota;
import java.util.List;
/**
 *
 * @author Prasetyo
 */
public interface KotaService {
    public List<Kota> getAll();
    public Kota getById(int id);
    public long count();
   /* public void insert(Kota kota);
    public void update(Kota kota);
    public void delete(Kota kota); */
}
