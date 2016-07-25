/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author seccim
 */
public class Administrador {
    
    private String nickName;
    private String senha;
    
    public String getNickName(){
        return this.nickName;
    }
    public void setNickName(String nome){
        this.nickName = nome;
    }
    public String getSenha(){
        return this.senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public Administrador (String nick, String senha) {
        this.nickName = nick;
        this.senha = senha;
    }
    
    public Administrador () {
        
    }
    
}
