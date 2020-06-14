/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao.impl;

import com.je.spring.rest.master.model.Receiver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.je.spring.rest.master.dao.ReceiverDao;
/**
 *
 * @author User
 */
@Repository("receiverDao")
public class ReceiverDaoImpl implements ReceiverDao{
    private static final String SQL_INSERT_RECEIVER = "INSERT INTO RECEIVER (id_receiver313339,nama_receiver313339,telp_receiver313339,email_receiver313339,alamat_receiver313339,pos_receiver313339) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE_RECEIVER = "UPDATE RECEIVER SET nama_receiver313339=?, telp_receiver313339=?, email_receiver313339=?,alamat_receiver313339=?,pos_receiver313339=? WHERE id_receiver313339=?";
    private static final String SQL_DELETE_RECEIVER = "DELETE FROM RECEIVER WHERE id_receiver313339=?";
    private static final String SQL_SELECT_RECEIVER_BY_ID = "SELECT id_receiver313339,nama_receiver313339,telp_receiver313339,email_receiver313339,alamat_receiver313339,pos_receiver313339=? FROM RECEIVER WHERE id_receiver313339=?";
    private static final String SQL_SELECT_RECEIVER_ALL = "SELECT id_receiver313339,nama_receiver313339,telp_receiver313339,email_receiver313339,alamat_receiver313339,pos_receiver313339=? FROM RECEIVER";
    private static final String SQL_COUNT_RECEIVER = "SELECT COUNT(*) FROM RECEIVER";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Receiver> getAll(){
        List<Receiver> receiverList = null;
        try{
            receiverList = jdbcTemplate.query(SQL_SELECT_RECEIVER_ALL, new Object[]{},
                    new BeanPropertyRowMapper(Receiver.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return receiverList;
    }
    
    @Override
    public Receiver getById(int id){
        Receiver receiver = null;
        try{
            receiver = (Receiver) jdbcTemplate.queryForObject(SQL_SELECT_RECEIVER_BY_ID, new Object[]{id},
                        new RowMapper<Receiver>(){
                        @Override
                        public Receiver mapRow(ResultSet rs, int rowNum)throws SQLException{
                                                Receiver receiver = new Receiver();
                                                receiver.setId_receiver313339(rs.getInt("id_receiver313339"));
                                                receiver.setNama_receiver313339(rs.getString("nama_receiver313339"));
                                                receiver.setTelp_receiver313339(rs.getString("telp_receiver313339"));
                                                receiver.setEmail_receiver313339(rs.getString("email_receiver313339"));
                                                receiver.setAlamat_receiver313339(rs.getString("alamat_receiver313339"));
                                                receiver.setPos_receiver313339(rs.getString("pos_receiver313339"));
                                                
                                                return receiver;
                                        }    
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return receiver;
    }
    
    @Override
    public long count(){
        long count = 0;
        
        try{
            count = jdbcTemplate.queryForObject(SQL_COUNT_RECEIVER, null,Long.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }
    
    @Override
    public void insert(Receiver receiver){
        try{
            jdbcTemplate.update(SQL_INSERT_RECEIVER, new Object[]{receiver.getId_receiver313339(),receiver.getNama_receiver313339(),receiver.getTelp_receiver313339(),
                receiver.getEmail_receiver313339(),receiver.getAlamat_receiver313339(),receiver.getPos_receiver313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(Receiver receiver){
        try{
            jdbcTemplate.update(SQL_UPDATE_RECEIVER, new Object[]{receiver.getNama_receiver313339(),receiver.getTelp_receiver313339(),
                receiver.getEmail_receiver313339(),receiver.getAlamat_receiver313339(),receiver.getId_receiver313339(),receiver.getPos_receiver313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void delete(Receiver receiver){
        try{
            jdbcTemplate.update(SQL_DELETE_RECEIVER, new Object[]{receiver.getId_receiver313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
