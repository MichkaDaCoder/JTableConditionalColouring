package jtableconditionalcolouring.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * JFrameUtils.java: class of utilities functions such as display info/warning/error messages,
 * converters...
 * @author MichkaDaCoder
 */
public class JFrameUtils {
    static final String PROPERTIES_FILE="jtableconditionalcolouring/config/params_en_US";
    static final String EMAIL_FORMAT="\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
    static final String DATE_FORMAT="dd/MM/yyyy";
    
    public static String getPROPERTIES_FILE() {
        return PROPERTIES_FILE;
    }
    
    /**
     * Displays an info message to the user.
     * @param msg
     * @param titre 
     */
     public static void showInfoMessage(String msg,String titre) {
        JOptionPane.showMessageDialog(null, msg,titre,JOptionPane.INFORMATION_MESSAGE);
    }
    
     /**
      * Displays an error message to the user.
      * @param msg
      * @param title 
      */
    public static void showErrorMessage(String msg,String title) {
        JOptionPane.showMessageDialog(null, msg,title,JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Display a confirmation message dialog.
     * @param msg
     * @param title
     * @return <b>int</b>
     */
    public static int showConfirmMessage(String msg, String title) {
        return JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_NO_OPTION);
    }
    
    /**
     * Parses a given date to the format (dd/MM/yyyy)
     * @param date
     * @throws ParseException 
     */
    public static void parseDate(Object date) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(DATE_FORMAT);
        sdf.parse((String)date);
    }
    
    /**
     * Loads the properties files of configuration.
     * @throws IOException 
     */
    public static void loadConfigFile() throws IOException, NullPointerException{
        Locale locale=new Locale("en");
        Properties prop=new Properties();
        ResourceBundle rb=ResourceBundle.getBundle(getPROPERTIES_FILE(),locale);
        /*InputStream is=JFrameUtils.class.getClassLoader().getResourceAsStream(getPROPERTIES_FILE());
        prop.load(is);*/
    }
    
    /**
     * Gets the param key from the properties configuration file.
     * @param bundle
     * @param param
     * @return nothing
     */
    public static String getBundleParam(String bundle, String param)  {
        bundle="/jtableconditionalcolouring/config/params_fr_FR";
        return ResourceBundle.getBundle(getPROPERTIES_FILE()).getString(param);
    }
    
    /**
     * Check if a group of a given String fields ais empty.
     * @see Empty Multiple JTextFields.
     * @param txt
     * @return <b>boolean</b>
     */
    public static boolean areFieldsEmpty(String...txt) {
        return txt.length<1;
    }
    
    /**
     * Check if a given email address matches the pattern.
     * @param txt
     * @return <b>boolean</b>
     */
    public static boolean isEmailFormat(String txt) {
        Pattern p=Pattern.compile(EMAIL_FORMAT);
        Matcher m=p.matcher(txt);
        return m.find();
    }
}
