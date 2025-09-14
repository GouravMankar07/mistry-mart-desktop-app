
package mistrymart_GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.SQLException;
import java.util.List;
import mistrymart_DAO.orderDAO;
import mistrymart_POJO.ReceptionistPOJO;
import mistrymart_POJO.UserProfile;

public class ViewOrderOfManager extends javax.swing.JDialog {

    public ViewOrderOfManager() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadAllOrderIds();
    }

    // ComboBox me order IDs load karna
    private void loadAllOrderIds() {
           try {
        List<String> allIds = orderDAO.getAllOrderId(); // DAO se sari IDs mangwao
        if (allIds.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No orders found in the database.", "No Data", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (String id : allIds) {
            comboxOrderId.addItem(id); // Ek-ek karke ComboBox me add karo
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading order IDs from database!", "DB Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }

    }

    // Show button action
    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {

         try {
        // 1. ComboBox se select ki hui Order ID nikalo.
        String selectedOrderId = (String) comboxOrderId.getSelectedItem();

        // 2. Check karo ki user ne kuch select kiya hai ya nahi.
        if (selectedOrderId == null) {
            JOptionPane.showMessageDialog(this, "Please select an Order ID!", "Selection Missing", JOptionPane.WARNING_MESSAGE);
            return; // Method se bahar aa jao
        }

        // 3. Order ID ko process karo (e.g., "O-101" se 101 banao).
        String numericId = selectedOrderId; 

        // 4. DAO se us Order ID ki saari details mangwao.
        // Maan lete hain ki aapke paas orderDAO me getOrderDetails naam ka method hai.
        List<Object[]> orderDetails = orderDAO.getOrderDetails(numericId);

        // 5. Table ko clear karo aur nayi details daalo.
        DefaultTableModel model = (DefaultTableModel) tableAllOrders.getModel();
        model.setRowCount(0); // Purana saara data table se हटा do

        // Check karo ki us order me details hain ya nahi.
        if (orderDetails.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No details found for Order ID: " + selectedOrderId, "Empty Order", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Ek-ek karke saari rows ko table me add karo.
            for (Object[] row : orderDetails) {
                model.addRow(row);
            }
        }

    } catch (NumberFormatException e) {
        // Yeh error tab aayega agar "O-101" se 101 me convert karte time problem hui.
        JOptionPane.showMessageDialog(this, "Invalid Order ID format.", "Format Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (SQLException e) {
        // Yeh error tab aayega agar database se data laane me problem hui.
        JOptionPane.showMessageDialog(this, "Error fetching data from database!", "Database Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }

    // 🔻 original buttons ki action ko rehne dete hain
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        ManagerOptionsFrame managerOptionsFrame = new ManagerOptionsFrame();
        managerOptionsFrame.setVisible(true);
        this.dispose();
    }

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }

    private void comboxOrderIdActionPerformed(java.awt.event.ActionEvent evt) {
        // comboBox select hone par kuchh nahi karna
    }

    // ====== Swing Designer generated code + table ======
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAllOrders = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboxOrderId = new javax.swing.JComboBox<>();
        btnShow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        tableAllOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Product ID", "Product Name", "Product Company", "Product Price", "Our Price", "Quantity", "Tax"
            }
        ) {
            boolean[] canEdit = new boolean [] { false, false, false, false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAllOrders);

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnBack.setText("Back");
        btnBack.addActionListener(this::btnBackActionPerformed);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED),
                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("View All Orders");

        btnLogOut.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(this::btnLogOutActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel2.setText("Select Order Id");

        comboxOrderId.addActionListener(this::comboxOrderIdActionPerformed);

        btnShow.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnShow.setText("Show");
        btnShow.addActionListener(this::btnShowActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(44, 44, 44))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(comboxOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnShow)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnLogOut))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboxOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShow))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    // Variables declaration
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnShow;
    private javax.swing.JComboBox<String> comboxOrderId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAllOrders;
   
}
