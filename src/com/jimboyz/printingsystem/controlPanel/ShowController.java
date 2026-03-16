package com.jimboyz.printingsystem.controlPanel;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import com.jimboyz.printingsystem.billingStatement.BillingStatementGUI;
import com.jimboyz.printingsystem.chargeInvoice.ChargeInvoicePanelGUI;
import com.jimboyz.printingsystem.layout.MainPanel;
import com.jimboyz.printingsystem.pref.GUIProperties;

public class ShowController {
	
	public void showBillingStatement(JPanel _panel, JPanel panelBillingStatementContainer) {
		_panel.removeAll();
		_panel.revalidate();
		_panel.repaint();
		
		_panel.add(panelBillingStatementContainer, BorderLayout.CENTER);
		panelBillingStatementContainer.add(new BillingStatementGUI(), BorderLayout.CENTER);
	}
	
	public void showChargeInvoice(JPanel _panel, JPanel panelChargeInvoiceContainer) {
		_panel.removeAll();
		_panel.revalidate();
		_panel.repaint();
		
		_panel.add(panelChargeInvoiceContainer, BorderLayout.CENTER);
		panelChargeInvoiceContainer.add(new ChargeInvoicePanelGUI(), BorderLayout.CENTER);
	}
	
	
	public void showHome(JPanel _panel, JPanel homePanel) {
		_panel.setLayout(new BorderLayout());
		_panel.removeAll();
		_panel.revalidate();
		_panel.repaint();
		
		_panel.add(homePanel, BorderLayout.CENTER);
	}
	public void showHome0(JFrame _frame, JPanel homePanel) {
		
		_frame.add(homePanel, BorderLayout.CENTER);
		homePanel.add(new MainPanel(), BorderLayout.CENTER);
	}
	
	public static void showUserGuid() {
		try {
			File file = new File(GUIProperties.HOME_DIR+"/.FPSv1.0.0/FPS-UserGuide.pdf");
			if(file.exists()) {
				Desktop.getDesktop().browse(file.toURI());
			}
			
			System.out.println("The system cannot find the file!");
//			return;
//			Desktop.getDesktop().browse(new File(GUIProperties.HOME_DIR+"/.FPSv1.0.0/FPS-UserGuide.pdf").toURI());
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}
	
	public static void clearData0(JPanel _panel, JFrame frame, JTextField txtName, JTextField txtAddress, JTextField txtTin, JTextField txtTerm, JTextField txtOsca, JTextField txtCh, JTextField txtBusiness, JTextField qty, JTextField qty2, JTextField qty3, JTextField qty4, JTextField qty5, JTextField qty6, JTextField qty7, JTextField unit, JTextField unit2, JTextField unit3, JTextField unit4, JTextField unit5, JTextField unit6, JTextField unit7, JTextField des, JTextField des2, JTextField des3, JTextField des4, JTextField des5, JTextField des6, JTextField des7, JTextField unitPrice, JTextField unitPrice2, JTextField unitPrice3, JTextField unitPrice4, JTextField unitPrice5, JTextField unitPrice6, JTextField unitPrice7, JTextField amount, JTextField amount2, JTextField amount3, JTextField amount4, JTextField amount5, JTextField amount6, JTextField amount7,JTextField txtTotalSales, JTextField txtVatableSales, JTextField txtVatExempt, JTextField txtZeroRated, JTextField txtVatAmount, JTextField txtLessVat, JTextField txtAmountNetVat, JTextField txtLessDis, JTextField txtAmountDue, JTextField txtTotalAmountDue, JTextField txtCust, JTextField txtBy) {
		KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
		String bindingKey = keyStroke.toString();
		
		InputMap inputMap = _panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		ActionMap actionMap = _panel.getActionMap();
		
		inputMap.put(keyStroke, bindingKey);
		actionMap.put(bindingKey, new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to clear?","Clear", JOptionPane.YES_NO_OPTION);
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
		
		
	}
	
	public static void clearData1(JPanel _panel, JFrame frame, JTextField txtName, JTextField txtAddress, JTextField txtTin, JTextField txtTerm, JTextField txtOsca, JTextField txtCh, JTextField txtBusiness, JTextField qty, JTextField qty2, JTextField qty3, JTextField qty4, JTextField qty5, JTextField qty6, JTextField qty7, JTextField qty8, JTextField qty9, JTextField qty10, JTextField unit, JTextField unit2, JTextField unit3, JTextField unit4, JTextField unit5, JTextField unit6, JTextField unit7,  JTextField unit8,  JTextField unit9,  JTextField unit10, JTextField des, JTextField des2, JTextField des3, JTextField des4, JTextField des5, JTextField des6, JTextField des7, JTextField des8, JTextField des9, JTextField des10, JTextField unitPrice, JTextField unitPrice2, JTextField unitPrice3, JTextField unitPrice4, JTextField unitPrice5, JTextField unitPrice6, JTextField unitPrice7,  JTextField unitPrice8,  JTextField unitPrice9,  JTextField unitPrice10, JTextField amount, JTextField amount2, JTextField amount3, JTextField amount4, JTextField amount5, JTextField amount6, JTextField amount7, JTextField amount8, JTextField amount9, JTextField amount10, JTextField txtTotalSales, JTextField txtVatableSales, JTextField txtVatExempt, JTextField txtZeroRated, JTextField txtVatAmount, JTextField txtLessVat, JTextField txtAmountNetVat, JTextField txtLessDis, JTextField txtAmountDue, JTextField txtTotalAmountDue, JTextField txtCust, JTextField txtBy) {
		KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
		String bindingKey = keyStroke.toString();
		
		InputMap inputMap = _panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		ActionMap actionMap = _panel.getActionMap();
		
		inputMap.put(keyStroke, bindingKey);
		actionMap.put(bindingKey, new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to clear?","Clear", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
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
					
					qty8.setText("");
					unit8.setText("");
					des8.setText("");
					unitPrice8.setText("");
					amount8.setText("");
					
					qty9.setText("");
					unit9.setText("");
					des9.setText("");
					unitPrice9.setText("");
					amount9.setText("");
					
					qty10.setText("");
					unit10.setText("");
					des10.setText("");
					unitPrice10.setText("");
					amount10.setText("");
					
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
	}
}
