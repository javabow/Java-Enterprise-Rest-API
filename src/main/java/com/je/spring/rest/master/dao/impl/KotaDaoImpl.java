/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao.impl;

import com.je.spring.rest.master.model.Kota;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.je.spring.rest.master.dao.KotaDao;
/**
 *
 * @author Javabow
 */

@Repository("kotaDao")
public class KotaDaoImpl {
    
    private static final String SQL_INSERT_KOTA = "INSERT INTO KOTA (nama_kota313339,telp_kota313339,email_kota313339,alamat_kota313339,partner_kota313339) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE_KOTA = "UPDATE KOTA SET nama_kota313339=?, telp_kota313339=?, email_kota313339=?,alamat_kota313339=?,partner_kota313339=? WHERE id_kota313339=?";
    private static final String SQL_DELETE_KOTA = "DELETE FROM KOTA WHERE id_kota313339=?";
    private static final String SQL_SELECT_KOTA_BY_ID = "SELECT id_kota313339,nama_kota313339,telp_kota313339,email_kota313339,alamat_kota313339,partner_kota313339 FROM KOTA WHERE id_kota313339=?";
    private static final String SQL_SELECT_KOTA_ALL = "SELECT id_kota313339,nama_kota313339,telp_kota313339,email_kota313339,alamat_kota313339,partner_kota313339 FROM KOTA";
    private static final String SQL_COUNT_KOTA = "SELECT COUNT(*) FROM KOTA";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
//    @Override
//    public List<Kota> getAll(){
//        List<Kota> kotaList = null;
//        try{
//            kotaList = jdbcTemplate.query(SQL_SELECT_KOTA_ALL, new Object[]{},
//                    new BeanPropertyRowMapper(Kota.class));
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        
//        return kotaList;
//    }
//    
//    @Override
//    public Kota getById(int id){
//        Kota kota = null;
//        try{
//            kota = (Kota) jdbcTemplate.queryForObject(SQL_SELECT_KOTA_BY_ID, new Object[]{id},
//                        new RowMapper<Kota>(){
//                        @Override
//                        public Kota mapRow(ResultSet rs, int rowNum)throws SQLException{
//                                                Kota kota = new Kota();
//                                                kota.setId_kota313339(rs.getInt("id_kota313339"));
//                                                kota.setNama_kota313339(rs.getString("nama_kota313339"));
//                                                kota.setTelp_kota313339(rs.getString("telp_kota313339"));
//                                                kota.setEmail_kota313339(rs.getString("email_kota313339"));
//                                                kota.setAlamat_kota313339(rs.getString("alamat_kota313339"));
//                                                kota.setPartner_kota313339(rs.getString("partner_kota313339"));
//                                                
//                                                return kota;
//                                        }    
//                        });
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        
//        return kota;
//    }
//    
//    @Override
//    public long count(){
//        long count = 0;
//        
//        try{
//            count = jdbcTemplate.queryForObject(SQL_COUNT_KOTA, null,Long.class);
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        
//        return count;
//    }
    
}
