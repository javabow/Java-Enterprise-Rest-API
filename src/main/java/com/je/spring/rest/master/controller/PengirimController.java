/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.controller;

import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.Map;
import com.je.spring.rest.master.model.Pengirim;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.je.spring.rest.master.service.PengirimService;
/**
 *
 * @author User
 */
@Controller
public class PengirimController {
    @Autowired
    private PengirimService pengirimService;
    
    @RequestMapping(value = "/master/pengirim", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<Pengirim> pengirimList = pengirimService.getAll();
            long count = pengirimService.count();
            
            response.put(Constants.LIST, pengirimList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/pengirim/{nip}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("nip") final int nip){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            Pengirim pengirim = pengirimService.getById(nip);
            response.put(Constants.PENGIRIM313339_KEY, pengirim);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/pengirim", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> pengirimMap = (Map<String, Object>) request.get(Constants.PENGIRIM313339_KEY);
        Pengirim pengirim = new Pengirim();
        
        try{
            //pengirim.setNip_pengirim313339(Integer.parseInt((String) pengirimMap.get("nip_pengirim313339")));
            pengirim.setNama_pengirim313339((String) pengirimMap.get("nama_pengirim313339"));
            pengirim.setTelp_pengirim313339((String) pengirimMap.get("telp_pengirim313339"));
            pengirim.setEmail_pengirim313339((String) pengirimMap.get("email_pengirim313339"));
            pengirim.setAlamat_pengirim313339((String) pengirimMap.get("alamat_pengirim313339"));
            
            pengirimService.insert(pengirim);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/pengirim/{nip}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("nip") final int nip,
           @RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> pengirimMap = (Map<String, Object>) request.get(Constants.PENGIRIM313339_KEY);
        Pengirim pengirim = new Pengirim();
        
        try{
            pengirim.setNip_pengirim313339(nip);
            pengirim.setNama_pengirim313339((String) pengirimMap.get("nama_pengirim313339"));
            pengirim.setTelp_pengirim313339((String) pengirimMap.get("telp_pengirim313339"));
            pengirim.setEmail_pengirim313339((String) pengirimMap.get("email_pengirim313339"));
            pengirim.setAlamat_pengirim313339((String) pengirimMap.get("alamat_pengirim313339"));
            
            pengirimService.update(pengirim);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/pengirim/{nip}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("nip")final int nip){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Pengirim pengirim = new Pengirim();
        
        try{
            pengirim.setNip_pengirim313339(nip);
            
            pengirimService.delete(pengirim);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
}
