/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao.impl;

import com.je.spring.rest.master.model.JenisPengiriman;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.je.spring.rest.master.dao.JenisPengirimanDao;
/**
 *
 * @author Prasetyo
 */
@Repository("jenisPengirimanDao")
public class JenisPengirimanDaoImpl implements JenisPengirimanDao{
    
    private static final String SQL_INSERT_PENGIRIMAN = "INSERT INTO SERVICE (id_kurir_service313339,nama_service313339,harga_service313339,lama_hari313339,berat_barang313339) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE_PENGIRIMAN = "UPDATE SERVICE SET nama_service313339=?, harga_service313339=?, lama_hari313339=?, berat_barang313339=? WHERE id_kurir_service313339=?";
    private static final String SQL_DELETE_PENGIRIMAN = "DELETE FROM SERVICE WHERE id_kurir_service313339=?";
    private static final String SQL_SELECT_PENGIRIMAN_BY_ID = "SELECT id_kurir_service313339,nama_service313339,harga_service313339,lama_hari313339,berat_barang313339 FROM SERVICE WHERE id_kurir_service313339=?";
    private static final String SQL_SELECT_PENGIRIMAN_ALL = "SELECT id_kurir_service313339,nama_service313339,harga_service313339,lama_hari313339,berat_barang313339 FROM SERVICE";
    private static final String SQL_COUNT_PENGIRIMAN = "SELECT COUNT(*) FROM SERVICE";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<JenisPengiriman> getAll(){
        List<JenisPengiriman> jenisPengirimanList = null;
        try{
            jenisPengirimanList = jdbcTemplate.query(SQL_SELECT_PENGIRIMAN_ALL, new Object[]{},
                    new BeanPropertyRowMapper(JenisPengiriman.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return jenisPengirimanList;
    }
    
    @Override
    public JenisPengiriman getById(int id){
        JenisPengiriman jenisPengiriman = null;
        try{
            jenisPengiriman = (JenisPengiriman) jdbcTemplate.queryForObject(SQL_SELECT_PENGIRIMAN_BY_ID, new Object[]{id},
                        new RowMapper<JenisPengiriman>(){
                        @Override
                        public JenisPengiriman mapRow(ResultSet rs, int rowNum)throws SQLException{
                                                JenisPengiriman jenisPengiriman = new JenisPengiriman();
                                                jenisPengiriman.setId_kurir_service313339(rs.getInt("id_kurir_service313339"));
                                                jenisPengiriman.setNama_service313339(rs.getString("nama_service313339"));
                                                jenisPengiriman.setId_harga_service313339(rs.getInt("harga_service313339"));
                                                jenisPengiriman.setLama_hari313339(rs.getInt("lama_hari313339"));
                                                jenisPengiriman.setBerat_barang313339(rs.getInt("berat_barang313339"));
                                                
                                                return jenisPengiriman;
                                        }    
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return jenisPengiriman;
    }
    
    @Override
    public long count(){
        long count = 0;
        
        try{
            count = jdbcTemplate.queryForObject(SQL_COUNT_PENGIRIMAN, null,Long.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return count;
    }
    
    @Override
    public void insert(JenisPengiriman jenisPengiriman){
        try{
            jdbcTemplate.update(SQL_INSERT_PENGIRIMAN, new Object[]{jenisPengiriman.getId_kurir_service313339(),jenisPengiriman.getNama_service313339(),jenisPengiriman.getId_harga_service313339(),
                jenisPengiriman.getLama_hari313339(),jenisPengiriman.getBerat_barang313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(JenisPengiriman jenisPengiriman){
        try{
            jdbcTemplate.update(SQL_UPDATE_PENGIRIMAN, new Object[]{jenisPengiriman.getNama_service313339(),jenisPengiriman.getId_harga_service313339(),
                jenisPengiriman.getLama_hari313339(),jenisPengiriman.getBerat_barang313339(),jenisPengiriman.getId_kurir_service313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
     
    @Override
    public void delete(JenisPengiriman jenisPengiriman){
        try{
            jdbcTemplate.update(SQL_DELETE_PENGIRIMAN, new Object[]{jenisPengiriman.getId_kurir_service313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
