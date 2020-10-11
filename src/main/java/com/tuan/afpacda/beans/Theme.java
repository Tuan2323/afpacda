/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuan.afpacda.beans;

import java.io.Serializable;

// UN BEAN EST
// sérialisable
// respecte l'encapsulation (attributs privés accessibles avec des getters/setters
// un contructeur sans paramètre (avec implantation)

/**
 *
 * @author Tuan
 */
public class Theme implements Serializable{
    
      private long idTheme;
    private String libelle;

    public Theme(){

    }

    /**
     * @return the idTheme
     */
    public long getIdTheme() {
        return idTheme;
    }

    /**
     * @param idTheme the idTheme to set
     */
    public void setIdTheme(long idTheme) {
        this.idTheme = idTheme;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
