package com.jimboyz.printingsystem.pref;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import com.jimboyz.printingsystem.controlPanel.ChargeInvoiceReport;
import com.jimboyz.printingsystem.controlPanel.JasperReportGenerator;
import com.jimboyz.printingsystem.err.ErrorDialog;
import com.jimboyz.printingsystem.layout.MyInterface;
import com.jimboyz.printingsystem.layout.SwingUtil;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class JRXMLSettings extends JDialog implements MyInterface {
	
	private Properties properties;
	
	private static JComboBox<String> cmbFont;
	private static JComboBox<String> cmbFontStyle;
	private static JComboBox<String> cmbAddressFontSize;
	private static JComboBox<String> cmbFontSize;
	private static JComboBox<String> cmbFontColor;
	
	private static JCheckBox chkBold;
	private static JCheckBox chkItalic;
	private static JCheckBox chkUnderline;
	private static JCheckBox chkStrikeThrough;
	
	
	public JRXMLSettings() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("JRXML Font Settings");
		this.setSize(new Dimension(360, 270));
		this.setLocationRelativeTo(null);
		this.setIconImage(frame.getIconImage());
		this.setLayout(new BorderLayout());
		
		init();
	}
	
	private void init() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		
		panel.add(SwingUtil.label("<html><b>Page Settings:</b><html>"), "wrap, span, growx, pushx");
		
		panel.add(SwingUtil.label("Font: "));
		panel.add(cmbFont(), "wrap, growx, pushx");
		
		panel.add(SwingUtil.label("Address Font Size: "));
		panel.add(cmbAddressFontSize(),"wrap, pushx, growx");
		
		panel.add(SwingUtil.label("Font Size: "));
		panel.add(cmbFontSize(), "wrap, growx, pushx");
		
		panel.add(SwingUtil.label("Font Color: "));
		panel.add(cmbFontColor(), "wrap, growx, pushx");
		
		panel.add(new JSeparator(), "span, wrap, growx, pushx");
		
		panel.add(SwingUtil.label("<html><b>Font Style:</b></html>"), "wrap, pushx, growx");
		
		JPanel panelChk = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		panelChk.add(SwingUtil.label("Bold:"));
		panelChk.add(chkBold());
		
		panelChk.add(SwingUtil.label("Italic:"));
		panelChk.add(chkItalic());
		
		panelChk.add(SwingUtil.label("Underline:"));
		panelChk.add(chkUnderline());
		
		panelChk.add(SwingUtil.label("Strike Through:"));
		panelChk.add(chkStrikeThrough());
		
		
		panel.add(panelChk, "span, pushx, growx");
		
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(panel);
		
		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.add(panel, BorderLayout.SOUTH);
		panel.add(btnOk());
		panel.add(btnCancel());
		
		JRXMLSettings.this.setModal(true);
	}
	
	private Component cmbAddressFontSize() {
		String[] fontSizeList = {"7.0","8.0","9.0", "10.0", "11.0", "12.0", "15.0", "17.0", "20.0"};
		cmbAddressFontSize = new JComboBox<>(fontSizeList);
		cmbAddressFontSize.setEnabled(true);
		cmbAddressFontSize.setEditable(true);
		
		try {
			properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"));
			String fontSize = properties.getProperty("jrxmlAddressFontSize");
			cmbAddressFontSize.setSelectedItem(fontSize);
			
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return cmbAddressFontSize;
	}

	private JComboBox<String> cmbFont(){
		String[] fontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		cmbFont = new JComboBox<>(fontList);
		
		try {
			properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"));
			String selectedFont = properties.getProperty("jrxmlFont");
			cmbFont.setSelectedItem(selectedFont);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return cmbFont;
	}
	
	private JCheckBox chkBold() {
		chkBold = new JCheckBox();
		chkBold.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chkBold.setToolTipText("Bold");
		
		try {
			properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"));
			String bold = properties.getProperty("isBold");
			boolean isBold = Boolean.parseBoolean(bold);
			chkBold.setSelected(isBold);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return chkBold;
	}
	
	private JCheckBox chkItalic() {
		chkItalic = new JCheckBox();
		chkItalic.setToolTipText("Italic");
		chkItalic.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		try {
			properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"));
			String bold = properties.getProperty("isItalic");
			boolean isBold = Boolean.parseBoolean(bold);
			chkItalic.setSelected(isBold);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return chkItalic;
	}
	
	private JCheckBox chkUnderline() {
		chkUnderline = new JCheckBox();
		chkUnderline.setToolTipText("Underline");
		chkUnderline.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		try {
			properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"));
			String bold = properties.getProperty("isUnderline");
			boolean isBold = Boolean.parseBoolean(bold);
			chkUnderline.setSelected(isBold);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return chkUnderline;
	}
	
	private JCheckBox chkStrikeThrough() {
		chkStrikeThrough = new JCheckBox();
		chkStrikeThrough.setToolTipText("Strike Through");
		chkStrikeThrough.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		try {
			properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"));
			String bold = properties.getProperty("isStrikeThrough");
			boolean isBold = Boolean.parseBoolean(bold);
			chkStrikeThrough.setSelected(isBold);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return chkStrikeThrough;
	}
	
	@SuppressWarnings("unused")
	private JComboBox<String> cmbFontStyle(){
		String[] fontStyleList = {"Plain", "Bold","Italic","Roman Baseline", "Center Baseline", "Hanging Baseline", "True Type Font", "Type1 Font"};
		cmbFontStyle = new JComboBox<>(fontStyleList);
		
		try {
			properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"));
			String selectedFontStyle = properties.getProperty("jrxmlFontStyle");
			cmbFontStyle.setSelectedItem(selectedFontStyle);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		
		return cmbFontStyle;
	}
	
	private JComboBox<String> cmbFontSize(){
		String[] fontSizeList = {"7.0","8.0","9.0", "10.0", "11.0", "12.0", "15.0", "17.0", "20.0"};
		cmbFontSize = new JComboBox<>(fontSizeList);
		cmbFontSize.setEnabled(true);
		cmbFontSize.setEditable(true);
		try {
			properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"));
			String selectedFontStyle = properties.getProperty("jrxmlFontSize");
			cmbFontSize.setSelectedItem(selectedFontStyle);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		
		return cmbFontSize;
	}
	
	private JComboBox<String> cmbFontColor(){
		String[] fontColorList = {"Blue", "Red", "Gray", "Cyan", "Green", "Black"};
		cmbFontColor = new JComboBox<>(fontColorList);
		
		try {
			properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"));
			String selectedFontStyle = properties.getProperty("jrxmlFontColor");
			switch(selectedFontStyle) {
			case"#0000FF":
				selectedFontStyle = "Blue";
				break;
			case"#FF0000":
				selectedFontStyle = "Red";
				break;
			case"#808080":
				selectedFontStyle = "Gray";
				break;
			case"#00FFFF":
				selectedFontStyle = "Cyan";
				break;
			case"#008000":
				selectedFontStyle = "Green";
				break;
			case"#000000":
				selectedFontStyle = "Black";
				break;
			}
			cmbFontColor.setSelectedItem(selectedFontStyle);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		
		return cmbFontColor;
	}
	
	private JButton btnOk() {
		JButton btn = SwingUtil.button("OK", "ok", SwingUtil.myFont("Dialog", Font.PLAIN, 11), Color.BLACK);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setSize(new Dimension(30, 20));
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setJrxmlSettings();
				getJrxmlSettings();
				JRXMLSettings.this.setVisible(false);
			}
		});
		return btn;
	}
	
	private JButton btnCancel() {
		JButton btn = SwingUtil.button("Cancel", "cancel", SwingUtil.myFont("Dialog", Font.PLAIN, 11), Color.BLACK);
		btn.setSize(new Dimension(30, 20));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JRXMLSettings.this.setVisible(false);
			}
		});
		return btn;
	}
	
	private static void setJrxmlSettings() {
		try {
			(new File(GUIProperties.HOME_DIR+"/.FPSv1.0.0")).mkdirs();
			(new File(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs")).createNewFile();
			String foreColor = cmbFontColor.getSelectedItem().toString();
			switch(foreColor) {
			case"Blue":
				foreColor = "#0000FF";
				break;
			case"Red":
				foreColor = "#FF0000";
				break;
			case"Gray":
				foreColor = "#808080";
				break;
			case"Cyan":
				foreColor = "#00FFFF";
				break;
			case"Green":
				foreColor = "#008000";
				break;
			case"Black":
				foreColor = "#000000";
				break;
			}
			Properties properties = new Properties();
			properties.put("jrxmlFont", cmbFont.getSelectedItem().toString());
			
			boolean isBold = false;
			boolean isItalic = false;
			boolean isUnderline = false;
			boolean isStrikeThrough = false;
			
			if(chkBold.isSelected()) {
				isBold = true;
			}
			
			if(chkItalic.isSelected()) {
				isItalic = true;
			}
			
			if(chkUnderline.isSelected()) {
				isUnderline = true;
			}
			
			if(chkStrikeThrough.isSelected()) {
				isStrikeThrough = true;
			}
			
			properties.put("isBold", String.valueOf(isBold));
			properties.put("isItalic", String.valueOf(isItalic));
			properties.put("isUnderline", String.valueOf(isUnderline));
			properties.put("isStrikeThrough", String.valueOf(isStrikeThrough));
			properties.put("jrxmlAddressFontSize", cmbAddressFontSize.getSelectedItem().toString());
			properties.put("jrxmlFontSize", cmbFontSize.getSelectedItem().toString());
			properties.put("jrxmlFontColor", foreColor);
			properties.store(new FileOutputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"), "jimBoYz Ni ChOy!!!");
			
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
	}
	
	public static void getJrxmlSettings() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"));
			String font = properties.getProperty("jrxmlFont");
			String isBold = properties.getProperty("isBold");
			String isItalic = properties.getProperty("isItalic");
			String isUnderline = properties.getProperty("isUnderline");
			String isStrikeThrough = properties.getProperty("isStrikeThrough");
			String addressFontSize = properties.getProperty("jrxmlAddressFontSize");
			String fontSize = properties.getProperty("jrxmlFontSize");
			String fontColor = properties.getProperty("jrxmlFontColor");
			
			File file = new File("jimBoYz Ni ChOy/reportFeb122024.jrxml");
			File f = new File("jimBoYz Ni ChOy/jj.b");
			file.createNewFile();
			f.createNewFile();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			FileWriter write = new FileWriter(f);
			
			writer.write(JasperReportGenerator.setBillingReport(font, isBold, isItalic, isUnderline, isStrikeThrough, addressFontSize, fontSize, fontColor));
			write.write(ChargeInvoiceReport.setChargeInvoiceReport(font, isBold, isItalic, isUnderline, isStrikeThrough, addressFontSize, fontSize, fontColor));
			
			
			writer.close();
			write.close();
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
	}

}
