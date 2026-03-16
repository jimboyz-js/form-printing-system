package com.jimboyz.printingsystem.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jimboyz.printingsystem.err.ErrorDialog;
import com.jimboyz.printingsystem.layout.MainGUI;
import com.jimboyz.printingsystem.pref.GUIProperties;
import com.jimboyz.printingsystem.pref.JRXMLSettings;

/**
 * 
 * @author jimboy Ni ChOy!!!
 * Date Finished: Jan. 30, 2024
 * Date Update: March 15, 2026 SUN.
 * Update data and remove some personal images
 * To be put in public (repo) in my GitHub repository (github.com/jimboyz-js)
 *
 */

public class Main {

	public static void main(String[] args) {
		
		File file = new File(GUIProperties.HOME_DIR+"/.fps-invoice-print-v1.0.1");
		if(!file.exists()) {
			file.mkdir();
		}
		
		// LICENSE
		Path output = Path.of(GUIProperties.HOME_DIR + File.separator + ".fps-invoice-print-v1.0.1" + File.separator + "LICENSE");
		
		if(!Files.exists(output)) {
			try(InputStream is = Main.class.getResourceAsStream("/com/jimboyz/user/LICENSE")) {
				if(is == null) {
					throw new RuntimeException("Resource not found: " + output);
				}
				Files.copy(is, output);
//				Files.copy(is, output, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("File extracted to: " + output.toAbsolutePath());
			} catch(Exception e) {
				ErrorDialog.show(e);
			}
		}
	
		setPrefFile();
		GUIProperties.loadLaf();
		
		File f = new File(GUIProperties.HOME_DIR + File.separator + ".fps-invoice-print-v1.0.1" + File.separator + "reportFeb122024.jrxml");
		if(!f.exists()) {
			JRXMLSettings.getJrxmlSettings();
		}
		
		File fCi = new File(GUIProperties.HOME_DIR + File.separator + ".fps-invoice-print-v1.0.1" + File.separator + "reportMarch162026.jrxml");
		if(!fCi.exists()) {
			JRXMLSettings.getJrxmlSettings();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new MainGUI();
				}catch(Exception e) {
					ErrorDialog.show(e);
				}
			}
		});
	}
	
	public static void restore() {

		try {
			(new File(GUIProperties.HOME_DIR+"/.FPSv1.0.0")).mkdirs();
			(new File(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs")).createNewFile();
			Properties properties = new Properties();
			properties.put("bsName", "JIMBOYZ TRANSPORT SERVICES"); // Company Name (Billing Statement)
			properties.put("ciName", "JIMBOYZ AGGREGATES TRADING"); // Company Name (Charge Invoice)
			properties.put("bstin", "122-XXX-XXX-000"); // BS TIN No.
			properties.put("citin", "122-XXX-XXX-00004"); // CI TIN No.
			properties.put("address", "P-6, St. Brgy. Mun. Province");
			properties.put("Laf", "System"); // Look And Feel (LAF)
			properties.put("Proprietor", "JIMBOYZ NI CHOY"); // Proprietor Name (example only)
			properties.put("dateFormat", "MM/dd/yyyy");
			properties.put("dateFont", "Dialog");
			properties.put("dateFontStyle", "Plain");
			properties.put("dateFontSize", "11");
			properties.put("font", "Times New Roman");
			properties.put("fontStyle", "Plain");
			properties.put("fontSize", "16");
			properties.put("fontColor", "Black");
			
			properties.store(new FileOutputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"), "jimBoYz Ni ChOy!!!");
			
			// JRXMLSettings
			restoreJRXMLSettings();
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		try {
			GUIProperties.loadLaf();
			UIManager.setLookAndFeel(GUIProperties.PLAF_SYSTEM);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author jimBoYz Ni ChOy!!!
	 * March 16, 2026 Mon. 6:27-28 PM
	 */
	public static void restoreJRXMLSettings() {
		setJrxmlSettings();
		// Load JRXML File
		JRXMLSettings.getJrxmlSettings();
	}
	
	public static void setJrxmlSettings() {
		try {
			(new File(GUIProperties.HOME_DIR+"/.FPSv1.0.0")).mkdirs();
			(new File(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs")).createNewFile();
			Properties properties = new Properties();
			properties.put("jrxmlFont", "Calibri");
			properties.put("isBold", "false");
			properties.put("isItalic", "false");
			properties.put("isUnderline", "false");
			properties.put("isStrikeThrough", "false");
			properties.put("jrxmlAddressFontSize", "7.0");
			properties.put("jrxmlFontSize", "8.0");
			properties.put("jrxmlFontColor", "Black");
			properties.store(new FileOutputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs"), "jimBoYz Ni ChOy!!!");
			
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
	}
	
	public static void setPrefFile() {
		if(!(new File(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs")).exists()) {
			restore();
		}
		
		if(!(new File(GUIProperties.HOME_DIR+"/.FPSv1.0.0/JRXMLFontSettings.prefs")).exists()) {
			setJrxmlSettings();
		}
	}
	
	@SuppressWarnings("unused")
	private void setDefaultLookAndFeel() {
		if(new GUIProperties().isTextureLook()) {

			try {
				GUIProperties.loadLaf();
				UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}

		}
	}
}
