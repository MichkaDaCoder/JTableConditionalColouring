package jtableconditionalcolouring.dao;

import java.io.IOException;
import java.util.List;
import jtableconditionalcolouring.model.Employee;

/**
 * EmployeeImplementation.java: Implementation class of all CRUD methods for the object <b>Employee</b>.
 * Inherits from <b>GenericDAO</b>
 * @author MichkaDaCoder
 */
public class EmployeeImplementation extends GenericDAO<Employee>{

    /**
     * Default constructor of EmployeeImplementation class. It contains 
     * a call of the mother class an a method to connect to the database.
     */
    public EmployeeImplementation() {
        super(Employee.class);
        try {
        connexion();
        }
        catch(IOException ex) {
            
        }
    }
    
    /**
     * Add a new employee.
     * @param employee 
     */
    public void add(Employee employee) {
        super.create(employee);
    }
    
    /**
     * Remove an existing employee.
     * @param employee 
     */
    public void remove(Employee employee) {
        super.delete(employee);
    }
    
    /**
     * Edit datas of an existing employee. 
     * @param employee
     * @return <b>Employee</b>
     */
    public Employee edit(Employee employee) {
        return super.update(employee);
    }
    
    /**
     * List all existing employees.
     * @return <b>List</b>
     */
    public List<Employee> findEmployees() {
        return super.findAll();
    }
    
    /**
     * Gets the total sum of existing employees.
     * @return <b>int</b>
     */
    public int total() {
        return super.count();
    }

}
