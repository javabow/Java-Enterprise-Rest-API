/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao.impl;

import com.je.spring.rest.master.model.TrackPaket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.je.spring.rest.master.dao.TrackPaketDao;
/**
 *
 * @author User
 */
@Repository("trackpaketDao")
public class TrackPaketDaoImpl implements TrackPaketDao{
    private static final String SQL_INSERT_TRACKPAKET = "INSERT INTO TRACK_PAKET (track_id313339,id_paket313339,nomor_resi313339,keterangan313339,tujuan_kota313339) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE_TRACKPAKET = "UPDATE TRACK_PAKET SET id_paket313339=?, nomor_resi313339=?, keterangan313339=?, tujuan_kota313339=? WHERE track_id313339=?";
    private static final String SQL_DELETE_TRACKPAKET = "DELETE FROM TRACK_PAKET WHERE track_id313339=?";
    private static final String SQL_SELECT_TRACKPAKET_BY_ID = "SELECT track_id313339,id_paket313339,nomor_resi313339,keterangan313339,tujuan_kota313339 FROM TRACK_PAKET WHERE track_id313339=?";
    private static final String SQL_SELECT_TRACKPAKET_ALL = "SELECT track_id313339,id_paket313339,nomor_resi313339,keterangan313339,tujuan_kota313339 FROM TRACK_PAKET";
    private static final String SQL_COUNT_TRACKPAKET = "SELECT COUNT(*) FROM TRACK_PAKET";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<TrackPaket> getAll(){
        List<TrackPaket> trackpaketList = null;
        try{
            trackpaketList = jdbcTemplate.query(SQL_SELECT_TRACKPAKET_ALL, new Object[]{},
                    new BeanPropertyRowMapper(TrackPaket.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return trackpaketList;
    }
    
    @Override
    public TrackPaket getById(int id){
        TrackPaket trackpaket = null;
        try{
            trackpaket = (TrackPaket) jdbcTemplate.queryForObject(SQL_SELECT_TRACKPAKET_BY_ID, new Object[]{id},
                        new RowMapper<TrackPaket>(){
                        @Override
                        public TrackPaket mapRow(ResultSet rs, int rowNum)throws SQLException{
                                                TrackPaket trackpaket = new TrackPaket();
                                                trackpaket.setTrack_id313339(rs.getInt("track_id313339"));
                                                trackpaket.setId_paket313339(rs.getString("id_paket313339"));
                                                trackpaket.setNomor_resi313339(rs.getString("nomor_resi313339"));
                                                trackpaket.setKeterangan313339(rs.getString("Keterangan313339"));
                                                trackpaket.setTujuan_kota313339(rs.getString("tujuan_kota313339"));
                                                
                                                return trackpaket;
                                        }    
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return trackpaket;
    }
    
    @Override
    public long count(){
        long count = 0;
        
        try{
            count = jdbcTemplate.queryForObject(SQL_COUNT_TRACKPAKET, null,Long.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }
    
    @Override
    public void insert(TrackPaket trackpaket){
        try{
            jdbcTemplate.update(SQL_INSERT_TRACKPAKET, new Object[]{trackpaket.getTrack_id313339(),trackpaket.getId_paket313339(),trackpaket.getNomor_resi313339(),
                trackpaket.getKeterangan313339(),trackpaket.getTujuan_kota313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
     
    @Override
    public void update(TrackPaket trackpaket){
        try{
            jdbcTemplate.update(SQL_UPDATE_TRACKPAKET, new Object[]{trackpaket.getId_paket313339(),trackpaket.getNomor_resi313339(),
                trackpaket.getKeterangan313339(),trackpaket.getTujuan_kota313339(),trackpaket.getTrack_id313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void delete(TrackPaket trackpaket){
        try{
            jdbcTemplate.update(SQL_DELETE_TRACKPAKET, new Object[]{trackpaket.getTrack_id313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
