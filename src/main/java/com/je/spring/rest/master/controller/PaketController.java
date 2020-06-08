/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.controller;

import com.je.spring.rest.master.service.PaketService;
import com.je.spring.rest.util.Constants;
import java.util.HashMap;
import java.util.Map;
import com.je.spring.rest.master.model.Paket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.je.spring.rest.master.service.JenisPengirimanService;
import com.je.spring.rest.master.service.PengirimService;
import com.google.gson.Gson;
/**
 *
 * @author Prasetyo
 */

@Controller
public class PaketController {
    
    @Autowired
    private PaketService paketService;
    
    @Autowired
    private JenisPengirimanService jenisPengirimanService;
    
    @Autowired
    private PengirimService pengirimService;
    
    Gson gson = new Gson();
    
    @RequestMapping(value = "/transaksi/paket", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getAll(){
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            List<Paket> paketList = paketService.getAll();
            long count = paketService.count();
            
            response.put(Constants.LIST, paketList);
            response.put(Constants.TOTAL, count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/transaksi/paket/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Map<String, Object> getById(@PathVariable("id") final int id){
        
        Map<String, Object> response = new HashMap<String, Object>();
        
        try{
            Paket paket = paketService.getById(id);
            response.put(Constants.PAKET313339_KEY, paket);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return response;
    }
    
    @RequestMapping(value = "/transaksi/paket", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> insert(@RequestBody final Map<String, Object> request){
        
        Map<String, Object> response = new HashMap<String, Object>();
        Map<String, Object> paketMap = (Map<String, Object>) request.get(Constants.PAKET313339_KEY);
     
        try{
            StringBuffer str = new StringBuffer(paketMap.toString());
        
            System.out.println(str);
            
            String mappaket = str.toString();
            Paket paket = gson.fromJson(mappaket, Paket.class);
            
            Integer id_service313339 = paket.getId_service313339().getId_kurir_service313339();
                if(jenisPengirimanService.getById(id_service313339) == null) {
                    response.put(Constants.STATUS, "Data Service tidak ditemukan.");

                    return response;
                }

            Integer nip_pengirim313339 = paket.getId_pengirim313339().getNip_pengirim313339();
                if(pengirimService.getById(nip_pengirim313339) == null) {
                    response.put(Constants.STATUS, "Data Pengirim tidak ditemukan.");

                    return response;
                }
            
            paketService.insert(paket);
            
            response.put(Constants.STATUS, Constants.OK);
        }
        catch(Exception e){
            response.put(Constants.STATUS, Constants.ERROR);
            e.printStackTrace();
        }
        
        return response;
        
    }
    
}
