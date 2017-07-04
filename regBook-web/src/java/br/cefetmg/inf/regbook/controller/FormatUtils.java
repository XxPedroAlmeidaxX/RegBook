/*
 * FormatUtils.java
 *
 * Created on 20 de Março de 2008, 19:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.cefetmg.inf.regbook.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author root
 */
public class FormatUtils {
    
    public static void  main(String[] args){
        
        FormatUtils f = new FormatUtils();
        
        String data = "12/25/2007";
        String data1 = "12/25/2007";
        
        data = f.formatDateJdbc(data);
        
        data1 = f.formatDateUser(data1);
        
        System.out.println("Formato Banco " + data);
        
        System.out.println("Formato Usuario " + data);
        
    }
    
    public static String formatDateJdbc(String data){
        SimpleDateFormat f = new SimpleDateFormat("dd/mm/yyyy");
        Date d1 = null;
        try {
            d1 = f.parse(data);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        
        data = format.format(d1);
        
        return data;        
       
    }
    
    
    public static String formatDateUser(String data){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
        Date d1 = null;
        try {
            d1 = f.parse(data);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        
        data = format.format(d1);
        
        return data;       
        
    }
    
}
