
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Business.UserAccount.CustomerUser;
import java.awt.Font;

public class AddView extends JFrame {

	private static final long serialVersionUID = -1984182788841566838L;

	private JPanel jPanelCenter, jPanelSouth;
	private JButton addButton, exitButton;
	private JTextField Age, Email, phone, SSN, DocumentID;

	public AddView(CustomerUser user) {
		init(user);
	}

	private void init(CustomerUser user) {
		setTitle("Adding infomation");
		// center panel
		jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new GridLayout(9, 2));
		JLabel label = new JLabel("Age");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		jPanelCenter.add(label);
		Age = new JTextField();
		Age.setFont(new Font("Arial", Font.BOLD, 14));
		jPanelCenter.add(Age);
		JLabel label_1 = new JLabel("Email");
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		jPanelCenter.add(label_1);
		Email = new JTextField();
		Email.setFont(new Font("Arial", Font.BOLD, 14));
		jPanelCenter.add(Email);
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 16));
		jPanelCenter.add(lblPhone);
		phone = new JTextField();
		phone.setFont(new Font("Arial", Font.BOLD, 14));
		jPanelCenter.add(phone);
		JLabel label_3 = new JLabel("SSN");
		label_3.setFont(new Font("Arial", Font.PLAIN, 16));
		jPanelCenter.add(label_3);
		SSN = new JTextField();
		SSN.setFont(new Font("Arial", Font.BOLD, 14));
		jPanelCenter.add(SSN);
		JLabel lblDocumentId = new JLabel("Document ID");
		lblDocumentId.setFont(new Font("Arial", Font.PLAIN, 16));
		jPanelCenter.add(lblDocumentId);
		DocumentID = new JTextField();
		DocumentID.setFont(new Font("Arial", Font.BOLD, 14));
		jPanelCenter.add(DocumentID);

		jPanelCenter.add(new JLabel("-------------------------------------------------"));
		jPanelCenter.add(new JLabel("-------------------------------------------------"));

		// south panel
		jPanelSouth = new JPanel();
		jPanelSouth.setLayout(new GridLayout(1, 2));
		addButton = new JButton("Submit");
		addButton.setFont(new Font("Arial", Font.BOLD, 18));
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (check()) {
					user.setAge(Integer.parseInt(Age.getText()));
					user.setEmailAddress(Email.getText());
					user.setPhoneNumbe(phone.getText());
					user.setSSN(SSN.getText());
					user.setDocumentId(DocumentID.getText());
					dispose();
					JOptionPane.showMessageDialog(null, "Apply successfully!");
				}
			}
		});
		jPanelSouth.add(addButton);
		exitButton = new JButton("Cancel");
		exitButton.setFont(new Font("Arial", Font.BOLD, 18));
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
		setBounds(470, 200, 549, 411);
		setResizable(false);
		setVisible(true);
	}
	//Age, Email, phone, SSN, DocumentID;
	private boolean check() {
		boolean result = false;
		if(!isMobile(phone.getText())) {
			JOptionPane.showMessageDialog(null, "phone is error");
			return result;
		}

		if(!isEmail(Email.getText())) {
			JOptionPane.showMessageDialog(null, "email is error");
			return result;
		}

		if ("".equals(Age.getText()) || "".equals(Email.getText()) || "".equals(phone.getText())
				|| "".equals(SSN.getText()) || "".equals(DocumentID.getText())) {
			return result;
		} else {
			result = true;
		}
		return result;
	}

	public  boolean isMobile(String str) {
		Pattern p ;
		Matcher m ;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // ��֤�ֻ���
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
	public boolean isEmail(String email) {
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

		Matcher matcher = pattern.matcher(email);
		return  matcher.matches();
	}
}
