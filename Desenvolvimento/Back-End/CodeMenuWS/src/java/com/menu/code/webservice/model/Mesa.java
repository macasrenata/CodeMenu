/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.model;

import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author anderson
 */

public class Mesa {
    
    private Long id;
    private String qrcode;
    @ManyToOne
    @PrimaryKeyJoinColumn
    private Estabelecimento estabelecimento;
    
    public Mesa(long id, String qrcode, Estabelecimento estabelecimento) {
	this.id = id;
	this.qrcode = qrcode;
	this.estabelecimento = estabelecimento;	
	}

    public Mesa() {
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
    
    
}