/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.dao.impl;

import com.je.spring.rest.model.Pengirim;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.je.spring.rest.dao.PengirimDao;
/**
 *
 * @author User
 */
@Repository("pengirimDao")
public class PengirimDaoImpl implements PengirimDao{
    private static final String SQL_INSERT_PENGIRIM = "INSERT INTO PENGIRIM (nip_pengirim313339,nama_pengirim313339,telp_pengirim313339,email_pengirim313339,alamat_pengirim313339) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE_PENGIRIM = "UPDATE PENGIRIM SET nama_pengirim313339=?, telp_pengirim313339=?, email_pengirim313339=?,alamat_pengirim313339=? WHERE nip_pengirim313339=?";
    private static final String SQL_DELETE_PENGIRIM = "DELETE FROM PENGIRIM WHERE nip_pengirim313339=?";
    private static final String SQL_SELECT_PENGIRIM_BY_ID = "SELECT nip_pengirim313339,nama_pengirim313339,telp_pengirim313339,email_pengirim313339,alamat_pengirim313339 FROM PENGIRIM WHERE nip_pengirim313339=?";
    private static final String SQL_SELECT_PENGIRIM_ALL = "SELECT nip_pengirim313339,nama_pengirim313339,telp_pengirim313339,email_pengirim313339,alamat_pengirim313339 FROM PENGIRIM";
    private static final String SQL_COUNT_PENGIRIM = "SELECT COUNT(*) FROM PENGIRIM";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Pengirim> getAll(){
        List<Pengirim> pengirimList = null;
        try{
            pengirimList = jdbcTemplate.query(SQL_SELECT_PENGIRIM_ALL, new Object[]{},
                    new BeanPropertyRowMapper(Pengirim.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return pengirimList;
    }
    
    @Override
    public Pengirim getById(int nip){
        Pengirim pengirim = null;
        try{
            pengirim = (Pengirim) jdbcTemplate.queryForObject(SQL_SELECT_PENGIRIM_BY_ID, new Object[]{nip},
                        new RowMapper<Pengirim>(){
                        @Override
                        public Pengirim mapRow(ResultSet rs, int rowNum)throws SQLException{
                                                Pengirim pengirim = new Pengirim();
                                                pengirim.setNip_pengirim313339(rs.getInt("nip_pengirim313339"));
                                                pengirim.setNama_pengirim313339(rs.getString("nama_pengirim313339"));
                                                pengirim.setTelp_pengirim313339(rs.getString("telp_pengirim313339"));
                                                pengirim.setEmail_pengirim313339(rs.getString("email_pengirim313339"));
                                                pengirim.setAlamat_pengirim313339(rs.getString("alamat_pengirim313339"));
                                                
                                                return pengirim;
                                        }    
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return pengirim;
    }
    
    @Override
    public long count(){
        long count = 0;
        
        try{
            count = jdbcTemplate.queryForObject(SQL_COUNT_PENGIRIM, null,Long.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }
    
    @Override
    public void insert(Pengirim pengirim){
        try{
            jdbcTemplate.update(SQL_INSERT_PENGIRIM, new Object[]{pengirim.getNip_pengirim313339(),pengirim.getNama_pengirim313339(),pengirim.getTelp_pengirim313339(),
                pengirim.getEmail_pengirim313339(),pengirim.getAlamat_pengirim313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(Pengirim pengirim){
        try{
            jdbcTemplate.update(SQL_UPDATE_PENGIRIM, new Object[]{pengirim.getNama_pengirim313339(),pengirim.getTelp_pengirim313339(),
                pengirim.getEmail_pengirim313339(),pengirim.getAlamat_pengirim313339(),pengirim.getNip_pengirim313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void delete(Pengirim pengirim){
        try{
            jdbcTemplate.update(SQL_DELETE_PENGIRIM, new Object[]{pengirim.getNip_pengirim313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
