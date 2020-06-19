/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.controller;

import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.Map;
import com.je.spring.rest.master.model.Kota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.je.spring.rest.master.service.KotaService;
/**
 *
 * @author Prasetyo
 */
@Controller
public class KotaController {
    @Autowired
    private KotaService kotaService;
    
    @RequestMapping(value = "/master/kota", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<Kota> kotaList = kotaService.getAll();
            long count = kotaService.count();
            
            response.put(Constants.LIST, kotaList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/kota/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            Kota kota = kotaService.getById(id);
            response.put(Constants.KOTA313339_KEY, kota);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    /*@RequestMapping(value = "/master/kota", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> kotaMap = (Map<String, Object>) request.get(Constants.KOTA313339_KEY);
        Kota kota = new Kota();
        
        try{
            //kota.setId_kota313339(Integer.parseInt((String) kotaMap.get("id_kota313339")));
            kota.setNama_kota313339((String) kotaMap.get("nama_kota313339"));
            kota.setTelp_kota313339((String) kotaMap.get("telp_kota313339"));
            kota.setEmail_kota313339((String) kotaMap.get("email_kota313339"));
            kota.setAlamat_kota313339((String) kotaMap.get("alamat_kota313339"));
            kota.setJenkel_kota313339((String) kotaMap.get("jenkel_kota313339"));
            
            kotaService.insert(kota);
            
            response.put(Constants.KOTA, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.KOTA, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/kota/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("id") final int id,
           @RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> kotaMap = (Map<String, Object>) request.get(Constants.KOTA313339_KEY);
        Kota kota = new Kota();
        
        try{
            kota.setId_kota313339(id);
            kota.setNama_kota313339((String) kotaMap.get("nama_kota313339"));
            kota.setTelp_kota313339((String) kotaMap.get("telp_kota313339"));
            kota.setEmail_kota313339((String) kotaMap.get("email_kota313339"));
            kota.setAlamat_kota313339((String) kotaMap.get("alamat_kota313339"));
            kota.setJenkel_kota313339((String) kotaMap.get("jenkel_kota313339"));
            
            kotaService.update(kota);
            
            response.put(Constants.KOTA, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.KOTA, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/kota/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("id")final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Kota kota = new Kota();
        
        try{
            kota.setId_kota313339(id);
            
            kotaService.delete(kota);
            
            response.put(Constants.KOTA, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.KOTA, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    } */
}
