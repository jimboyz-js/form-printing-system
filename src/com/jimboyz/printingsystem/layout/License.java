package com.jimboyz.printingsystem.layout;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.jimboyz.printingsystem.err.ErrorDialog;
import com.jimboyz.printingsystem.pref.GUIProperties;

public class License {
	
	public static JPanel licenseDetails() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JEditorPane editor = new JEditorPane();
		editor.setEditable(false);
		editor.setContentType("text/html");
		String path = GUIProperties.HOME_DIR + File.separator + ".fps-invoice-print-v1.0.1";
		String fileSeparator = System.getProperty("file.separator");
		path += fileSeparator+"LICENSE";
		try {
//			editor.setText("<html><p style=\"text-align:justify;\" style=\"text-indent:12px;\" font face=\"Consolas\" color=black>Form Printing System - FPS Version 1.0.1 Freeware License\r\n"
//					+ "Copyright (c) 2026 JS Software And IT Support\r\n"
//					+ "Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to use the Software for personal, non-commercial purposes only. Commercial use, redistribution, and modification are prohibited without prior written permission from the copyright holder.</p>"
//					+ "<h3 color=black style=\"text-align:justify;\" style=\"text-indent:12px\" >THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</h3>"
//					+ "<h3 font face=\"Consolas\" color=blue>JS Software and IT Support all rights reserves not expressly granted herein.</h3>"
//					+ "<p><span font face=\"Consolas\" color=red>Note: The copy of the longer version of this License shall be found at \""+path+"\"</span></p></html>");
			
			editor.setText("<html><p style=\"text-align:justify;\" style=\"text-indent:12px;\" font face=\"Consolas\" color=black> <span style=\"font-weight:bold;\">FPS – Form Printing System</span>\r\n"
					+ "Version 1.0.1\r\n"
					+ "\r\n"
					+ "Copyright © 2026 Jimboyz-JS.\r\n"
					+ "\r\n"
					+ "This program is free software: you can redistribute it and/or modify\r\n"
					+ "it under the terms of the GNU General Public License, version 3.\r\n"
					+ "\r\n"
					+ "This program is distributed in the hope that it will be useful,\r\n"
					+ "but WITHOUT ANY WARRANTY; without even the implied warranty of\r\n"
					+ "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.\r\n"
					+ "\r\n"
					+ "See the GNU General Public License for more details.</p>"
					+ "<p style=\"line-height:1.8; text-align:justify;\">A full copy of the license is included with this software.</p><span style=\"color:red;\">"+path+"</span></html>");
			
		} catch (Exception e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		JScrollPane scrollPane = new JScrollPane(editor);
		
		panel.add(scrollPane, BorderLayout.CENTER);
		
		return panel;
		
	}
}
