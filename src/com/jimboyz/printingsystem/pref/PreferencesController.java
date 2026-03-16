package com.jimboyz.printingsystem.pref;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.jimboyz.printingsystem.layout.SwingUtil;

public class PreferencesController {
	public PreferencesController() {
		
	}
	
	public static JButton saveSettings() {
		JButton btnSave = SwingUtil.button("Apply", "save", SwingUtil.myFont(null, Font.PLAIN, 11), Color.BLACK);
		btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("Hello Boy");
			}
		});
		
		return btnSave;
	}
}
