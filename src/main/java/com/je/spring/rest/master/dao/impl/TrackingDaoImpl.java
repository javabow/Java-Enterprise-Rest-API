/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao.impl;

import com.je.spring.rest.master.dao.TrackingDao;
import com.je.spring.rest.master.model.Tracking;
import com.je.spring.rest.master.model.Sender;
import com.je.spring.rest.master.model.Receiver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Prasetyo
 */

@Repository("TrackingDao")
public class TrackingDaoImpl implements TrackingDao{
    
    private static final String SQL_INSERT_PAKET = "INSERT INTO TRACKING (id_sender313339, id_receiver313339, tujuan313339, status313339) VALUES (?,?,?,?,?)";
    
    private static final String SQL_UPDATE_PAKET = "UPDATE TRACKING SET id_sender313339=?, id_receiver313339=?, tujuan313339=?, status313339=? WHERE id_tracking313339=?";
    
    private static final String SQL_SELECT_PAKET_BY_ID = "SELECT tracking.id_tracking313339, tracking.nomor_resi313339, tracking.id_sender313339, tracking.id_receiver313339, tracking.tujuan313339, tracking.status313339,"
            + " sender.id_sender313339, sender.alamat_sender313339, sender.email_sender313339, sender.partner_sender313339, sender.nama_sender313339, sender.telp_sender313339,"
            + " receiver.id_receiver313339, receiver.alamat_receiver313339, receiver.email_receiver313339, receiver.pos_receiver313339, receiver.nama_receiver313339, receiver.telp_receiver313339"
            + " FROM tracking"
            + " INNER JOIN sender ON sender.id_sender313339 = tracking.id_sender313339"
            + " INNER JOIN receiver ON receiver.id_receiver313339 = tracking.id_receiver313339"
            + " WHERE tracking.id_tracking313339 = ?";
    
    private static final String SQL_SELECT_PAKET_ALL = "SELECT tracking.id_tracking313339, tracking.nomor_resi313339, tracking.id_sender313339, tracking.id_receiver313339, tracking.tujuan313339, tracking.status313339,"
            + " sender.id_sender313339, sender.alamat_sender313339, sender.email_sender313339, sender.partner_sender313339, sender.nama_sender313339, sender.telp_sender313339,"
            + " receiver.id_receiver313339, receiver.alamat_receiver313339, receiver.email_receiver313339, receiver.pos_receiver313339, receiver.nama_receiver313339, receiver.telp_receiver313339"
            + " FROM tracking"
            + " INNER JOIN sender ON sender.id_sender313339 = tracking.id_sender313339"
            + " INNER JOIN receiver ON receiver.id_receiver313339 = tracking.id_receiver313339";
            
    private static final String SQL_COUNT_PAKET = "SELECT COUNT(*)"
            + " FROM tracking"
            + " INNER JOIN sender ON sender.id_sender313339 = tracking.id_sender313339"
            + " INNER JOIN receiver ON receiver.id_receiver313339 = tracking.id_receiver313339";
            
            
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Tracking> getAll(){
        List<Tracking> trackingList = null;
        try{
            trackingList = jdbcTemplate.query(SQL_SELECT_PAKET_ALL, new Object[]{},
                        new RowMapper<Tracking>(){
                            @Override
                            public Tracking mapRow(ResultSet rs, int rowNum)throws SQLException{

                                Sender sender = new Sender();
                                sender.setId_sender313339(rs.getInt("id_sender313339"));
                                sender.setNama_sender313339(rs.getString("nama_sender313339"));
                                sender.setEmail_sender313339(rs.getString("email_sender313339"));
                                sender.setAlamat_sender313339(rs.getString("alamat_sender313339"));
                                sender.setTelp_sender313339(rs.getString("telp_sender313339"));
                                sender.setPartner_sender313339(rs.getString("partner_sender313339"));        
                                        
                                Receiver receiver = new Receiver();
                                receiver.setId_receiver313339(rs.getInt("id_receiver313339"));
                                receiver.setNama_receiver313339(rs.getString("nama_receiver313339"));
                                receiver.setEmail_receiver313339(rs.getString("email_receiver313339"));
                                receiver.setTelp_receiver313339(rs.getString("telp_receiver313339"));
                                receiver.setAlamat_receiver313339(rs.getString("alamat_receiver313339"));
                                receiver.setPos_receiver313339(rs.getString("pos_receiver313339"));

                                Tracking tracking = new Tracking();
                                tracking.setId_tracking313339(rs.getInt("tracking.id_tracking313339"));
                                tracking.setId_sender313339(sender);
                                tracking.setId_receiver313339(receiver);
                                tracking.setNomor_Resi313339(rs.getString("tracking.nomor_resi313339"));
                                tracking.setTujuan313339(rs.getString("tracking.tujuan313339"));
                                tracking.setStatus313339(rs.getString("tracking.status313339"));

                                return tracking;
                            }
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return trackingList;
    }
    
    @Override
    public Tracking getById(int id){
        Tracking tracking = null;
        try{
            tracking = (Tracking) jdbcTemplate.queryForObject(SQL_SELECT_PAKET_BY_ID, new Object[]{id},
                        new RowMapper<Tracking>(){
                            @Override
                            public Tracking mapRow(ResultSet rs, int rowNum)throws SQLException{

                                Sender sender = new Sender();
                                sender.setId_sender313339(rs.getInt("id_sender313339"));
                                sender.setNama_sender313339(rs.getString("nama_sender313339"));
                                sender.setEmail_sender313339(rs.getString("email_sender313339"));
                                sender.setAlamat_sender313339(rs.getString("alamat_sender313339"));
                                sender.setTelp_sender313339(rs.getString("telp_sender313339"));
                                sender.setPartner_sender313339(rs.getString("partner_sender313339"));        
                                        
                                Receiver receiver = new Receiver();
                                receiver.setId_receiver313339(rs.getInt("id_receiver313339"));
                                receiver.setNama_receiver313339(rs.getString("nama_receiver313339"));
                                receiver.setEmail_receiver313339(rs.getString("email_receiver313339"));
                                receiver.setTelp_receiver313339(rs.getString("telp_receiver313339"));
                                receiver.setAlamat_receiver313339(rs.getString("alamat_receiver313339"));
                                receiver.setPos_receiver313339(rs.getString("pos_receiver313339"));

                                Tracking tracking = new Tracking();
                                tracking.setId_tracking313339(rs.getInt("tracking.id_tracking313339"));
                                tracking.setId_sender313339(sender);
                                tracking.setId_receiver313339(receiver);
                                tracking.setNomor_Resi313339(rs.getString("tracking.nomor_resi313339"));
                                tracking.setTujuan313339(rs.getString("tracking.tujuan313339"));
                                tracking.setStatus313339(rs.getString("tracking.status313339"));

                                return tracking;
                            }
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return tracking;
    }
    
    @Override
    public long count(){
        long count = 0;
        
        try{
            count = jdbcTemplate.queryForObject(SQL_COUNT_PAKET, null,Long.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }
    
    @Override
    public void insert(Tracking tracking){
        try{
            jdbcTemplate.update(SQL_INSERT_PAKET, new Object[]{tracking.getId_sender313339().getId_sender313339(),tracking.getId_receiver313339().getId_receiver313339(),tracking.getTujuan313339(),tracking.getStatus313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(Tracking tracking){
        try{
            jdbcTemplate.update(SQL_UPDATE_PAKET, new Object[]{tracking.getId_sender313339().getId_sender313339(),tracking.getId_receiver313339().getId_receiver313339(),tracking.getTujuan313339(),tracking.getStatus313339(),tracking.getId_tracking313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
