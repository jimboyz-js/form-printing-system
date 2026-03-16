package com.jimboyz.printingsystem.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
 * To be put on public repo on my GitHub repository (github.com/jimboyz-js)
 *
 */

public class Main {

	public static void main(String[] args) {
		
		File file = new File("jimBoYz Ni ChOy");
		if(!file.exists()) {
			file.mkdir();
		}
		
		try {
			InputStream is = Main.class.getResourceAsStream("/FPS-UserGuide.pdf");
			if(is != null) {
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				/*
				String line;
				while((line = br.readLine()) != null) {
					System.out.println(line);
				}
				*/
				
				br.close();
			}else {
				System.out.println("Cannot find file");
			}
		}catch(IOException e) {
			ErrorDialog.show(e);
		}
	
		setPrefFile();
		GUIProperties.loadLaf();
		
		File f = new File("jimBoYz Ni ChOy/reportFeb122024.jrxml");
		if(!f.exists()) {
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
