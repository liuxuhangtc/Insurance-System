/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Plan;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author xuhang
 */
public class PlanDirectory {
    ArrayList<Plan> planList;
    ArrayList<Plan> marketPlanList;
        
    public PlanDirectory(){
        planList = new ArrayList();
        marketPlanList = new ArrayList<>();
    }
    
    public void createPlan(UserAccount userAccount, String title, int price, String offerAgeRange, String offerField, String covertimerange,String createTime,String type,String companyName){
        Plan plan = new Plan();
        plan.setTitle(title);
        plan.setPlanId((int) (1 + Math.random() * 100000));
        plan.setCovertimerange(covertimerange);
        plan.setPrice(price);
        plan.setOfferAgeRange(offerAgeRange);
        plan.setOfferField(offerField);
        plan.setStatus("pending");
        plan.setCreateUser(userAccount);
        plan.setCreateTime(createTime);
        plan.setOfferCustomerType(type);
        plan.setCompanyName(companyName);
        planList.add(plan);
    }

    public ArrayList<Plan> getPlanList() {
    	System.out.println("getPlanList=="+planList.size());
        return planList;
    }

    public void setPlanList(ArrayList<Plan> planList) {
        this.planList = planList;
    }
    
    public Plan findPlanById(int id){
        for(Plan p : planList){
            if(p.getPlanId() == id){
                return  p;
            }
        }
        return null;
    }
    
    public void addToMarket(Plan plan){
        marketPlanList.add(plan);
    }
}
