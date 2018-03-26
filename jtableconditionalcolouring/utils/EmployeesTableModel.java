package jtableconditionalcolouring.utils;

import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import jtableconditionalcolouring.model.Employee;

/**
 * EmployeeTableModel.java: class that create a new model for employees
 * JTable according to its table columns names.
 * @author MichkaDaCoder
 */
public class EmployeesTableModel extends AbstractTableModel{

    /**
     * Array of table's columns names.
     */
    String[] colNames=new String[] {"ID","First Name","Last Name","Salary","Email","Hiredate","Address"};
    /**
     * Non-initialized List of employees.
     */
    List employeesList;
    
    final Vector data = new Vector();
    
    /**
     * Constructor of the class.
     * @param list 
     */
    public EmployeesTableModel(List list) {
        this.employeesList=list;
    }
    
    /**
     * Gets the the number of employees row
     * @return <b>int</b>
     */
    @Override
    public int getRowCount() {
       return employeesList.size();
    }

    /**
     * Gets the number of columns
     * @return <b>int</b>
     */
    @Override
    public int getColumnCount() {
       return 6;
    }

    /**
     * Maps the columns index to each employee attribute. 
     * @param row
     * @param column
     * @return <b>Object</b>
     */
    @Override
    public Object getValueAt(int row, int column) {
        Employee employee=(Employee)employeesList.get(row);
        
        switch(column) {
            case 0:
                return employee.getId();
            case 1:
                return employee.getFirstName();
            case 2:
                return employee.getLastName();
            case 3:
                return employee.getSalary();
            case 4:
                return employee.getEmail();
            case 5:
                return employee.getHiredate();
            case 6:
                return employee.getAddress();
        }
       return employee;
    }
    
    /**
     * Gets an employee from a selected row index.
     * @param row
     * @return <b>Object</b>
     */
    public Object getValueAtRow(int row) {
      Employee employee = (Employee) employeesList.get(row);
      return employee;
   }

    /**
     * Gets a column name from a given index.
     * @param col
     * @return <b>String</b>
     */
    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }
}
