// Contoh inheritance (pewarisan) di Java
class Orang {                                        // mendefinisikan kelas Orang sebagai kelas induk (parent class)
    protected String name;                           // field name diset protected agar bisa diakses oleh kelas turunan
    protected int age;                               // field age juga protected untuk umur orang

    public Orang(String name, int age) {             // konstruktor Orang dengan parameter name dan age
        this.name = name;                            // mengisi field name dengan nilai dari parameter name
        this.age = age;                              // mengisi field age dengan nilai dari parameter age
    }                                                // akhir konstruktor Orang

    public void printInfo() {                        // method printInfo() umum untuk menampilkan informasi dasar orang
        System.out.println("Nama : " + name);        // mencetak nama orang ke layar
        System.out.println("Umur : " + age + " tahun"); // mencetak umur orang ke layar
    }                                                // akhir method printInfo
}                                                    // akhir kelas Orang

class Murid extends Orang {                          // kelas Murid sebagai kelas turunan (child) dari Orang
    private String studentId;                        // field studentId khusus untuk murid/mahasiswa, disembunyikan sebagai private
    private double gpa;                              // field gpa untuk menyimpan IPK murid/mahasiswa

    public Murid(String name, int age,               // konstruktor Murid, menerima name, age, studentId, dan gpa
                 String studentId, double gpa) {     // lanjutan parameter konstruktor
        super(name, age);                            // memanggil konstruktor kelas induk Orang untuk mengisi name dan age
        this.studentId = studentId;                  // mengisi field studentId dengan nilai dari parameter
        this.gpa = gpa;                              // mengisi field gpa dengan nilai dari parameter
    }                                                // akhir konstruktor Murid

    @Override                                        // anotasi bahwa method ini meng-override method dari kelas induk
    public void printInfo() {                        // method printInfo() versi Murid, menambah info khusus murid/mahasiswa
        System.out.println("=== Data Murid ===");    // judul bagian untuk data murid
        super.printInfo();                           // memanggil printInfo() milik Orang untuk menampilkan nama dan umur
        System.out.println("NIM  : " + studentId);   // mencetak NIM murid/mahasiswa
        System.out.println("IPK  : " + gpa);         // mencetak IPK murid/mahasiswa
    }                                                // akhir method printInfo pada Murid

    public void study() {                            // method tambahan khusus Murid untuk menunjukkan perilaku belajar
        System.out.println(name + " sedang belajar."); // mencetak bahwa murid tersebut sedang belajar
    }                                                // akhir method study
}                                                    // akhir kelas Murid

class Guru extends Orang {                           // kelas Guru sebagai kelas turunan (child) dari Orang
    private String subject;                          // field subject untuk menyimpan mata pelajaran atau mata kuliah yang diajar

    public Guru(String name, int age,                // konstruktor Guru, menerima name, age, dan subject
                String subject) {                    // lanjutan parameter konstruktor
        super(name, age);                            // memanggil konstruktor Orang untuk mengisi name dan age
        this.subject = subject;                      // mengisi field subject dengan nilai dari parameter
    }                                                // akhir konstruktor Guru

    @Override                                        // menandai bahwa method ini meng-override method dari Orang
    public void printInfo() {                        // method printInfo() versi Guru, menambah info mata pelajaran
        System.out.println("=== Data Guru/Dosen ==="); // judul bagian untuk data pengajar
        super.printInfo();                           // memanggil printInfo() milik Orang untuk menampilkan nama dan umur
        System.out.println("Mengajar : " + subject); // mencetak mata pelajaran atau mata kuliah yang diajar
    }                                                // akhir method printInfo pada Guru

    public void teach() {                            // method tambahan khusus Guru untuk menunjukkan perilaku mengajar
        System.out.println(name + " sedang mengajar " + subject + "."); // mencetak bahwa pengajar sedang mengajar mata kuliah tertentu
    }                                                // akhir method teach
}                                                    // akhir kelas Guru

public class Main {                                  // kelas Main sebagai kelas utama program
    public static void main(String[] args) {         // method main sebagai titik awal eksekusi program
        Orang orangBiasa = new Orang(                // membuat objek Orang (bukan murid atau guru)
                "Dian",                              // nama orang biasa
                30                                   // umur orang biasa
        );                                           // akhir pembuatan objek Orang

        Murid murid = new Murid(                     // membuat objek Murid yang mewarisi Orang
                "Rizky",                             // nama murid/mahasiswa
                20,                                  // umur murid
                "230123001",                         // NIM murid/mahasiswa
                3.75                                 // IPK murid/mahasiswa
        );                                           // akhir pembuatan objek Murid

        Guru guru = new Guru(                        // membuat objek Guru yang mewarisi Orang
                "Siti",                              // nama guru/dosen
                35,                                  // umur guru/dosen
                "Pemrograman Java"                   // mata pelajaran atau mata kuliah yang diajar
        );                                           // akhir pembuatan objek Guru

        System.out.println("=== Contoh Orang ===");  // mencetak judul bagian untuk objek Orang
        orangBiasa.printInfo();                      // memanggil printInfo() milik Orang untuk menampilkan data orang biasa

        System.out.println();                        // mencetak baris kosong untuk pemisah output

        System.out.println("=== Contoh Murid ===");  // mencetak judul bagian untuk objek Murid
        murid.printInfo();                           // memanggil printInfo() versi Murid (override) untuk menampilkan data murid
        murid.study();                               // memanggil method study() khusus Murid

        System.out.println();                        // mencetak baris kosong lagi sebagai pemisah

        System.out.println("=== Contoh Guru/Dosen ==="); // mencetak judul bagian untuk objek Guru
        guru.printInfo();                            // memanggil printInfo() versi Guru (override) untuk menampilkan data guru/dosen
        guru.teach();                                // memanggil method teach() khusus Guru
    }                                                // akhir method main
}                                                    // akhir kelas Main
