package jtableconditionalcolouring.reports;

import java.io.IOException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

/**
 * JasperInterface: interface that contains all reporting methods signatures
 * @author MichkaDaCoder
 */
public interface JasperInterface {
    /**
     * Initialize and synchronize JasperReports and database parameters with the application. 
     * @throws JRException
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void init() throws JRException,ClassNotFoundException, SQLException;
    /**
     * Exports all datas to a PDF file using JasperReports and iReport(for the template).
     * @throws JRException
     * @throws IOException 
     */
    public void PDF() throws JRException, IOException ;
    /**
     * Export all datas to a XLSX file using JasperReports and iReport(for the template)
     * @throws JRException
     * @throws IOException 
     */
    public void XLSX() throws JRException, IOException;
    /**
     * Export data to XML format using JasperReports methods and iRepot(for the template).
     * via iReport
     * @throws JRException
     * @throws IOException 
     */
    public void XML() throws JRException, IOException;
}
