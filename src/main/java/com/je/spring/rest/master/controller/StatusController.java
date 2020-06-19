/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.controller;

import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.Map;
import com.je.spring.rest.master.model.Status;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.je.spring.rest.master.service.StatusService;
/**
 *
 * @author User
 */
@Controller
public class StatusController {
    @Autowired
    private StatusService statusService;
    
    @RequestMapping(value = "/master/status", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<Status> statusList = statusService.getAll();
            long count = statusService.count();
            
            response.put(Constants.LIST, statusList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/status/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            Status status = statusService.getById(id);
            response.put(Constants.STATUS313339_KEY, status);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    /*@RequestMapping(value = "/master/status", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> statusMap = (Map<String, Object>) request.get(Constants.STATUS313339_KEY);
        Status status = new Status();
        
        try{
            //status.setId_status313339(Integer.parseInt((String) statusMap.get("id_status313339")));
            status.setNama_status313339((String) statusMap.get("nama_status313339"));
            status.setTelp_status313339((String) statusMap.get("telp_status313339"));
            status.setEmail_status313339((String) statusMap.get("email_status313339"));
            status.setAlamat_status313339((String) statusMap.get("alamat_status313339"));
            status.setJenkel_status313339((String) statusMap.get("jenkel_status313339"));
            
            statusService.insert(status);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/status/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("id") final int id,
           @RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> statusMap = (Map<String, Object>) request.get(Constants.STATUS313339_KEY);
        Status status = new Status();
        
        try{
            status.setId_status313339(id);
            status.setNama_status313339((String) statusMap.get("nama_status313339"));
            status.setTelp_status313339((String) statusMap.get("telp_status313339"));
            status.setEmail_status313339((String) statusMap.get("email_status313339"));
            status.setAlamat_status313339((String) statusMap.get("alamat_status313339"));
            status.setJenkel_status313339((String) statusMap.get("jenkel_status313339"));
            
            statusService.update(status);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/status/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("id")final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Status status = new Status();
        
        try{
            status.setId_status313339(id);
            
            statusService.delete(status);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    } */
}
