package Business;

import Business.UserAccount.UserAccountDirectory;

/**
 * @author xuhang
 */
public class ConfigureASystem {
    
    public static InsuranceSystem configure(){
        
        InsuranceSystem system = InsuranceSystem.getInstance();
        
        UserAccountDirectory uad = system.getUserAccountDirectory();
        
        //create user account
        uad.createAdminUser("admin", "admin");
        
        
        uad.createCustomerUser("cus1", "cus1", "info","","individual");
        uad.createCustomerUser("cus2", "cus2", "info","","enterprise");
        uad.createCustomerUser("cus3", "cus3", "info","","ALL");
        uad.createCustomerUser("cus4", "cus4", "info","","individual");
        uad.createCustomerUser("cus5", "cus5", "info","","enterprise");
        uad.createCustomerUser("cus6", "cus6", "info","","individual");
        uad.createCustomerUser("cus7", "cus7", "info","","individual");
        uad.createCustomerUser("cus8", "cus8", "info","","enterprise");
        uad.createCustomerUser("cus9", "cus9", "info","","ALL");
        uad.createCustomerUser("cus10", "cus10", "info","","ALL");
        
        uad.createCompanyManagerUser("comp1", "comp1","Allen","AAA");
        uad.createCompanyManagerUser("comp2", "comp2","Bob","BBB");
        uad.createCompanyManagerUser("comp3", "comp3","Charlie","CCC");
        
        uad.createInsuranceCompanyUser("planA1", "planA1","David","AAA");
        uad.createInsuranceCompanyUser("planA2", "planA2","Emily","AAA");
        
        uad.createInsuranceCompanyUser("planB1", "planB1","Ford","BBB");
        uad.createInsuranceCompanyUser("planB2", "planB2","Gavin","BBB");
        
        uad.createInsuranceCompanyUser("planC1", "planC1","Hillyard","CCC");
        uad.createInsuranceCompanyUser("planC2", "planC2","Ivan","CCC");
        
        uad.createGovernmentUser("gov", "gov", "gov branch", "new york", "office name", "0210476989","","");
        
        return system;
    }
    
}
