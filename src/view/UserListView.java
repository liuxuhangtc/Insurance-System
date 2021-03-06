/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Business.InsuranceSystem;
import Business.Plan.Plan;
import Business.UserAccount.UserAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

/**
 *
 * @author xuhang
 */
public class UserListView extends javax.swing.JFrame {

	private InsuranceSystem system;
	
	private JButton deleteBtn;
	/**
	 * Creates new form CompanyManagerJPanel
	 */
	public UserListView(InsuranceSystem system) {
		JPanel jPanel = new JPanel();
		getContentPane().add(jPanel);
		this.system = system;
		initComponents(jPanel);
		initTable();
		setResizable(false);
		setBounds(470, 200, 800, 500);
		setVisible(true);
	}

	private void initTable(){
		DefaultTableModel model = (DefaultTableModel) planListTable.getModel();

		model.setRowCount(0);

		List<UserAccount> userAccounts = system.getUserAccountDirectory().getUserAccountList();

		for (int i=0;i<userAccounts.size();i++) {
			UserAccount user = userAccounts.get(i);
			Object[] row = new Object[6];
			row[0] = user.getUsername();
			row[1] = user.getPassword();
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
	private void initComponents(JPanel jPanel) {

		jScrollPane1 = new javax.swing.JScrollPane();
		planListTable = new javax.swing.JTable();
		planListTable.setFont(new Font("Arial", Font.BOLD, 14));
		
		deleteBtn = new JButton("delete");
		deleteBtn.setFont(new Font("Arial", Font.BOLD, 15));

		planListTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
					{null, null, null, null}
				},
				new String [] {
						"Username", "Password"
				}
				) {
			Class[] types = new Class [] {
					java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
			};
			boolean[] canEdit = new boolean [] {
					false, true, true, true
			};

			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});


		planListTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				planListTableMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(planListTable);
		if (planListTable.getColumnModel().getColumnCount() > 0) {
			planListTable.getColumnModel().getColumn(0).setResizable(false);
		}
		
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					int planIndex = planListTable.getSelectedRow();
					if(planIndex!=-1) {
						List<UserAccount> userAccounts = system.getUserAccountDirectory().getUserAccountList();
						userAccounts.remove(planIndex);
						initTable();
					}
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


		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanel);
		jPanel.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
										.addGap(25, 25, 25))
								.addComponent(deleteBtn,100,100,100)))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(28, 28, 28)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(28, 28, 28)
						.addComponent(deleteBtn, 50,50,50)
						.addGap(42, 42, 42)
						.addContainerGap(188, Short.MAX_VALUE))
				);
	}// </editor-fold>//GEN-END:initComponents

	private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
		// TODO add your handling code here:

		int planIndex = planListTable.getSelectedRow();
		if(planIndex >= 0) {
			String id = planListTable.getValueAt(planListTable.getSelectedRow(), 1).toString();
			Plan plan = system.getPlanDirectory().findPlanById(Integer.valueOf(id));
			plan.setStatus("approve");
			JOptionPane.showMessageDialog(null, "Plan approved!");
			DefaultTableModel model = (DefaultTableModel)planListTable.getModel();
			model.removeRow(planIndex);
		}
	}//GEN-LAST:event_approveButtonActionPerformed

	private void planListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_planListTableMouseClicked
		// TODO add your handling code here:
	}//GEN-LAST:event_planListTableMouseClicked

	private void rejectjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectjButtonActionPerformed
		// TODO add your handling code here:
		int planIndex = planListTable.getSelectedRow();
		String id = planListTable.getValueAt(planListTable.getSelectedRow(), 1).toString();
		Plan plan = system.getPlanDirectory().findPlanById(Integer.valueOf(id));
		plan.setStatus("reject");
		JOptionPane.showMessageDialog(null, "Plan reject!");
		DefaultTableModel model = (DefaultTableModel) planListTable.getModel();
		model.removeRow(planIndex);
	}//GEN-LAST:event_rejectjButtonActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_jButton1ActionPerformed


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable planListTable;
}
