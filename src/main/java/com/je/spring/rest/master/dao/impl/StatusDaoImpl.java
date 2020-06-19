/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao.impl;

import com.je.spring.rest.master.model.Status;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.je.spring.rest.master.dao.StatusDao;
/**
 *
 * @author User
 */
@Repository("statusDao")
public class StatusDaoImpl implements StatusDao{
   // private static final String SQL_INSERT_STATUS = "INSERT INTO STATUS (id_status313339,nama_status313339,telp_status313339,email_status313339,alamat_status313339,jenkel_status313339) VALUES (?,?,?,?,?,?)";
   // private static final String SQL_UPDATE_STATUS = "UPDATE STATUS SET nama_status313339=?, telp_status313339=?, email_status313339=?,alamat_status313339=?,jenkel_status313339=? WHERE id_status313339=?";
   // private static final String SQL_DELETE_STATUS = "DELETE FROM STATUS WHERE id_status313339=?";
    private static final String SQL_SELECT_STATUS_BY_ID = "SELECT id_status313339,jenis_status313339 FROM STATUS WHERE id_status313339=?";
    private static final String SQL_SELECT_STATUS_ALL = "SELECT id_status313339,jenis_status313339 FROM STATUS";
    private static final String SQL_COUNT_STATUS = "SELECT COUNT(*) FROM STATUS";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Status> getAll(){
        List<Status> statusList = null;
        try{
            statusList = jdbcTemplate.query(SQL_SELECT_STATUS_ALL, new Object[]{},
                    new BeanPropertyRowMapper(Status.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return statusList;
    }
    
    @Override
    public Status getById(int id){
        Status status = null;
        try{
            status = (Status) jdbcTemplate.queryForObject(SQL_SELECT_STATUS_BY_ID, new Object[]{id},
                        new RowMapper<Status>(){
                        @Override
                        public Status mapRow(ResultSet rs, int rowNum)throws SQLException{
                                                Status status = new Status();
                                                status.setId_status313339(rs.getInt("id_status313339"));
                                                status.setJenis_status313339(rs.getString("jenis_status313339"));
                                               /* status.setTelp_status313339(rs.getString("telp_status313339"));
                                                status.setEmail_status313339(rs.getString("email_status313339"));
                                                status.setAlamat_status313339(rs.getString("alamat_status313339"));
                                                status.setJenkel_status313339(rs.getString("jenkel_status313339"));
                                               */ 
                                                return status;
                                        }    
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return status;
    }
    
    @Override
    public long count(){
        long count = 0;
        
        try{
            count = jdbcTemplate.queryForObject(SQL_COUNT_STATUS, null,Long.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }
    
  /*  @Override
    public void insert(Status status){
        try{
            jdbcTemplate.update(SQL_INSERT_STATUS, new Object[]{status.getId_status313339(),status.getNama_status313339(),status.getTelp_status313339(),
                status.getEmail_status313339(),status.getAlamat_status313339(),status.getJenkel_status313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(Status status){
        try{
            jdbcTemplate.update(SQL_UPDATE_STATUS, new Object[]{status.getNama_status313339(),status.getTelp_status313339(),
                status.getEmail_status313339(),status.getAlamat_status313339(),status.getJenkel_status313339(),status.getId_status313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void delete(Status status){
        try{
            jdbcTemplate.update(SQL_DELETE_STATUS, new Object[]{status.getId_status313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } */
}
