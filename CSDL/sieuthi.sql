use SieuThiMini
create table KhachHang(
	MaKH int identity primary key,
	TenKH nvarchar(50),
	GioiTinh nvarchar(10),
	SDT nvarchar(13),
	DiaChi nvarchar(150)

)
create table NVien(
	MaNV int identity primary key,
	TenNV nvarchar(50),
	GioiTinh nvarchar(10),
	MatKhau nvarchar(50)
)
create table DanhMuc(
	MaDanhMuc int identity primary key,
	TenDanhMuc nvarchar(50),
	MieuTa nvarchar(150)
)
create table SanPham(
	MaSanPham int identity primary key,
	TenSanPham nvarchar(50),
	DanhMuc nvarchar(50),
	DonVi nvarchar(50),
	Gia real,
	SoLuongCon int,
)


create table tblAdmin(
	ID int identity primary key,
	TenAdmin nvarchar(50),
	MatKhau nvarchar(150)
)
create table HoaDon(
	maHD int identity primary key,
	maKH int foreign key references KhachHang(MaKH),
	TenKhachHang nvarchar(50),
	DiaChi nvarchar(150),
	NgayTaoHoaDon date
)
create table ChiTietHoaDon(
	maCTHD int identity primary key,
	maHD int foreign key references HoaDon(maHD),
	maSP int foreign key references SanPham(MaSanPham ),
	tenSP nvarchar(50),
	donvi nvarchar(50),
	soluong int not null,
	gia real not null,
	thanhtien real not null
)
