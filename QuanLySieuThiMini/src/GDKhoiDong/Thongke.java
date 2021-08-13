/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GDKhoiDong;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import static ketnoiSQL.JDBCConnection.getJDBCConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ADMIN
 */
public class Thongke extends javax.swing.JFrame {

    Connection con = getJDBCConnection();
    Statement st = null;
    ResultSet rs = null;
    CallableStatement cs;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date date = new java.util.Date();
    DecimalFormat formatter = new DecimalFormat("###,###,###");
//Clear Table BangMuaHang

    public void clearTable() {
        DefaultTableModel dm = (DefaultTableModel) BangThongKe.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }

    public Thongke() {
        initComponents();
        
        ngayhientai.setVisible(false);
        namtk.setVisible(false);
        thangtk.setVisible(false);

    }

    //Hiển Thị Dữ Liệu theo ngày
    public void TKTheoNgayHienTai() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("Set dateformat dmy Select *from ChiTietHoaDon as c , HoaDon as d where c.maHD=d.maHD and d.NgayTaoHoaDon='" + dateFormat.format(date) + "'");
            BangThongKe.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void TKTheoNgay() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("Set dateformat dmy Select *from ChiTietHoaDon as c , HoaDon as d where c.maHD=d.maHD and d.NgayTaoHoaDon='" + ngayhientai.getText() + "'");
            BangThongKe.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void TKTheoThang() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("Set dateformat dmy Select * from ChiTietHoaDon as c , HoaDon as d where c.maHD=d.maHD and year(d.NgayTaoHoaDon)='" + namtk.getText() + "'" + "and month(d.NgayTaoHoaDon)='" + thangtk.getText() + "'");
            BangThongKe.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TKTheoNam() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("Set dateformat dmy Select * from ChiTietHoaDon as c , HoaDon as d where c.maHD=d.maHD and year(d.NgayTaoHoaDon)='" + namtk.getText() + "'");
            BangThongKe.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbtk = new javax.swing.JComboBox<>();
        Edit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BangThongKe = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        ngayhientai = new javax.swing.JLabel();
        thongke = new javax.swing.JLabel();
        thangtk = new javax.swing.JLabel();
        namtk = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        back2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setBackground(new java.awt.Color(255, 102, 102));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 51));
        jLabel3.setText("THỐNG KÊ DOANH THU");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Vui lòng chọn danh mục cần thống kê ( dữ liệu liên quan sẽ đổ ra ở dưới)");

        cbtk.setBackground(new java.awt.Color(255, 204, 204));
        cbtk.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbtk.setForeground(new java.awt.Color(255, 102, 51));
        cbtk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê ngày hiện tại", "Thống kê theo ngày", "Thống kê theo tháng/năm", "Thống kê theo năm", " " }));

        Edit.setBackground(new java.awt.Color(255, 102, 0));
        Edit.setText("Thống kê");
        Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditMouseClicked(evt);
            }
        });

        BangThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        BangThongKe.setIntercellSpacing(new java.awt.Dimension(0, 0));
        BangThongKe.setRowHeight(25);
        jScrollPane1.setViewportView(BangThongKe);

        jLabel10.setBackground(new java.awt.Color(255, 102, 102));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 102, 51));
        jLabel10.setText("DANH SÁCH DỮ LIỆU THỐNG KÊ");

        ngayhientai.setText("jLabel2");

        thongke.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        thongke.setForeground(new java.awt.Color(255, 51, 0));

        thangtk.setText("jLabel2");

        namtk.setText("jLabel4");

        Clear.setBackground(new java.awt.Color(255, 102, 0));
        Clear.setText("Làm mới");
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(namtk, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(thangtk, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ngayhientai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(257, 257, 257))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ngayhientai)
                                .addComponent(cbtk, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14)
                            .addComponent(thangtk)
                            .addGap(40, 40, 40))
                        .addComponent(namtk))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/tien.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        back2.setBackground(new java.awt.Color(255, 255, 255));
        back2.setText("Trở về");
        back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(back2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void back2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new TrangChuAdmin().setVisible(true);
    }//GEN-LAST:event_back2ActionPerformed

    private void EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseClicked
        // TODO add your handling code here:
        if (cbtk.getSelectedItem().toString().equals("Thống kê ngày hiện tại")) {
            String sql = "set dateformat dmy select SUM(thanhtien) from ChiTietHoaDon as c , HoaDon as d where c.maHD=d.maHD and d.NgayTaoHoaDon='" + dateFormat.format(date) + "'";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    thongke.setText("Doanh thu ngày hôm nay thu được là:       " + String.valueOf(formatter.format(rs.getDouble(1)) + " VNĐ"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            TKTheoNgayHienTai();

        } else if (cbtk.getSelectedItem().toString().equals("Thống kê theo ngày")) {
            String ngay = JOptionPane.showInputDialog(this, "Nhập ngày bạn cần thống kê(dd/MM/yyy)", "Nhập ngày", JOptionPane.DEFAULT_OPTION);
            ngayhientai.setText(ngay);
            String sql = "set dateformat dmy select SUM(thanhtien) from ChiTietHoaDon as c , HoaDon as d where c.maHD=d.maHD and d.NgayTaoHoaDon='" + ngayhientai.getText() + "'";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    thongke.setText("Doanh thu ngày " + ngayhientai.getText() + " thu được là:       " + String.valueOf(formatter.format(rs.getDouble(1)) + " VNĐ"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            TKTheoNgayHienTai();
        } else if (cbtk.getSelectedItem().toString().equals("Thống kê theo tháng/năm")) {
            String thang = JOptionPane.showInputDialog(this, "Nhập tháng cần thống kê", "Nhập tháng", JOptionPane.DEFAULT_OPTION);
            thangtk.setText(thang);
            String nam = JOptionPane.showInputDialog(this, "Nhập năm tương ứng", "Nhập năm", JOptionPane.DEFAULT_OPTION);
            namtk.setText(nam);
            String sql = "set dateformat dmy select SUM(thanhtien) from ChiTietHoaDon as c , HoaDon as d where c.maHD=d.maHD and year(d.NgayTaoHoaDon)='" + nam + "'" + "and month(d.NgayTaoHoaDon)='" + thang + "'";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    thongke.setText("Doanh thu tháng " + thang + " năm " + nam + " thu được là:     " + String.valueOf(formatter.format(rs.getDouble(1)) + "   VNĐ"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            TKTheoThang();
        } else {
            String nam = JOptionPane.showInputDialog(this, "Nhập năm tương ứng", "Nhập năm", JOptionPane.DEFAULT_OPTION);
            namtk.setText(nam);
            String sql = "set dateformat dmy select SUM(thanhtien) from ChiTietHoaDon as c , HoaDon as d where c.maHD=d.maHD and year(d.NgayTaoHoaDon)='" + nam + "'";
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    thongke.setText("Doanh thu tháng năm " + nam + " thu được là:     " + String.valueOf(formatter.format(rs.getDouble(1)) + "   VNĐ"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            TKTheoNam();
        }

    }//GEN-LAST:event_EditMouseClicked

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
        // TODO add your handling code here:
        clearTable();
        thongke.setText("");
        
    }//GEN-LAST:event_ClearMouseClicked

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
            java.util.logging.Logger.getLogger(Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Thongke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thongke().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangThongKe;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Edit;
    private javax.swing.JButton back2;
    private javax.swing.JComboBox<String> cbtk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel namtk;
    private javax.swing.JLabel ngayhientai;
    private javax.swing.JLabel thangtk;
    private javax.swing.JLabel thongke;
    // End of variables declaration//GEN-END:variables
}