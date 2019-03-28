package Business;

import Business.Plan.PlanDirectory;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import CustomerApply.folder.CustomerPlanDirectory;

public class InsuranceSystem {
    
    private static InsuranceSystem business;

    private UserAccountDirectory userAccountDirectory;
    
    private UserAccount currentUser;
    
    private PlanDirectory planDirectory;
    
    private CustomerPlanDirectory customerPlanDirectory;

    public static InsuranceSystem getInstance(){
        if(business==null){
            business=new InsuranceSystem();
            business.setUserAccountDirectory(new UserAccountDirectory());
            business.setPlanDirectory(new PlanDirectory());
            business.setCustomerPlanDirectory(new CustomerPlanDirectory());
        }
        return business;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public PlanDirectory getPlanDirectory() {
        return planDirectory;
    }

    public void setPlanDirectory(PlanDirectory planDirectory) {
        this.planDirectory = planDirectory;
    }

    public UserAccount getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserAccount currentUser) {
        this.currentUser = currentUser;
    }

    public CustomerPlanDirectory getCustomerPlanDirectory() {
        return customerPlanDirectory;
    }

    public void setCustomerPlanDirectory(CustomerPlanDirectory customerPlanDirectory) {
        this.customerPlanDirectory = customerPlanDirectory;
    }
    
    
}
