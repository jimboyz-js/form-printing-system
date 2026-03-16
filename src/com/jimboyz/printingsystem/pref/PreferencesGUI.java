package com.jimboyz.printingsystem.pref;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.jimboyz.printingsystem.err.ErrorDialog;
import com.jimboyz.printingsystem.layout.SwingUtil;
import com.jimboyz.printingsystem.main.Main;

import net.miginfocom.swing.MigLayout;


public class PreferencesGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	
	protected JButton btnOk = PreferencesController.saveSettings();
	private JTextField txtBSTitle;
	private JTextField txtCITitle;
	private JTextField txtBsTIN, txtCiTIN;
	private JTextField txtProp, txtAddress;
	private JComboBox<?> lafComboBox;
	
	private JComboBox<?> cmbDateFormatString;
	private JComboBox<?> cmbDateChooserFontSize;
	private JComboBox<?> cmbDateChooserFont;
	private JComboBox<?> cmbDateChooserFontStyle;

	private JComboBox<?> cmbFont;
	private JComboBox<?> cmbFontSize;
	private JComboBox<?> cmbFontStyle;
	private JComboBox<?> cmbFontColor;
	
	public PreferencesGUI(JFrame frame) {
		
		this.setTitle("Preferences");
		this.setSize(new Dimension(400, 600));
		this.setLocationRelativeTo(frame);
		this.setIconImage(frame.getIconImage());
		this.getContentPane().setLayout(new BorderLayout());;
		btnAction();
		initComponents();
		setAction();
		
	}
	
	public void initComponents() {
		SwingUtil.invokeLater(()->{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
			panel.setLayout(new BorderLayout());
			panel.setBackground(null);
			
			this.add(scrollPane, BorderLayout.CENTER);
			scrollPane.setViewportView(panel);
			
			Box preferencesPanel = Box.createVerticalBox();
			preferencesPanel.setBackground(panel.getBackground());
			preferencesPanel.setOpaque(true);
			panel.add(preferencesPanel, BorderLayout.CENTER);
			
			panel = new JPanel();
			panel.setBorder(BorderFactory.createTitledBorder("General Settings"));
			panel.setLayout(new BorderLayout());
			panel.setPreferredSize(new Dimension(250, 200));
			panel.setBackground(panel.getBackground());
			preferencesPanel.add(panel, BorderLayout.NORTH);
			
			JScrollPane scroll = new JScrollPane(generalSettings());
			panel.add(scroll, BorderLayout.CENTER);
			
			panel = new JPanel();
			panel.setBorder(BorderFactory.createTitledBorder("Date Chooser Settings"));
			panel.setLayout(new BorderLayout());
			panel.setBackground(panel.getBackground());
			panel.add(dateChooserSettings(), BorderLayout.CENTER);
			preferencesPanel.add(panel, BorderLayout.CENTER);
			
			panel = new JPanel();
			panel.setBorder(BorderFactory.createTitledBorder("Font Settings"));
			panel.setLayout(new BorderLayout());
			panel.setBackground(panel.getBackground());
			panel.add(fontSettings(), BorderLayout.CENTER);
			preferencesPanel.add(panel, BorderLayout.CENTER);
			
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 7, 7));
			panel.setBackground(panel.getBackground());
			this.add(panel, BorderLayout.SOUTH);
			
			
			JButton btnRestore = new JButton("Restore");
			btnRestore.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnRestore.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					int confirm = JOptionPane.showConfirmDialog(PreferencesGUI.this, "Restore to defaults?", "Restore",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(confirm == 0) {
						Main.restore();
						Main.setJrxmlSettings();
						JRXMLSettings.getJrxmlSettings();
						GUIProperties.updatePref();
						SetPreferences.updatePref(PreferencesGUI.this);
						PreferencesGUI.this.setVisible(false);
					}
				}
			});
			panel.add(btnRestore);

			btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));
			panel.add(btnOk);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnCancel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PreferencesGUI.this.setVisible(false);
				}
			});
			panel.add(btnCancel);
			panel.add(new JLabel());
			
			
			this.setModal(true); 
			
		});
	}

	public JPanel generalSettings() {
		JPanel panel = new JPanel(new MigLayout("fillx"));
		panel.setPreferredSize(new Dimension(250, 200));
		panel.add(SwingUtil.label("Title Name (BS): "));
		txtBSTitle = SwingUtil.textField("","bs", 500, SwingUtil.myFont(null, Font.PLAIN, 11), Color.BLACK);
		panel.add(txtBSTitle, "wrap, pushx, growx");
		
		panel.add(SwingUtil.label("Title Name (CI): "));
		txtCITitle = SwingUtil.textField("","ci", 77, SwingUtil.myFont(null, Font.PLAIN, 11), Color.BLACK);
		panel.add(txtCITitle, "wrap");
		
		panel.add(SwingUtil.label("BS TIN: "));
		txtBsTIN = SwingUtil.textField("","bs_tin", 77, SwingUtil.myFont(null, Font.PLAIN, 11), Color.BLACK);
		panel.add(txtBsTIN, "wrap, pushx, growx");
		
		panel.add(SwingUtil.label("CI TIN: "));
		txtCiTIN = SwingUtil.textField("","ci_tin", 77, SwingUtil.myFont(null, Font.PLAIN, 11), Color.BLACK);
		panel.add(txtCiTIN, "wrap, pushx, growx");
		
		panel.add(SwingUtil.label("Proprietor: "));
		txtProp = SwingUtil.textField("", "prop", 77, SwingUtil.myFont(null, Font.PLAIN, 11), Color.BLACK);
		panel.add(txtProp, "wrap, pushx, growx");
		
		/**
		 * Date: 03-15-2026 SUN. 8:07 PM
		 */
		panel.add(SwingUtil.label("Address: "));
		txtAddress = SwingUtil.textField("", "address", 77, SwingUtil.myFont(null, Font.PLAIN, 11), Color.BLACK);
		panel.add(txtAddress, "wrap, pushx, growx");
		
		panel.add(SwingUtil.label("Theme: "));
		JComboBox<?> cmbLaf = laf();
		panel.add(cmbLaf, "pushx, growx");
		
		
		return panel;
	}
	
	public JPanel dateChooserSettings() {
		JPanel panel = new JPanel(new MigLayout());
		panel.add(SwingUtil.label("Date Format: "));
		cmbDateFormatString = cmbDateFormat();
		panel.add(cmbDateFormatString, "wrap, growx, pushx");
		
		panel.add(SwingUtil.label("Font: "));
		cmbDateChooserFont = cmbDateChooserFont();
		panel.add(cmbDateChooserFont, "wrap, growx, pushx");
		
		panel.add(SwingUtil.label("Font Style: "));
		cmbDateChooserFontStyle = cmbDateFontStyle();
		panel.add(cmbDateChooserFontStyle, "wrap, growx, pushx");
		
		panel.add(SwingUtil.label("Font Size: "));
		cmbDateChooserFontSize = cmbDateFontSize();
		panel.add(cmbDateChooserFontSize, "growx, pushx");
		
		
		return panel;
	}
	
	public JPanel fontSettings() {
		JPanel panel = new JPanel(new MigLayout());
		panel.add(SwingUtil.label("Font: "));
		cmbFont = cmbFontSettings();
		panel.add(cmbFont, "wrap, pushx, growx");
		
		panel.add(SwingUtil.label("Font Style: "));
		cmbFontStyle = cmbFontStyle();
		panel.add(cmbFontStyle, "wrap, growx, pushx");
		
		panel.add(SwingUtil.label("Font Size: "));
		cmbFontSize = cmbFontSizeSettings();
		panel.add(cmbFontSize, "wrap, growx, pushx");
		
		panel.add(SwingUtil.label("Font Color: "));
		cmbFontColor = cmbFontColorSettings();
		panel.add(cmbFontColor, "wrap, growx, pushx");
		
		panel.add(lblJRXMLSettings());
		
		return panel;
	}
	
	private JComboBox<?> laf() {
		String[] lafList = {"Metal","Nimbus","Motif","System","Windows","Windows Classic","Acryl","Aero","Aluminium","Bernstein","Fast","Graphite","HiFi","Luna","McWin","Mint","Noire","Smart","Texture", "FlatLaf Light", "Custom"};
		lafComboBox = new JComboBox<>(lafList);
		lafComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			String laf = properties.getProperty("Laf");
			lafComboBox.setSelectedItem(laf);
		} catch (IOException e1) {
			e1.printStackTrace();
			ErrorDialog.show(e1.getMessage());
		}
		
		return lafComboBox;
	}
	
	private JComboBox<String> cmbDateFormat(){
		String[] dateFormatList = {"MM/dd/yyyy", "MMMM/dd/yyyy", "dd/MM/yy", "yyyy/dd/MMMM"};
		JComboBox<String> cmb = new JComboBox<>(dateFormatList);
		cmb.setEditable(true);
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			String dateFormatString = properties.getProperty("dateFormat");
			cmb.setSelectedItem(dateFormatString);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return cmb;
	}
	
	private JComboBox<String> cmbDateChooserFont() {
		String[] dateFontList = {"Times New Roman", "Dialog", "Consolas", "MV Boli", "Verdana"};
		JComboBox<String> cmb = new JComboBox<>(dateFontList);
		cmb.setEditable(true);
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			String dateFont = properties.getProperty("dateFont");
			cmb.setSelectedItem(dateFont);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return cmb;
	}
	
	private JComboBox<String> cmbDateFontStyle() {
		String fontStyleList[] = {"Plain","Bold","Italic","Roman Baseline", "Center Baseline", "Hanging Baseline", "True Type Font", "Type1 Font"};
		JComboBox<String> cmb = new JComboBox<>(fontStyleList);
		
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			String fontStyle = properties.getProperty("dateFontStyle");
			cmb.setSelectedItem(fontStyle);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return cmb;
	}
	
	private JComboBox<String> cmbDateFontSize() {
		String[] fontSizeList = {"10", "11", "12", "13", "15", "17", "20"};
		JComboBox<String> cmb = new JComboBox<>(fontSizeList);
		cmb.setEditable(true);
		
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			String fontSize = properties.getProperty("dateFontSize");
			cmb.setSelectedItem(fontSize);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return cmb;
	}
	
	private JComboBox<String> cmbFontSettings() {
		String[] fontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JComboBox<String> cmb = new JComboBox<>(fontList);
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			String font = properties.getProperty("font");
			cmb.setSelectedItem(font);
			
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return cmb;
	}
	
	private JComboBox<String> cmbFontStyle() {
		String fontStyleList[] = {"Plain","Bold","Italic","Roman Baseline", "Center Baseline", "Hanging Baseline", "True Type Font", "Type1 Font"};
		JComboBox<String> cmb = new JComboBox<>(fontStyleList);
		
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			String fontStyle = properties.getProperty("fontStyle");
			cmb.setSelectedItem(fontStyle);
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return cmb;
	}
	
	private JComboBox<String> cmbFontSizeSettings(){
		String[] fontSizeList = {"9", "10", "11", "12", "15", "17", "20"};
		JComboBox<String> cmb = new JComboBox<>(fontSizeList);
		cmb.setEditable(true);
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			cmb.setSelectedItem(properties.getProperty("fontSize"));
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return cmb;
	}
	
	private JComboBox<String> cmbFontColorSettings(){
		String[] fontColorList = {"Blue", "Red", "Gray", "Cyan", "Green", "Black"};
		JComboBox<String> cmb = new JComboBox<>(fontColorList);
		cmb.setEditable(false);
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			cmb.setSelectedItem(properties.getProperty("fontColor"));
		}catch(IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		return cmb;
	}
	
	private JLabel lblJRXMLSettings() {
		JLabel lbl = SwingUtil.label("<html><u>Set JRXML Font Settings</u></html>");
		lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lbl.addMouseListener(new SetHoverText(lbl) {
			@Override
			public void mouseClicked(MouseEvent e) {
				new JRXMLSettings().setVisible(true);
			}
		});
		
		return lbl;
	}
	
	private void setAction() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(GUIProperties.HOME_DIR+"/.FPSv1.0.0/Properties.prefs"));
			String bsName = properties.getProperty("bsName");
			String ciName = properties.getProperty("ciName");
			String bstin = properties.getProperty("bstin");
			String citin = properties.getProperty("citin");
			String address = properties.getProperty("address");
			String prop = properties.getProperty("Proprietor");
			
			txtBSTitle.setText(bsName);
			txtCITitle.setText(ciName);
			txtBsTIN.setText(bstin);
			txtCiTIN.setText(citin);
			txtProp.setText(prop);
			txtAddress.setText(address);
			
		} catch (IOException e) {
			e.printStackTrace();
			ErrorDialog.show(e.getMessage());
		}
	}
	
	public void btnAction() {
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(lafComboBox.getSelectedItem().equals("Metal")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.METAL_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("Nimbus")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.NIMBUS_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("Motif")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.MOTIF_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("Windows")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.WINDOWS_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("Windows Classic")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.WINDOW_CLASSIC_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("Acryl")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.ACRYL_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("Aero")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.AERO_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
				}else if(lafComboBox.getSelectedItem().equals("Aluminium")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.ALUMINIUM_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("Bernstein")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.BERNSTEIN_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
				}else if(lafComboBox.getSelectedItem().equals("Fast")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.FAST_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("Graphite")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.GRAPHITE_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
				}else if(lafComboBox.getSelectedItem().equals("HiFi")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.HIFI_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("Luna")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.LUNA_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
				}else if(lafComboBox.getSelectedItem().equals("McWin")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.MCWIN_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
				}else if(lafComboBox.getSelectedItem().equals("Mint")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.MINT_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("Noire")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.NOIRE_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
				}else if(lafComboBox.getSelectedItem().equals("Smart")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.SMART_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
				}else if(lafComboBox.getSelectedItem().equals("Texture")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.TEXTURE_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("System")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.SYSTEM_PLAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("Custom")) {
					
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.CUSTOM_LAF, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}else if(lafComboBox.getSelectedItem().equals("FlatLaf Light")) {
					// Added Code (FlatLaf) 
					// March 16, 2026 Mon. 12:0-7, 8 PM
					SetPreferences.setPref(txtBSTitle.getText().toString(), txtCITitle.getText().toString(), txtBsTIN.getText().toString(), txtCiTIN.getText().toString(), txtAddress.getText().toString(), txtProp.getText().toString(), GUIProperties.FLAT_LAF_LIGHT, cmbDateFormatString.getSelectedItem().toString(), cmbDateChooserFont.getSelectedItem().toString(), cmbDateChooserFontStyle.getSelectedItem().toString(), cmbDateChooserFontSize.getSelectedItem().toString(), cmbFont.getSelectedItem().toString(), cmbFontStyle.getSelectedItem().toString(), cmbFontSize.getSelectedItem().toString(), cmbFontColor.getSelectedItem().toString());
					GUIProperties.loadLaf();
					SetPreferences.updatePref(PreferencesGUI.this);
					
				}
				new SwingUtil();
				SetPreferences.updatePref();
				PreferencesGUI.this.setVisible(false);
			}
		});	
	}
	
	class SetHoverText extends MouseAdapter {
		
		private JLabel lblText;
		
		private SetHoverText(JLabel lblText) {
			this.lblText = lblText;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			lblText.setForeground(Color.BLUE);
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			lblText.setForeground(Color.BLACK);
		}
		
	}
}
