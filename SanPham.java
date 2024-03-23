package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Iterator;

class SanPham {
    private static ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private String ten;
    private double gia;
    private int soLuong;
  

    public SanPham(String ten, double gia, int soLuong) {
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
    }
    
    public String layTen() {
        return ten;
    }

    public double layGia() {
        return gia;
    }

    public int laySoLuong() {
        return soLuong;
    }

    public void datGia(double gia) {
        this.gia = gia;
    }

    public void datSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tinhTongGiaTri() {
        return gia * soLuong;
    }

    @Override
    public String toString() {
        return String.format("Sản phẩm [Tên: %s, Giá: %.2f, Số lượng: %d]", ten, gia, soLuong);
    }

    public static void main(String[] args) {
        while (true) {
            hienThiMenu();

            System.out.print("Chọn chức năng bạn muốn thực hiện: ");
            int luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    themSanPham();
                    break;
                case 2:
                    timKiemSanPham();
                    break;
                case 3:
                    xoaSanPham();
                    break;
                case 4:
                    suaThongTinSanPham();
                    break;
                case 5:
                    sapXepSanPhamTheoGia();
                    break;
                case 6:
                    hienThiDanhSachSanPham();
                    break;
                case 7:
                    thongKeSanPham();
                    break;
                case 8:
                    baoCaoSanPham();
                    break;
                case 9:
                    System.out.println("Thoát chương trình. Cảm ơn bạn đã sử dụng!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
            }
        }
    }

    private static void hienThiMenu() {
        System.out.println("|=============== MENU CÁC CHỨC NĂNG ===============|");
        System.out.println("|1. Nhập thông tin sản phẩm                       ||");
        System.out.println("|2. Tìm kiếm thông tin sản phẩm                   ||");
        System.out.println("|3. Xóa sản phẩm ra khỏi danh sách                ||");
        System.out.println("|4. Sửa thông tin sản phẩm                        ||");
        System.out.println("|5. Sắp xếp sản phẩm theo giá                     ||");
        System.out.println("|6. Hiển thị danh sách các sản phẩm hiện có       ||");
        System.out.println("|7. Thống kê số lượng và giá trị các sản phẩm     ||");
        System.out.println("|8. Báo cáo tổng quan về sản phẩm                 ||");
        System.out.println("|9. Thoát chương trình                            ||");
        System.out.println("|==================================================|");
    }

    private static void themSanPham() {
        System.out.println("===== Nhập thông tin sản phẩm =====");
        System.out.print("Nhập tên sản phẩm: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double gia = scanner.nextDouble();
        System.out.print("Nhập số lượng sản phẩm: ");
        int soLuong = scanner.nextInt();
        danhSachSanPham.add(new SanPham(ten, gia, soLuong));
        System.out.println("Sản phẩm đã được thêm vào danh sách.");
    } 

    private static void timKiemSanPham() {
        System.out.println("===== Tìm kiếm thông tin sản phẩm =====");
        System.out.print("Nhập tên sản phẩm cần tìm kiếm: ");
        String tenTimKiem = scanner.nextLine().trim();
        boolean timThay = false;
        for (SanPham sp : danhSachSanPham) {
            if (sp.layTen().equalsIgnoreCase(tenTimKiem)) {
                System.out.println("Thông tin sản phẩm: " + sp);
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    private static void xoaSanPham() {
        System.out.println("===== Xóa sản phẩm =====");
        System.out.print("Nhập tên sản phẩm cần xóa: ");
        String tenXoa = scanner.nextLine();

        Iterator<SanPham> iterator = danhSachSanPham.iterator();
        while (iterator.hasNext()) {
            SanPham sp = iterator.next();
            if (sp.layTen().equals(tenXoa)) {
                iterator.remove();
                System.out.println("Sản phẩm đã được xóa khỏi danh sách.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm.");
    }

    private static void suaThongTinSanPham() {
        System.out.println("===== Sửa thông tin sản phẩm =====");
        System.out.print("Nhập tên sản phẩm cần sửa: ");
        String tenSua = scanner.nextLine();
        SanPham sanPhamCanSua = null;
        for (SanPham sp : danhSachSanPham) {
            if (sp.layTen().equalsIgnoreCase(tenSua)) {
                sanPhamCanSua = sp;
                break;
            }
        }
        if (sanPhamCanSua != null) {
            System.out.print("Nhập giá mới cho sản phẩm: ");
            double giaMoi = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Nhập số lượng mới cho sản phẩm: ");
            int soLuongMoi = scanner.nextInt();
            scanner.nextLine();
            sanPhamCanSua.datGia(giaMoi);
            sanPhamCanSua.datSoLuong(soLuongMoi);
            System.out.println("Thông tin sản phẩm đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    private static void sapXepSanPhamTheoGia() {
        if (danhSachSanPham.isEmpty()) {
            System.out.println("Danh sách sản phẩm rỗng.");
            return;
        }
        
        Collections.sort(danhSachSanPham, Comparator.comparingDouble(SanPham::layGia));

        System.out.println("Danh sách sản phẩm đã được sắp xếp theo giá tăng dần:");
        for (SanPham sp : danhSachSanPham) {
            System.out.println(sp);
        }
    }

    private static void hienThiDanhSachSanPham() {
        System.out.println("===== Danh sách sản phẩm =====");
        if (danhSachSanPham.isEmpty()) {
            System.out.println("Danh sách sản phẩm rỗng.");
            return;
        }
        for (SanPham sp : danhSachSanPham) {
            System.out.println(sp);
        }
    }

    private static void thongKeSanPham() {
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        for (SanPham sp : danhSachSanPham) {
            tongSoLuong += sp.laySoLuong();
            tongGiaTri += sp.tinhTongGiaTri();
        }
        System.out.println("===== Thống kê sản phẩm =====");
        System.out.println("Tổng số lượng sản phẩm: " + tongSoLuong);
        System.out.println("Tổng giá trị của các sản phẩm: " + tongGiaTri);
    }

    private static void baoCaoSanPham() {
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        double giaCaoNhat = 0;
        int soLuongMax = 0;
        SanPham spGiaCaoNhat = null;

        for (SanPham sp : danhSachSanPham) {
            tongSoLuong += sp.laySoLuong();
            tongGiaTri += sp.tinhTongGiaTri();
            if (sp.layGia() > giaCaoNhat) {
                giaCaoNhat = sp.layGia();
                spGiaCaoNhat = sp;
            }
            if (sp.laySoLuong() > soLuongMax) {
                soLuongMax = sp.laySoLuong();
            }
        }

        System.out.println("===== Báo cáo tổng quan về sản phẩm =====");
        System.out.println("Tổng số lượng sản phẩm: " + tongSoLuong);
        System.out.println("Tổng giá trị của các sản phẩm: " + tongGiaTri);
        if (spGiaCaoNhat != null) {
            System.out.println("Sản phẩm có giá cao nhất: " + spGiaCaoNhat);
        } else {
            System.out.println("Không có sản phẩm nào trong danh sách.");
        }
        System.out.println("Số lượng sản phẩm nhiều nhất: " + soLuongMax);
    }
    

}
