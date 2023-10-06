/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import java.sql.ResultSet;

/**
 *
 * @author mileny.1948
 */
public class DaoPais extends BancoDeDadosMySql{
    private String sql2;
    
    public Boolean inserir(int id, String nome){
        try{
            sql2 = "INSERT INTO PAIS (ID, NOME) VALUES (?, ?)";
            
             setStatement(getConexao().prepareStatement(sql2));
             
             getStatement().setInt(1, id);
             getStatement().setString(2, nome);
            
             getStatement().executeUpdate();
             
             return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, String novoNome){
        try{
             sql2 = "UPDATE PAIS SET NOME = ?, WHERE ID = ?";
             
            setStatement(getConexao().prepareStatement(sql2));
             
            getStatement().setInt(2, id);
            getStatement().setString(1, novoNome);
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql2 = "DELETE FROM CATEGORIA WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql2));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate(sql2);
             
            return true;
    }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }   
    
    public ResultSet listarTodos(){
        try{
            sql2 = "SELECT ID, NOME";
            
            setStatement(getConexao().prepareStatement(sql2));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
         System.out.println(e.getMessage());
        }
        
        return getResultado();
    }    
    
     public ResultSet listarPorId(int id){
        try{
            sql2 = "SELECT ID, NOME WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql2));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
     
     public ResultSet listarPorNome(String nome){
        try{
            sql2 = "SELECT ID, NOME WHERE NOME LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql2));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
     
      public int buscarProximoId(){
        int id = -1;
        
        try{    
            sql2 = "SELECT MAX(ID)";
            
            setStatement(getConexao().prepareStatement(sql2));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
}
