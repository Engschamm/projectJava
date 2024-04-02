package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Menu {
    private String ten;
    private double gia;
    private int soLuong;

    private static ArrayList<Menu> danhSachSanPham = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    

    public static void menu() {
        while (true) {
            hienThiMenu();

            System.out.print("Chọn chức năng bạn muốn thực hiện: ");

            // nhập lựa chọn của người dùng
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
                    hienThiDanhSachSanPham();
                    break;
                case 6:
                    sapXepSanPhamTheoGia();
                    break;
                case 7:
                    thongKeSanPham();
                    break;
                case 8:
                    baoCaoSanPham();
                    break;
                case 9:
                    timKiemSanPhamTheoGia();
                    break;
                case 10:
                    locSanPhamTheoTen();
                    break;
                case 11:
                    datHang();
                    break;
                case 12:
                    xuatDanhSachSanPhamRaFile();
                    break;
                case 13:
                    System.out.println("Thoát chương trình. Cảm ơn bạn đã sử dụng!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại");
            }
        }
    }

    // MENU

    private static void hienThiMenu() {
        System.out.println("|====  MENU CÁC CHỨC NĂNG SHOP VĂN PHÒNG PHẨM =====|");
        System.out.println("|1. Nhập thông tin sản phẩm                       ||");
        System.out.println("|2. Tìm kiếm thông tin sản phẩm                   ||");
        System.out.println("|3. Xóa sản phẩm ra khỏi danh sách                ||");
        System.out.println("|4. Sửa thông tin sản phẩm                        ||");
        System.out.println("|5. Hiển thị danh sách các sản phẩm hiện có       ||");
        System.out.println("|6. Sắp xếp sản phẩm theo giá                     ||");
        System.out.println("|7. Thống kê số lượng và giá trị các sản phẩm     ||");
        System.out.println("|8. Báo cáo tổng quan về sản phẩm                 ||");
        System.out.println("|9. Tìm kiếm sản phẩm theo giá                    ||");
        System.out.println("|10. Lọc sản phẩm theo tên                        ||");
        System.out.println("|11. Đặt hàng                                     ||");
        System.out.println("|12. Xuất sản phẩm ra file                        ||");
        System.out.println("|13. Thoát chương trình                           ||");
        System.out.println("|==================================================|");
    }

    // thêm sản phẩm vào danh sách

    private static void themSanPham() {
        System.out.println("===== Nhập thông tin sản phẩm =====");
        System.out.print("Nhập tên sản phẩm: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double gia = scanner.nextDouble();
        System.out.print("Nhập số lượng sản phẩm: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // xử lý ký tự xuống dòng

        Menu sanPham = new Menu();
        sanPham.setTen(ten);
        sanPham.setGia(gia);
        sanPham.setSoLuong(soLuong);

        danhSachSanPham.add(sanPham);
        System.out.println("Thêm sản phẩm thành công!");
    }

    // tìm kiếm sản phẩm 

    private static void timKiemSanPham() {
        System.out.println("===== Tìm kiếm thông tin sản phẩm =====");
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String ten = scanner.nextLine();

        boolean timThay = false;

        for (Menu sanPham : danhSachSanPham) {
            if (sanPham.getTen().toLowerCase().contains(ten.toLowerCase())) {
                System.out.println(sanPham);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    // xóa sản phẩm

    private static void xoaSanPham() {
        System.out.println("===== Xóa sản phẩm ra khỏi danh sách =====");
        System.out.print("Nhập tên sản phẩm cần xóa: ");
        String ten = scanner.nextLine();

        Iterator<Menu> iterator = danhSachSanPham.iterator();
        boolean timThay = false;

        while (iterator.hasNext()) {
            Menu sanPham = iterator.next();
            if (sanPham.getTen().equalsIgnoreCase(ten)) {
                iterator.remove();
                timThay = true;
            }
        }

        if (timThay) {
            System.out.println("Xóa sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    // sửa thông tin 

    private static void suaThongTinSanPham() {
        System.out.println("===== Sửa thông tin sản phẩm =====");
        System.out.print("Nhập tên sản phẩm cần sửa: ");
        String ten = scanner.nextLine();

        boolean timThay = false;

        for (Menu sanPham : danhSachSanPham) {
            if (sanPham.getTen().equalsIgnoreCase(ten)) {
                System.out.print("Nhập mới tên sản phẩm: ");
                String newTen = scanner.nextLine();
                System.out.print("Nhập mới giá sản phẩm: ");
                double newGia = scanner.nextDouble();
                System.out.print("Nhập mới số lượng sản phẩm: ");
                int newSoLuong = scanner.nextInt();
                scanner.nextLine(); // xử lý ký tự xuống dòng

                sanPham.setTen(newTen);
                sanPham.setGia(newGia);
                sanPham.setSoLuong(newSoLuong);

                timThay = true;
                break;
            }
        }

        if (timThay) {
            System.out.println("Sửa thông tin sản phẩm thành công!");
        } else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    // sắp xếp sản phẩm theo giá

    private static void sapXepSanPhamTheoGia() {
        Collections.sort(danhSachSanPham, Comparator.comparingDouble(Menu::getGia));

        System.out.println("Danh sách sản phẩm sau khi sắp xếp theo giá tăng dần: ");
        hienThiDanhSachSanPham();
    }

    // hiển thị danh sách sản phẩm 

    private static void hienThiDanhSachSanPham() {
        for (Menu sanPham : danhSachSanPham) {
            System.out.println(sanPham);
        }
    }

    // thống kê

    private static void thongKeSanPham() {
        int tongSoLuong = 0;
        double tongGiaTri = 0;

        for (Menu sanPham : danhSachSanPham) {
            tongSoLuong += sanPham.getSoLuong();
            tongGiaTri += sanPham.getGia() * sanPham.getSoLuong();
        }

        System.out.println("===== Thống kê số lượng và giá trị các sản phẩm =====");
        System.out.println("Tổng số lượng sản phẩm: " + tongSoLuong);
        System.out.println("Tổng giá trị các sản phẩm: " + tongGiaTri);
    }

    // báo cảo sản phẩm

    private static void baoCaoSanPham() {
        System.out.println("===== Báo cáo tổng quan về sản phẩm =====");
        System.out.println("Các sản phẩm có sẵn: " + danhSachSanPham.size());

        double tongGiaTri = 0;
        for (Menu sanPham : danhSachSanPham) {
            tongGiaTri += sanPham.getGia() * sanPham.getSoLuong();
        }
        System.out.println("Tổng giá trị các sản phẩm: " + tongGiaTri);
    }

    // tìm kiểm sản phẩm theo GIÁ

    private static void timKiemSanPhamTheoGia() {
        System.out.println("===== Tìm kiếm sản phẩm theo giá =====");
        System.out.print("Nhập giá sản phẩm cần tìm: ");
        double gia = scanner.nextDouble();
        scanner.nextLine(); // xử lý ký tự xuống dòng

        boolean timThay = false;

        for (Menu sanPham : danhSachSanPham) {
            if (Math.abs(sanPham.getGia() - gia) < 0.0001) {
                System.out.println(sanPham);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    // tìm kiếm sản phẩm theo TÊN 
    private static void locSanPhamTheoTen() {
        System.out.println("===== Lọc sản phẩm theo tên =====");
        System.out.print("Nhập tên sản phẩm cần lọc: ");
        String ten = scanner.nextLine();

        System.out.println("Các sản phẩm có tên chứa '" + ten + "':");

        boolean timThay = false;
        for (Menu sanPham : danhSachSanPham) {
            if (sanPham.getTen().toLowerCase().contains(ten.toLowerCase())) {
                System.out.println(sanPham);
                timThay = true;
            }
        }
        
        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }

    // đặt hàng

    private static void datHang() {
        ArrayList<Menu> gioHang = new ArrayList<>();

        System.out.println("===== Đặt hàng =====");
        System.out.println("Danh sách sản phẩm:");
        hienThiDanhSachSanPham();

        while (true) {
            System.out.print("Nhập tên sản phẩm cần đặt (Nhập 'x' để kết thúc đặt hàng): ");
            String tenSanPham = scanner.nextLine();

            if (tenSanPham.equalsIgnoreCase("x")) {
                break;
            }

            Menu sanPhamDat = null;
            for (Menu sanPham : danhSachSanPham) {
                if (sanPham.getTen().equalsIgnoreCase(tenSanPham)) {
                    sanPhamDat = sanPham;
                    break;
                }
            }

            if (sanPhamDat != null) {
                System.out.print("Nhập số lượng sản phẩm cần đặt: ");
                int soLuong = scanner.nextInt();
                scanner.nextLine(); // xử lý ký tự xuống dòng

                if (soLuong > 0 && sanPhamDat.getSoLuong() >= soLuong) {
                    // Thêm sản phẩm vào giỏ hàng
                    Menu sanPhamGioHang = new Menu();
                    sanPhamGioHang.setTen(sanPhamDat.getTen());
                    sanPhamGioHang.setGia(sanPhamDat.getGia());
                    sanPhamGioHang.setSoLuong(soLuong);
                    gioHang.add(sanPhamGioHang);

                    // Giảm số lượng sản phẩm trong kho
                    sanPhamDat.setSoLuong(sanPhamDat.getSoLuong() - soLuong);

                    System.out.println("Thêm sản phẩm vào giỏ hàng thành công!");
                } else {
                    System.out.println("Số lượng sản phẩm không hợp lệ hoặc không đủ trong kho!");
                }
            } else {
                System.out.println("Sản phẩm không tồn tại trong danh sách!");
            }
        }

        if (!gioHang.isEmpty()) {
            // Tạo hóa đơn
            HoaDon hoaDon = new HoaDon(gioHang);

            // In thông tin hóa đơn
            System.out.println("===== Hóa đơn =====");
            System.out.println("Ngày giờ hóa đơn: " + hoaDon.getNgayGio());
            System.out.println("Danh sách sản phẩm:");
            for (Menu sanPham : hoaDon.getDanhSachSanPham()) {
                System.out.println(sanPham.getTen() + " - Giá: " + sanPham.getGia() + " - Số lượng: " + sanPham.getSoLuong());
            }
            System.out.println("Tổng giá trị hóa đơn: " + hoaDon.getTongGiaTri());
        } else {
            System.out.println("Giỏ hàng trống! Không tạo được hóa đơn.");
        }
    }
    private static void xuatDanhSachSanPhamRaFile() {
        System.out.println("===== Xuất danh sách sản phẩm ra file =====");
        System.out.print("Nhập tên file (bao gồm đường dẫn nếu cần): ");
        String tenFile = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenFile))) {
            for (Menu sanPham : danhSachSanPham) {
                writer.write(sanPham.toString());
                writer.newLine();
            }
            System.out.println("Xuất danh sách sản phẩm ra file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        String header = "| Tên sản phẩm         |       Giá | Số lượng |%n";
        String divider = "|----------------------|-----------|----------|%n";
        String formatString = "| %-20s | %10.2f | %7d |%n";

        // in dòng dữ liệu
        return String.format(header + divider + formatString, ten, gia, soLuong);
    }

    public static void main(String[] args) {
        Menu.menu();
    }
}
