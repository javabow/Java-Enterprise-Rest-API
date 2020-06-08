/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao;

import java.util.List;
import com.je.spring.rest.master.model.Pengirim;
/**
 *
 * @author User
 */
public interface PengirimDao {
    public List<Pengirim>getAll();
    public Pengirim getById(int nip);
    public long count();
    public void insert(Pengirim pengirim);
    public void update(Pengirim pengirim);
    public void delete(Pengirim pengirim);
}
