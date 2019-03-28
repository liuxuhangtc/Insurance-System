/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.InsuranceSystem;
import javax.swing.JPanel;
import userinterface.Admin.AdminJPanel;

/**
 *
 * @author xuhang
 */
public class AdminUser extends UserAccount{

	
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, InsuranceSystem business) {
        return new AdminJPanel(userProcessContainer, business);
    }

    
}
