package E1;

import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền bạn muốn rút : ");
        int n = sc.nextInt();
        if (n % 50000 == 0) {
            System.out.println("Số tiền rút: " + n);
            int a;
            a = n / 500000;
            if (a > 0) {
                System.out.println("Số tờ 500.000VNĐ: " + a);
                n %= 500000;
            }
            a = n / 200000;
            if (a > 0) {
                System.out.println("Số tờ 200.000VNĐ: " + a);
                n %= 200000;
            }
            a = n / 100000;
            if (a > 0) {
                System.out.println("Số tờ 100.000VNĐ: " + a);
                n %= 100000;
            }
            a = n / 50000;
            if (a > 0) {
                System.out.println("Số tờ 50.000VNĐ: " + a);
                n %= 50000;
            }
        } else {
            System.out.println("Số tiền bạn nhập phải là bội số 50000");
        }
    }
}
