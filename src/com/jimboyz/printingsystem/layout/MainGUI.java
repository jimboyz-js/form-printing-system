package com.jimboyz.printingsystem.layout;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import com.jimboyz.printingsystem.controlPanel.ShowController;
import com.jimboyz.printingsystem.pref.PreferencesGUI;

public class MainGUI extends WindowAdapter implements MyInterface {
	
	public MainGUI() {
		
		frame.setPreferredSize(new Dimension(700, 640));
		frame.setTitle("For Printing System - FPS v. 1.0.1");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.pack();
		frame.setIconImage(SwingUtil.getImage("/com/jimboyz/lts/images/print_pref-9.png"));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.addWindowListener(this);
		frame.getContentPane().add(new MainPanel(), "Center");
		
		menuAction(false, false, false, false, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Menu is disabled...");
			}
		}, null, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("About");
				new AboutView(frame);
			}
		}, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("User Guide");
				ShowController.showUserGuid();
			}
		}, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PreferencesGUI(frame).setVisible(true);
			}
		}, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Print");
			}
		}, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exit");
			}
		});
	}
	
	public static void menuAction(boolean enableHome, boolean enablePrint, boolean enableBilling, boolean enableChargeInvoice, ActionListener actionListener, ActionListener homeActionlistener, ActionListener aboutActionListener, ActionListener userGuideActionListener, ActionListener prefActionListener, ActionListener printActionListener, ActionListener exitActionListener) {
		
		Action openHome = SwingUtil.newAction("Home", SwingUtil.newImageIcon("/com/jimboyz/lts/images/home_nav.png"), enableHome, "Go to home", homeActionlistener);
		Action openAction = SwingUtil.newAction("Billing Statement", SwingUtil.newImageIcon("/com/jimboyz/lts/images/page_white_camera.png"), enableBilling, "Open Billing Statement", actionListener);
		Action chargeInvoice = SwingUtil.newAction("Charge Invoice", SwingUtil.newImageIcon("/com/jimboyz/lts/images/copy_edit.gif"), enableChargeInvoice, "Open Charge Invoice", actionListener);
		Action aboutAction = SwingUtil.newAction("About", SwingUtil.newImageIcon("/com/jimboyz/lts/images/about.png"), true, aboutActionListener);
		Action userGuideAction = SwingUtil.newAction("User's Guide", SwingUtil.newImageIcon("/com/jimboyz/lts/images/list-icon24.png"), true, userGuideActionListener);
		Action preferencesAction = SwingUtil.newAction("Preferences", SwingUtil.newImageIcon("/com/jimboyz/lts/images/cog-edit.png"), true, prefActionListener);
		Action printAction = SwingUtil.newAction("Print", SwingUtil.newImageIcon("/com/jimboyz/lts/images/b_print.png"), enablePrint, "Print Preview", printActionListener);
		Action exitAction = SwingUtil.newAction("Exit", SwingUtil.newImageIcon("/com/jimboyz/lts/images/exit.png"), true, exitActionListener);
		
		int menuShortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx();
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu.add(openHome).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, menuShortcutKeyMask));
		menu.addSeparator();
		menu.add(printAction).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, menuShortcutKeyMask));
		menu.addSeparator();
		menu.add(exitAction).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 8));
		menuBar.add(menu);
		
		menu = new JMenu("System");
		menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu.add(openAction).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, menuShortcutKeyMask));
		menu.addSeparator();
		menu.setMnemonic(KeyEvent.VK_S);
		menu.add(chargeInvoice).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, menuShortcutKeyMask));
		menuBar.add(menu);
		
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu.add(userGuideAction).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, menuShortcutKeyMask));
		menu.addSeparator();
		menu.add(aboutAction).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menu.addSeparator();
		menu.add(preferencesAction).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, menuShortcutKeyMask));
		menuBar.add(menu);
		
		frame.setJMenuBar(menuBar);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		
		System.exit(JFrame.EXIT_ON_CLOSE);
	}
}
