
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Business.Plan.Plan;
import javax.swing.JOptionPane;
import userinterface.Customer.CustomerMainJPanel.CallBack;
import java.awt.Font;

public class MarkView extends JFrame {

	private static final long serialVersionUID = -1984182788841566838L;

	private JPanel jPanelCenter, jPanelSouth;
	private JButton addButton, exitButton;
	private JTextField mark;
	private CallBack callBack;
	public MarkView(Plan plan,CallBack callBack) {
		init(plan,callBack);
		this.callBack = callBack;
	}

	private void init(Plan plan,CallBack callBack) {
		setTitle("Mark rating");
		// center panel
		jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new GridLayout(1, 2));
		JLabel lblRating = new JLabel("Rating Score");
		lblRating.setFont(new Font("Arial", Font.BOLD, 15));
		jPanelCenter.add(lblRating);
		mark = new JTextField();
		mark.setFont(new Font("Arial", Font.BOLD, 15));
		mark.setPreferredSize(new Dimension(100, 50));
		jPanelCenter.add(mark);

		// south panel
		jPanelSouth = new JPanel();
		jPanelSouth.setLayout(new GridLayout(1, 2));
		addButton = new JButton("Submit");
		addButton.setFont(new Font("Arial", Font.BOLD, 16));
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                            int score = Integer.valueOf(mark.getText());
                            if(score < 0 || score > 100){
                                JOptionPane.showMessageDialog(null, "Mark should be between 0 - 100.");
                                return;
                            }
                            plan.setMark(Integer.valueOf(mark.getText()));
                            callBack.markFinish();
                            dispose();
			}
		});
		jPanelSouth.add(addButton);
		exitButton = new JButton("Cancle");
		exitButton.setFont(new Font("Arial", Font.BOLD, 16));
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jPanelSouth.add(exitButton);

		getContentPane().add(jPanelCenter, BorderLayout.CENTER);
		getContentPane().add(jPanelSouth, BorderLayout.SOUTH);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 200, 312, 130);
		setResizable(false);
		setVisible(true);
	}
}
