package project;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class HoaDon {
    private ArrayList<Menu> danhSachSanPham;
    private LocalDateTime ngayGio;

    public HoaDon(ArrayList<Menu> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
        this.ngayGio = LocalDateTime.now();
    }

    public ArrayList<Menu> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public LocalDateTime getNgayGio() {
        return ngayGio;
    }

    public double getTongGiaTri() {
        double tongGiaTri = 0;
        for (Menu sanPham : danhSachSanPham) {
            tongGiaTri += sanPham.getGia() * sanPham.getSoLuong();
        }
        return tongGiaTri;
    }
}

