/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Admin;

import Business.InsuranceSystem;
import Business.UserAccount.CustomerUser;
import Business.UserAccount.GovernmentUser;
import Business.UserAccount.InsuranceCompanyManagerUser;
import Business.UserAccount.InsuranceCompanyUser;
import Business.UserAccount.UserAccount;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;

/**
 *
 * @author xuhang
 */
public class CreateUserJPanel extends javax.swing.JPanel {
	private InsuranceSystem system;
	private Container container;
	private String type;
	private String label3Text;
	private String label4Text;
	private UserAccount user;

	private JButton back;
	/**
	 * Creates new form CreateUserJPanel
	 */
	public CreateUserJPanel(Container container, InsuranceSystem system, String type) {
		this.container = container;
		this.type = type;
		this.system = system;
		initLabelText(type);
		initComponents();
	}

	private void initLabelText(String type) {
		if(type.equals("gov")) {
			user = new GovernmentUser();
			label3Text = "Branch Location:";
			label4Text = "Government Manager Name:";
		}else if(type.equals("customer")) {
			user = new CustomerUser();
			label3Text = "Email Address:";
			label4Text = "Customer Type:";
		}else if(type.equals("planner")) {
			user = new InsuranceCompanyUser();
			label3Text = "Planner Name:";
			label4Text = "Planner Company:";
		}else if(type.equals("department")) {
			user = new InsuranceCompanyManagerUser();
			label3Text = "Manager Name:";
			label4Text = "Manager Company:";
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

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();

		username = new javax.swing.JTextField();
		password = new javax.swing.JTextField();
		branchLocation = new javax.swing.JTextField();
		governmentManagerName = new javax.swing.JTextField();


		jButton1 = new javax.swing.JButton();
		jButton1.setFont(new Font("Arial", Font.BOLD, 14));

		back = new javax.swing.JButton();
		back.setFont(new Font("Arial", Font.BOLD, 14));
		

		jLabel1.setText("Username");

		jLabel2.setText("Password");

		jLabel3.setText(label3Text);

		jLabel4.setText(label4Text);

		username.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				usernameActionPerformed(evt);
			}
		});

		jButton1.setText("Create");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		back.setText("back");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                    container.removeAll();
                    container.add(new AdminJPanel(container, system));
                    container.revalidate();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(142)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel1, Alignment.TRAILING)
						.addComponent(jLabel3, Alignment.TRAILING)
						.addComponent(jLabel4, Alignment.TRAILING)
						.addGroup(Alignment.TRAILING, layout.createParallelGroup(Alignment.LEADING)
							.addComponent(back)
							.addComponent(jLabel2)))
					.addGap(18)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
							.addComponent(username, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addComponent(password, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addComponent(branchLocation, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addComponent(governmentManagerName, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(71)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel2)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel3)
						.addComponent(branchLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel4)
						.addComponent(governmentManagerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(61)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton1)
						.addComponent(back))
					.addContainerGap())
		);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
		// TODO add your handling code here:

	}//GEN-LAST:event_usernameActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		if(!checkPassWord(password.getText())) {
			JOptionPane.showMessageDialog(null, "Password lenth >= 4 and must contain number and character");
			return;
		}
		if(type.equals("admin")){
			system.getUserAccountDirectory().createAdminUser(username.getText(), password.getText());
		} else if(type.equals("planner")){
			system.getUserAccountDirectory().createInsuranceCompanyUser(username.getText(), password.getText(),branchLocation.getText(),governmentManagerName.getText());
		} else if(type.equals("department")){
			system.getUserAccountDirectory().createCompanyManagerUser(username.getText(), password.getText(),branchLocation.getText(),governmentManagerName.getText());
		} else if(type.equals("customer")){
			if(!isEmail(branchLocation.getText())) {
				JOptionPane.showMessageDialog(null, "email is error");
				return ;
			}
			system.getUserAccountDirectory().createCustomerUser(username.getText(), password.getText(), "",branchLocation.getText(),governmentManagerName.getText());
		} else if(type.equals("gov")){
			system.getUserAccountDirectory().createGovernmentUser(username.getText(), password.getText(), "", "", "", "",branchLocation.getText(),governmentManagerName.getText());
		}

		JOptionPane.showMessageDialog(null, "Create User Successful!");

	}//GEN-LAST:event_jButton1ActionPerformed

	private boolean checkPassWord(String password) {
		String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,16}$";	
		if(password.matches(regex)) {
			return true; 
		}
		return false;
	}

	public boolean isEmail(String email) {
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

		Matcher matcher = pattern.matcher(email);
		return  matcher.matches();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JTextField password;
	private javax.swing.JTextField username;
	private javax.swing.JTextField branchLocation;
	private javax.swing.JTextField governmentManagerName;
	// End of variables declaration//GEN-END:variables
}
