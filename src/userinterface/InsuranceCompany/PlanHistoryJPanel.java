/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InsuranceCompany;

import Business.InsuranceSystem;
import Business.Plan.Plan;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;

/**
 *
 * @author xuhang
 */
public class PlanHistoryJPanel extends javax.swing.JPanel {
    
    private Container userProcessContainer;

    private InsuranceSystem system;

    /**
     * Creates new form planHistoryJPanel
     */
    public PlanHistoryJPanel(Container userProcessContainer, InsuranceSystem system) {
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        initComponents();
        initTable(system.getPlanDirectory().getPlanList());

    }

    private void initTable(ArrayList<Plan> plans) {
        DefaultTableModel model = (DefaultTableModel) planListTable.getModel();

        model.setRowCount(0);

        for (Plan plan : plans) {
            if (!plan.getCreateUser().equals(system.getCurrentUser())) {
                continue;
            }
            Object[] row = new Object[6];
            row[0] = plan.getTitle();
            row[1] = plan.getPlanId();
            row[2] = plan.getPrice();
            row[3] = plan.getOfferField();
            row[4] = plan.getOfferAgeRange();
            row[5] = plan.getStatus();

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
    	
    	ImageIcon statusIcon = new ImageIcon("./img/solution.png");

        jScrollPane1 = new javax.swing.JScrollPane();
        planListTable = new javax.swing.JTable();
        planListTable.setFont(new Font("Arial", Font.BOLD, 14));
        jButton1 = new javax.swing.JButton();
        jButton1.setFont(new Font("Arial", Font.BOLD, 14));

        planListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title", "Plan id", "Price", "Offer Field", "Offer Age Range", "Status"
            }
        ));
        jScrollPane1.setViewportView(planListTable);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        lblPlanStatus = new JLabel(statusIcon);
        lblPlanStatus.setText("Plan Status");
        lblPlanStatus.setForeground(Color.BLUE);
        lblPlanStatus.setFont(new Font("Arial", Font.BOLD, 16));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(49)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 809, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblPlanStatus, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(32)
        			.addComponent(lblPlanStatus)
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
        			.addGap(35)
        			.addComponent(jButton1)
        			.addContainerGap(127, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.removeAll();
        userProcessContainer.add(new InsuranceCompanyJPanel(userProcessContainer, system));
        userProcessContainer.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable planListTable;
    private JLabel lblPlanStatus;
    // End of variables declaration//GEN-END:variables
}
