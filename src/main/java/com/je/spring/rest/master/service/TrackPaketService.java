/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.service;

import com.je.spring.rest.master.model.TrackPaket;
import java.util.List;
/**
 *
 * @author User
 */
public interface TrackPaketService {
    public List<TrackPaket> getAll();
    public TrackPaket getById(int id);
    public long count();
    public void insert(TrackPaket trackpaket);
    public void update(TrackPaket trackpaket);
    public void delete(TrackPaket trackpaket);
}
