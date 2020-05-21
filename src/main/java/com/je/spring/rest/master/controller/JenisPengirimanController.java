/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.controller;

import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.Map;
import com.je.spring.rest.master.model.JenisPengiriman;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.je.spring.rest.master.service.JenisPengirimanService;
/**
 *
 * @author Prasetyo
 */
@Controller
public class JenisPengirimanController {
 
    @Autowired
    private JenisPengirimanService jenisPengirimanService;
    
    @RequestMapping(value = "/master/jenis-pengiriman", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<JenisPengiriman> jenisPengirimanList = jenisPengirimanService.getAll();
            long count = jenisPengirimanService.count();
            
            response.put(Constants.LIST, jenisPengirimanList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/jenis-pengiriman/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            JenisPengiriman jenisPengiriman = jenisPengirimanService.getById(id);
            response.put(Constants.JENISPENGIRIMAN313339_KEY, jenisPengiriman);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/jenis-pengiriman", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> jenisPengirimanMap = (Map<String, Object>) request.get(Constants.JENISPENGIRIMAN313339_KEY);
        JenisPengiriman jenisPengiriman = new JenisPengiriman();
        
        try{
            //jenisPengiriman.setId_kurir_service313339(Integer.parseInt((String) jenisPengirimanMap.get("id_kurir_service313339")));
            jenisPengiriman.setNama_service313339((String) jenisPengirimanMap.get("nama_service313339"));
            jenisPengiriman.setId_harga_service313339(Integer.parseInt((String)jenisPengirimanMap.get("harga_service313339")));
            jenisPengiriman.setLama_hari313339(Integer.parseInt((String)jenisPengirimanMap.get("lama_hari313339")));
            jenisPengiriman.setBerat_barang313339(Integer.parseInt((String)jenisPengirimanMap.get("berat_barang313339")));
                    
            jenisPengirimanService.insert(jenisPengiriman);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/jenis-pengiriman/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Map<String, Object> update(@PathVariable("id") final int id,
           @RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> jenisPengirimanMap = (Map<String, Object>) request.get(Constants.JENISPENGIRIMAN313339_KEY);
        JenisPengiriman jenisPengiriman = new JenisPengiriman();
        
        try{
            jenisPengiriman.setId_kurir_service313339(id);
            jenisPengiriman.setNama_service313339((String) jenisPengirimanMap.get("nama_service313339"));
            jenisPengiriman.setId_harga_service313339(Integer.parseInt((String)jenisPengirimanMap.get("harga_service313339")));
            jenisPengiriman.setLama_hari313339(Integer.parseInt((String)jenisPengirimanMap.get("lama_hari313339")));
            jenisPengiriman.setBerat_barang313339(Integer.parseInt((String)jenisPengirimanMap.get("berat_barang313339")));
            jenisPengirimanService.update(jenisPengiriman);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/master/jenis-pengiriman/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Map<String, Object> delete(@PathVariable("id")final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        JenisPengiriman jenisPengiriman = new JenisPengiriman();
        
        try{
            jenisPengiriman.setId_kurir_service313339(id);
            
            jenisPengirimanService.delete(jenisPengiriman);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
    }
    
}
