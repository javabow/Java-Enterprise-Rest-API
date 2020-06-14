/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.controller;

import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.Map;
import com.je.spring.rest.master.model.Sender;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.je.spring.rest.master.service.SenderService;
/**
 *
 * @author User
 */
@Controller
public class SenderController {
    @Autowired
    private SenderService senderService;
    
    @RequestMapping(value = "/master/sender", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<Sender> senderList = senderService.getAll();
            long count = senderService.count();
            
            response.put(Constants.LIST, senderList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/sender/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            Sender sender = senderService.getById(id);
            response.put(Constants.SENDER313339_KEY, sender);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/sender", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> senderMap = (Map<String, Object>) request.get(Constants.SENDER313339_KEY);
        Sender sender = new Sender();
        
        try{
            //sender.setId_sender313339(Integer.parseInt((String) senderMap.get("id_sender313339")));
            sender.setNama_sender313339((String) senderMap.get("nama_sender313339"));
            sender.setTelp_sender313339((String) senderMap.get("telp_sender313339"));
            sender.setEmail_sender313339((String) senderMap.get("email_sender313339"));
            sender.setAlamat_sender313339((String) senderMap.get("alamat_sender313339"));
            sender.setPartner_sender313339((String) senderMap.get("partner_sender313339"));
            
            senderService.insert(sender);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/sender/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("id") final int id,
           @RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> senderMap = (Map<String, Object>) request.get(Constants.SENDER313339_KEY);
        Sender sender = new Sender();
        
        try{
            sender.setId_sender313339(id);
            sender.setNama_sender313339((String) senderMap.get("nama_sender313339"));
            sender.setTelp_sender313339((String) senderMap.get("telp_sender313339"));
            sender.setEmail_sender313339((String) senderMap.get("email_sender313339"));
            sender.setAlamat_sender313339((String) senderMap.get("alamat_sender313339"));
            sender.setPartner_sender313339((String) senderMap.get("partner_sender313339"));
            
            senderService.update(sender);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/sender/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("id")final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Sender sender = new Sender();
        
        try{
            sender.setId_sender313339(id);
            
            senderService.delete(sender);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
}
