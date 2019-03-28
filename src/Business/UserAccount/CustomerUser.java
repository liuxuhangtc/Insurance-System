/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.InsuranceSystem;

import javax.swing.*;
import userinterface.Customer.CustomerMainJPanel;

/**
 *
 * @author xuhang
 */
public class CustomerUser extends UserAccount{
    
    String information;
    
    int age;
    
    private String Careerfield;
    
    private String EmailAddress;
    
    private String type;
    
    private String phoneNumbe;
    
    private String SSN;
    
    private String documentId;
    

    public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getCareerfield() {
		return Careerfield;
	}

	public void setCareerfield(String careerfield) {
		Careerfield = careerfield;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getType() {
		return type;
	}

	public void setType(String type1) {
		this.type = type1;
	}

	public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumbe() {
        return phoneNumbe;
    }

    public void setPhoneNumbe(String phoneNumbe) {
        this.phoneNumbe = phoneNumbe;
    }
    
    


    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, InsuranceSystem business) {
        return new CustomerMainJPanel(userProcessContainer, business);
    }
}
