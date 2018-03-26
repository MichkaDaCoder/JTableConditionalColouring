package jtableconditionalcolouring.reports;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.query.JRJpaQueryExecuterFactory;
import jtableconditionalcolouring.model.Employee;
import jtableconditionalcolouring.utils.*;
import jtableconditionalcolouring.dao.*;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * JasperImplementation.java: implements <b>JasperInterface</b> interface and contains JasperReports methods for reporting and exporting datas in <b>PDF/XSLX/XML/HTML</b> formats.
 * @author MichkaDaCoder
 */
public class JasperImplementation implements JasperInterface{

    JasperPrint jp;
    EmployeeImplementation empImpl=new EmployeeImplementation();

    /**
     * Getter of EmployeeImplementation class.
     * @return EmployeeImplementation.
     */
    public EmployeeImplementation getEmpImpl() {
        return empImpl;
    }
    
    /**
     * Initialize JasperReport parameters with SQLite database
     * @throws JRException
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    @Override
    public void init() throws JRException, ClassNotFoundException, SQLException {
        Map params = new HashMap();
        params.put(JRJpaQueryExecuterFactory.PARAMETER_JPA_ENTITY_MANAGER, getEmpImpl().getEm());
        Class.forName(JFrameUtils.getBundleParam(JFrameUtils.getPROPERTIES_FILE(), "DB_CLASS_NAME"));
        Connection con = DriverManager.getConnection(JFrameUtils.getBundleParam(JFrameUtils.getPROPERTIES_FILE(), "DB_URL"), JFrameUtils.getBundleParam(JFrameUtils.getPROPERTIES_FILE(), "DB_USER"), JFrameUtils.getBundleParam(JFrameUtils.getPROPERTIES_FILE(), "DB_PASSWORD"));
        String path = "C:\\Users\\user\\Documents\\NetBeansProjects\\(Swing+JPA+SQLite) Conditional Table Colouring\\src\\jtableconditionalcolouring\\reports\\employeesReport.jasper";
        this.jp = JasperFillManager.fillReport(path, params,con);
    }

    /**
     * Export datas to a PDF file using JasperReport methods.
     * @throws JRException
     * @throws IOException 
     */
    @Override
    public void PDF() throws JRException, IOException {
         try {
            init();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployeeImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(getEmpImpl().findEmployees());
        JasperExportManager.exportReportToPdf(jp);
        JasperViewer.viewReport(jp);
    }

    /**
     * Export data to XLSX format using JasperReport methods.
     * @throws JRException
     * @throws IOException 
     */
    @Override
    public void XLSX() throws JRException, IOException {
        
    }

    /**
     * Export data to XML format using JasperReport methods.
     * @throws JRException
     * @throws IOException 
     */
    @Override
    public void XML() throws JRException, IOException {
        
    }

}
