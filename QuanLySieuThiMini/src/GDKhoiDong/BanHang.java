/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GDKhoiDong;

/**
 *
 * @author ADMIN
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static ketnoiSQL.JDBCConnection.getJDBCConnection;
import net.proteanit.sql.DbUtils;

public class BanHang extends javax.swing.JFrame {

    Connection con = getJDBCConnection();
    Statement st = null;
    ResultSet rs = null;
    int i = 1;
    double TongTien = 0;
    DefaultTableModel defaultTableModel;
    int slhientai; //sl hien tai trong bang San Pham
    int slsauban;   // sl con lai sau khi them san pham vao bang mua hang
    int slmua;  // sl mua trong bang mua hang
    int idspmua; //idsp mua
    int slconsauxoasp; //so luong con lai sau khi xoa san pham, cap nhap o bang san pham
    int slconlai; //so luong con lai sau khi them vao bang mua hang
    int MyindexBMH; //vi tri con tro trong bang mua hang
    double thanhtiensp; //thanhtien 1 sp khi chon
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    Vector vec;

    public BanHang() {
        initComponents();
        DisplayInTable();
        DisplayComboboxDanhMuc();
        DisplayComboboxKhachHang();
        formhoadon.setVisible(false);
        luu.setVisible(false);
        makhachhang.setVisible(false);
        diachikhachhang.setVisible(false);
        donvi.setVisible(false);
        slht.setVisible(false);
        idsp.setVisible(false);
        huyhoadon.setVisible(false);
    }

    //Hiển Thị thông tin trong bảng mua hàng
    public void DisplayBangMuaHang() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select maSP as N'Mã Sản Phẩm', tensp as N'Tên Sản Phẩm', Donvi as N'Đơn Vị', SoLuong as N'Số Lượng', Gia as N'Giá', thanhtien as N'Thành tiền' from ChiTietHoaDon where maHD='" + Integer.parseInt(maHD1.getText()) + "'");
            BangMuaHang.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Hiển Thị thông tin trong bảng sản phẩm
    public void DisplayInTable() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select MaSanPham as N'Mã Sản Phẩm', TenSanPham as N'Tên Sản Phẩm', DanhMuc as N'Danh Mục' ,DonVi as N'Đơn Vị', Gia as N'Giá', SoLuongCon as N'Số Lượng Còn', Hinhanh as N'Hình ảnh' from SanPham");
            BangSanPham.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Hiển thị danh mục trong combobox
    public void DisplayComboboxDanhMuc() {
        try {
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("Select * from DanhMuc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ten = rs.getString("TenDanhMuc");
                DMSP.addItem(ten);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Hiển thị tên khách hàng trong Combobox
    public void DisplayComboboxKhachHang() {
        try {
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("Select * from KhachHang");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ten = rs.getString("TenKH");
                khachhang.addItem(ten);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatemua() {
        slsauban = Integer.parseInt(slht.getText()) - Integer.parseInt(soluong.getText());
        try {

            String sql = "Update SanPham set SoLuongCon='" + slsauban + "'" + " where MaSanPham=" + idsp.getText();
            Statement Add = con.createStatement();
            Add.executeUpdate(sql);
            DisplayInTable();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công số lượng sản phẩm sau khi bán!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//Clear Table BangMuaHang

    public void clearTable() {
        DefaultTableModel dm = (DefaultTableModel) BangMuaHang.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        namesp = new javax.swing.JTextField();
        DMSP = new javax.swing.JComboBox<>();
        gia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        soluong = new javax.swing.JTextField();
        loc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BangSanPham = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        khachhang = new javax.swing.JComboBox<>();
        themKHmoi = new javax.swing.JButton();
        lammoi1 = new javax.swing.JButton();
        formhoadon = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        diachi = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BangMuaHang = new javax.swing.JTable();
        ngayBH = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        maHD1 = new javax.swing.JLabel();
        tenKH1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tt = new javax.swing.JLabel();
        xoasp = new javax.swing.JButton();
        makhachhang = new javax.swing.JLabel();
        diachikhachhang = new javax.swing.JLabel();
        donvi = new javax.swing.JLabel();
        slht = new javax.swing.JLabel();
        idsp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        taohoadon = new javax.swing.JButton();
        huyhoadon = new javax.swing.JButton();
        luu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setBackground(new java.awt.Color(255, 102, 102));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 51));
        jLabel3.setText("BÁN HÀNG");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 51));
        jLabel5.setText("Tên sản phẩm:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 51));
        jLabel6.setText("Lọc theo:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setText("Giá:");

        DMSP.setForeground(new java.awt.Color(255, 102, 51));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 51));
        jLabel8.setText("Số lượng:");

        loc.setBackground(new java.awt.Color(255, 102, 0));
        loc.setText("Lọc");
        loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locActionPerformed(evt);
            }
        });

        BangSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "DANH MỤC", "ĐƠN VỊ", "GIÁ"
            }
        ));
        BangSanPham.setIntercellSpacing(new java.awt.Dimension(0, 0));
        BangSanPham.setRowHeight(25);
        BangSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BangSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BangSanPham);

        jLabel10.setBackground(new java.awt.Color(255, 102, 102));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 102, 51));
        jLabel10.setText("DANH SÁCH SẢN PHẨM");

        add.setBackground(new java.awt.Color(255, 102, 0));
        add.setText("Thêm vào hóa đơn");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 51));
        jLabel9.setText("Tên khách hàng:");

        khachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khachhangActionPerformed(evt);
            }
        });

        themKHmoi.setBackground(new java.awt.Color(255, 102, 51));
        themKHmoi.setText("Thêm");
        themKHmoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themKHmoiMouseClicked(evt);
            }
        });

        lammoi1.setBackground(new java.awt.Color(255, 102, 0));
        lammoi1.setText("Làm mới");
        lammoi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lammoi1MouseClicked(evt);
            }
        });

        formhoadon.setBackground(new java.awt.Color(224, 249, 249));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Mã hóa đơn:");

        jLabel12.setBackground(new java.awt.Color(255, 102, 102));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setText("HÓA ĐƠN BÁN HÀNG");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Ngày bán hàng:");

        diachi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        diachi.setForeground(new java.awt.Color(255, 51, 51));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("Địa chỉ:");

        BangMuaHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        BangMuaHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BangMuaHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(BangMuaHang);

        ngayBH.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ngayBH.setForeground(new java.awt.Color(255, 51, 51));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("Tên khách hàng:");

        maHD1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        maHD1.setForeground(new java.awt.Color(255, 51, 51));

        tenKH1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tenKH1.setForeground(new java.awt.Color(255, 51, 51));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 102, 51));
        jLabel17.setText("TỔNG TIỀN:");

        tt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tt.setForeground(new java.awt.Color(255, 102, 51));

        xoasp.setBackground(new java.awt.Color(255, 51, 51));
        xoasp.setText("Xóa");
        xoasp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xoaspMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout formhoadonLayout = new javax.swing.GroupLayout(formhoadon);
        formhoadon.setLayout(formhoadonLayout);
        formhoadonLayout.setHorizontalGroup(
            formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formhoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formhoadonLayout.createSequentialGroup()
                        .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diachi)
                            .addComponent(ngayBH, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(formhoadonLayout.createSequentialGroup()
                        .addComponent(xoasp)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(formhoadonLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formhoadonLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(maHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formhoadonLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(tenKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formhoadonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(345, 345, 345))
        );
        formhoadonLayout.setVerticalGroup(
            formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formhoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formhoadonLayout.createSequentialGroup()
                        .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngayBH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(formhoadonLayout.createSequentialGroup()
                        .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tenKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formhoadonLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(formhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formhoadonLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formhoadonLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(tt)
                                .addGap(65, 65, 65))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formhoadonLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xoasp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );

        makhachhang.setText("jLabel2");

        diachikhachhang.setText("jLabel2");

        donvi.setText("jLabel4");

        slht.setText("jLabel2");

        idsp.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namesp)
                            .addComponent(soluong)
                            .addComponent(gia)
                            .addComponent(khachhang, 0, 194, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(add)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(makhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(idsp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(diachikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(donvi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(slht, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(themKHmoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(88, 88, 88))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(DMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(loc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 545, Short.MAX_VALUE)
                        .addComponent(lammoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(392, 392, 392))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(formhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(themKHmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namesp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(makhachhang)
                            .addComponent(idsp))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(gia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(slht)))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(diachikhachhang)
                                .addGap(18, 18, 18)
                                .addComponent(donvi)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(DMSP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(loc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lammoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(formhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/4.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setText("Trở về");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        taohoadon.setBackground(new java.awt.Color(204, 255, 255));
        taohoadon.setText("Tạo hóa đơn");
        taohoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taohoadonMouseClicked(evt);
            }
        });

        huyhoadon.setBackground(new java.awt.Color(204, 255, 255));
        huyhoadon.setText("Hủy hóa đơn");
        huyhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                huyhoadonMouseClicked(evt);
            }
        });

        luu.setBackground(new java.awt.Color(204, 255, 255));
        luu.setText("Lưu hóa đơn");
        luu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                luuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(taohoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(huyhoadon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(luu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(38, 38, 38)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(taohoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(huyhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(luu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BangSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangSanPhamMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) BangSanPham.getModel();
        int Myindex = BangSanPham.getSelectedRow();
        namesp.setText(model.getValueAt(Myindex, 1).toString());
        soluong.setText("1");
        gia.setText(model.getValueAt(Myindex, 4).toString());
        donvi.setText(model.getValueAt(Myindex, 3).toString());
        slht.setText(model.getValueAt(Myindex, 5).toString());
        idsp.setText(model.getValueAt(Myindex, 0).toString());
    }//GEN-LAST:event_BangSanPhamMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new TrangChuNhanVien().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void themKHmoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themKHmoiMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new KhachHang().setVisible(true);
    }//GEN-LAST:event_themKHmoiMouseClicked

    private void locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locActionPerformed
        // TODO add your handling code here:
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select *from SanPham where DanhMuc=N'" + DMSP.getSelectedItem().toString() + "'");
            BangSanPham.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_locActionPerformed

    private void lammoi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lammoi1MouseClicked
        // TODO add your handling code here:
        DisplayInTable();
    }//GEN-LAST:event_lammoi1MouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        //Lấy giá trị của mã sản phẩm
        DisplayBangMuaHang();
        DefaultTableModel model = (DefaultTableModel) BangSanPham.getModel();
        int Myindex = BangSanPham.getSelectedRow();
        String idsp, dv;
        idsp = model.getValueAt(Myindex, 0).toString();
        dv = model.getValueAt(Myindex, 3).toString();
        //Tinh thành tiền
        int sl;
        sl = Integer.parseInt(soluong.getText());
        double giasp, thanhtien;
        giasp = Double.parseDouble(gia.getText());
        thanhtien = sl * giasp;
        slhientai = Integer.parseInt(slht.getText());
        //Chèn vào csdl ChiTietHoaDon

        if (namesp.getText().isEmpty() || soluong.getText().isEmpty() || gia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống! Mời bạn chọn sản phẩm lại!");
        } else if (slhientai < sl) {
            JOptionPane.showMessageDialog(this, "Không đủ sản phẩm để mua");
        } else {
            //Kiem tra ma sp nhap vao da co hay chua
            String sql1 = "select count(maSP) from ChiTietHoaDon where maHD=" + maHD1.getText() + "and maSP= " + idsp;
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql1);
                ResultSet rs1 = preparedStatement.executeQuery();
                while (rs1.next()) {
                    if (rs1.getInt(1) < 1) {
                        try {
                            PreparedStatement add = con.prepareStatement("insert into ChiTietHoaDon values (?,?,?,?,?,?,?)");
                            add.setString(1, maHD1.getText());
                            add.setString(2, idsp);
                            add.setString(3, namesp.getText());
                            add.setString(4, dv);
                            add.setString(5, soluong.getText());
                            add.setString(6, gia.getText());
                            add.setString(7, String.valueOf(thanhtien));
                            int row = add.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào Chi Tiết Hóa Đơn thành công!");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        DisplayBangMuaHang();
                        TongTien = TongTien + thanhtien;
                        tt.setText(String.valueOf(formatter.format(TongTien) + " VNĐ"));
                        updatemua();

                    } else {
                        try {
                            String sql = "Update ChiTietHoaDon set soluong=soluong+'" + soluong.getText() + "'" + ", thanhtien=thanhtien+'" + (Integer.parseInt(soluong.getText()) * Double.parseDouble(gia.getText())) + "'" + " where maHD=" + maHD1.getText() + "and maSP= " + idsp;
                            Statement Add = con.createStatement();
                            Add.executeUpdate(sql);
                            DisplayBangMuaHang();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        //Thêm dữ liệu vào bảng mua hàng    
                        DisplayBangMuaHang();
                        TongTien = TongTien + thanhtien;
                        tt.setText(String.valueOf(formatter.format(TongTien) + " VNĐ"));
                        updatemua();

                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        namesp.setText("");
        soluong.setText("");
        gia.setText("");

    }//GEN-LAST:event_addMouseClicked

//Hien thi maKH diachi từ combobox
    private void khachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khachhangActionPerformed
        // TODO add your handling code here:
        try {
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("Select *from KhachHang where TenKH=N'" + khachhang.getSelectedItem().toString() + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaKH");
                makhachhang.setText(ma);
                String dc = rs.getString("DiaChi");
                diachikhachhang.setText(dc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_khachhangActionPerformed

    private void taohoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taohoadonMouseClicked
        // Format ngày tháng năm
        TongTien = 0;
        tt.setText(String.valueOf(formatter.format(TongTien) + " VNĐ"));
        formhoadon.setVisible(true);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = new java.util.Date();
        //Thêm vào CSDL HoaDon
        try {
            PreparedStatement add = con.prepareStatement("Set dateformat dmy insert into HoaDon values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            add.setString(1, makhachhang.getText());
            add.setString(2, khachhang.getSelectedItem().toString());
            add.setString(3, diachikhachhang.getText());
            add.setString(4, dateFormat.format(date));
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công!");
            //Tự động lấy maHD vừa thêm
            ResultSet rs = add.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                maHD1.setText(String.valueOf(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Lay thong tin
        tenKH1.setText(khachhang.getSelectedItem().toString());
        ngayBH.setText(dateFormat.format(date));
        diachi.setText(diachikhachhang.getText());
        taohoadon.setVisible(false);
        huyhoadon.setVisible(true);
        luu.setVisible(true);


    }//GEN-LAST:event_taohoadonMouseClicked

    private void huyhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huyhoadonMouseClicked
        String sql1 = "select count(maHD) from ChiTietHoaDon  where maHD='" + Integer.parseInt(maHD1.getText()) + "'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql1);
            ResultSet rs1 = preparedStatement.executeQuery();
            while (rs1.next()) {
                if (rs1.getInt(1) == 0) {
                    try {
                        String mahd = maHD1.getText();
                        String sql = "Delete from HoaDon where maHD=" + mahd;
                        Statement Add = con.createStatement();
                        Add.executeUpdate(sql);
                        JOptionPane.showMessageDialog(this, "Xóa Thành Công Hóa Đơn!");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //delete table
                    formhoadon.setVisible(false);
                    taohoadon.setVisible(true);
                    huyhoadon.setVisible(false);
                    luu.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng xóa dữ liệu ở bảng mua hàng trước!");
                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_huyhoadonMouseClicked


    private void luuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_luuMouseClicked
        // TODO add your handling code here:
        String sql1 = "select count(maHD) from ChiTietHoaDon  where maHD='" + Integer.parseInt(maHD1.getText()) + "'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql1);
            ResultSet rs1 = preparedStatement.executeQuery();
            while (rs1.next()) {
                if (rs1.getInt(1) > 0) {
                    clearTable();
                    maHD1.setText("");
                    tenKH1.setText("");
                    diachi.setText("");
                    ngayBH.setText("");
                    formhoadon.setVisible(false);
                    taohoadon.setVisible(true);
                    huyhoadon.setVisible(false);
                    luu.setVisible(false);
                    namesp.setText("");
                    soluong.setText("");
                    gia.setText("");
                    JOptionPane.showMessageDialog(this, "Bạn đã lưu hóa đơn thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm trước khi lưu!");
                }

            }
        } catch (Exception e) {
        }


    }//GEN-LAST:event_luuMouseClicked

    private void xoaspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xoaspMouseClicked
        //Xoa trong CSDL ChiTietHoaDon
        if (idspmua == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xóa");
        } else {
            try {
                String sql = "Delete from ChiTietHoaDon where maHD=" + maHD1.getText() + "and maSP= " + idspmua;
                Statement Add = con.createStatement();
                Add.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Xóa Thành Công!");
                DisplayInTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Xoa trong BangMua Hang
            DefaultTableModel model = (DefaultTableModel) BangMuaHang.getModel();
            model.removeRow(MyindexBMH);
            //Thiet lap lai tong tien sau khi xoa
            TongTien = TongTien - thanhtiensp;
            tt.setText(String.valueOf(formatter.format(TongTien) + " VNĐ"));

            //Lấy số lượng trong bảng sản phẩm hiện tại
            String sql = "select * from SanPham where MaSanPham=" + idspmua;
            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    slconlai = rs.getInt("SoLuongCon");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            slconsauxoasp = slconlai + slmua;
            //Update soluong sau khi xóa
            try {

                String sql2 = "Update SanPham set SoLuongCon='" + slconsauxoasp + "'" + " where MaSanPham=" + idspmua;
                Statement Add = con.createStatement();
                Add.executeUpdate(sql2);
                DisplayInTable();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công số lượng sản phẩm sau khi bán!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            idspmua = 0;

        }

    }//GEN-LAST:event_xoaspMouseClicked

    private void BangMuaHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BangMuaHangMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) BangMuaHang.getModel();
        MyindexBMH = BangMuaHang.getSelectedRow();
        idspmua = Integer.parseInt(model.getValueAt(MyindexBMH, 0).toString());
        thanhtiensp = Double.parseDouble(model.getValueAt(MyindexBMH, 5).toString());
        slmua = Integer.parseInt(model.getValueAt(MyindexBMH, 3).toString());
    }//GEN-LAST:event_BangMuaHangMouseClicked

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
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangMuaHang;
    private javax.swing.JTable BangSanPham;
    private javax.swing.JComboBox<String> DMSP;
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JLabel diachi;
    private javax.swing.JLabel diachikhachhang;
    private javax.swing.JLabel donvi;
    private javax.swing.JPanel formhoadon;
    private javax.swing.JTextField gia;
    private javax.swing.JButton huyhoadon;
    private javax.swing.JLabel idsp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> khachhang;
    private javax.swing.JButton lammoi1;
    private javax.swing.JButton loc;
    private javax.swing.JButton luu;
    private javax.swing.JLabel maHD1;
    private javax.swing.JLabel makhachhang;
    private javax.swing.JTextField namesp;
    private javax.swing.JLabel ngayBH;
    private javax.swing.JLabel slht;
    private javax.swing.JTextField soluong;
    private javax.swing.JButton taohoadon;
    private javax.swing.JLabel tenKH1;
    private javax.swing.JButton themKHmoi;
    private javax.swing.JLabel tt;
    private javax.swing.JButton xoasp;
    // End of variables declaration//GEN-END:variables
}
