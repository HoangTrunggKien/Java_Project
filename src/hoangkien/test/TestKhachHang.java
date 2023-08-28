package hoangkien.test;

import hoangkien.io.SerializeFileFactory;
import hoangkien.model.KhachHang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestKhachHang {

    static ArrayList<KhachHang>dsKH = new ArrayList<KhachHang>();

    public static void menu(){
        System.out.println("1. Nhập khách hàng");
        System.out.println("2. Xuất khách hàng");
        System.out.println("3. Tìm kiếm khách hàng");
        System.out.println("4. Sắp xếp khách hàng");
        System.out.println("5. Lưu khách hàng");
        System.out.println("6. Đọc khách hàng");
        System.out.println("7. Thống kê theo nhà mạng");
        System.out.println("8. Thoát");
        int chon = 0;
        System.out.println("Chọn chức năng từ 1 tới 8: ");
        chon = new Scanner(System.in).nextInt();

        switch (chon){
            case 1:
                xuLyNhap();
                break;
            case 2:
                xuLyXuat();
                break;
            case 3:
                xuLyTim();
                break;
            case 4:
                xuLySapXep();
                break;
            case 5:
                xuLyLuu();
                break;
            case 6:
                xuLyDoc();
                break;
            case 7:
                xuLyThongKe();
                break;
            case 8:
                xuLyThoat();
                break;
            default:
                break;
        }
    }

    private static void xuLyNhap() {
        KhachHang kh = new KhachHang();
        System.out.println("Nhập mã: ");
        int ma = new Scanner(System.in).nextInt();
        System.out.println("Nhập tên: ");
        String ten = new Scanner(System.in).nextLine();
        System.out.println("Nhập sđt: ");
        String phone = new Scanner(System.in).nextLine();

        kh.setMa(ma);
        kh.setTen(ten);
        kh.getPhone(phone);

        dsKH.add(kh);
    }

    private static void xuLyXuat() {
        System.out.println("==============");
        System.out.println("Mã\tTên\tPhone");
        for (KhachHang kh : dsKH){
            System.out.println(kh);
        }
        System.out.println("==============");

    }

    private static void xuLyTim() {
        String phone = "090";
        System.out.println("================");
        System.out.println("Khách hàng có đầu số 090: ");
        System.out.println("Mã\tTên\tPhone");
        for (KhachHang kh: dsKH){
            if (kh.getPhone().startsWith(phone)){
                System.out.println(kh);
            }
        }
    }

    private static void xuLySapXep() {
        Collections.sort(dsKH);
        System.out.println("Đã sắp xếp");
    }

    private static void xuLyLuu() {
        boolean kt = SerializeFileFactory.luuFile(dsKH, "D:\\dulieukhachhang.txt");
        if(kt = true){
            System.out.println("Lưu file thành công");
        }
        else {
            System.out.println("Lưu file thất bại");
        }
    }

    private static void xuLyDoc() {
        dsKH = SerializeFileFactory.docFile("D:\\dulieukhachhang.txt");
        System.out.println("Đọc file thành công");
    }

    private static void xuLyThongKe() {
        int n = 0;
        for (KhachHang kh : dsKH){
            if (kh.getPhone().startsWith("098")){
                n++;
            }

        }
        System.out.println("Có " + n + " khách hàng Viettel.");
    }

    private static void xuLyThoat() {
        System.out.println("Cảm ơn bạn đã dùng phần mềm");
        System.exit(0);
    }


    public static void main(String[] args) {
        while (true){
            menu();
        }
    }
}
