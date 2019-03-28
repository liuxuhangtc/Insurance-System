/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Plan;

import Business.UserAccount.UserAccount;

/**
 *
 * @author xuhang
 */
public class Plan {
    int planId;
    
    String title="";
    
    int price;
    
    private String offerCustomerType ;
    
    String offerField="";
    
    String offerAgeRange="";
    
    String status = "pending"; 
    
    UserAccount createUser;//Not Use
    
    private String createTime;
    
    private String covertimerange;
    
    private String userName;
    
    private int mark;
    
    private int count;
    
    private String companyName;
    
    public String getOfferCustomerType() {
		return offerCustomerType;
	}

	public void setOfferCustomerType(String offerCustomerType) {
		this.offerCustomerType = offerCustomerType;
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

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCovertimerange() {
		return covertimerange;
	}

	public void setCovertimerange(String covertimerange) {
		this.covertimerange = covertimerange;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPlanId() {
        return planId;
    }
        
    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getOfferField() {
        return offerField;
    }

    public void setOfferField(String offerField) {
        this.offerField = offerField;
    }

    public String getOfferAgeRange() {
        return offerAgeRange;
    }

    public void setOfferAgeRange(String offerAgeRange) {
        this.offerAgeRange = offerAgeRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserAccount getCreateUser() {
        return createUser;
    }

    public void setCreateUser(UserAccount createUser) {
        this.createUser = createUser;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }  
    
    
}