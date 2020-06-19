/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.je.spring.rest.master.model;

/**
 *
 * @author Prasetyo
 */
public class Tracking {
    
    private int id_tracking313339;
    private String nomor_resi313339;
    private Sender id_sender313339;
    private Receiver id_receiver313339;
    private Status id_status313339;
    private String tujuan313339;
    private String status313339;

    public Status getId_status313339() {
        return id_status313339;
    }

    public void setId_status313339(Status id_status313339) {
        this.id_status313339 = id_status313339;
    }
    
    public int getId_tracking313339() {
        return id_tracking313339;
    }

    public void setId_tracking313339(int id_tracking313339) {
        this.id_tracking313339 = id_tracking313339;
    }

    public Receiver getId_receiver313339() {
        return id_receiver313339;
    }

    public void setId_receiver313339(Receiver id_receiver313339) {
        this.id_receiver313339 = id_receiver313339;
    }

    public Sender getId_sender313339() {
        return id_sender313339;
    }

    public void setId_sender313339(Sender id_sender313339) {
        this.id_sender313339 = id_sender313339;
    }

    public String getNomor_Resi313339() {
        return nomor_resi313339;
    }

    public void setNomor_Resi313339(String resi313339) {
        this.nomor_resi313339 = resi313339;
    }

    public String getTujuan313339() {
        return tujuan313339;
    }

    public void setTujuan313339(String alamat313339) {
        this.tujuan313339 = alamat313339;
    }

    public String getStatus313339() {
        return status313339;
    }

    public void setStatus313339(String penerima313339) {
        this.status313339 = penerima313339;
    }
    
}
