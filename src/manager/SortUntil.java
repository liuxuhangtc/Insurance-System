package manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Business.InsuranceSystem;
import Business.Plan.Plan;
import Business.UserAccount.CustomerUser;
import Business.UserAccount.UserAccount;
import CustomerApply.folder.CustomerPlan;

public class SortUntil {

	public static List<Plan> sortPlan(InsuranceSystem system) {
		List<Plan> plans=system.getPlanDirectory().getPlanList();

		List<CustomerPlan> customerPlans = system.getCustomerPlanDirectory().getCustomerPlans();

		for(CustomerPlan customerPlan:customerPlans) {
			for(Plan plan:plans) {
				if(customerPlan.getPlan().getPlanId()==plan.getPlanId()) {
					plan.add();
					break;
				}
			}
		}

		Collections.sort(plans, new Comparator<Plan>() {

			@Override
			public int compare(Plan o1, Plan o2) {

				return o2.getCount()-o1.getCount();
			}
		});
		return plans;
	}

	public static List<CustomerUser> sortCustomUser(InsuranceSystem system) {
		ArrayList<UserAccount> coCustomerUsers = system.getUserAccountDirectory().getUserAccountList();
		List<CustomerPlan> customerPlans = system.getCustomerPlanDirectory().getCustomerPlans();

		for(CustomerPlan customerPlan:customerPlans) {
			for(UserAccount userAccount:coCustomerUsers) {
				if(customerPlan.getPlan().getCreateUser().getUsername()==userAccount.getUsername()) {
					userAccount.add();
					break;
				}
			}
		}
		List<CustomerUser> customerUsers = new ArrayList<>();
	    for(int i=0;i<coCustomerUsers.size();i++) {
	    	UserAccount userAccount = coCustomerUsers.get(i);
	    	if(userAccount instanceof CustomerUser) {
	    		customerUsers.add((CustomerUser)userAccount);
	    	}
	    }

		Collections.sort(customerUsers, new Comparator<UserAccount>() {

			@Override
			public int compare(UserAccount o1, UserAccount o2) {

				return o2.getCount()-o1.getCount();
			}
		});
		return customerUsers;
	}
	

}
