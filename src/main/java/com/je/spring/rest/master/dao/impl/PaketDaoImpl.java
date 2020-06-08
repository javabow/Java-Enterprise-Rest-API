/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.dao.impl;

import com.je.spring.rest.master.dao.PaketDao;
import com.je.spring.rest.master.model.Paket;
import com.je.spring.rest.master.model.JenisPengiriman;
import com.je.spring.rest.master.model.Pengirim;
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

@Repository("paketDao")
public class PaketDaoImpl implements PaketDao{
    
    private static final String SQL_INSERT_PAKET = "INSERT INTO PAKET (service313339,nip_pengirim313339,nomor_resi313339,order_id313339,alamatpaket313339,penerima313339) VALUES (?,?,?,?,?,?)";
    
    private static final String SQL_SELECT_PAKET_BY_ID = "SELECT paket.id_paket313339, paket.nomor_resi313339, paket.order_id313339, paket.alamatpaket313339, paket.penerima313339,"
            + " service.id_kurir_service313339, service.nama_service313339, service.harga_service313339, service.lama_hari313339,"
            + " pengirim.nip_pengirim313339, pengirim.nama_pengirim313339, pengirim.telp_pengirim313339, pengirim.email_pengirim313339, pengirim.alamat_pengirim313339"
            + " FROM paket"
            + " INNER JOIN service ON service.id_kurir_service313339 = paket.service313339"
            + " INNER JOIN pengirim ON pengirim.nip_pengirim313339 = paket.nip_pengirim313339"
            + " WHERE paket.id_paket313339 = ?";
    
    private static final String SQL_SELECT_PAKET_ALL = "SELECT paket.id_paket313339, paket.nomor_resi313339, paket.order_id313339, paket.alamatpaket313339, paket.penerima313339,"
            + " service.id_kurir_service313339, service.nama_service313339, service.harga_service313339, service.lama_hari313339,"
            + " pengirim.nip_pengirim313339, pengirim.nama_pengirim313339, pengirim.telp_pengirim313339, pengirim.email_pengirim313339, pengirim.alamat_pengirim313339"
            + " FROM paket"
            + " INNER JOIN service ON service.id_kurir_service313339 = paket.service313339"
            + " INNER JOIN pengirim ON pengirim.nip_pengirim313339 = paket.nip_pengirim313339";
            
    private static final String SQL_COUNT_PAKET = "SELECT COUNT(*)"
            + " FROM paket"
            + " INNER JOIN service ON service.id_kurir_service313339 = paket.service313339"
            + " INNER JOIN pengirim ON pengirim.nip_pengirim313339 = paket.nip_pengirim313339";
            
            
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Paket> getAll(){
        List<Paket> paketList = null;
        try{
            paketList = jdbcTemplate.query(SQL_SELECT_PAKET_ALL, new Object[]{},
                        new RowMapper<Paket>(){
                            @Override
                            public Paket mapRow(ResultSet rs, int rowNum)throws SQLException{

                                JenisPengiriman jenisPengiriman = new JenisPengiriman();
                                jenisPengiriman.setId_kurir_service313339(rs.getInt("id_kurir_service313339"));
                                jenisPengiriman.setNama_service313339(rs.getString("nama_service313339"));
                                jenisPengiriman.setId_harga_service313339(rs.getInt("harga_service313339"));
                                jenisPengiriman.setLama_hari313339(rs.getInt("lama_hari313339"));

                                Pengirim pengirim = new Pengirim();
                                pengirim.setNip_pengirim313339(rs.getInt("nip_pengirim313339"));
                                pengirim.setNama_pengirim313339(rs.getString("nama_pengirim313339"));
                                pengirim.setTelp_pengirim313339(rs.getString("telp_pengirim313339"));
                                pengirim.setEmail_pengirim313339(rs.getString("email_pengirim313339"));
                                pengirim.setAlamat_pengirim313339(rs.getString("alamat_pengirim313339"));

                                Paket paket = new Paket();
                                paket.setId_paket313339(rs.getInt("paket.id_paket313339"));
                                paket.setId_service313339(jenisPengiriman);
                                paket.setId_pengirim313339(pengirim);
                                paket.setResi313339(rs.getString("paket.nomor_resi313339"));
                                paket.setId_order313339(rs.getInt("paket.order_id313339"));
                                paket.setAlamat313339(rs.getString("paket.alamatpaket313339"));
                                paket.setPenerima313339(rs.getString("paket.penerima313339"));

                                return paket;
                            }
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return paketList;
    }
    
    @Override
    public Paket getById(int id){
        Paket paket = null;
        try{
            paket = (Paket) jdbcTemplate.queryForObject(SQL_SELECT_PAKET_BY_ID, new Object[]{id},
                        new RowMapper<Paket>(){
                            @Override
                            public Paket mapRow(ResultSet rs, int rowNum)throws SQLException{

                                JenisPengiriman jenisPengiriman = new JenisPengiriman();
                                jenisPengiriman.setId_kurir_service313339(rs.getInt("id_kurir_service313339"));
                                jenisPengiriman.setNama_service313339(rs.getString("nama_service313339"));
                                jenisPengiriman.setId_harga_service313339(rs.getInt("harga_service313339"));
                                jenisPengiriman.setLama_hari313339(rs.getInt("lama_hari313339"));

                                Pengirim pengirim = new Pengirim();
                                pengirim.setNip_pengirim313339(rs.getInt("nip_pengirim313339"));
                                pengirim.setNama_pengirim313339(rs.getString("nama_pengirim313339"));
                                pengirim.setTelp_pengirim313339(rs.getString("telp_pengirim313339"));
                                pengirim.setEmail_pengirim313339(rs.getString("email_pengirim313339"));
                                pengirim.setAlamat_pengirim313339(rs.getString("alamat_pengirim313339"));

                                Paket paket = new Paket();
                                paket.setId_paket313339(rs.getInt("paket.id_paket313339"));
                                paket.setId_service313339(jenisPengiriman);
                                paket.setId_pengirim313339(pengirim);
                                paket.setResi313339(rs.getString("paket.nomor_resi313339"));
                                paket.setId_order313339(rs.getInt("paket.order_id313339"));
                                paket.setAlamat313339(rs.getString("paket.alamatpaket313339"));
                                paket.setPenerima313339(rs.getString("paket.penerima313339"));

                                return paket;
                            }
                        });
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return paket;
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
    public void insert(Paket paket){
        try{
            jdbcTemplate.update(SQL_INSERT_PAKET, new Object[]{paket.getId_service313339().getId_kurir_service313339(),paket.getId_pengirim313339().getNip_pengirim313339(),paket.getResi313339(),paket.getId_order313339(),paket.getAlamat313339(),paket.getPenerima313339()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
