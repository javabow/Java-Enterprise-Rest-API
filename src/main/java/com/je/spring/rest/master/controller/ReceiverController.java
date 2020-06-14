/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.controller;

import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.Map;
import com.je.spring.rest.master.model.Receiver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.je.spring.rest.master.service.ReceiverService;
/**
 *
 * @author User
 */
@Controller
public class ReceiverController {
    @Autowired
    private ReceiverService receiverService;
    
    @RequestMapping(value = "/master/receiver", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<Receiver> receiverList = receiverService.getAll();
            long count = receiverService.count();
            
            response.put(Constants.LIST, receiverList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/receiver/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            Receiver receiver = receiverService.getById(id);
            response.put(Constants.RECEIVER313339_KEY, receiver);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/receiver", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> receiverMap = (Map<String, Object>) request.get(Constants.RECEIVER313339_KEY);
        Receiver receiver = new Receiver();
        
        try{
            //receiver.setId_receiver313339(Integer.parseInt((String) receiverMap.get("id_receiver313339")));
            receiver.setNama_receiver313339((String) receiverMap.get("nama_receiver313339"));
            receiver.setTelp_receiver313339((String) receiverMap.get("telp_receiver313339"));
            receiver.setEmail_receiver313339((String) receiverMap.get("email_receiver313339"));
            receiver.setAlamat_receiver313339((String) receiverMap.get("alamat_receiver313339"));
            receiver.setPos_receiver313339((String) receiverMap.get("pos_receiver313339"));
            
            receiverService.insert(receiver);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/receiver/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("id") final int id,
           @RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> receiverMap = (Map<String, Object>) request.get(Constants.RECEIVER313339_KEY);
        Receiver receiver = new Receiver();
        
        try{
            receiver.setId_receiver313339(id);
            receiver.setNama_receiver313339((String) receiverMap.get("nama_receiver313339"));
            receiver.setTelp_receiver313339((String) receiverMap.get("telp_receiver313339"));
            receiver.setEmail_receiver313339((String) receiverMap.get("email_receiver313339"));
            receiver.setAlamat_receiver313339((String) receiverMap.get("alamat_receiver313339"));
            receiver.setPos_receiver313339((String) receiverMap.get("pos_receiver313339"));
            
            receiverService.update(receiver);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/receiver/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("id")final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Receiver receiver = new Receiver();
        
        try{
            receiver.setId_receiver313339(id);
            
            receiverService.delete(receiver);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
}
