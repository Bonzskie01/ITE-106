Payroll System - Java GUI Application
This is a basic Java GUI application for a Payroll System. It allows users to manage employee records, including adding, calculating pay, saving, displaying, updating, and deleting records.

Features
	- User-friendly GUI with labels, text fields, buttons, and a text area.
	- Add new employees by entering their ID, name, hourly rate, and hours worked.
	- Calculate gross pay and net pay after applying a 20% deduction (configurable).
	- Save employee records to a text file (payroll.txt).
	- Display existing employee records.
	- Update employee information by entering their ID and modifying other fields.
	- Delete employee records by entering their ID.

Requirements
	- Java Runtime Environment (JRE)

Running the application
	- Compile the source code using a Java compiler (e.g., javac PayrollSystem.java).
	- Run the compiled class (PayrollSystem.class) using: javac PayrollSystem and java PayrollSystem

File format
	- The application reads and writes data to a text file named payroll.txt.
	- Each line in the file represents an employee record in the format:
	- Employee ID, Employee Name, Hourly Rate, Hours Worked, Net Pay

Customization
	- You can modify the deduction rate in the calculatePay method by changing the value used for deductions (currently set to 0.2 for 20%).
	- The text file path (filePath) can be changed in the class definition.

I hope this README provides a clear overview of the Payroll System application. Feel free to explore the code and customize it according to your needs.