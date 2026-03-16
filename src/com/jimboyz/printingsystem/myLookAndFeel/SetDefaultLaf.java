package com.jimboyz.printingsystem.myLookAndFeel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.jimboyz.printingsystem.err.ErrorDialog;
import com.jimboyz.printingsystem.pref.GUIProperties;

public class SetDefaultLaf {
	
	public static void windowsLookAndFeel0() {
		Properties properties = System.getProperties();
		properties.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	}

	public static void systemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(GUIProperties.PLAF_SYSTEM);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	public static void metalLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void nimbusLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void motifLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void windowsLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void windowsClassicLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void textureLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void smartLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void noireLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void acryleLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void aeroLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void aluminumLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void bernsteinLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void fastLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void graphiteLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void hifiLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void lunaLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void mcwinLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void mintLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void customLookAndFeel() {
		try {//JTatoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.custom.CustomLookAndFeel");
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			systemLookAndFeel();
			forCustom();
			e.printStackTrace();
			ErrorDialog.show(e+"\nClass not found. Try to change theme name or contact the System Administrator(JS)");
		}
	}
	
	public static void flatLafLightLookAndFeel() {
		// Set FlatLaf Light theme
        try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        // Optional: Customize UI defaults before creating components
        UIManager.put("Button.arc", 20); // Rounded buttons
        UIManager.put("Component.arc", 15); // Rounded text fields, etc.
        UIManager.put("TextComponent.arc", 10);
	}
	
	private static void forCustom() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			String bsName = properties.getProperty("bsName");
			String ciName = properties.getProperty("ciName");
			String bstin = properties.getProperty("bstin");
			String citin = properties.getProperty("citin");
			String properietor = properties.getProperty("Proprietor");
			String dateFormat = properties.getProperty("dateFormat");
			String dateFont = properties.getProperty("dateFont");
			String dateFontStyle = properties.getProperty("dateFontStyle");
			
			String dateFontSize = properties.getProperty("dateFontSize");
			String font = properties.getProperty("font");
			String fontStyle = properties.getProperty("fontStyle");
			String fontSize = properties.getProperty("fontSize");
			String fontColor = properties.getProperty("fontColor");
			
			properties.put("bsName", bsName);
			properties.put("ciName", ciName);
			properties.put("bstin", bstin);
			properties.put("citin", citin);
			properties.put("Proprietor", properietor);
			properties.put("Laf", "System");
			properties.put("dateFormat", dateFormat);
			properties.put("dateFont", dateFont);
			properties.put("dateFontStyle", dateFontStyle);
			properties.put("dateFontSize", dateFontSize);
			properties.put("font", font);
			properties.put("fontStyle", fontStyle);
			properties.put("fontSize", fontSize);
			properties.put("fontColor", fontColor);
			
			properties.store(new FileOutputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"), "jimBoYz Ni ChOy!!!");
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
	}
}
