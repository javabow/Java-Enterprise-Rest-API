/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.controller;

import com.je.spring.rest.master.service.TrackingService;
import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.Map;
import com.je.spring.rest.master.model.Tracking;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.je.spring.rest.master.service.ReceiverService;
import com.je.spring.rest.master.service.SenderService;
import com.google.gson.Gson;
/**
 *
 * @author Prasetyo
 */

@Controller
public class TrackingController {
    
    @Autowired
    private TrackingService trackingService;
    
    @Autowired
    private ReceiverService receiverService;
    
    @Autowired
    private SenderService senderService;
    
    Gson gson = new Gson();
    
    @RequestMapping(value = "/transaksi/tracking", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<Tracking> trackingList = trackingService.getAll();
            long count = trackingService.count();
            
            response.put(Constants.LIST, trackingList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/transaksi/tracking/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            Tracking tracking = trackingService.getById(id);
            response.put(Constants.TRACKING313339_KEY, tracking);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/transaksi/tracking", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> trackingMap = (Map<String, Object>) request.get(Constants.TRACKING313339_KEY);
     
        try{
            StringBuffer str = new StringBuffer(trackingMap.toString());
        
            System.out.println(str);
            
            String maptracking = str.toString();
            Tracking tracking = gson.fromJson(maptracking, Tracking.class);
            //gson.fromJson(gson.toJson(<your_data>), YourClassName::class.java)
            
            Integer id_receiver313339 = tracking.getId_receiver313339().getId_receiver313339();
                if(receiverService.getById(id_receiver313339) == null) {
                    response.put(Constants.STATUS, "Data Receiver tidak ditemukan.");

                    return response;
                }

            Integer id_sender313339 = tracking.getId_sender313339().getId_sender313339();
                if(senderService.getById(id_sender313339) == null) {
                    response.put(Constants.STATUS, "Data Sender tidak ditemukan.");

                    return response;
                }
            
            trackingService.insert(tracking);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
        
    }
    
    @RequestMapping(value = "/transaksi/tracking/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("id") final int id,
           @RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> trackingMap = (Map<String, Object>) request.get(Constants.TRACKING313339_KEY);
     
        try{
            StringBuffer str = new StringBuffer(trackingMap.toString());
        
            System.out.println(str);
            
            String maptracking = str.toString();
            Tracking tracking = gson.fromJson(maptracking, Tracking.class);
            
            Integer id_receiver313339 = tracking.getId_receiver313339().getId_receiver313339();
                if(receiverService.getById(id_receiver313339) == null) {
                    response.put(Constants.STATUS, "Data Receiver tidak ditemukan.");

                    return response;
                }

            Integer id_sender313339 = tracking.getId_sender313339().getId_sender313339();
                if(senderService.getById(id_sender313339) == null) {
                    response.put(Constants.STATUS, "Data Sender tidak ditemukan.");

                    return response;
                }
            
            trackingService.update(tracking);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
        
    }
    
}
