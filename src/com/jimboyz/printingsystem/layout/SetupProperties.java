package com.jimboyz.printingsystem.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class SetupProperties  {

	public JPanel properties() {
		
		JPanel panel = new JPanel(new BorderLayout());
		Properties prop = System.getProperties();
		
		JTable table = new JTable();
		table.setBackground(null);
		table.getTableHeader().setReorderingAllowed(false);
		DefaultTableModel tableModel = new DefaultTableModel(new Object[] {"Name", "Value"}, 0) {
			
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
				
			}
		};
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setForeground(Color.BLUE);
		tableHeader.setBackground(null);
		tableHeader.setFont(new Font("Calibri", Font.BOLD, 13));
		table.setModel(tableModel);
		
		for(String propertyName : prop.stringPropertyNames()) {
			String propertyValue = prop.getProperty(propertyName);
			tableModel.addRow(new Object[] {propertyName, propertyValue});;
		}
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		panel.add(scrollPane, BorderLayout.CENTER);
		
		return panel;
		
	}
}
