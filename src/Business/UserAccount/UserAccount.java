/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.InsuranceSystem;


import javax.swing.*;

/**
 *
 * @author xuhang
 */
public abstract class UserAccount {
    
    private String username;
    private String password;
    
    private int count;

    public UserAccount() {
        
    }
    
    public void add() {
    	this.count++;
    }

    public int getCount() {
	return count;
    }


    public void setCount(int count) {
	this.count = count;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    
    
    @Override
    public String toString() {
        return username;
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, InsuranceSystem business);
    
    
    
}