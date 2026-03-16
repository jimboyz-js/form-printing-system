package com.jimboyz.printingsystem.pref;

import java.awt.Frame;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import com.jimboyz.printingsystem.err.ErrorDialog;

public class SetPreferences {
	
	static String home_dir = System.getProperty("user.home");
	
	public static void setPref(String bsName, String ciName, String bstin, String citin, String address, String prop, String laf, String dateFormat, String dateFont, String dateFontStyle, String dateFontSize, String font, String fontStyle, String fontSize, String fontColor) {
	
		try {
			
			(new File(home_dir+"/.FPSv1.0.0")).mkdirs();
			(new File(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs")).createNewFile();
			Properties properties = new Properties();
			properties.put("bsName", bsName);
			properties.put("ciName", ciName);
			properties.put("bstin", bstin);
			properties.put("citin", citin);
			properties.put("address", address);
			properties.put("Proprietor", prop);
			properties.put("Laf", laf);
			properties.put("dateFormat", dateFormat);
			properties.put("dateFont", dateFont);
			properties.put("dateFontStyle", dateFontStyle);
			properties.put("dateFontSize", dateFontSize);
			properties.put("font", font);
			properties.put("fontStyle", fontStyle);
			properties.put("fontSize", fontSize);
			properties.put("fontColor", fontColor);
			
			properties.store(new FileOutputStream(home_dir+"/.FPSv1.0.0/Properties.prefs"), "jimBoYz Ni ChOy!!!");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperietor() {
		String properietor = null;
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			properietor = properties.getProperty("Proprietor");
			
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return properietor;
	}
	
	public static void updatePref() {
		for(Window window : Frame.getFrames()) {
			SwingUtilities.updateComponentTreeUI(window);
		}
	}
	
	public static void updatePref(JDialog dialog) {
		SwingUtilities.updateComponentTreeUI(dialog);
		
	}
}
