/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuan.afpacda.dao;

import com.tuan.afpacda.beans.Theme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Tuan
 */
public class ThemeDao implements Dao{
    
    private Connection cnx;
    
//-----------------------------------------------------------------------
//----------------------------------------------------------------------- 
    public ThemeDao(Connection con) {
        
        // Aggrégation !
	cnx = con;	
    }
    

//-----------------------------------------------------------------------
//-----------------------------------------------------------------------
    @Override
    public List<Theme> liste() {
        
        List<Theme> listeThemes = new ArrayList();
        
        String sql = "SELECT * FROM themes";
        
        // Avec les 'try-with-ressources'
        // Les classes qui implantent l'interface autoCloseable sont acceptées comme ressources
        try(PreparedStatement ps = cnx.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	){
	
	while(rs.next()) {
		Theme obj = new Theme();
                obj.setIdTheme(rs.getLong("id_theme")); // nom de la colonne
                obj.setLibelle(rs.getString("libelle"));				
		listeThemes.add(obj);		
	}
	
        } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
        
        return listeThemes;
    }

    @Override
    public boolean insert(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

