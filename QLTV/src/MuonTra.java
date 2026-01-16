import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class MuonTra extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MuonTra.class.getName());

    /**
     * Creates new form StudentJFrame
     */
    public MuonTra() {
        initComponents();
        LoadData();
        
    }

    Connection con;
    PreparedStatement pst;
    
public class JDBCUtil{
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sach","root","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }   
    
    public static void closeConnection(Connection con){
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

private void LoadData(){
        try {
            con = JDBCUtil.getConnection();
            int QQ;
            pst = con.prepareStatement("SELECT * FROM muonsach");
            ResultSet Rs = pst.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            
            QQ = RSMD.getColumnCount();
            
            DefaultTableModel DFG = (DefaultTableModel)jTable1.getModel();
            
            DFG.setRowCount(0);
            
            while(Rs.next()){
                Vector v2 = new Vector();
                
                
                    v2.add(Rs.getInt("STT"));
                    v2.add(Rs.getString("Mã Sinh Viên"));
                    v2.add(Rs.getString("Họ và Tên"));
                    v2.add(Rs.getInt("Mã Sách"));
                    v2.add(Rs.getDate("Ngày mượn"));
                    v2.add(Rs.getDate("Ngày hẹn trả"));
                    v2.add(Rs.getInt("Số Lượng"));
                    v2.add(Rs.getString("Trạng Thái"));
                    
                
                DFG.addRow(v2);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            System.getLogger(BookJFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
private void searchAll(String keyword){
        try {
            con = JDBCUtil.getConnection();
            
            String sql ="""
                            SELECT * FROM muonsach
                            WHERE CAST(`STT` AS CHAR) LIKE ?
                            OR CAST(`Mã Sinh Viên` AS CHAR) LIKE ?
                            OR `Họ và Tên` LIKE ?
                            OR CAST(`Mã Sách` AS CHAR) LIKE ?
                            OR CAST(`Ngày mượn` AS CHAR) LIKE ?
                            OR CAST(`Ngày hẹn trả` AS CHAR) LIKE ?
                            OR CAST(`Số Lượng` AS CHAR) LIKE ?
                            OR `Trạng Thái` LIKE ?
                            """;
            
            pst = con.prepareStatement(sql);
            
            for(int i=1;i<=8;i++){
                pst.setString(i, "%" + keyword + "%");
            } 
            
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                Vector row = new Vector();
                row.add(rs.getInt("STT"));
                row.add(rs.getString("Mã Sinh Viên"));
                row.add(rs.getString("Họ và Tên"));
                row.add(rs.getString("Mã Sách"));
                row.add(rs.getDate("Ngày mượn"));
                row.add(rs.getDate("Ngày hẹn trả"));
                row.add(rs.getInt("Số Lượng"));
                row.add(rs.getString("Trạng Thái"));
                model.addRow(row);
            }
            JDBCUtil.closeConnection(con);
              } catch (SQLException ex) {
            System.getLogger(MuonTra.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtMaSach = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTenSV = new javax.swing.JTextField();
        btnmuon = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btntra = new javax.swing.JButton();
        btntim = new javax.swing.JButton();
        txttim = new javax.swing.JTextField();
        txtNgayHenTra = new com.toedter.calendar.JDateChooser();
        txtNgayMuon = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtSTT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chương Trình Quản Lý Thư Viện");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản Lý Mượn Trả");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Mã SV");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Mã Sách");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Ngày mượn");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Số lượng");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Ngày hẹn trả");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Tên SV");

        btnmuon.setText("Mượn");
        btnmuon.addActionListener(this::btnmuonActionPerformed);

        btnupdate.setText("Sửa");
        btnupdate.addActionListener(this::btnupdateActionPerformed);

        btntra.setText("Trả");
        btntra.addActionListener(this::btntraActionPerformed);

        btntim.setText("Tìm Kiếm");
        btntim.addActionListener(this::btntimActionPerformed);

        txttim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("STT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSTT)
                    .addComponent(txtMaSV)
                    .addComponent(txtMaSach)
                    .addComponent(txtTenSV)
                    .addComponent(txtNgayHenTra, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btntim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btntra)
                                .addGap(30, 30, 30)
                                .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnmuon))
                        .addGap(47, 47, 47)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtNgayHenTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmuon)
                    .addComponent(btnupdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btntra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntim)
                    .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sinh Viên", "Họ và Tên", "Mã Sách", "Ngày mượn", "Ngày hẹn trả", "Số lượng", "Trạng Thái"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setText("x");
        jButton6.addActionListener(this::jButton6ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btntraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntraActionPerformed
        if (txtSTT.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nhập STT cần trả!");
        return;
    }

    int stt;
    try {
        stt = Integer.parseInt(txtSTT.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "STT phải là số!");
        return;
    }

    try {
        con = JDBCUtil.getConnection();
        con.setAutoCommit(false);

        // 2️⃣ Lấy thông tin mượn theo STT
        String selectSql = """
            SELECT `Mã Sách`, `Số Lượng`, `Trạng Thái`
            FROM muonsach
            WHERE STT = ?
        """;

        pst = con.prepareStatement(selectSql);
        pst.setInt(1, stt);
        ResultSet rs = pst.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "Không tồn tại STT này!");
            return;
        }

        if ("Đã trả".equals(rs.getString("Trạng Thái"))) {
            JOptionPane.showMessageDialog(this, "Phiếu mượn này đã được trả!");
            return;
        }

        int maSach = rs.getInt("Mã Sách");
        int soLuongTra = rs.getInt("Số Lượng");

        String updateMuon = """
            UPDATE muonsach
            SET `Trạng Thái` = 'Đã trả'
            WHERE STT = ?
        """;
        pst = con.prepareStatement(updateMuon);
        pst.setInt(1, stt);
        pst.executeUpdate();

        String updateSach = """
            UPDATE sach
            SET `Số Lượng` = `Số Lượng` + ?
            WHERE `Mã Sách` = ?
        """;
        pst = con.prepareStatement(updateSach);
        pst.setInt(1, soLuongTra);
        pst.setInt(2, maSach);
        pst.executeUpdate();

        con.commit();

        JOptionPane.showMessageDialog(this, "Trả sách thành công!");
        LoadData();
        txtSTT.setText("");

    } catch (Exception e) {
        try { con.rollback(); } catch (Exception ex) {}
        JOptionPane.showMessageDialog(this, "Lỗi trả sách!");
        e.printStackTrace();
    }
    }//GEN-LAST:event_btntraActionPerformed

    private void btnmuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmuonActionPerformed
        int maSach = Integer.parseInt(txtMaSach.getText());
    int soLuongMuon = (int) txtSoLuong.getValue();

    try {
        con = JDBCUtil.getConnection();
        con.setAutoCommit(false);

        
        String checkSql = "SELECT `Số Lượng` FROM sach WHERE `Mã Sách` = ?";
        pst = con.prepareStatement(checkSql);
        pst.setInt(1, maSach);
        ResultSet rs = pst.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sách!");
            return;
        }

        int soLuongHienTai = rs.getInt("Số Lượng");

        if (soLuongHienTai < soLuongMuon) {
            JOptionPane.showMessageDialog(this, "Không đủ sách để mượn!");
            return;
        }

        
        String insertSql = """
            INSERT INTO muonsach 
            (`Mã Sinh Viên`, `Họ và Tên`, `Mã Sách`,
             `Ngày mượn`, `Ngày hẹn trả`, `Số Lượng`, `Trạng Thái`)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        pst = con.prepareStatement(insertSql);
        pst.setString(1, txtMaSV.getText());
        pst.setString(2, txtTenSV.getText());
        pst.setInt(3, maSach);
        pst.setDate(4, new java.sql.Date(txtNgayMuon.getDate().getTime()));
        pst.setDate(5, new java.sql.Date(txtNgayHenTra.getDate().getTime()));
        pst.setInt(6, soLuongMuon);
        pst.setString(7, "Chưa trả");

        pst.executeUpdate();

        
        String updateSach = """
            UPDATE sach 
            SET `Số Lượng` = `Số Lượng` - ?
            WHERE `Mã Sách` = ?
        """;

        pst = con.prepareStatement(updateSach);
        pst.setInt(1, soLuongMuon);
        pst.setInt(2, maSach);
        pst.executeUpdate();

        con.commit();

        JOptionPane.showMessageDialog(this, "Mượn sách thành công!");
        LoadData();

    } catch (Exception e) {
        try { con.rollback(); } catch (Exception ex) {}
        JOptionPane.showMessageDialog(this, "Lỗi mượn sách!");
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnmuonActionPerformed

    private void txttimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimKeyReleased
        String keyword = txttim.getText().trim();
        if(keyword.isEmpty()){
            LoadData();
        }
        else{
            searchAll(keyword);
        }
    }//GEN-LAST:event_txttimKeyReleased

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE muonsach SET "
                    + "`Mã Sinh Viên` = ?, "
                    + "`Họ và Tên` = ?, "
                    + "`Mã Sách` = ?, "                  
                    + "`Ngày mượn` = ?, "
                    + "`Ngày hẹn trả` = ?, "
                    + "`Số Lượng` = ? "
                    + "WHERE STT = ?";

            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, txtMaSV.getText());
            pst.setString(2, txtTenSV.getText());
            pst.setInt(3, Integer.parseInt(txtMaSach.getText()));
            pst.setDate(4, new java.sql.Date(txtNgayMuon.getDate().getTime()));
            pst.setDate(5, new java.sql.Date(txtNgayHenTra.getDate().getTime()));
            pst.setInt(6, (int) txtSoLuong.getValue());
            pst.setInt(7, Integer.parseInt(txtSTT.getText()));

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Sửa Thành Công");

            JDBCUtil.closeConnection(con);
            LoadData();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnupdateActionPerformed

    private void btntimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimActionPerformed
        String keyword = txttim.getText().trim();
        if(keyword.isEmpty()){
            LoadData();
        }
        else{
            searchAll(keyword);
        }
    }//GEN-LAST:event_btntimActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MuonTra().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmuon;
    private javax.swing.JButton btntim;
    private javax.swing.JButton btntra;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtMaSach;
    private com.toedter.calendar.JDateChooser txtNgayHenTra;
    private com.toedter.calendar.JDateChooser txtNgayMuon;
    private javax.swing.JTextField txtSTT;
    private javax.swing.JSpinner txtSoLuong;
    private javax.swing.JTextField txtTenSV;
    private javax.swing.JTextField txttim;
    // End of variables declaration//GEN-END:variables
}
