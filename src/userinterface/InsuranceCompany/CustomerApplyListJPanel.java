/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InsuranceCompany;

import Business.InsuranceSystem;
import Business.Plan.Plan;
import Business.UserAccount.CustomerUser;
import Business.UserAccount.InsuranceCompanyManagerUser;
import CustomerApply.folder.CustomerPlan;
import view.DetailView;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author xuhang
 */
public class CustomerApplyListJPanel extends javax.swing.JPanel {
	private InsuranceSystem system;

	private Container container;

	/**
	 * Creates new form CustomerApplyListJPanel
	 */
	public CustomerApplyListJPanel(Container container, InsuranceSystem system) {
		this.container = container;
		this.system = system;
		initComponents();
                ArrayList<CustomerPlan> plans = system.getCustomerPlanDirectory().getCustomerPlans();
                ArrayList<CustomerPlan> results = new ArrayList<>();
                String managerCompany = ((InsuranceCompanyManagerUser)system.getCurrentUser()).getManagerCompany();
                for(CustomerPlan plan : plans) {
                    if(plan.getPlan().getCompanyName() != null && plan.getPlan().getCompanyName().equals(managerCompany))
                        results.add(plan);
                }
		initTable(results);

	}

	private void initTable(ArrayList<CustomerPlan> customerPlans) {
		DefaultTableModel model = (DefaultTableModel) planListTable.getModel();

		model.setRowCount(0);

		for (CustomerPlan customerPlan : customerPlans) {
			if (!customerPlan.getStatus().equals("pending")) {
				continue;
			}
			Plan plan = customerPlan.getPlan();
			CustomerUser user = customerPlan.getCustomer();
			Object[] row = new Object[5];
			row[0] = customerPlan.getId();
			row[1] = plan.getTitle();
			row[2] = plan.getPlanId();
			row[3] = user.getUsername();
			row[4] = user.getInformation();

			model.addRow(row);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		
		ImageIcon customerIcon = new ImageIcon("./img/customer.png");

		jScrollPane1 = new javax.swing.JScrollPane();
		planListTable = new javax.swing.JTable();
		planListTable.setFont(new Font("Arial", Font.BOLD, 14));
		backJButton = new javax.swing.JButton();
		backJButton.setFont(new Font("Arial", Font.BOLD, 14));
		approveBtn = new javax.swing.JButton();
		approveBtn.setFont(new Font("Arial", Font.BOLD, 14));
		rejectBtn = new javax.swing.JButton();
		rejectBtn.setFont(new Font("Arial", Font.BOLD, 14));
		detailButton = new JButton(customerIcon);
		detailButton.setText("Check Customer Info");
		detailButton.setFont(new Font("Arial", Font.BOLD, 14));
		planListTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null}
				},
				new String [] {
						"id", "Insurance Title", "Plan id", "username", "Information"
				}
				) {
			boolean[] canEdit = new boolean [] {
					false, false, false, false, false
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		jScrollPane1.setViewportView(planListTable);

		detailButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				int planIndex = planListTable.getSelectedRow();
				CustomerPlan customerPlan=system.getCustomerPlanDirectory().getCustomerPlans().get(planIndex);
				DetailView detailView = new DetailView(customerPlan.getCustomer());
				}
				catch (Exception error) {
			         /* This is a generic Exception handler which means it can handle
			          * all the exceptions. This will execute if the exception is not
			          * handled by previous catch blocks.
			          */
					JOptionPane.showMessageDialog(null, "Please select a row");
			      }
			}
		});

		backJButton.setText("back");
		backJButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backJButtonActionPerformed(evt);
			}
		});

		approveBtn.setText("Approve");
		approveBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				approveBtnActionPerformed(evt);
			}
		});

		rejectBtn.setText("Reject");
		rejectBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rejectBtnActionPerformed(evt);
			}
		});
		
		JLabel lblCustomerApplyList = new JLabel("Customer Apply List");
		lblCustomerApplyList.setFont(new Font("Arial", Font.BOLD, 12));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(backJButton)
							.addPreferredGap(ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
							.addComponent(detailButton, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(approveBtn)
							.addGap(18)
							.addComponent(rejectBtn))
						.addComponent(jScrollPane1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
						.addComponent(lblCustomerApplyList, Alignment.TRAILING))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(83)
					.addComponent(lblCustomerApplyList)
					.addGap(18)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(backJButton)
						.addComponent(rejectBtn)
						.addComponent(approveBtn)
						.addComponent(detailButton))
					.addContainerGap(194, Short.MAX_VALUE))
		);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
		// TODO add your handling code here:
		container.removeAll();
		container.add(new CompanyManagerJPanel(container, system));
		container.revalidate();
	}//GEN-LAST:event_backJButtonActionPerformed

	private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed
		// TODO add your handling code here:
		int planIndex = planListTable.getSelectedRow();
                if(planIndex < 0){
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                    return;
                }
		String id = planListTable.getValueAt(planListTable.getSelectedRow(), 0).toString();
		CustomerPlan customerPlan = system.getCustomerPlanDirectory().findById(Integer.valueOf(id));
		customerPlan.setStatus("approve");
		JOptionPane.showMessageDialog(null, "Application approved!");
		DefaultTableModel model = (DefaultTableModel) planListTable.getModel();
		model.removeRow(planIndex);
	}//GEN-LAST:event_approveBtnActionPerformed

	private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
		// TODO add your handling code here:
		int planIndex = planListTable.getSelectedRow();
                if(planIndex < 0){
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                    return;
                }
		String id = planListTable.getValueAt(planListTable.getSelectedRow(), 0).toString();
		CustomerPlan customerPlan = system.getCustomerPlanDirectory().findById(Integer.valueOf(id));
		customerPlan.setStatus("reject");
		JOptionPane.showMessageDialog(null, "Application rejected!");
		DefaultTableModel model = (DefaultTableModel) planListTable.getModel();
		model.removeRow(planIndex);
	}//GEN-LAST:event_rejectBtnActionPerformed


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton approveBtn;
	private javax.swing.JButton backJButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable planListTable;
	private javax.swing.JButton rejectBtn,detailButton;
}