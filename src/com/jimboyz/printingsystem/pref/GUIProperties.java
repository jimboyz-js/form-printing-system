package com.jimboyz.printingsystem.pref;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.jimboyz.printingsystem.err.ErrorDialog;
import com.jimboyz.printingsystem.layout.MyInterface;
import com.jimboyz.printingsystem.myLookAndFeel.SetDefaultLaf;

public class GUIProperties implements MyInterface {

	public static final String HOME_DIR = System.getProperty("user.home");

	public static final String METAL_LAF = "Metal";
	public static final String NIMBUS_LAF = "Nimbus";
	public static final String MOTIF_LAF = "Motif";
	public static final String WINDOWS_LAF = "Windows";
	public static final String WINDOW_CLASSIC_LAF = "Windows Classic";
	public static final String ACRYL_LAF = "Acryl";
	public static final String AERO_LAF = "Aero";
	public static final String ALUMINIUM_LAF = "Aluminium";
	public static final String BERNSTEIN_LAF = "Bernstein";
	public static final String FAST_LAF = "Fast";
	public static final String GRAPHITE_LAF = "Graphite";
	public static final String HIFI_LAF = "HiFi";
	public static final String LUNA_LAF = "Luna";
	public static final String MCWIN_LAF = "McWin";
	public static final String MINT_LAF = "Mint";
	public static final String NOIRE_LAF = "Noire";
	public static final String SMART_LAF = "Smart";
	public static final String TEXTURE_LAF = "Texture";
	public static final String SYSTEM_PLAF = "System";
	public static final String CUSTOM_LAF = "Custom";
	public static final String FLAT_LAF_LIGHT = "FlatLaf Light";

	public static final String PLAF_METAL = "javax.swing.plaf.metal.MetalLookAndFeel";

	public static final String PLAF_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	public static final String PLAF_MOTIF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";

	public static final String PLAF_SYSTEM = UIManager.getSystemLookAndFeelClassName();

	public static final String PLAF_ACRYL = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";

	public static final String PLAF_AERO = "com.jtattoo.plaf.aero.AeroLookAndFeel";

	public static final String PLAF_ALUMINIUM = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";

	public static final String PLAF_BERNSTEIN = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";

	public static final String PLAF_FAST = "com.jtattoo.plaf.fast.FastLookAndFeel";

	public static final String PLAF_GRAPHITE = "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";

	public static final String PLAF_HIFI = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";

	public static final String PLAF_LUNA = "com.jtattoo.plaf.luna.LunaLookAndFeel";

	public static final String PLAF_MCWIN = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";

	public static final String PLAF_MINT = "com.jtattoo.plaf.mint.MintLookAndFeel";

	public static final String PLAF_NOIRE = "com.jtattoo.plaf.noire.NoireLookAndFeel";

	public static final String PLAF_SMART = "com.jtattoo.plaf.smart.SmartLookAndFeel";

	public static final String PLAF_TEXTURE = "com.jtattoo.plaf.texture.TextureLookAndFeel";

	public static final String PLAF_CUSTOM = "com.jtattoo.plaf.custom.flx.FLXLookAndFeel";

	/*
	private String lookAndFeel = "com.jtattoo.plaf.texture.TextureLookAndFeel";
	public static String lookAndFeelz = "com.jtattoo.plaf.texture.TextureLookAndFeel";
	*/
	
	private String lookAndFeel = PLAF_SYSTEM;
	public static String lookAndFeelz = PLAF_SYSTEM;
	
	public void setLookAndFeel(String lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
	}

	public String getLookAndFeel() {
		return this.lookAndFeel;
	}

	public boolean isMetalLook() {
		return this.lookAndFeel.equals("javax.swing.plaf.metal.MetalLookAndFeel");
	}

	public boolean isNimbusLook() {
		return this.lookAndFeel.equals("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	}

	public boolean isMotifLook() {
		return this.lookAndFeel.equals("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	}

	public boolean isSystemLook() {
		return this.lookAndFeel.equals(PLAF_SYSTEM);
	}

	public boolean isAcrylLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
	}

	public boolean isAeroLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.aero.AeroLookAndFeel");
	}

	public boolean isAluminiumLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
	}

	public boolean isBernsteinLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
	}

	public boolean isFastLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.fast.FastLookAndFeel");
	}

	public boolean isGraphiteLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
	}

	public boolean isHiFiLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
	}

	public boolean isLunaLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.luna.LunaLookAndFeel");
	}

	public boolean isMcWinLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	}

	public boolean isMintLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.mint.MintLookAndFeel");
	}

	public boolean isNoireLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.noire.NoireLookAndFeel");
	}

	public boolean isSmartLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.smart.SmartLookAndFeel");
	}

	public boolean isTextureLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.texture.TextureLookAndFeel");
	}

	public static boolean isCustomEnabled() {
		return false;
	}

	public boolean isCustomLook() {
		return this.lookAndFeel.equals("com.jtattoo.plaf.custom.flx.FLXLookAndFeel");
	}
	
	public static void loadLaf() {

		if((new File(HOME_DIR+"/.FPSv1.0.0/Properties.prefs")).canRead()) {
			try {
				Properties property = new Properties();
				property.load(new FileInputStream(HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
				lookAndFeelz = property.getProperty("Laf");
				
				if(lookAndFeelz.equals(METAL_LAF)) {
					SetDefaultLaf.metalLookAndFeel();
				}else if(lookAndFeelz.equals(NIMBUS_LAF)) {
					SetDefaultLaf.nimbusLookAndFeel();
				}else if(lookAndFeelz.equals(MOTIF_LAF)) {
					SetDefaultLaf.motifLookAndFeel();
				}else if(lookAndFeelz.equals(WINDOWS_LAF)) {
					SetDefaultLaf.windowsLookAndFeel();
				}else if(lookAndFeelz.equals(WINDOW_CLASSIC_LAF)) {
					SetDefaultLaf.windowsClassicLookAndFeel();
				}else if(lookAndFeelz.equals(ACRYL_LAF)) {
					SetDefaultLaf.acryleLookAndFeel();
				}else if(lookAndFeelz.equals(AERO_LAF)) {
					SetDefaultLaf.aeroLookAndFeel();
				}else if(lookAndFeelz.equals(ALUMINIUM_LAF)) {
					SetDefaultLaf.aluminumLookAndFeel();
				}else if(lookAndFeelz.equals(BERNSTEIN_LAF)) {
					SetDefaultLaf.bernsteinLookAndFeel();
				}else if(lookAndFeelz.equals(FAST_LAF)) {
					SetDefaultLaf.fastLookAndFeel();
				}else if(lookAndFeelz.equals(GRAPHITE_LAF)) {
					SetDefaultLaf.graphiteLookAndFeel();
				}else if(lookAndFeelz.equals(HIFI_LAF)) {
					SetDefaultLaf.hifiLookAndFeel();
				}else if(lookAndFeelz.equals(LUNA_LAF)) {
					SetDefaultLaf.lunaLookAndFeel();
				}else if(lookAndFeelz.equals("McWin")) {
					SetDefaultLaf.mcwinLookAndFeel();
				}else if(lookAndFeelz.equals(MINT_LAF)) {
					SetDefaultLaf.mintLookAndFeel();
				}else if(lookAndFeelz.equals(NOIRE_LAF)) {
					SetDefaultLaf.noireLookAndFeel();
				}else if(GUIProperties.lookAndFeelz.equals(SMART_LAF)) {
					SetDefaultLaf.smartLookAndFeel();
				}else if(GUIProperties.lookAndFeelz.equals(TEXTURE_LAF)) {
					SetDefaultLaf.textureLookAndFeel();
				}else if(GUIProperties.lookAndFeelz.equals(SYSTEM_PLAF)) {
					 SetDefaultLaf.systemLookAndFeel();
				}else if(GUIProperties.lookAndFeelz.equals("Custom")) {
					SetDefaultLaf.customLookAndFeel();
				}else if(lookAndFeelz.equals(FLAT_LAF_LIGHT)) {
					
					SetDefaultLaf.flatLafLightLookAndFeel();
				}
				updatePref();
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void updatePref() {
		for(Window window : Frame.getFrames()) {
			SwingUtilities.updateComponentTreeUI(window);
			window.repaint();
			update();
			restart();
		}
	}
	
	private static void update() {
		SwingUtilities.updateComponentTreeUI(frame);
		frame.revalidate();
		frame.repaint();
		for(Window win : Dialog.getWindows()) {
			SwingUtilities.updateComponentTreeUI(win);
		}
	}
	
	public static void restart() {
		
		try {
			
			String javaCommand = System.getProperty("sun.java.command");
			Runtime.getRuntime().exec(new String[] {"java", "-jar",javaCommand});
			System.exit(0);
			
		}catch(Exception e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
	}
}
