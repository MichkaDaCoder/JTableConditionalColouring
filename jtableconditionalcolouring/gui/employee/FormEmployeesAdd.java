package jtableconditionalcolouring.gui.employee;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import jtableconditionalcolouring.dao.EmployeeImplementation;
import jtableconditionalcolouring.model.Employee;
import jtableconditionalcolouring.utils.JFrameUtils;

/**
 * FormEmployeeAdd.java: form that allow you to add a new employee.
 *
 * @author MichkaDaCoder
 */
public class FormEmployeesAdd extends javax.swing.JFrame {

    final EmployeeImplementation empImpl = new EmployeeImplementation();
    Employee employee = new Employee();

    int confirm;

    public FormEmployeesAdd() {
        initComponents();

        this.hireDate.setFormats("dd/MM/yyyy");

        try {
            empImpl.connexion();
        } catch (Exception ex) {
            JFrameUtils.showErrorMessage(ex.getMessage(), ex.getClass().getName());
        }
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeImplementation getEmpImpl() {
        return empImpl;
    }

    /**
     * Mapping the employee attributes to JTextFields values.
     */
    private void mapping() {
        this.employee.setFirstName(txtFname.getText());
        this.employee.setLastName(txtLname.getText());
        this.employee.setEmail(txtEmail.getText());
        this.employee.setAddress(txtAddress.getText());
        this.employee.setHiredate(this.hireDate.getDate());
        if (!txtSalary.getText().isEmpty()) {
            this.employee.setSalary(Integer.parseInt(txtSalary.getText()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLname = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        hireDate = new org.jdesktop.swingx.JXDatePicker();
        btn_add = new javax.swing.JButton();

        setTitle("New Employee");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Last Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("First Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 19, -1, -1));
        jPanel1.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 230, -1));
        jPanel1.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 230, -1));

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 230, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSalaryKeyPressed(evt);
            }
        });
        jPanel1.add(txtSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 230, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Salary:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Hiredate:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        jPanel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 230, 100));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Address:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        hireDate.setToolTipText("Pick a date");
        jPanel1.add(hireDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 660, 200));

        btn_add.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btn_add.setText("Create");
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 230, 100, 40));

        setSize(new java.awt.Dimension(698, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:

        this.confirm = JFrameUtils.showConfirmMessage(JFrameUtils.getBundleParam(JFrameUtils.getPROPERTIES_FILE(), "PARAM_CONFIRM_EMPLOYEE_ADD"), "Confirm");
        switch (this.confirm) {
            case 0:
                try {
                    mapping();
                    if (getEmpImpl().getEm().isOpen()) {
                        getEmpImpl().connexion();
                        getEmpImpl().add(employee);
                        JFrameUtils.showInfoMessage("" + hireDate.getDate(), "Info");
                    }
                    JFrameUtils.showInfoMessage(JFrameUtils.getBundleParam(JFrameUtils.getPROPERTIES_FILE(), "PARAM_SUCCESS_EMPLOYEE_ADD"), "Info");
                } catch (Exception ex) {
                    JFrameUtils.showErrorMessage(ex.getMessage(), ex.getClass().getName());
                }
                break;
                
            case JOptionPane.NO_OPTION:
                 
                break;
        }


    }//GEN-LAST:event_btn_addActionPerformed


    private void txtSalaryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalaryKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_txtSalaryKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        // TODO add your handling code here:
        if (!txtEmail.getText().isEmpty()) {
            if (!JFrameUtils.isEmailFormat(txtEmail.getText())) {
                txtEmail.setBackground(Color.RED);
            } else {
                txtEmail.setBackground(Color.WHITE);
            }
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormEmployeesAdd.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEmployeesAdd.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEmployeesAdd.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEmployeesAdd.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEmployeesAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private org.jdesktop.swingx.JXDatePicker hireDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables
}
