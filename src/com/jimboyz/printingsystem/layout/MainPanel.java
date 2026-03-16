package com.jimboyz.printingsystem.layout;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import com.jimboyz.printingsystem.controlPanel.ShowController;

public class MainPanel extends JPanel implements MyInterface {

	private static final long serialVersionUID = 1L;
	
	private JPanel panelBillingStatementContainer;
	private JPanel panelChargeInvoiceContainer;
	private JPanel homePanel;
	private JPanel billingStatementPanel, chargeInvoicePanel;
	private ImageIcon imageIcon1;
	private Image image1;
	private Image img1;
	private ImageIcon imageIcon2;
	private JLabel lblBillingIcon, lblChargeInvoiceIcon;
	
	public MainPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(null);
		
		panelBillingStatementContainer = new JPanel();
		panelChargeInvoiceContainer = new JPanel();
		
		homePanel = new JPanel();
		homePanel.setBackground(null);
		homePanel.setLayout(new FlowLayout(0, 20, 30));
		
		panelBillingStatementContainer.setLayout(new BorderLayout());
		panelBillingStatementContainer.setBackground(null);
		
		panelChargeInvoiceContainer.setBackground(null);
		panelChargeInvoiceContainer.setLayout(new BorderLayout());
		
		this.add(panelBillingStatementContainer, BorderLayout.CENTER);
		this.add(panelChargeInvoiceContainer, BorderLayout.CENTER);
		
		show();
		billingStatement();
		chargeInvoice();
		loadImage();
	}
	
	public void show() {
		this.add(homePanel, BorderLayout.CENTER);
		
	}
	
	public void showPanel(MouseEvent e) {
		
		if(e.getSource() == chargeInvoicePanel) {
			
			new ShowController().showChargeInvoice(this, panelChargeInvoiceContainer);
			frame.setTitle("Form Printing System - FPS v. 1.0.1 - Charge Invoice");
		}else if(e.getSource() == billingStatementPanel) {
			
			new ShowController().showBillingStatement(this, panelBillingStatementContainer);
			frame.setTitle("Form Printing System - FPS v. 1.0.1 - Billing Statement");
			
		}
	}
	
	public void billingStatement() {
		
		billingStatementPanel = SwingUtil.panel(new Dimension(120, 120), new Cursor(Cursor.HAND_CURSOR));
		billingStatementPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		billingStatementPanel.addMouseListener(new MouseHovering1(billingStatementPanel));
		billingStatementPanel.setLayout(new BorderLayout());
		
		lblBillingIcon = SwingUtil.label("");
		lblBillingIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblBillingIcon.setSize(new Dimension(90, 90));
		
		JLabel des = SwingUtil.label("Billing Statement");
		des.setHorizontalAlignment(JLabel.CENTER);
		des.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		billingStatementPanel.add(des, BorderLayout.SOUTH);
		billingStatementPanel.add(lblBillingIcon, BorderLayout.CENTER);
		homePanel.add(billingStatementPanel);
	}
	
	public void chargeInvoice() {
		
		chargeInvoicePanel = SwingUtil.panel(new Dimension(120, 120), new Cursor(Cursor.HAND_CURSOR));
		chargeInvoicePanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		chargeInvoicePanel.addMouseListener(new MouseHovering1(chargeInvoicePanel));
		chargeInvoicePanel.setLayout(new BorderLayout());
		
		lblChargeInvoiceIcon = SwingUtil.label("");
		lblChargeInvoiceIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblChargeInvoiceIcon.setSize(new Dimension(90, 90));
		
		JLabel des = SwingUtil.label("Charge Invoice");
		des.setHorizontalAlignment(JLabel.CENTER);
		des.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		chargeInvoicePanel.add(des, BorderLayout.SOUTH);
		chargeInvoicePanel.add(lblChargeInvoiceIcon, BorderLayout.CENTER);
		homePanel.add(chargeInvoicePanel);
	}
	
	private void loadImage() {
		imageIcon1 = new ImageIcon(SwingUtil.getImage("/com/jimboyz/lts/images/invoice2.png"));
		image1 = imageIcon1.getImage();
		img1 = image1.getScaledInstance(lblBillingIcon.getWidth(), lblBillingIcon.getHeight(), Image.SCALE_SMOOTH);
		imageIcon2 = new ImageIcon(img1);
		lblBillingIcon.setIcon(imageIcon2);
		
		ImageIcon imageIcon1 = new ImageIcon(SwingUtil.getImage("/com/jimboyz/lts/images/bill.png"));
		Image image1 = imageIcon1.getImage();
		Image img1 = image1.getScaledInstance(lblChargeInvoiceIcon.getWidth(), lblChargeInvoiceIcon.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon2 = new ImageIcon(img1);
		lblChargeInvoiceIcon.setIcon(imageIcon2);
	}
	
	public class MouseHovering1 extends MouseAdapter {
		private JPanel panel;
		public MouseHovering1(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			MainPanel.this.showPanel(e);
		}
	}
}
