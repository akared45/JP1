package E1;

import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền gửi : ");
        double sotiengui = scanner.nextDouble();

        System.out.print("Nhập kỳ hạn gửi 6,9,12,24,36: ");
        int kyhan = scanner.nextInt();

        double laisuat = 0;

        switch (kyhan) {
            case 6:
                laisuat = 5.1 / 100;
                break;
            case 9:
                laisuat = 5.5 / 100;
                break;
            case 12:
                laisuat = 6.4 / 100;
                break;
            case 24:
                laisuat = 6.5 / 100;
                break;
            case 36:
                laisuat = 6.5 / 100;
                break;
            default:
                System.out.println("Kỳ hạn không hợp lệ!");
                return;
        }

        double tienlai = sotiengui * laisuat;
        double tongtien = sotiengui + tienlai;

        System.out.printf("Tiền gốc: %.2f VNĐ\n", sotiengui);
        System.out.printf("Tiền lãi: %.2f VNĐ\n", tienlai);
        System.out.printf("Tổng số tiền sau khi rút: %.2f VNĐ\n", tongtien);

    }
}

