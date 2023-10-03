/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import com.mysql.cj.xdevapi.Result;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author mileny.1948
 */
public class DaoCategoria extends BancoDeDadosMySql{
    
    private String sql;
    
    public Boolean inserir(int id, String nome, String descricao){
        try{
            sql = "INSERIR INTO CATEGORIA (ID, NOME, DESCRICAO) VALUES (?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            getStatement().setString(3, descricao);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet listarTodos(){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CATEGORIA";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CATEGORIA WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CATEGORIA WHERE NOME LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorDescricao(String descricao){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CATEGORIA WHERE DESCRICAO LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, descricao + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT MAX(ID) + 1 FROM CATEGORIA";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
}
