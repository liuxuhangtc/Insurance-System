/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerApply.folder;

import java.util.ArrayList;

/**
 *
 * @author xuhang
 */
public class CustomerPlanDirectory {
    ArrayList<CustomerPlan> customerPlans;
    
    public CustomerPlanDirectory(){
        customerPlans = new ArrayList<>();
    }
    
    public void addCustomerPlan(CustomerPlan customerPlan){
        customerPlan.setId((int) (1 + Math.random() * 100000));
        customerPlans.add(customerPlan);
    }

    public ArrayList<CustomerPlan> getCustomerPlans() {
        return customerPlans;
    }

    public void setCustomerPlans(ArrayList<CustomerPlan> customerPlans) {
        this.customerPlans = customerPlans;
    }
    
    public CustomerPlan findById(int id){
        for(CustomerPlan cp : customerPlans){
            if(cp.getId() == id){
                return cp;
            }
        }
        return null;
    }
}
