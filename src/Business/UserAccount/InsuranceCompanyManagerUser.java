/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.InsuranceSystem;
import javax.swing.JPanel;
import userinterface.InsuranceCompany.CompanyManagerJPanel;

/**
 *
 * @author xuhang
 */
public class InsuranceCompanyManagerUser extends UserAccount{

	private String ManagerName;
	private String  ManagerCompany;
	

	public String getManagerName() {
		return ManagerName;
	}

	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}


	public String getManagerCompany() {
		return ManagerCompany;
	}


	public void setManagerCompany(String managerCompany) {
		ManagerCompany = managerCompany;
	}


	@Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, InsuranceSystem business) {
        return new CompanyManagerJPanel(userProcessContainer,business); //To change body of generated methods, choose Tools | Templates.
    }
    
}
