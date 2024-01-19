import java.util.Scanner;

public class ATMUygulaması {

    private static final String DEFAULT_PIN = "1234";
    private static final double DEFAULT_BAKIYE = 1000.0;

    private String girilenPIN;
    private double bakiye;

    public ATMUygulaması() {
        this.girilenPIN = "";
        this.bakiye = DEFAULT_BAKIYE;
    }

    public void girisYap() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("PIN giriniz: ");
        girilenPIN = scanner.nextLine();

        if (girilenPIN.equals(DEFAULT_PIN)) {
            anaMenu();
        } else {
            System.out.println("Hatalı PIN! Çıkış yapılıyor.");
        }
    }

    private void anaMenu() {
        Scanner scanner = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\n--- Ana Menü ---");
            System.out.println("1. Bakiye Sorgula");
            System.out.println("2. Para Çek");
            System.out.println("3. Para Yatır");
            System.out.println("4. Çıkış");
            System.out.print("Lütfen bir seçenek girin: ");

            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    bakiyeSorgula();
                    break;
                case 2:
                    paraCek();
                    break;
                case 3:
                    paraYatir();
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor. İyi günler!");
                    break;
                default:
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
                    break;
            }
        } while (secim != 4);
    }

    private void bakiyeSorgula() {
        System.out.println("Bakiyeniz: $" + bakiye);
    }

    private void paraCek() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Çekilecek miktarı girin: $");
        double cekilecekMiktar = scanner.nextDouble();

        if (cekilecekMiktar > 0 && cekilecekMiktar <= bakiye) {
            bakiye -= cekilecekMiktar;
            System.out.println("Çekilen miktar: $" + cekilecekMiktar);
            bakiyeSorgula();
        } else {
            System.out.println("Geçersiz miktar veya yetersiz bakiye!");
        }
    }

    private void paraYatir() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Yatırılacak miktarı girin: $");
        double yatirilacakMiktar = scanner.nextDouble();

        if (yatirilacakMiktar > 0) {
            bakiye += yatirilacakMiktar;
            System.out.println("Yatırılan miktar: $" + yatirilacakMiktar);
            bakiyeSorgula();
        } else {
            System.out.println("Geçersiz miktar!");
        }
    }

    public static void main(String[] args) {
        ATMUygulaması atm = new ATMUygulaması();
        atm.girisYap();
    }
}