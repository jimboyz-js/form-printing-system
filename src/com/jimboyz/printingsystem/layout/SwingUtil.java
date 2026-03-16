package com.jimboyz.printingsystem.layout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.jimboyz.printingsystem.err.ErrorDialog;
import com.jimboyz.printingsystem.pref.GUIProperties;

public class SwingUtil implements MyInterface {
	
	public int FONT_SIZE = 16;
	public String FONT = "Times New Roman";
	public int FONT_STYLE = Font.PLAIN;
	public String bs_name = "JIMBOYZ TRANSPORT SERVICES";
	public String ci_name = "JIMBOYZ AGGREGATES TRADING";
	public String prop = "JIMBOYZ NI CHOY"; // Proprietor name (example name) 
	public String bs_tin = "122-XXX-XXX-000";
	public String ci_tin = "122-XXX-XXX-00004";
	public String address = "P-6, St. Brgy. Mun. Province";
	public String dateFormatString = "MM/dd/yyyy";
	public String dateFont = "Dialog";
	public int dateFontStyle = Font.PLAIN;
	public int dateFontSize = 11;
	
	
	  
	public SwingUtil() {

		setHeaderTitle();
		setPreferencesProperties();
	}



	public static Image getImage(String iconPath) {
		return Toolkit.getDefaultToolkit().getImage(SwingUtil.class.getResource(iconPath));
	}
	
	public static Font myFont(String fontz, int fontStyle, int fontSize) {
		
		Font font = new Font(fontz, fontStyle, fontSize);
		
		return font;
		
	}
	
	public static ImageIcon newImageIcon(String iconPath) {
		return new ImageIcon(getImage(iconPath));
	}
	
	public static JPanel panel(Dimension dimension, Cursor cursor) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(dimension);
		panel.setCursor(cursor);
		return panel;
	}
	
	public static JLabel label(String name) {
		JLabel label = new JLabel(name);
	
		return label;
	}
	
	public static JLabel label(String name, Font font, Color fontColor, int x, int y, int width, int height) {
		JLabel label = new JLabel();
		label.setText(name);
		label.setBounds(x, y, width, height);
		label.setFont(font);
		label.setForeground(fontColor);
		
		return label;
	}
	
	public static JTextField textField(String name, String actionCommand, int column, Font font, Color fontColor) {
		JTextField textField = new JTextField(name);
		textField.setColumns(column);
		textField.setActionCommand(actionCommand);
		textField.setFont(font);
		textField.setForeground(fontColor);
		return textField;
	}
	
	public static JTextField textField(String actionCommand, Font font, Color fontColor, int x, int y, int width, int height) {
		JTextField textField = new JTextField();
		textField.setBounds(x, y, width, height);
		textField.setActionCommand(actionCommand);
		textField.setFont(font);
		textField.setForeground(fontColor);
		return textField;
	}
	
	public static JButton button(String name, String actionCommand, Font font, Color fontColor) {
		JButton button = new JButton(name);
		button.setActionCommand(actionCommand);
		button.setFont(font);
		button.setForeground(fontColor);
		
		return button;
	}
	
	public static Action newAction(String name, boolean enable, final ActionListener listener) {
		Action action = new AbstractAction(name) {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.actionPerformed(e);
				
			}
		};
		action.setEnabled(enable);
		return action;
	}
	
	public static Action newAction(String name, ImageIcon icon, boolean enable, ActionListener listener) {
		Action action = newAction(name, enable, listener);
		action.putValue("SmallIcon", icon);
		return action;
	}
	
	public static Action newAction(String name, ImageIcon icon, boolean enable, String shortDescription, ActionListener listener) {
		Action action = newAction(name, icon, enable, listener);
		action.putValue("ShortDescription", shortDescription);
		return action;
	}
	
	public static void invokeLater(Runnable runnable) {
		if(SwingUtilities.isEventDispatchThread()) {
			runnable.run();
		}else {
			SwingUtilities.invokeLater(runnable);
		}
	}
	
	public static ImageIcon setLabelImageIcon(JLabel lblLogo, String icoPath) {
		
		try {
			ImageIcon imageIcon = new ImageIcon(SwingUtil.getImage(icoPath));
			Image image = imageIcon.getImage();
			Image img = image.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon2 = new ImageIcon(img);
			lblLogo.setIcon(imageIcon2);
			return imageIcon2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void setHeaderTitle() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			String bsName = properties.getProperty("bsName");
			String ciName = properties.getProperty("ciName");
			String bstin = properties.getProperty("bstin");
			String citin = properties.getProperty("citin");
			String address = properties.getProperty("address");
			String properietor = properties.getProperty("Proprietor");
			
			this.bs_tin = bstin;
			this.ci_tin = citin;
			this.bs_name = bsName;
			this.ci_name = ciName;
			this.address = address;
			prop = properietor;
			
			
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
	}
	
	public void setPreferencesProperties() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			String _dateFormat = properties.getProperty("dateFormat");
			String dateFont = properties.getProperty("dateFont");
			String dateFontStyle = properties.getProperty("dateFontStyle");
			int dateFontSize = Integer.parseInt(properties.getProperty("dateFontSize"));
			
			this.dateFormatString = _dateFormat;
			this.dateFont = dateFont;
			
			switch(dateFontStyle) {
			case "Plain":
				this.dateFontStyle = Font.PLAIN;
				break;
			case "Bold":
				this.dateFontStyle = Font.BOLD;
				break;
			case "Italic":
				this.dateFontStyle = Font.ITALIC;
				break;
			case "Roman Baseline":
				this.dateFontStyle = Font.ROMAN_BASELINE;
				break;
			case "Center Baseline":
				this.dateFontStyle = Font.CENTER_BASELINE;
				break;
			case "Hanging Baseline":
				this.dateFontStyle = Font.HANGING_BASELINE;
				break;
			case "True Type Font":
				this.dateFontStyle = Font.TRUETYPE_FONT;
				break;
			case "Type1 Font":
				this.dateFontStyle = Font.TYPE1_FONT;
				break;
			}
			this.dateFontSize = dateFontSize;
			
			setFontPreferences(properties, "font","fontStyle","fontSize","fontColor");
			
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
	}
	
	private void setFontPreferences(Properties properties, String fontProperty, String fontStyleProperty, String fontSizeProperty, String fontColorProperty) {
		String font = properties.getProperty(fontProperty);
		String fontStyle = properties.getProperty(fontStyleProperty);
		String fontSize = properties.getProperty(fontSizeProperty);
		String fontColor = properties.getProperty(fontColorProperty);
		
		this.FONT = font;
		
		switch(fontStyle) {
		case "Plain":
			this.FONT_STYLE = Font.PLAIN;
			break;
		case "Bold":
			this.FONT_STYLE = Font.BOLD;
			break;
		case "Italic":
			this.FONT_STYLE = Font.ITALIC;
			break;
		case "Roman Baseline":
			this.FONT_STYLE = Font.ROMAN_BASELINE;
			break;
		case "Center Baseline":
			this.FONT_STYLE = Font.CENTER_BASELINE;
			break;
		case "Hanging Baseline":
			this.FONT_STYLE = Font.HANGING_BASELINE;
			break;
		case "True Type Font":
			this.FONT_STYLE = Font.TRUETYPE_FONT;
			break;
		case "Type1 Font":
			this.FONT_STYLE = Font.TYPE1_FONT;
			break;
		}
		
		this.FONT_SIZE = Integer.parseInt(fontSize);
		
		switch(fontColor) {
		case "Blue":
			setForegroundColor(fontColor);
			break;
		case "Red":
			setForegroundColor(fontColor);
			break;
		case "Gray":
			setForegroundColor(fontColor);
			break;
		case "Cyan":
			setForegroundColor(fontColor);
			break;
		case "Green":
			setForegroundColor(fontColor);
			break;
		case "Black":
			setForegroundColor(fontColor);
			break;
		}
		
	}
	
	private void setForegroundColor(String color) {
		if(color.equals("Blue")) {
			UIManager.put("Label.foreground", Color.BLUE);
			UIManager.put("TextField.foreground", Color.blue);
			UIManager.put("Button.foreground", Color.blue);
			
		}else if(color.equals("Red")) {
			UIManager.put("Label.foreground", Color.RED);
			UIManager.put("TextField.foreground", Color.RED);
			UIManager.put("Button.foreground", Color.RED);
			
		}else if(color.equals("Gray")) {
			UIManager.put("Label.foreground", Color.GRAY);
			UIManager.put("TextField.foreground", Color.GRAY);
			UIManager.put("Button.foreground", Color.GRAY);
			
		}else if(color.equals("Cyan")) {
			UIManager.put("Label.foreground", Color.CYAN);
			UIManager.put("TextField.foreground", Color.CYAN);
			UIManager.put("Button.foreground", Color.CYAN);
			
		}else if(color.equals("Green")) {
			UIManager.put("Label.foreground", Color.GREEN);
			UIManager.put("TextField.foreground", Color.GREEN);
			UIManager.put("Button.foreground", Color.GREEN);
			
		}else if(color.equals("Black")) {
			UIManager.put("Label.foreground", Color.BLACK);
			UIManager.put("TextField.foreground", Color.BLACK);
			UIManager.put("Button.foreground", Color.BLACK);
			
		}
		
	}
	
	@SuppressWarnings("unused")
	private void anotherFontSize(int newSize) {
        Font newFont = UIManager.getFont("Label.font").deriveFont((float) newSize);
        UIManager.put("Label.font", newFont);
        UIManager.put("Button.font", newFont);
        UIManager.put("TextField.font", newFont);
        UIManager.put("TextArea.font", newFont);
        UIManager.put("List.font", newFont);
        UIManager.put("ComboBox.font", newFont);
        UIManager.put("Menu.font", newFont);
        UIManager.put("MenuItem.font", newFont);
        UIManager.put("CheckBoxMenuItem.font", newFont);
        UIManager.put("RadioButtonMenuItem.font", newFont);
        UIManager.put("ToolTip.font", newFont);
        UIManager.put("OptionPane.messageFont", newFont);
        UIManager.put("OptionPane.buttonFont", newFont);
	}
}
