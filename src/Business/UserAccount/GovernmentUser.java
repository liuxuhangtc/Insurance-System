/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.InsuranceSystem;

import javax.swing.*;
import userinterface.Government.GovernmentJPanel;

/**
 *
 * @author xuhang
 */
public class GovernmentUser extends UserAccount{
    
    String officeName;
    
    String branchName;
    
    String telephoneNum;
    
    String locationGov;
     
    private String BranchLocation;
    
    private String GovernmentManagerName;
    
    public String getBranchLocation() {
		return BranchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		BranchLocation = branchLocation;
	}

	public String getGovernmentManagerName() {
		return GovernmentManagerName;
	}

	public void setGovernmentManagerName(String governmentManagerName) {
		GovernmentManagerName = governmentManagerName;
	}

	public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getLocationGov() {
        return locationGov;
    }

    public void setLocationGov(String locationGov) {
        this.locationGov = locationGov;
    }


    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, InsuranceSystem business) {
//        return new AdminWorkAreaJPanel(userProcessContainer);
        return new GovernmentJPanel(business);
    }
}
