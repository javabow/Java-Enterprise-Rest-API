/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.controller;

import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.Map;
import com.je.spring.rest.master.model.TrackPaket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.je.spring.rest.master.service.TrackPaketService;
/**
 *
 * @author User
 */
@Controller
public class TrackPaketController {
    @Autowired
    private TrackPaketService trackpaketService;
    
    @RequestMapping(value = "/master/trackpaket", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<TrackPaket> trackpaketList = trackpaketService.getAll();
            long count = trackpaketService.count();
            
            response.put(Constants.LIST, trackpaketList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/trackpaket/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            TrackPaket trackpaket = trackpaketService.getById(id);
            response.put(Constants.TRACKPAKET313339_KEY, trackpaket);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/trackpaket", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> trackpaketMap = (Map<String, Object>) request.get(Constants.TRACKPAKET313339_KEY);
        TrackPaket trackpaket = new TrackPaket();
        
        try{
            trackpaket.setTrack_id313339(Integer.parseInt((String) trackpaketMap.get("track_id313339")));
            trackpaket.setId_paket313339((String) trackpaketMap.get("id_paket313339"));
            trackpaket.setNomor_resi313339((String) trackpaketMap.get("nomor_resi313339"));
            trackpaket.setKeterangan313339((String) trackpaketMap.get("keterangan313339"));
            trackpaket.setTujuan_kota313339((String) trackpaketMap.get("tujuan_kota313339"));
            
            trackpaketService.insert(trackpaket);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/trackpaket/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("id") final int id,
           @RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> trackpaketMap = (Map<String, Object>) request.get(Constants.TRACKPAKET313339_KEY);
        TrackPaket trackpaket = new TrackPaket();
        
        try{
            trackpaket.setTrack_id313339(id);
            trackpaket.setId_paket313339((String) trackpaketMap.get("id_paket313339"));
            trackpaket.setNomor_resi313339((String) trackpaketMap.get("nomor_resi313339"));
            trackpaket.setKeterangan313339((String) trackpaketMap.get("keterangan313339"));
            trackpaket.setTujuan_kota313339((String) trackpaketMap.get("tujuan_kota313339"));
            
            trackpaketService.update(trackpaket);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/trackpaket/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("id")final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        TrackPaket trackpaket = new TrackPaket();
        
        try{
            trackpaket.setTrack_id313339(id);
            
            trackpaketService.delete(trackpaket);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
}
