
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

import Business.UserAccount.CustomerUser;
import java.awt.Font;

public class DetailView extends JFrame {

	private static final long serialVersionUID = -1984182788841566838L;

	private JPanel jPanelCenter, jPanelSouth;
	private JButton addButton, exitButton;
	private JLabel Age, Email, phone, SSN, DocumentID;

	public DetailView(CustomerUser user) {
		init(user);
	}

	private void init(CustomerUser user) {
		setTitle("Customer Information");
		// center panel
		jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new GridLayout(9, 2));
		JLabel label = new JLabel("Age");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		jPanelCenter.add(label);
		Age = new JLabel(user.getAge()+"");
		jPanelCenter.add(Age);
		JLabel label_1 = new JLabel("Email");
		label_1.setFont(new Font("Arial", Font.PLAIN, 16));
		jPanelCenter.add(label_1);
		Email = new JLabel(user.getEmailAddress());
		jPanelCenter.add(Email);
		JLabel label_2 = new JLabel("Phone");
		label_2.setFont(new Font("Arial", Font.PLAIN, 16));
		jPanelCenter.add(label_2);
		phone = new JLabel(user.getPhoneNumbe());
		jPanelCenter.add(phone);
		JLabel label_3 = new JLabel("SSN");
		label_3.setFont(new Font("Arial", Font.PLAIN, 16));
		jPanelCenter.add(label_3);
		SSN = new JLabel(user.getSSN());
		jPanelCenter.add(SSN);
		JLabel label_4 = new JLabel("Document ID");
		label_4.setFont(new Font("Arial", Font.PLAIN, 16));
		jPanelCenter.add(label_4);
		DocumentID = new JLabel(user.getDocumentId());
		jPanelCenter.add(DocumentID);

		jPanelCenter.add(new JLabel("-------------------------------------------------"));
		jPanelCenter.add(new JLabel("-------------------------------------------------"));

		// south panel
		jPanelSouth = new JPanel();
		exitButton = new JButton("Close");
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
		setBounds(470, 200, 549, 388);
		setResizable(false);
		setVisible(true);
	}
	//Age, Email, phone, SSN, DocumentID;
	private boolean check() {
		boolean result = false;
		if(isMobile(phone.getText())) {
			JOptionPane.showMessageDialog(null, "phone is error");
			return result;
		}

		if(isEmail(Email.getText())) {
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

		Matcher matcher = pattern.matcher("a@aa.com");
		return  matcher.matches();
	}
}
