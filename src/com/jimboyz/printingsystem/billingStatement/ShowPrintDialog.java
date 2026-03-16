package com.jimboyz.printingsystem.billingStatement;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jimboyz.printingsystem.layout.MyInterface;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

public class ShowPrintDialog extends JDialog implements MyInterface {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPanel;
	
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
	
	private JTextField txtBy;
	
	private String date;
	
	
	public ShowPrintDialog(JTextField txtName, JTextField txtAddress, JTextField txtTin, JTextField txtTerm, JTextField txtOsca, JTextField txtCh, JTextField txtBusiness, JTextField qty, JTextField qty2, JTextField qty3, JTextField qty4, JTextField qty5, JTextField qty6, JTextField qty7, JTextField unit, JTextField unit2, JTextField unit3, JTextField unit4, JTextField unit5, JTextField unit6, JTextField unit7, JTextField des, JTextField des2, JTextField des3, JTextField des4, JTextField des5, JTextField des6, JTextField des7, JTextField unitPrice, JTextField unitPrice2, JTextField unitPrice3, JTextField unitPrice4, JTextField unitPrice5, JTextField unitPrice6, JTextField unitPrice7, JTextField amount, JTextField amount2, JTextField amount3, JTextField amount4, JTextField amount5, JTextField amount6, JTextField amount7, JTextField txtTotalSales, JTextField txtVatableSales, JTextField txtVatExempt, JTextField txtZeroRated, JTextField txtVatAmount, JTextField txtLessVat, JTextField txtAmountNetVat, JTextField txtLessDis, JTextField txtAmountDue, JTextField txtTotalAmountDue, JTextField txtCust, JTextField txtBy, String date) {
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		this.setLocationRelativeTo(null);
		this.setTitle("Print");
		this.setIconImage(frame.getIconImage());
		this.getContentPane().setLayout(new BorderLayout());
		
		this.setModal(true);
		
		this.txtName = txtName;
		this.txtAddress = txtAddress;
		this.txtTerm = txtTerm;
		this.txtTin = txtTin;
		this.txtBusiness = txtBusiness;
		this.txtCh = txtCh;
		this.txtOsca = txtOsca;
	
		this.qty = qty;
		this.qty2 = qty2;
		this.qty3 = qty3;
		this.qty4 = qty4;
		this.qty5 = qty5;
		this.qty6 = qty6;
		this.qty7 = qty7;
		this.unit = unit;
		this.unit2 = unit2;
		this.unit3 = unit3;
		this.unit4 = unit4;
		this.unit5 = unit5;
		this.unit6 = unit6;
		this.unit7 = unit7;
		this.des = des;
		this.des2 = des2;
		this.des3 = des3;
		this.des4 = des4;
		this.des5 = des5;
		this.des6 = des6;
		this.des7 = des7;
		this.unitPrice = unitPrice;
		this.unitPrice2 = unitPrice2;
		this.unitPrice3 = unitPrice3;
		this.unitPrice4 = unitPrice4;
		this.unitPrice5 = unitPrice5;
		this.unitPrice6 = unitPrice6;
		this.unitPrice7 = unitPrice7;
		this.amount = amount;
		this.amount2 = amount2;
		this.amount3 = amount3;
		this.amount4 = amount4;
		this.amount5 = amount5;
		this.amount6 = amount6;
		this.amount7 = amount7;
		this.txtTotalSales = txtTotalSales;
		this.txtLessVat = txtLessVat;
		this.txtVatableSales = txtVatableSales;
		this.txtTotalAmountDue = txtTotalAmountDue;
		this.txtVatAmount = txtVatAmount;
		this.txtAmountDue = txtAmountDue;
		this.txtZeroRated = txtZeroRated;
		this.txtLessDis = txtLessDis;
		this.txtVatExempt = txtVatExempt;
		this.txtAmountNetVat = txtAmountNetVat;
		this.txtCust = txtCust;
		this.txtBy = txtBy;
		this.date = date;
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		exit();
		loadPrint();
	}
	
	private void exit() {
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				frame.setTitle("For Printing System - FPS v. 1.0.0 - Billing Statement");
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public String setDate(String date) {
		return date;
	}
	
	public void loadPrint() {
		
		try {
			String name = txtName.getText().toString();
			String addr = txtAddress.getText().toString();
			String term = txtTerm.getText().toString();
			String tin = txtTin.getText().toString();
			String business = txtBusiness.getText().toString();
			String cardholder = txtCh.getText().toString();
			String osca = txtOsca.getText().toString();
			String qty1 = qty.getText().toString();
			String qty_2 = qty2.getText().toString();
			String qty_3 = qty3.getText().toString();
			String qty_4 = qty4.getText().toString();
			String qty_5 = qty5.getText().toString();
			String qty_6 = qty6.getText().toString();
			String qty_7 = qty7.getText().toString();
			String unit_1 = unit.getText().toString();
			String unit_2 = unit2.getText().toString();
			String unit_3 = unit3.getText().toString();
			String unit_4 = unit4.getText().toString();
			String unit_5 = unit5.getText().toString();
			String unit_6 = unit6.getText().toString();
			String unit_7 = unit7.getText().toString();
			String des_1 = des.getText().toString();
			String des_2 = des2.getText().toString();
			String des_3 = des3.getText().toString();
			String des_4 = des4.getText().toString();
			String des_5 = des5.getText().toString();
			String des_6 = des6.getText().toString();
			String des_7 = des7.getText().toString();
			String unitPrice_1 = unitPrice.getText().toString();
			String unitPrice_2 = unitPrice2.getText().toString();
			String unitPrice_3 = unitPrice3.getText().toString();
			String unitPrice_4 = unitPrice4.getText().toString();
			String unitPrice_5 = unitPrice5.getText().toString();
			String unitPrice_6 = unitPrice6.getText().toString();
			String unitPrice_7 = unitPrice7.getText().toString();
			String amount_1 = amount.getText().toString();
			String amount_2 = amount2.getText().toString();
			String amount_3 = amount3.getText().toString();
			String amount_4 = amount4.getText().toString();
			String amount_5 = amount5.getText().toString();
			String amount_6 = amount6.getText().toString();
			String amount_7 = amount7.getText().toString();
			String totalSales = txtTotalSales.getText().toString();
			String lessVat = txtLessVat.getText().toString();
			String vatableSales = txtVatableSales.getText().toString();
			String totalAmountDue = txtTotalAmountDue.getText().toString();
			String vatAmount = txtVatAmount.getText().toString();
			String amountDue = txtAmountDue.getText().toString();
			String zrs = txtZeroRated.getText().toString();
			String lessDis = txtLessDis.getText().toString();
			String vatExempt = txtVatExempt.getText().toString();
			String amountNetVat = txtAmountNetVat.getText().toString();
			String cust = txtCust.getText().toString();
			String by = txtBy.getText().toString();
			
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("name", name);
			hashMap.put("address", addr);
			hashMap.put("term", term);
			hashMap.put("tin", tin);
			hashMap.put("businessStyle", business);
			hashMap.put("cardholder", cardholder);
			hashMap.put("osca", osca);
			hashMap.put("qty1", qty1);
			hashMap.put("qty2", qty_2);
			hashMap.put("qty3", qty_3);
			hashMap.put("qty4", qty_4);
			hashMap.put("qty5", qty_5);
			hashMap.put("qty6", qty_6);
			hashMap.put("qty7", qty_7);
			hashMap.put("unit1", unit_1);
			hashMap.put("unit2", unit_2);
			hashMap.put("unit3", unit_3);
			hashMap.put("unit4", unit_4);
			hashMap.put("unit5", unit_5);
			hashMap.put("unit6", unit_6);
			hashMap.put("unit7", unit_7);
			hashMap.put("des1", des_1);
			hashMap.put("des2", des_2);
			hashMap.put("des3", des_3);
			hashMap.put("des4", des_4);
			hashMap.put("des5", des_5);
			hashMap.put("des6", des_6);
			hashMap.put("des7", des_7);
			hashMap.put("unitPrice1", unitPrice_1);
			hashMap.put("unitPrice2", unitPrice_2);
			hashMap.put("unitPrice3", unitPrice_3);
			hashMap.put("unitPrice4", unitPrice_4);
			hashMap.put("unitPrice5", unitPrice_5);
			hashMap.put("unitPrice6", unitPrice_6);
			hashMap.put("unitPrice7", unitPrice_7);
			hashMap.put("amount1", amount_1);
			hashMap.put("amount2", amount_2);
			hashMap.put("amount3", amount_3);
			hashMap.put("amount4", amount_4);
			hashMap.put("amount5", amount_5);
			hashMap.put("amount6", amount_6);
			hashMap.put("amount7", amount_7);
			hashMap.put("totalSales", totalSales);
			hashMap.put("lessVat", lessVat);
			hashMap.put("amountNet", amountNetVat);
			hashMap.put("vatables", vatableSales);
			hashMap.put("lessdis", lessDis);
			hashMap.put("amountDue", amountDue);
			hashMap.put("totalAmountDue", totalAmountDue);
			hashMap.put("vatExempt", vatExempt);
			hashMap.put("zrs", zrs);
			hashMap.put("vatAmount", vatAmount);
			hashMap.put("customerName", cust);
			hashMap.put("by", by);
			hashMap.put("date", setDate(date));
			
			contentPanel.removeAll();
			contentPanel.repaint();
			contentPanel.revalidate();
			
			JasperDesign jasperDesign = JRXmlLoader.load("jimBoYz Ni ChOy/reportFeb122024.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hashMap, new JREmptyDataSource());
			
			JRViewer viewer = new JRViewer(jasperPrint);
			contentPanel.add(viewer, BorderLayout.CENTER);
			
		} catch (JRException  e) {
			
			e.printStackTrace();
		}
		
		this.add(contentPanel, BorderLayout.CENTER);
		
	}
}
