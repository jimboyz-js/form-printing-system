package com.jimboyz.printingsystem.billingStatement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

import com.jimboyz.printingsystem.chargeInvoice.ChargeInvoicePanelGUI;
import com.jimboyz.printingsystem.controlPanel.ShowController;
import com.jimboyz.printingsystem.layout.AboutView;
import com.jimboyz.printingsystem.layout.MainGUI;
import com.jimboyz.printingsystem.layout.MainPanel;
import com.jimboyz.printingsystem.layout.MyInterface;
import com.jimboyz.printingsystem.layout.SwingUtil;
import com.jimboyz.printingsystem.pref.PreferencesGUI;
import com.jimboyz.printingsystem.pref.SetPreferences;
import com.toedter.calendar.JDateChooser;

public class BillingStatementGUI extends JPanel implements MyInterface {
	
	private static final long serialVersionUID = 1L;

	

	private JLabel lblTitle, lblBusiness;
	private JLabel lblTitle4, lblTitle5;
	private JDateChooser dateChooser;
	private SimpleDateFormat f;

	private JPanel headerTitlePanel;
	private JPanel panelBodyContainer;
	private JPanel panelCon2, panelContainer2, panelContainer1;
	private JTextField txtBy;
	private JButton btnPrint;
	JScrollBar scrollbar;

	private JTextField qty;
	private JTextField unit;
	private JTextField des;
	private JTextField unitPrice;
	private JTextField amount;
	private JTextField qty2;
	private JTextField unit2;
	private JTextField des2;
	private JTextField unitPrice2;
	private JTextField amount2;
	private JTextField qty3;
	private JTextField unit3;
	private JTextField des3;
	private JTextField unitPrice3;
	private JTextField amount3;
	private JTextField qty4;
	private JTextField unit4;
	private JTextField des4;
	private JTextField unitPrice4;
	private JTextField amount4;
	private JTextField qty5;
	private JTextField unit5;
	private JTextField des5;
	private JTextField unitPrice5;
	private JTextField amount5;
	private JTextField qty6;
	private JTextField unit6;
	private JTextField unitPrice6;
	private JTextField des6;
	private JTextField amount6;
	private JTextField qty7;
	private JTextField unit7;
	private JTextField des7;
	private JTextField amount7;
	private JTextField unitPrice7;
	private JTextField txtTotalSales;
	private JTextField txtLessVat;
	private JTextField txtVatableSales;
	private JTextField txtCust;
	private JTextField txtTotalAmountDue;
	private JTextField txtVatAmount;
	private JTextField txtAmountDue;
	private JTextField txtZeroRated;
	private JTextField txtLessDis;
	private JTextField txtVatExempt;
	private JTextField txtAmountNetVat;

	private JTextField txtName;

	private JTextField txtAddress;

	private JTextField txtTerm;

	private JTextField txtTin;

	private JTextField txtBusiness;

	private JTextField txtCh;

	private JTextField txtOsca;
	
	SwingUtil swingUtil = new SwingUtil();
	
	public BillingStatementGUI() {
		this.setLayout(null);
		this.setBackground(null);

		panelBodyContainer = new JPanel();
		panelBodyContainer.setLayout(null);

		headerTitlePanel = new JPanel();
		headerTitlePanel.setLayout(null);
		headerTitlePanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

		scrollbar = new JScrollBar();
		scrollbar.setOrientation(JScrollBar.VERTICAL);
		
		headerTitlePanel.add(panelBodyContainer);
		this.add(headerTitlePanel);

		titleHeader();
		infoHeader();
		panelBody();
		tableContainer();
		scrollBarFunctionable();
		printView();
		clear();
		
		KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_P, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
		String bindingKey = keyStroke.toString();
		
		InputMap inputMap = this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		ActionMap actionMap = this.getActionMap();
		
		inputMap.put(keyStroke, bindingKey);
		actionMap.put(bindingKey, new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new ShowPrintDialog(txtName, txtAddress, txtTin, txtTerm, txtOsca, txtCh, txtBusiness, qty, qty2, qty3, qty4, qty5, qty6, qty7, unit, unit2, unit3, unit4, unit5, unit6, unit7, des, des2, des3, des4, des5, des6, des7, unitPrice, unitPrice2, unitPrice3, unitPrice4, unitPrice5, unitPrice6, unitPrice7, amount, amount2, amount3, amount4, amount5, amount6, amount7, txtTotalSales, txtVatableSales, txtVatExempt, txtZeroRated, txtVatAmount, txtLessVat, txtAmountNetVat, txtLessDis, txtAmountDue, txtTotalAmountDue, txtCust, txtBy, f.format(dateChooser.getDate())).setVisible(true);
			}
			
		});
		
		myAction(true);
		ShowController.clearData0(this, frame, txtName, txtAddress, txtTin, txtTerm, txtOsca, txtCh, txtBusiness, qty, qty2, qty3, qty4, qty5, qty6, qty7, unit, unit2, unit3, unit4, unit5, unit6, unit7, des, des2, des3, des4, des5, des6, des7, unitPrice, unitPrice2, unitPrice3, unitPrice4, unitPrice5, unitPrice6, unitPrice7, amount, amount2, amount3, amount4, amount5, amount6, amount7, txtTotalSales, txtVatableSales, txtVatExempt, txtZeroRated, txtVatAmount, txtLessVat, txtAmountNetVat, txtLessDis, txtAmountDue, txtTotalAmountDue, txtCust, txtBy);
	}

	public void showChargeInvoicePanel() {
		this.setLayout(new BorderLayout());
		this.removeAll();
		this.revalidate();
		this.repaint();
		this.add(new ChargeInvoicePanelGUI(), BorderLayout.CENTER);
	}
	
	public void myAction(boolean enable) {
		
		MainGUI.menuAction(enable, true, false, true, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				showChargeInvoicePanel();
				frame.setTitle("For Printing System - FPS v. 1.0.1 - Charge Invoice");
			}
		}, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setTitle("For Printing System - FPS v. 1.0.1");
				showHome();
			}
		}, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutView(frame);
			}
		},  new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("User Guide");
				ShowController.showUserGuid();
			}
		}, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new PreferencesGUI(frame).setVisible(true);
				
			}
		}, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new ShowPrintDialog(txtName, txtAddress, txtTin, txtTerm, txtOsca, txtCh, txtBusiness, qty, qty2, qty3, qty4, qty5, qty6, qty7, unit, unit2, unit3, unit4, unit5, unit6, unit7, des, des2, des3, des4, des5, des6, des7, unitPrice, unitPrice2, unitPrice3, unitPrice4, unitPrice5, unitPrice6, unitPrice7, amount, amount2, amount3, amount4, amount5, amount6, amount7, txtTotalSales, txtVatableSales, txtVatExempt, txtZeroRated, txtVatAmount, txtLessVat, txtAmountNetVat, txtLessDis, txtAmountDue, txtTotalAmountDue, txtCust, txtBy, f.format(dateChooser.getDate())).setVisible(true);
				
			}
		}, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void showHome() {
		
		new ShowController().showHome(this, new MainPanel());
	}
	
	public void titleHeader() {

		lblTitle = SwingUtil.label(
				"<html><h1 font face=\"Times New Roman\" color=black text-align=\"center\">"+new SwingUtil().bs_name+"</h1></html>");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, headerTitlePanel.getWidth(), 30);

		JLabel lblTitle2 = SwingUtil.label(
				"<html><h3 font face=\"Times New Roman\">"+new SwingUtil().address+"</h3></html>");
		lblTitle2.setHorizontalAlignment(JLabel.CENTER);
		lblTitle2.setBounds(0, lblTitle.getY() + lblTitle.getHeight(), headerTitlePanel.getWidth(), 20);

		JLabel lblTitle3 = SwingUtil
				.label("<html><h4 font face=\"Times New Roman\">" + new SwingUtil().prop + " <span>- Prop.</span></h4></html>");
		lblTitle3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle3.setBounds(0, lblTitle2.getY() + lblTitle2.getHeight(), headerTitlePanel.getWidth(), 20);

		lblTitle4 = SwingUtil.label("<html><h4 font face=\"Times New Roman\">VAT Reg. TIN: " + new SwingUtil().bs_tin + "</h4></html>");
		lblTitle4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle4.setBounds(0, lblTitle3.getY() + lblTitle3.getHeight(), headerTitlePanel.getWidth(), 20);

		headerTitlePanel.add(lblTitle);
		headerTitlePanel.add(lblTitle2);
		headerTitlePanel.add(lblTitle3);
		headerTitlePanel.add(lblTitle4);
	}

	public void infoHeader() {

		lblTitle5 = SwingUtil
				.label("<html><h2 font face=\"Times New Roman\" color=black>BILLING STATEMENT</h2></html>");
		lblTitle5.setBounds(1, lblTitle4.getY() + lblTitle4.getHeight() + 27, 200, 20);

		JLabel lblDate = SwingUtil.label("<html><h3 font face=\"Times New Roman\" color=black>Date:</h3></html>");
		lblDate.setBounds(lblTitle5.getX() + frame.getWidth() / 2 + 135, lblTitle5.getY(), 37, 20);

		Date date = new Date();
		f = new SimpleDateFormat(new SwingUtil().dateFormatString);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(lblDate.getX() + 47, lblDate.getY() + 2, 127, 20);
		dateChooser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dateChooser.setDate(date);
		dateChooser.setFont(SwingUtil.myFont(swingUtil.dateFont, swingUtil.dateFontStyle, swingUtil.dateFontSize));
		dateChooser.setDateFormatString(new SwingUtil().dateFormatString);
		
		headerTitlePanel.add(lblTitle5);
		headerTitlePanel.add(lblDate);
		headerTitlePanel.add(dateChooser);

	}

	public void panelBody() {
		panelBodyContainer.setBounds(1, lblTitle5.getY() + 30, headerTitlePanel.getWidth(), 420);
		panelBodyContainer.setBackground(null);

		panelContainer1 = new JPanel();
		panelContainer1.setLayout(null);
		panelContainer1.setBackground(Color.GRAY);
		panelContainer1.setBounds(4, 3, panelBodyContainer.getWidth() - 40, panelBodyContainer.getHeight() - 20);
		panelContainer1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));

		panelCon2 = new JPanel();
		panelCon2.setBounds(3, 3, panelContainer1.getWidth() - 6, panelContainer1.getHeight() - 6);
		panelCon2.setLayout(null);
		
		scrollbar.setBounds(panelContainer1.getX() + panelContainer1.getWidth() + 3, 0, 17, panelBodyContainer.getHeight());
		scrollbar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelBodyContainer.add(scrollbar);
		
		JLabel lblName = SwingUtil.label("Name:", new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE),
				Color.BLACK, 10, 10, 100, 20);
		txtName = SwingUtil.textField("name", new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE),
				Color.BLACK, lblName.getX() + lblName.getWidth() + 10, lblName.getY()-3,
				(panelContainer1.getWidth() - (lblName.getX() + lblName.getWidth()) - 20), 23);
		
		JLabel lblAddress = SwingUtil.label("Address:", new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE),
				Color.BLACK, lblName.getX(), lblName.getY() + lblName.getHeight() + 6, 100, 20);
		txtAddress = SwingUtil.textField("address",
				new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE), Color.BLACK,
				lblAddress.getX() + lblAddress.getWidth() + 10, lblAddress.getY()-4,
				(panelContainer1.getWidth() - (lblAddress.getX() + lblAddress.getWidth()) - 20), txtName.getHeight());

		JLabel lblTerm = SwingUtil.label("Term:", new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE),
				Color.BLACK, panelContainer1.getWidth() - 200, lblAddress.getY() + lblAddress.getHeight() + 5, 50, 20);
		txtTerm = SwingUtil.textField("term", new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE),
				Color.BLACK, lblTerm.getX() + lblTerm.getWidth() + 10, lblTerm.getY()-4,
				((txtAddress.getX() + txtAddress.getWidth()) - (lblTerm.getX() + lblTerm.getWidth()) - 10), txtName.getHeight());
		
		JLabel lblTin = SwingUtil.label("TIN:", new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE),
				Color.BLACK, lblAddress.getX(), lblAddress.getY() + lblAddress.getHeight() + 5, 100, 20);
		txtTin = SwingUtil.textField("tin", new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE),
				Color.BLACK, lblTin.getX() + lblTin.getWidth() + 10, lblTin.getY()-4,
				lblTerm.getX() - (lblTin.getX() + lblTin.getWidth()) - 17, txtName.getHeight());
		
		JLabel lblOsca = SwingUtil.label("OSCA/PWD ID No. :",
				new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE), Color.BLACK, lblTin.getX(),
				lblTin.getY() + lblTin.getHeight() + 5, 150, 20);
		txtOsca = SwingUtil.textField("osca", new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE),
				Color.BLACK, lblOsca.getX() + lblOsca.getWidth() + 10, lblOsca.getY()-4,
				(panelContainer1.getWidth() - (lblOsca.getX() + lblOsca.getWidth()) - 20), txtName.getHeight());

		JLabel lblCh = SwingUtil.label("Cardholder's Signature:",
				new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE), Color.BLACK, lblOsca.getX(),
				lblOsca.getY() + lblOsca.getHeight() + 5, 150, 20);
		txtCh = SwingUtil.textField("txtch", new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE),
				Color.BLACK, lblCh.getX() + lblCh.getWidth() + 10, lblCh.getY()-4,
				(panelContainer1.getWidth() - (lblCh.getX() + lblCh.getWidth()) - 20), txtName.getHeight());

		lblBusiness = SwingUtil.label("Business Style :", new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE),
				Color.BLACK, lblCh.getX(), lblCh.getY() + lblCh.getHeight() + 5, 150, 20);
		txtBusiness = SwingUtil.textField("businessStyle",
				new Font("Times New Roman", Font.PLAIN, swingUtil.FONT_SIZE), Color.BLACK,
				lblBusiness.getX() + lblBusiness.getWidth() + 10, lblBusiness.getY()-4,
				(panelContainer1.getWidth() - (lblBusiness.getX() + lblBusiness.getWidth()) - 20), txtName.getHeight());


		panelCon2.add(lblName);
		panelCon2.add(txtName);
		panelCon2.add(lblAddress);
		panelCon2.add(txtAddress);
		panelCon2.add(lblTin);
		panelCon2.add(txtTin);
		panelCon2.add(lblTerm);
		panelCon2.add(txtTerm);
		panelCon2.add(lblOsca);
		panelCon2.add(txtOsca);
		panelCon2.add(lblCh);
		panelCon2.add(txtCh);
		panelCon2.add(lblBusiness);
		panelCon2.add(txtBusiness);

		panelContainer1.add(panelCon2);
		panelBodyContainer.add(panelContainer1);
		
	}

	public void tableContainer() {
		panelContainer2 = new JPanel();
		panelContainer2.setLayout(null);
		panelContainer2.setBounds(5, lblBusiness.getY() + 28, panelBodyContainer.getWidth() - 55, panelBodyContainer.getHeight()-77);
		panelContainer2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));

		JTextField tfQty = new JTextField("QTY.");
		tfQty.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		tfQty.setEditable(false);
		tfQty.setBounds(3, 3, 107, 23);
		tfQty.setHorizontalAlignment(SwingConstants.CENTER);
		tfQty.setForeground(Color.BLACK);
		tfQty.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JTextField tfUnit = new JTextField("Unit");
		tfUnit.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		tfUnit.setEditable(false);
		tfUnit.setBounds(tfQty.getX()+tfQty.getWidth(), tfQty.getY(), 90, 23);
		tfUnit.setHorizontalAlignment(SwingConstants.CENTER);
		tfUnit.setForeground(Color.BLACK);
		tfUnit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JTextField tfDescription = new JTextField("DESCRIPTION");
		tfDescription.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		tfDescription.setEditable(false);
		tfDescription.setBounds(tfUnit.getX()+tfUnit.getWidth(), tfUnit.getY(), 240, tfUnit.getHeight());
		tfDescription.setHorizontalAlignment(SwingConstants.CENTER);
		tfDescription.setForeground(Color.BLACK);
		tfDescription.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JTextField tfUnitPrice = new JTextField("Unit Price");
		tfUnitPrice.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		tfUnitPrice.setEditable(false);
		tfUnitPrice.setBounds(tfDescription.getX()+tfDescription.getWidth(), tfDescription.getY(), 90, tfDescription.getHeight());
		tfUnitPrice.setHorizontalAlignment(SwingConstants.CENTER);
		tfUnitPrice.setForeground(Color.BLACK);
		tfUnitPrice.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JTextField tfAmount = new JTextField("AMOUNT");
		tfAmount.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		tfAmount.setEditable(false);
		tfAmount.setBounds(tfUnitPrice.getX()+tfUnitPrice.getWidth(), tfUnitPrice.getY(), 107, tfUnitPrice.getHeight());
		tfAmount.setHorizontalAlignment(SwingConstants.CENTER);
		tfAmount.setForeground(Color.BLACK);
		tfAmount.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		qty = SwingUtil.textField("qty", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, tfQty.getX(), tfQty.getY()+tfQty.getHeight()+3, tfQty.getWidth(), tfQty.getHeight());
		unit = SwingUtil.textField("unit", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty.getX()+qty.getWidth(), qty.getY(), tfUnit.getWidth(), tfUnit.getHeight());
		des = SwingUtil.textField("des", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, tfDescription.getX(), tfDescription.getY()+tfDescription.getHeight()+3, tfDescription.getWidth(), tfDescription.getHeight());
		unitPrice = SwingUtil.textField("unitPrice", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, tfUnitPrice.getX(), tfUnitPrice.getY()+tfUnitPrice.getHeight()+3, tfUnitPrice.getWidth(), tfUnitPrice.getHeight());
		amount = SwingUtil.textField("amount", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, tfAmount.getX(), tfAmount.getY()+tfAmount.getHeight()+3, tfAmount.getWidth(), tfAmount.getHeight());
		
		qty2 = SwingUtil.textField("qty2", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty.getX(), qty.getY()+qty.getHeight(), qty.getWidth(), qty.getHeight());
		unit2 = SwingUtil.textField("unit2", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty2.getX()+qty2.getWidth(), qty2.getY(), unit.getWidth(), unit.getHeight());
		des2 = SwingUtil.textField("des2", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, des.getX(), des.getY()+des.getHeight(), des.getWidth(), des.getHeight());
		unitPrice2 = SwingUtil.textField("unitPrice2", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, unitPrice.getX(), unitPrice.getY()+unitPrice.getHeight(), unitPrice.getWidth(), unitPrice.getHeight());
		amount2 = SwingUtil.textField("amount2", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, amount.getX(), amount.getY()+amount.getHeight(), amount.getWidth(), amount.getHeight());
		
		qty3 = SwingUtil.textField("qty3", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty2.getX(), qty2.getY()+qty2.getHeight(), qty2.getWidth(), qty2.getHeight());
		unit3 = SwingUtil.textField("unit3", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty3.getX()+qty3.getWidth(), qty3.getY(), unit2.getWidth(), unit2.getHeight());
		des3 = SwingUtil.textField("des3", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, des2.getX(), des2.getY()+des2.getHeight(), des2.getWidth(), des2.getHeight());
		unitPrice3 = SwingUtil.textField("unitPrice3", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, unitPrice2.getX(), unitPrice2.getY()+unitPrice2.getHeight(), unitPrice2.getWidth(), unitPrice2.getHeight());
		amount3 = SwingUtil.textField("amount3", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, amount2.getX(), amount2.getY()+amount2.getHeight(), amount2.getWidth(), amount2.getHeight());
		
		qty4 = SwingUtil.textField("qty4", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty3.getX(), qty3.getY()+qty3.getHeight(), qty3.getWidth(), qty3.getHeight());
		unit4 = SwingUtil.textField("unit4", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty4.getX()+qty4.getWidth(), qty4.getY(), unit3.getWidth(), unit3.getHeight());
		des4 = SwingUtil.textField("des4", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, des3.getX(), des3.getY()+des3.getHeight(), des3.getWidth(), des3.getHeight());
		unitPrice4 = SwingUtil.textField("unitPrice4", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, unitPrice3.getX(), unitPrice3.getY()+unitPrice3.getHeight(), unitPrice3.getWidth(), unitPrice3.getHeight());
		amount4 = SwingUtil.textField("amount4", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, amount3.getX(), amount3.getY()+amount3.getHeight(), amount3.getWidth(), amount3.getHeight());
		
		qty5 = SwingUtil.textField("qty5", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty4.getX(), qty4.getY()+qty4.getHeight(), qty4.getWidth(), qty4.getHeight());
		unit5 = SwingUtil.textField("unit5", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty5.getX()+qty5.getWidth(), qty5.getY(), unit4.getWidth(), unit4.getHeight());
		des5 = SwingUtil.textField("des5", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, des4.getX(), des4.getY()+des4.getHeight(), des4.getWidth(), des4.getHeight());
		unitPrice5 = SwingUtil.textField("unitPrice5", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, unitPrice4.getX(), unitPrice4.getY()+unitPrice4.getHeight(), unitPrice4.getWidth(), unitPrice4.getHeight());
		amount5 = SwingUtil.textField("amount5", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, amount4.getX(), amount4.getY()+amount4.getHeight(), amount4.getWidth(), amount4.getHeight());
		
		qty6 = SwingUtil.textField("qty6", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty5.getX(), qty5.getY()+qty5.getHeight(), qty5.getWidth(), qty5.getHeight());
		unit6 = SwingUtil.textField("unit6", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty6.getX()+qty6.getWidth(), qty6.getY(), unit5.getWidth(), unit5.getHeight());
		des6 = SwingUtil.textField("des6", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, des5.getX(), des5.getY()+des5.getHeight(), des5.getWidth(), des5.getHeight());
		unitPrice6 = SwingUtil.textField("unitPrice6", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, unitPrice5.getX(), unitPrice5.getY()+unitPrice5.getHeight(), unitPrice5.getWidth(), unitPrice5.getHeight());
		amount6 = SwingUtil.textField("amount6", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, amount5.getX(), amount5.getY()+amount5.getHeight(), amount5.getWidth(), amount5.getHeight());
		
		qty7 = SwingUtil.textField("qty7", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty6.getX(), qty6.getY()+qty6.getHeight(), qty6.getWidth(), qty6.getHeight());
		unit7 = SwingUtil.textField("unit7", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty7.getX()+qty7.getWidth(), qty7.getY(), unit6.getWidth(), unit6.getHeight());
		des7 = SwingUtil.textField("des7", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, des6.getX(), des6.getY()+des6.getHeight(), des6.getWidth(), des6.getHeight());
		unitPrice7 = SwingUtil.textField("unitPrice7", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, unitPrice6.getX(), unitPrice6.getY()+unitPrice6.getHeight(), unitPrice6.getWidth(), unitPrice6.getHeight());
		amount7 = SwingUtil.textField("amount7", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, amount6.getX(), amount6.getY()+amount6.getHeight(), amount6.getWidth(), amount6.getHeight());
		
		JLabel lblTotalSales = SwingUtil.label("Total Sales (VAT Inclusive) :", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, qty7.getX(), qty7.getY()+qty7.getHeight()+5, 190, 23);
		txtTotalSales = SwingUtil.textField("totalSales", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblTotalSales.getX()+lblTotalSales.getWidth()+3, lblTotalSales.getY(), 150, qty7.getHeight());
		
		JLabel lblLessVat = SwingUtil.label("Less: VAT :", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, txtTotalSales.getX()+txtTotalSales.getWidth()+3, txtTotalSales.getY(), 160, 23);
		txtLessVat = SwingUtil.textField("lessVat", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblLessVat.getX()+lblLessVat.getWidth()+3, lblLessVat.getY(), 125, qty7.getHeight());
		
		JLabel lblVatableSales = SwingUtil.label("VATables Sales :", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblTotalSales.getX(), lblTotalSales.getY()+lblTotalSales.getHeight()+5, 135, 23);
		int s = lblVatableSales.getX()+lblVatableSales.getWidth()+6;
		
		txtVatableSales = SwingUtil.textField("vs", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblVatableSales.getX()+lblVatableSales.getWidth()+3, lblVatableSales.getY(), lblLessVat.getX()-s, qty7.getHeight());
		
		JLabel lblAmountNetVat = SwingUtil.label("Amount:Net of VAT:", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, txtVatableSales.getX()+txtVatableSales.getWidth()+3, txtVatableSales.getY(), lblLessVat.getWidth(), 23);
		lblAmountNetVat.setToolTipText("Amount:Net of VAT");
		txtAmountNetVat = SwingUtil.textField("amountNetVat", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblAmountNetVat.getX()+lblAmountNetVat.getWidth()+3, lblAmountNetVat.getY(), txtLessVat.getWidth(), qty7.getHeight());
		
		JLabel lblVatExempt = SwingUtil.label("VAT-Exempt Sales :", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblVatableSales.getX(), lblVatableSales.getY()+lblVatableSales.getHeight()+5, lblVatableSales.getWidth(), 23);
		txtVatExempt = SwingUtil.textField("vatExempt", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblVatExempt.getX()+lblVatExempt.getWidth()+3, lblVatExempt.getY(), lblAmountNetVat.getX()-s, qty7.getHeight());
		
		JLabel lblLessDis = SwingUtil.label("Less:SC/PWD Discount:", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, txtVatExempt.getX()+txtVatExempt.getWidth()+3, txtVatExempt.getY(), lblLessVat.getWidth(), 23);
		lblLessDis.setToolTipText("Less:SC/PWD Discount");
		txtLessDis = SwingUtil.textField("txtLessDis", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblLessDis.getX()+lblLessDis.getWidth()+3, lblLessDis.getY(), txtLessVat.getWidth(), qty7.getHeight());
		
		JLabel lblZeroRated = SwingUtil.label("Zero Rated Sales :", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblVatExempt.getX(), lblVatExempt.getY()+lblVatExempt.getHeight()+5, lblVatableSales.getWidth(), 23);
		txtZeroRated = SwingUtil.textField("zrs", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblZeroRated.getX()+lblZeroRated.getWidth()+3, lblZeroRated.getY(), lblLessDis.getX()-s, qty7.getHeight());
		
		JLabel lblAmountDue = SwingUtil.label("Amount Due:", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, txtZeroRated.getX()+txtZeroRated.getWidth()+3, txtZeroRated.getY(), lblLessVat.getWidth(), 23);
		lblAmountDue.setToolTipText("Amount Due");
		txtAmountDue = SwingUtil.textField("txtAmountDue", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblAmountDue.getX()+lblAmountDue.getWidth()+3, lblAmountDue.getY(), txtLessVat.getWidth(), qty7.getHeight());
		
		JLabel lblVatAmount = SwingUtil.label("VAT Amount :", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblZeroRated.getX(), lblZeroRated.getY()+lblZeroRated.getHeight()+5, lblVatableSales.getWidth(), 23);
		txtVatAmount = SwingUtil.textField("vatAmount", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblVatAmount.getX()+lblVatAmount.getWidth()+3, lblVatAmount.getY(), lblAmountDue.getX()-s, qty7.getHeight());
		
		JLabel lblTotalAmountDue = SwingUtil.label("Total Amount Due:", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, txtVatAmount.getX()+txtVatAmount.getWidth()+3, txtVatAmount.getY(), lblLessVat.getWidth(), 23);
		lblTotalAmountDue.setToolTipText("Total Amount Due");
		txtTotalAmountDue = SwingUtil.textField("totalAmountDue", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblTotalAmountDue.getX()+lblTotalAmountDue.getWidth()+3, lblTotalAmountDue.getY(), txtLessVat.getWidth(), qty7.getHeight());
		
		JLabel lblCust = SwingUtil.label("Customer's Name :", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, panelContainer2.getX(), panelContainer2.getY()+panelContainer2.getHeight()+7, lblVatableSales.getWidth(), 23);
		txtCust = SwingUtil.textField("customerName", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblCust.getX()+lblCust.getWidth()+3, lblCust.getY(), lblAmountDue.getX()-s, qty7.getHeight());
		
		JLabel lblBy = SwingUtil.label("By :", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, txtCust.getX()+txtCust.getWidth()+5, txtCust.getY(), 30, 23);
		int t = lblBy.getX()+lblBy.getWidth();
		txtBy = SwingUtil.textField("by", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK, lblBy.getX()+lblBy.getWidth()+3, lblBy.getY(), panelContainer2.getWidth()-t, qty7.getHeight());
		txtBy.setText(SetPreferences.getProperietor());
		
		panelContainer2.add(tfQty);
		panelContainer2.add(tfUnit);
		panelContainer2.add(tfDescription);
		panelContainer2.add(tfUnitPrice);
		panelContainer2.add(tfAmount);
		panelContainer2.add(qty);
		panelContainer2.add(unit);
		panelContainer2.add(des);
		panelContainer2.add(unitPrice);
		panelContainer2.add(amount);
		
		panelContainer2.add(qty2);
		panelContainer2.add(unit2);
		panelContainer2.add(des2);
		panelContainer2.add(unitPrice2);
		panelContainer2.add(amount2);
		
		panelContainer2.add(qty3);
		panelContainer2.add(unit3);
		panelContainer2.add(des3);
		panelContainer2.add(unitPrice3);
		panelContainer2.add(amount3);
		
		panelContainer2.add(qty4);
		panelContainer2.add(unit4);
		panelContainer2.add(des4);
		panelContainer2.add(unitPrice4);
		panelContainer2.add(amount4);
		
		panelContainer2.add(qty5);
		panelContainer2.add(unit5);
		panelContainer2.add(des5);
		panelContainer2.add(unitPrice5);
		panelContainer2.add(amount5);

		panelContainer2.add(qty6);
		panelContainer2.add(unit6);
		panelContainer2.add(des6);
		panelContainer2.add(unitPrice6);
		panelContainer2.add(amount6);

		panelContainer2.add(qty7);
		panelContainer2.add(unit7);
		panelContainer2.add(des7);
		panelContainer2.add(unitPrice7);
		panelContainer2.add(amount7);
		
		panelContainer2.add(lblTotalSales);
		panelContainer2.add(txtTotalSales);
		panelContainer2.add(lblLessVat);
		panelContainer2.add(txtLessVat);
		panelContainer2.add(lblVatableSales);
		panelContainer2.add(txtVatableSales);
		panelContainer2.add(lblAmountNetVat);
		panelContainer2.add(txtAmountNetVat);
		panelContainer2.add(lblVatExempt);
		panelContainer2.add(txtVatExempt);
		panelContainer2.add(lblLessDis);
		panelContainer2.add(txtLessDis);
		panelContainer2.add(lblZeroRated);
		panelContainer2.add(txtZeroRated);
		panelContainer2.add(lblAmountDue);
		panelContainer2.add(txtAmountDue);
		panelContainer2.add(lblVatAmount);
		panelContainer2.add(txtVatAmount);
		panelContainer2.add(lblTotalAmountDue);
		panelContainer2.add(txtTotalAmountDue);
		
		panelCon2.add(lblCust);
		panelCon2.add(txtCust);
		panelCon2.add(lblBy);
		panelCon2.add(txtBy);
		
		panelCon2.add(panelContainer2);

	}
	
	private void printView() {
		btnPrint = SwingUtil.button("Preview", "print", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK);
		btnPrint.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPrint.setToolTipText("Print Preview (Ctrl+P)");
		btnPrint.setBounds(((txtBy.getX()+txtBy.getWidth()/2)-15), txtBy.getY()+txtBy.getHeight()+13, 100, 30);
		btnPrint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ShowPrintDialog(txtName, txtAddress, txtTin, txtTerm, txtOsca, txtCh, txtBusiness, qty, qty2, qty3, qty4, qty5, qty6, qty7, unit, unit2, unit3, unit4, unit5, unit6, unit7, des, des2, des3, des4, des5, des6, des7, unitPrice, unitPrice2, unitPrice3, unitPrice4, unitPrice5, unitPrice6, unitPrice7, amount, amount2, amount3, amount4, amount5, amount6, amount7, txtTotalSales, txtVatableSales, txtVatExempt, txtZeroRated, txtVatAmount, txtLessVat, txtAmountNetVat, txtLessDis, txtAmountDue, txtTotalAmountDue, txtCust, txtBy, f.format(dateChooser.getDate())).setVisible(true);
			}
		});
		
		panelCon2.add(btnPrint);
	}
	
	private void clear() {
		JButton btnClear = SwingUtil.button("Clear", "clear", SwingUtil.myFont(swingUtil.FONT, swingUtil.FONT_STYLE, swingUtil.FONT_SIZE), Color.BLACK);
		btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClear.setBounds(btnPrint.getX()-105, txtBy.getY()+txtBy.getHeight()+13, 100, 30);
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to clear?", "Clear", JOptionPane.YES_NO_OPTION);
				if(confirm == 0) {
					txtName.setText("");
					txtAddress.setText("");
					txtTin.setText("");
					txtTerm.setText("");
					txtOsca.setText("");
					txtCh.setText("");
					txtBusiness.setText("");
					
					qty.setText("");
					unit.setText("");
					des.setText("");
					unitPrice.setText("");
					amount.setText("");
					
					qty2.setText("");
					unit2.setText("");
					des2.setText("");
					unitPrice2.setText("");
					amount2.setText("");
					
					qty3.setText("");
					unit3.setText("");
					des3.setText("");
					unitPrice3.setText("");
					amount3.setText("");
					
					qty4.setText("");
					unit4.setText("");
					des4.setText("");
					unitPrice4.setText("");
					amount4.setText("");
					
					qty5.setText("");
					unit5.setText("");
					des5.setText("");
					unitPrice5.setText("");
					amount5.setText("");
					
					qty6.setText("");
					unit6.setText("");
					des6.setText("");
					unitPrice6.setText("");
					amount6.setText("");
					
					qty7.setText("");
					unit7.setText("");
					des7.setText("");
					unitPrice7.setText("");
					amount7.setText("");
					
					txtTotalSales.setText("");
					txtVatableSales.setText("");
					txtVatExempt.setText("");
					txtZeroRated.setText("");
					txtVatAmount.setText("");
					
					txtLessVat.setText("");
					txtAmountNetVat.setText("");
					txtLessDis.setText("");
					txtAmountDue.setText("");
					txtTotalAmountDue.setText("");
					
					txtCust.setText("");
					txtBy.setText("");
					
				}
			}
		});
		
		panelCon2.add(btnClear);
	}
	
	
	
	private void scrollBarFunctionable() {
		AdjustmentListener adj = new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int changeValue = e.getValue()+e.getValue()+e.getValue();
				int y = 3;
				if(e.getValue() == 0) {
					panelCon2.setBounds(3, 3, panelContainer1.getWidth() - 6, panelContainer1.getHeight()-6);
				}else {
					panelCon2.setBounds(3, y-changeValue, panelContainer1.getWidth() - 6, panelContainer1.getHeight()+panelContainer1.getHeight());
				}
			}
		};
		
		scrollbar.addAdjustmentListener(adj);
	}
}
