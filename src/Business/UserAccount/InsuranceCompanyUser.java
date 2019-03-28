/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.InsuranceSystem;
import javax.swing.JPanel;
import userinterface.InsuranceCompany.InsuranceCompanyJPanel;

/**
 *
 * @author xuhang
 */
public class InsuranceCompanyUser extends UserAccount{

	private String PlannerName, PlannerCompany;
	
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, InsuranceSystem business) {
        return new InsuranceCompanyJPanel(userProcessContainer, business); //To change body of generated methods, choose Tools | Templates.
    }

	public String getPlannerName() {
		return PlannerName;
	}

	public void setPlannerName(String plannerName) {
		PlannerName = plannerName;
	}


	public String getPlannerCompany() {
		return PlannerCompany;
	}



	public void setPlannerCompany(String plannerCompany) {
		PlannerCompany = plannerCompany;
	}
    
    
    
}
