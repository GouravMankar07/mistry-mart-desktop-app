package mistrymart_GUI;

import java.sql.SQLException;
import javax.swing.JOptionPane;

import mistrymart_DAO.ProductDAO;
import mistrymart_POJO.BarCode_IMG_Generator;
import mistrymart_POJO.ProductPOJO;

public class AddItemPenal extends javax.swing.JFrame {

    /**
     * Creates new form AddItemPenal
     */
    public AddItemPenal() {
        initComponents();
        this.setLocationRelativeTo(null);
        getNewProductId();
    }

    private boolean validateInput() {
        return !(txtproductname.getText().isEmpty() || txtproductcompany.getText().isEmpty()
                || txtproductprice.getText().isEmpty() || txtourprice.getText().isEmpty()
                || txtQuantity.getText().isEmpty());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtproductid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtproductname = new javax.swing.JTextField();
        txtproductprice = new javax.swing.JTextField();
        txtourprice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tcomboxtax = new javax.swing.JComboBox<>();
        txtproductcompany = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Add Item Penal");

        btnback.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnback.setText("Back");
        btnback.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED),
                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnlogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnlogout.setText("Log Out");
        btnlogout.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED),
                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(btnlogout)
                                .addGap(70, 70, 70)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE)));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED),
                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Product Id");

        txtproductid.setEditable(false);
        txtproductid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Product Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Product Price");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Our Price");

        txtproductname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtproductprice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtourprice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Product Compnany");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Quantity");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Tax");

        tcomboxtax.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tcomboxtax.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "5%", "18%", "28%" }));

        txtproductcompany.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnadd.setBackground(new java.awt.Color(255, 204, 204));
        btnadd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnadd.setText("Add");
        btnadd.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED),
                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtproductid, javax.swing.GroupLayout.PREFERRED_SIZE, 119,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtproductprice,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 119,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtproductname,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 119,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtourprice,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 119,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addGroup(jPanel3Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(tcomboxtax, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(64, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(txtproductcompany,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 97,
                                                                Short.MAX_VALUE)
                                                        .addComponent(txtQuantity))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtproductid, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(txtproductcompany, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtproductname, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel8)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtproductprice, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel9)
                                        .addComponent(tcomboxtax, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtourprice, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41,
                                        Short.MAX_VALUE)
                                .addComponent(btnadd)
                                .addGap(25, 25, 25)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Add Item ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {
        ManageStockes manageStockes=new ManageStockes();
        manageStockes.setVisible(true);
        this.dispose();
    }

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {
        if (!validateInput()) {
            JOptionPane.showMessageDialog(null, "please Input all the filed", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int n = tcomboxtax.getSelectedItem().toString().length();
            int tax = Integer.parseInt(tcomboxtax.getSelectedItem().toString().substring(0, n - 1));
            ProductPOJO productPOJO = new ProductPOJO();
            productPOJO.setProductId(txtproductid.getText().trim());
            productPOJO.setProductName(txtproductname.getText().trim());
            productPOJO.setProductCompany(txtproductcompany.getText().trim());
            productPOJO.setProductPrice(Double.parseDouble(txtproductprice.getText().trim()));
            productPOJO.setOurPrice(Double.parseDouble(txtourprice.getText().trim()));
            productPOJO.setQuantity(Integer.parseInt(txtQuantity.getText().trim()));
            productPOJO.setTax(tax);

            boolean result = ProductDAO.addProduct(productPOJO);
            if (result) {
                JOptionPane.showMessageDialog(null, "Product Added Successfully ", "Success",JOptionPane.INFORMATION_MESSAGE);
                BarCode_IMG_Generator.createImage(txtproductid.getText()+".png", txtproductid.getText());
                clearText();
                getNewProductId();
                return;
            }
            JOptionPane.showMessageDialog(null, "Product Not Saved ", "ERROR!", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DB Error!", "Error!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "please Input Integers only", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddItemPenal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItemPenal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItemPenal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItemPenal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItemPenal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnlogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> tcomboxtax;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtourprice;
    private javax.swing.JTextField txtproductcompany;
    private javax.swing.JTextField txtproductid;
    private javax.swing.JTextField txtproductname;
    private javax.swing.JTextField txtproductprice;

    // End of variables declaration
    void getNewProductId() {
        try {
            String pId = ProductDAO.getNextProductId();
            txtproductid.setText(pId);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DB Error!", "Error!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    void clearText() {
        txtproductname.setText("");
        txtQuantity.setText("");
        txtourprice.setText("");
        txtproductcompany.setText("");
        txtproductprice.setText("");
        tcomboxtax.setSelectedItem(0);
    }

}
