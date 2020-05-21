/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service;

import java.util.List;
import com.je.spring.rest.master.model.JenisPengiriman;
/**
 *
 * @author Prasetyo
 */
public interface JenisPengirimanService {
    
    public List<JenisPengiriman> getAll();
    public JenisPengiriman getById(int id);
    public long count();
    public void insert(JenisPengiriman jenisPengiriman);
    public void update(JenisPengiriman jenisPengiriman);
    public void delete(JenisPengiriman jenisPengiriman);
    
}
