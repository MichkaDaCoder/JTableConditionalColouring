package jtableconditionalcolouring.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Employee.java: Entity class for employee table.
 * @author MichkaDaCoder
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    /**
     * Lists all existing employees.
     */
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    /**
     * List an existing employee by its given id.
     */
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    /**
     * Lists an existing employee by its given first name.
     */
    @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
    /**
     * Lists an existing employee by its given last name.
     */
    @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
    /**
     * Lists an existing employee by its given salary.
     */
    @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary"),
    /**
     * Lists an existing employee by its given email.
     */
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    /**
     * Lists an existing employee by its given address.
     */
    @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address"),
    /**
     * Lists an existing employee by its given hiredate.
     */
    @NamedQuery(name = "Employee.findByHiredate", query = "SELECT e FROM Employee e WHERE e.hiredate = :hiredate")})

public class Employee implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    /**
     * First name of the employee.
     */
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    /**
     * Last name of the employee.
     */
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    /**
     * Salary of the employee.
     */
    @Basic(optional = false)
    @Column(name = "SALARY")
    private Integer salary;
    /**
     * Email of the employee.
     */
    @Column(name = "EMAIL")
    private String email;
    /**
     * Address of the employee.
     */
    @Column(name = "ADDRESS")
    private String address;
    /**
     * Hire date of the employee.
     */
    @Column(name = "HIREDATE")
    @Temporal(TemporalType.DATE)
    private Date hiredate;

    /**
     * Default constructor
     */
    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    /**
     * Constructor of employee class
     * @param id
     * @param firstName
     * @param lastName
     * @param salary 
     */
    public Employee(Integer id, String firstName, String lastName, Integer salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    /**
     * Getter of the id of the employee;
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter of the id of the employee
     * @param id 
     */
    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    /**
     * Gettr of the first name of the employee
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter of the first name of the employee
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    /**
     * Getter of the last name of the employee
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter of the last name of the employee
     * @param lastName 
     */
    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    /**
     * Getter of the salary of the employee
     * @return 
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * Setter of the salary of the employee
     * @param salary 
     */
    public void setSalary(Integer salary) {
        Integer oldSalary = this.salary;
        this.salary = salary;
        changeSupport.firePropertyChange("salary", oldSalary, salary);
    }

    /**
     * Getter of the email of the employee
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter of the email of the employee
     * @param email 
     */
    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    /**
     * Getter of the address of the employee
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter of the address of the employee
     * @param address 
     */
    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    /**
     * Getter of the hiredate of the employee
     * @return Date
     */
    public Date getHiredate() {
        return hiredate;
    }

    /**
     * Setter of the hiredate of the employee.
     * @param hiredate 
     */
    public void setHiredate(Date hiredate) {
        Date oldHiredate = this.hiredate;
        this.hiredate = hiredate;
        changeSupport.firePropertyChange("hiredate", oldHiredate, hiredate);
    }

    /**
     * Returns the hashcode of the employee given object
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Check if two given employees objects are equals.
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    /**
     * Returns the string format of an employee object
     * @return String
     */
    @Override
    public String toString() {
        return this.firstName+" "+this.lastName;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
