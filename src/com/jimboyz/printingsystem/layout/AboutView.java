package com.jimboyz.printingsystem.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.jimboyz.printingsystem.err.ErrorDialog;

public class AboutView {
	
	protected JDialog jDialog;
	protected SetupProperties p = new SetupProperties();
	
	public AboutView(JFrame frame) {
		
		SwingUtil.invokeLater(()->{
			this.jDialog = new JDialog(frame, "About", true);
			this.jDialog.setResizable(false);
			this.jDialog.setIconImage(frame.getIconImage());
			jDialog.setLayout(new BorderLayout());
		
			init();
		});
	}
	
	private void init() {
		
		JTabbedPane tab = new JTabbedPane();
		tab.setFocusable(false);
		tab.setOpaque(false);
		tab.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 7));
		
		jDialog.add(tab, "Center");
		
		tab.addTab("About", SwingUtil.newImageIcon("/com/jimboyz/lts/images/about.png"), panelAbout());
		
		JLabel lbl = new JLabel("About");
		lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lbl.setFont(new Font("Calibri", Font.PLAIN, 14));
		//lbl.setIcon(SwingUtil.newImageIcon("/com/jimboyz/lts/images/about.png"));
		lbl.setIconTextGap(5);
		lbl.setFocusable(false);
		lbl.setOpaque(false);
		
		JLabel lblProp = new JLabel("Properties");
		lblProp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblProp.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblProp.setFocusable(false);
		lblProp.setOpaque(false);
		
		JLabel lblLicense = new JLabel("License");
		lblLicense.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblLicense.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblLicense.setFocusable(false);
		lblLicense.setOpaque(false);
		
		tab.setTabComponentAt(0, lbl);
	
		tab.addTab("Properties", p.properties());
		tab.setTabComponentAt(tab.getTabCount()-1, lblProp);
		tab.add("License", License.licenseDetails());
		tab.setTabComponentAt(tab.getTabCount()-1, lblLicense);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelBtn.add(okButton());
		jDialog.getContentPane().add(panelBtn, BorderLayout.SOUTH);
		
		this.jDialog.setSize(new Dimension(400, 370));
		this.jDialog.setLocationRelativeTo(this.jDialog.getParent());
		this.jDialog.setVisible(true);
	}
	
	private JPanel panelAbout() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		
		JLabel me = new JLabel();
		me.setBounds(0, 0, 367, 267);
		SwingUtil.setLabelImageIcon(me, "/com/jimboyz/lts/images/jimboysEdit2.png");
		me.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		
		JLabel lblTitle = new JLabel("Form Printing System");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTitle.setForeground(Color.WHITE);
		
		JPanel panelCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelCenter.setBounds(0, 30, 400, 40);
		panelCenter.setBackground(new Color(0, 0, 0, 2));
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 0, 410, 310);
		panel2.setBackground(new Color(0, 0, 0, 80));
		
		JLabel lblPrinterLogo = new JLabel();
		lblPrinterLogo.setBounds(10, panelCenter.getY()+panelCenter.getHeight() + 10, 105, 105);
		lblPrinterLogo.setIcon(SwingUtil.setLabelImageIcon(lblPrinterLogo, "/com/jimboyz/lts/images/print_pref-9.png"));
		
		JLabel lblAbouts = new JLabel("<html><h3>FPS     -     Version 1.0.1</h3></html>");
		lblAbouts.setFont(SwingUtil.myFont("Consolas", Font.PLAIN, 12));
		lblAbouts.setForeground(Color.WHITE);
		lblAbouts.setBounds(lblPrinterLogo.getWidth() + 50, panelCenter.getY() + panelCenter.getHeight() + 5, 300, 50);
		panel2.add(lblAbouts);
		
		JLabel lblAbout2 = new JLabel("<html><h3>Copyright © 2026</h3></html>");
		lblAbout2.setFont(SwingUtil.myFont("Consolas", Font.PLAIN, 12));
		lblAbout2.setForeground(Color.WHITE);
		lblAbout2.setBounds(lblPrinterLogo.getWidth() + 30, lblAbouts.getY()+25, 300, 50);
		panel2.add(lblAbout2);
		
		JLabel lblAbout3 = new JLabel("<html><h3>By: jimBoYz Ni ChOy!!! </h3></html>");
		lblAbout3.setFont(SwingUtil.myFont("Consolas", Font.PLAIN, 12));
		lblAbout3.setForeground(Color.WHITE);
		lblAbout3.setBounds(lblPrinterLogo.getWidth() + 30, lblAbout2.getY()+25, 300, 50);
		panel2.add(lblAbout3);
		
		JLabel lblAbout4 = new JLabel("<html><h3>of JS Software and</h3></html>");
		lblAbout4.setFont(SwingUtil.myFont("Consolas", Font.PLAIN, 12));
		lblAbout4.setForeground(Color.WHITE);
		lblAbout4.setBounds(lblPrinterLogo.getWidth() + 30, lblAbout3.getY()+25, 330, 50);
		panel2.add(lblAbout4);
		
		JLabel lblAbout5 = new JLabel("<html><h3>IT Support.</h3></html>");
		lblAbout5.setFont(SwingUtil.myFont("Consolas", Font.PLAIN, 12));
		lblAbout5.setForeground(Color.WHITE);
		lblAbout5.setBounds(lblPrinterLogo.getWidth() + 30, lblAbout4.getY()+25, 330, 50);
		panel2.add(lblAbout5);
		
		JPanel panelContactInfo = new JPanel(new FlowLayout());
		panelContactInfo.setBounds(7, 247, 400, 20);
		panelContactInfo.setBackground(Color.red);
		
		JLabel lblContactInfo = new JLabel("Contact me @: https://jimboyz-myemail.web.app/");
		lblContactInfo.setBounds(7, lblPrinterLogo.getY()+lblPrinterLogo.getHeight()+62, 400, 20);
		lblContactInfo.setToolTipText("Go to");
		lblContactInfo.setForeground(Color.WHITE);
		lblContactInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblContactInfo.addMouseListener(contactMe());
		lblContactInfo.setOpaque(false);
		
		panel2.add(lblContactInfo);
		panelCenter.add(lblTitle);
		panel2.add(lblPrinterLogo);
		
		panel2.add(panelCenter);
		panel.add(panel2);
		panel.add(me);
		
		return panel;
	}
	
	private JButton okButton() {
		JButton btnOk = SwingUtil.button("OK", null, SwingUtil.myFont("Times New Roman", Font.PLAIN, 12), Color.BLACK);
		btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnOk.setFocusable(false);
		btnOk.setPreferredSize(new Dimension(77,25));
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jDialog.setVisible(false);
			}
		});
		
		
		return btnOk;
	}
	
	private MouseAdapter contactMe() {
		
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://jimboyz-myemail.web.app").toURI());
				}catch(Exception ex) {
					ex.printStackTrace();
					ErrorDialog.show("Link not found : "+ex.getMessage());
				}
			}
		};
		
		return mouseAdapter;
		
	}
}