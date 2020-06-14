/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao.impl;

import com.je.spring.rest.master.model.Sender;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.je.spring.rest.master.dao.SenderDao;
/**
 *
 * @author User
 */
@Repository("senderDao")
public class SenderDaoImpl implements SenderDao{
    private static final String SQL_INSERT_SENDER = "INSERT INTO SENDER (id_sender313339,nama_sender313339,telp_sender313339,email_sender313339,alamat_sender313339,partner_sender313339) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE_SENDER = "UPDATE SENDER SET nama_sender313339=?, telp_sender313339=?, email_sender313339=?,alamat_sender313339=?,partner_sender313339=? WHERE id_sender313339=?";
    private static final String SQL_DELETE_SENDER = "DELETE FROM SENDER WHERE id_sender313339=?";
    private static final String SQL_SELECT_SENDER_BY_ID = "SELECT id_sender313339,nama_sender313339,telp_sender313339,email_sender313339,alamat_sender313339,partner_sender313339=? FROM SENDER WHERE id_sender313339=?";
    private static final String SQL_SELECT_SENDER_ALL = "SELECT id_sender313339,nama_sender313339,telp_sender313339,email_sender313339,alamat_sender313339,partner_sender313339=? FROM SENDER";
    private static final String SQL_COUNT_SENDER = "SELECT COUNT(*) FROM SENDER";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Sender> getAll(){
        List<Sender> senderList = null;
        try{
            senderList = jdbcTemplate.query(SQL_SELECT_SENDER_ALL, new Object[]{},
                    new BeanPropertyRowMapper(Sender.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return senderList;
    }
    
    @Override
    public Sender getById(int id){
        Sender sender = null;
        try{
            sender = (Sender) jdbcTemplate.queryForObject(SQL_SELECT_SENDER_BY_ID, new Object[]{id},
                        new RowMapper<Sender>(){
                        @Override
                        public Sender mapRow(ResultSet rs, int rowNum)throws SQLException{
                                                Sender sender = new Sender();
                                                sender.setId_sender313339(rs.getInt("id_sender313339"));
                                                sender.setNama_sender313339(rs.getString("nama_sender313339"));
                                                sender.setTelp_sender313339(rs.getString("telp_sender313339"));
                                                sender.setEmail_sender313339(rs.getString("email_sender313339"));
                                                sender.setAlamat_sender313339(rs.getString("alamat_sender313339"));
                                                sender.setPartner_sender313339(rs.getString("partner_sender313339"));
                                                
                                                return sender;
                                        }    
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return sender;
    }
    
    @Override
    public long count(){
        long count = 0;
        
        try{
            count = jdbcTemplate.queryForObject(SQL_COUNT_SENDER, null,Long.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }
    
    @Override
    public void insert(Sender sender){
        try{
            jdbcTemplate.update(SQL_INSERT_SENDER, new Object[]{sender.getId_sender313339(),sender.getNama_sender313339(),sender.getTelp_sender313339(),
                sender.getEmail_sender313339(),sender.getAlamat_sender313339(),sender.getPartner_sender313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(Sender sender){
        try{
            jdbcTemplate.update(SQL_UPDATE_SENDER, new Object[]{sender.getNama_sender313339(),sender.getTelp_sender313339(),
                sender.getEmail_sender313339(),sender.getAlamat_sender313339(),sender.getId_sender313339(),sender.getPartner_sender313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void delete(Sender sender){
        try{
            jdbcTemplate.update(SQL_DELETE_SENDER, new Object[]{sender.getId_sender313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
