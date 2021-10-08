import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    static class KhachHang {
        private String hoTenChuNha;
        private String soNha;
        private int maSoCongTo;

        public KhachHang() {
            super();
        }

        public KhachHang(String hoTenChuNha, String soNha, int maSoCongTo) {
            super();
            this.hoTenChuNha = hoTenChuNha;
            this.soNha = soNha;
            this.maSoCongTo = maSoCongTo;
        }

        public void nhapThongTinKhachHang() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên chủ hộ: ");
            hoTenChuNha = scanner.nextLine();
            System.out.print("Nhập số nhà: ");
            soNha = scanner.nextLine();
            System.out.print("Mã số công tơ: ");
            maSoCongTo = scanner.nextInt();
            scanner.close();
        }

        public void hienThiThongTinKhachHang() {
            System.out.println("Tên chủ hộ: " + hoTenChuNha);
            System.out.println("Số nhà: " + soNha);
            System.out.println("Mã số công tơ: " + maSoCongTo);
        }
    }

    static class BienLai {
        private int chiSoCu;
        private int chiSoMoi;
        private double soTienPhaiTra;
        private KhachHang khachHang;

        public BienLai() {}

        public BienLai(int chiSoCu, int chiSoMoi, double soTienPhaiTra, KhachHang khachHang) {
            super();
            this.chiSoCu = chiSoCu;
            this.chiSoMoi = chiSoMoi;
            this.soTienPhaiTra = soTienPhaiTra;
            this.khachHang = khachHang;
        }

        public void nhapBienLai() {
            khachHang = new KhachHang();
            khachHang.nhapThongTinKhachHang();

            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Nhập chỉ số cũ: ");
                chiSoCu = scanner.nextInt();
                System.out.print("Nhập chỉ số mới: ");
                chiSoMoi = scanner.nextInt();
            } while (chiSoCu > chiSoMoi);
            scanner.close();
            soTienPhaiTra = (double) (chiSoMoi - chiSoCu) * 750;
        }

        public void hienThiBienLai() {
            khachHang.hienThiThongTinKhachHang();
            System.out.println("Chỉ số cũ: " + chiSoCu);
            System.out.println("Chỉ số mới: " + chiSoMoi);
            System.out.println("Số tiền phải trả: " + soTienPhaiTra);
        }
    }


    public static void main(String[] args) {
        int n;
        BienLai bienLai = new BienLai();
        Scanner scanner = new Scanner(System.in);
        ArrayList<BienLai> arrBienLai = new ArrayList<>();

        System.out.print("Nhập số hộ gia đình: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin biên lai của hộ gia đình thứ " + (i + 1) + ": ");
            bienLai.nhapBienLai();
            arrBienLai.add(bienLai);
        }

        System.out.println("Thông tin biên lai của các hộ gia đình: ");
        for (int i = 0; i < arrBienLai.size(); i++) {
            System.out.println("Thông tin biên lai hộ gia đình thứ " + (i + 1) + ": ");
            arrBienLai.get(i).hienThiBienLai();
        }
        scanner.close();


    }
}



