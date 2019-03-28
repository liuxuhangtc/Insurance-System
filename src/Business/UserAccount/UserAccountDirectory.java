/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import java.util.ArrayList;

/**
 *
 * @author xuhang
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;


    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
    public UserAccount findUserByUsername(String username){
        for(UserAccount ua : userAccountList){
            if(ua.getUsername().equals(username)){
                return ua;
            }
        }
        
        return null;
    }
    
    public void update(UserAccount userAccount){
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(userAccount.getUsername())) {
                ua = userAccount;
                return;
            }
        }
    }
    
    public InsuranceCompanyUser createInsuranceCompanyUser(String username, String password,String PlannerName,String PlannerCompany){
        InsuranceCompanyUser userAccount = new InsuranceCompanyUser();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setPlannerCompany(PlannerCompany);
        userAccount.setPlannerName(PlannerName);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    
    public InsuranceCompanyManagerUser createCompanyManagerUser(String username, String password,String ManagerName,String ManagerCompany) {
        InsuranceCompanyManagerUser userAccount = new InsuranceCompanyManagerUser();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setManagerName(ManagerName);
        userAccount.setManagerCompany(ManagerCompany);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public CustomerUser createCustomerUser(String username, String password, String information,String EmailAddress,String type){
        CustomerUser userAccount = new CustomerUser();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setInformation(information);
        userAccount.setEmailAddress(EmailAddress);
        userAccount.setType(type);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public AdminUser createAdminUser(String username, String password) {
        AdminUser userAccount = new AdminUser();
        userAccount.setUsername(username);
        userAccount.setPassword(password);

        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public GovernmentUser createGovernmentUser(String username, String password, String branchName
            , String locationGov, String officeName, String telephoneNum,String BranchLocation,String GovernmentManagerName){
        GovernmentUser userAccount = new GovernmentUser();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setBranchName(branchName);
        userAccount.setLocationGov(locationGov);
        userAccount.setOfficeName(officeName);
        userAccount.setTelephoneNum(telephoneNum);
        userAccount.setBranchLocation(BranchLocation);
        userAccount.setGovernmentManagerName(GovernmentManagerName);
        userAccountList.add(userAccount);
        return userAccount;
    }
}
