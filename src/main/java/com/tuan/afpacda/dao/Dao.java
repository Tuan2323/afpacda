/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuan.afpacda.dao;
import java.util.List;

/**
 *
 * @author Tuan
 */

public interface Dao<T> {

    List<T> liste();
    boolean insert(T obj);
    T find(Long id);
    boolean update(T obj);
    void delete(Long id);
        long count();

}