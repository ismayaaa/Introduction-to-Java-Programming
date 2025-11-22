// Program enkapsulasi sederhana dengan rekening bank
class BankAccount {                                      // mendefinisikan kelas BankAccount sebagai representasi rekening bank
    private String accountNumber;                        // field accountNumber disembunyikan (private) agar tidak bisa diakses langsung
    private String ownerName;                            // field ownerName private untuk menjaga data nama pemilik
    private double balance;                              // field balance private untuk melindungi data saldo

    public BankAccount(String accountNumber,             // konstruktor BankAccount dengan parameter nomor rekening,
                       String ownerName,                 // nama pemilik,
                       double initialBalance) {          // dan saldo awal
        this.accountNumber = accountNumber;              // mengisi field accountNumber dengan nilai dari parameter
        this.ownerName = ownerName;                      // mengisi field ownerName dengan nilai dari parameter
        if (initialBalance < 0) {                        // mengecek apakah saldo awal bernilai negatif
            this.balance = 0;                            // jika negatif, saldo dipaksa menjadi 0 supaya data tetap logis
        } else {                                         // jika saldo awal tidak negatif
            this.balance = initialBalance;               // menyimpan saldo awal ke field balance
        }                                                // akhir blok if-else untuk validasi saldo awal
    }                                                    // akhir konstruktor BankAccount

    public String getAccountNumber() {                   // getter untuk membaca nomor rekening dari luar kelas
        return accountNumber;                            // mengembalikan nilai accountNumber
    }                                                    // akhir method getAccountNumber

    public String getOwnerName() {                       // getter untuk membaca nama pemilik rekening
        return ownerName;                                // mengembalikan nilai ownerName
    }                                                    // akhir method getOwnerName

    public void setOwnerName(String ownerName) {         // setter untuk mengubah nama pemilik rekening (tetap ada sebagai contoh enkapsulasi)
        if (ownerName == null || ownerName.isEmpty()) {  // jika nama baru null atau string kosong
            return;                                      // langsung keluar dari method, nama tidak diubah
        }                                                // akhir pengecekan nama kosong
        this.ownerName = ownerName;                      // jika valid, menyimpan nama baru ke field ownerName
    }                                                    // akhir method setOwnerName

    public double getBalance() {                         // getter untuk membaca saldo dari luar kelas
        return balance;                                  // mengembalikan nilai balance
    }                                                    // akhir method getBalance

    public boolean deposit(double amount) {              // method untuk menyetor uang ke rekening
        if (amount <= 0) {                               // mengecek apakah jumlah setoran kurang atau sama dengan 0
            System.out.println("Jumlah setoran harus lebih dari Rp0,00."); // pesan jika jumlah setoran tidak valid
            return false;                                // mengembalikan false karena setoran gagal
        }                                                // akhir pengecekan jumlah setoran
        balance += amount;                               // menambahkan jumlah setoran ke saldo
        System.out.println("Setoran berhasil: "          // menampilkan keterangan setoran berhasil
                + formatRupiah(amount));                 // menampilkan jumlah setoran dalam format rupiah
        return true;                                     // mengembalikan true karena setoran sukses
    }                                                    // akhir method deposit

    public boolean withdraw(double amount) {             // method untuk menarik uang dari rekening
        if (amount <= 0) {                               // mengecek apakah jumlah penarikan kurang atau sama dengan 0
            System.out.println("Jumlah penarikan harus lebih dari Rp0,00."); // pesan jika jumlah penarikan tidak valid
            return false;                                // mengembalikan false karena penarikan gagal
        }                                                // akhir pengecekan jumlah penarikan
        if (amount > balance) {                          // mengecek apakah saldo cukup untuk penarikan
            System.out.println("Saldo tidak cukup untuk penarikan: " // pesan kalau saldo tidak mencukupi
                    + formatRupiah(amount));             // menampilkan jumlah yang ingin ditarik dalam format rupiah
            return false;                                // mengembalikan false karena penarikan tidak jadi dilakukan
        }                                                // akhir pengecekan saldo cukup
        balance -= amount;                               // mengurangi saldo dengan jumlah yang ditarik
        System.out.println("Penarikan berhasil: "        // menampilkan keterangan penarikan berhasil
                + formatRupiah(amount));                 // menampilkan jumlah penarikan dalam format rupiah
        return true;                                     // mengembalikan true karena penarikan sukses
    }                                                    // akhir method withdraw

    public void printInfo() {                            // method untuk menampilkan informasi lengkap rekening
        System.out.println("==========================");            // mencetak garis pemisah
        System.out.println("No Rekening : " + accountNumber);        // menampilkan nomor rekening
        System.out.println("Nama Pemilik: " + ownerName);            // menampilkan nama pemilik rekening
        System.out.println("Saldo       : " + formatRupiah(balance)); // menampilkan saldo dalam format rupiah
    }                                                    // akhir method printInfo

    private String formatRupiah(double amount) {         // method bantuan private untuk memformat angka menjadi rupiah
        long rupiah = Math.round(amount);                // membulatkan nilai double ke long supaya rapi tanpa pecahan
        String angka = Long.toString(rupiah);            // mengubah angka rupiah menjadi string, misalnya "1300000"
        StringBuilder hasil = new StringBuilder();       // membuat StringBuilder untuk menyusun format dengan titik
        int hitungTiga = 0;                              // variabel penghitung untuk menyisipkan titik tiap 3 digit

        for (int i = angka.length() - 1; i >= 0; i--) {  // loop dari digit terakhir ke digit pertama
            hasil.insert(0, angka.charAt(i));            // menyisipkan digit saat ini di depan string yang sudah ada
            hitungTiga++;                                // menambah hitungan digit
            if (hitungTiga == 3 && i > 0) {              // jika sudah 3 digit dan belum sampai digit paling depan
                hasil.insert(0, '.');                    // menyisipkan titik sebagai pemisah ribuan
                hitungTiga = 0;                          // mengulang hitungan digit setelah titik
            }                                            // akhir blok if untuk menambah titik
        }                                                // akhir loop penyusunan digit

        return "Rp" + hasil.toString() + ",00";          // mengembalikan string dalam format "Rp1.300.000,00"
    }                                                    // akhir method formatRupiah
}                                                        // akhir kelas BankAccount

public class Main {                                      // kelas Main sebagai kelas utama program
    public static void main(String[] args) {             // method main sebagai titik awal eksekusi program
        BankAccount account = new BankAccount(           // membuat objek BankAccount baru dengan data awal yang konsisten
                "1234567890",                           // nomor rekening awal
                "Rizky",                                // nama pemilik awal
                1000000                                 // saldo awal Rp1.000.000,00
        );                                               // akhir pemanggilan konstruktor BankAccount

        account.printInfo();                             // menampilkan informasi rekening setelah dibuat

        account.deposit(500000);                         // menyetor Rp500.000,00, saldo menjadi Rp1.500.000,00
        account.printInfo();                             // menampilkan informasi rekening setelah setoran

        account.withdraw(200000);                        // menarik Rp200.000,00, saldo menjadi Rp1.300.000,00
        account.printInfo();                             // menampilkan informasi rekening setelah penarikan pertama

        boolean success = account.withdraw(2000000);     // mencoba menarik Rp2.000.000,00 (lebih besar dari saldo yang ada)
        if (!success) {                                  // jika penarikan gagal (success = false)
            System.out.println(                          // menampilkan penjelasan tambahan ke layar
                    "Transaksi penarikan besar gagal karena saldo tidak mencukupi.");
        }                                                // akhir blok if

        account.printInfo();                             // menampilkan informasi rekening setelah percobaan penarikan besar
                                                         // nama pemilik tetap "Rizky" dari awal sampai akhir program
    }                                                    // akhir method main
}                                                        // akhir kelas Main
