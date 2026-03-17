# FPS – Form Printing System

FPS (Form Printing System) is a lightweight Java desktop application designed to simplify the process of inputting and printing data onto **billing statement** and **charge invoice** templates.

The system was originally developed following a request to address printing issues related to Billing Statements and Charge Invoices for a client organization. It was not commercially distributed.

This project is not a full billing system. It assists users in inputting and printing required information onto existing billing statement and charge invoice templates, reducing manual writing.

## Features

- Input and print data onto Billing Statement templates
- Input and print data onto Charge Invoice templates
- Keyboard shortcut support for faster navigation
- Customizable **Look and Feel themes**
- Configurable **calendar date selector**
- Template-based printing powered by **JasperReports**
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
- _Layout adjustments_

## Purpose

This project demonstrates a practical Java desktop solution for inputting and printing data onto structured document templates such as billing statements and charge invoices.

## License

This project is shared for educational and demonstration purposes.
