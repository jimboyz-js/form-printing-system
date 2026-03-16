package com.jimboyz.printingsystem.layout;

import java.awt.BorderLayout;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.jimboyz.printingsystem.err.ErrorDialog;

public class License {
	
	public static JPanel licenseDetails() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JEditorPane editor = new JEditorPane();
		editor.setEditable(false);
		editor.setContentType("text/html");
		String path = System.getProperty("user.dir");
		String fileSeparator = System.getProperty("file.separator");
		path += fileSeparator+"LICENSE";
		try {
			editor.setText("<html><p style=\"text-align:justify;\" style=\"text-indent:12px;\" font face=\"Consolas\" color=black>For Printing System - FPS Version 1.0.0 Freeware License\r\n"
					+ "Copyright (c) 2023, 2024 JS Software And IT Support\r\n"
					+ "Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to use the Software for personal, non-commercial purposes only. Commercial use, redistribution, and modification are prohibited without prior written permission from the copyright holder.</p>"
					+ "<h3 color=black style=\"text-align:justify;\" style=\"text-indent:12px\" >THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</h3>"
					+ "<h3 font face=\"Consolas\" color=blue>JS Software and IT Support all rights reserves not expressly granted herein.</h3>"
					+ "<p><span font face=\"Consolas\" color=red>Note: The copy of the longer version of this License shall be found at \""+path+"\"</span></p></html>");
			
		} catch (Exception e) {
			e.printStackTrace();
			ErrorDialog.show(e);
		}
		
		JScrollPane scrollPane = new JScrollPane(editor);
		
		panel.add(scrollPane, BorderLayout.CENTER);
		
		return panel;
		
	}
}
