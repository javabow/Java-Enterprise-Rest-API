/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service;

import com.je.spring.rest.master.model.Pengirim;
import java.util.List;
/**
 *
 * @author User
 */
public interface PengirimService {
    public List<Pengirim> getAll();
    public Pengirim getById(int id);
    public long count();
    public void insert(Pengirim pengirim);
    public void update(Pengirim pengirim);
    public void delete(Pengirim pengirim);
}
