# FPS – Form Printing System

FPS (Form Printing System) is a lightweight Java desktop application designed to simplify the printing of structured documents such as **Billing Statements** and **Charge Invoices**.

The system was originally developed as an internal tool for a client company to automate and standardize their printing workflow.

## Features

- Generate and print **Billing Statements**
- Generate and print **Charge Invoices**
- Keyboard shortcut support for faster navigation
- Customizable **Look and Feel themes**
- Configurable **calendar date selector**
- Printable reports powered by **JasperReports**
- Simple and lightweight **Java Swing interface**

## Technologies Used

- Java (Swing)
- JasperReports
- JCalendar
- FlatLaf
- JTattoo

## Keyboard Shortcuts

| Action | Shortcut |  
 Home 	 ---> CTRL + H  
 Print ---> CTRL + P   
 Billing Statement  --->  CTRL + B   
 Charge Invoice  --->  CTRL + I   
 User Guide  --->  CTRL + U   
 Preferences --->  CTRL + F   
 Exit  --->  ALT + F4   
 About  --->  F1   

## Customization

### Calendar Settings
Users can modify the following settings from the **Preferences** menu:

- Date format
- Font size
- Font style

Note: Changing the font size will also affect the size of the calendar chooser component.

### Look and Feel
FPS supports multiple UI themes:

- Windows LookAndFeel (default on Windows)
- FlatLaf
- JTattoo

Themes can be changed in the **Preferences settings**.

## Reports

The report templates are implemented using **JasperReports JRXML** files.

These templates allow customization of:

- Font styles
- Text formatting (Bold, Italic, Underline)
- Layout adjustments

## Purpose

This project demonstrates a practical Java desktop solution for structured document printing and report generation.

## License

This project is shared for educational and demonstration purposes.
