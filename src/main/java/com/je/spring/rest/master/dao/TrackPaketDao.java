/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao;

import java.util.List;
import com.je.spring.rest.master.model.TrackPaket;
/**
 *
 * @author User
 */
public interface TrackPaketDao {
    public List<TrackPaket>getAll();
    public TrackPaket getById(int id);
    public long count();
    public void insert(TrackPaket trackpaket);
    public void update(TrackPaket trackpaket);
    public void delete(TrackPaket trackpaket);
}
