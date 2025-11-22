// Contoh polymorphism di Java
abstract class Shape {                         // mendefinisikan kelas abstrak Shape sebagai kelas induk
    protected String name;                     // properti name untuk menyimpan nama bangun

    public Shape(String name) {                // konstruktor Shape dengan parameter name
        this.name = name;                      // mengisi properti name dengan nilai dari parameter
    }                                          // akhir konstruktor Shape

    public abstract double area();             // method abstrak area(), wajib di-override di kelas turunan

    public String describe() {                 // method describe() untuk membuat deskripsi bangun
        return "Bangun " + name + " luasnya "  // mengembalikan teks yang diawali dengan "Bangun" dan nama bangun
                + area();                      // menambahkan hasil pemanggilan method area() (polymorphism terjadi di sini)
    }                                          // akhir method describe
}                                              // akhir kelas Shape

class Rectangle extends Shape {                // kelas Rectangle sebagai turunan dari Shape
    private double width;                      // properti width untuk lebar persegi panjang
    private double height;                     // properti height untuk tinggi persegi panjang

    public Rectangle(double width, double height) { // konstruktor Rectangle dengan parameter width dan height
        super("Persegi Panjang");              // memanggil konstruktor kelas induk Shape dan memberi nama "Persegi Panjang"
        this.width = width;                    // menyimpan nilai width ke properti objek
        this.height = height;                  // menyimpan nilai height ke properti objek
    }                                          // akhir konstruktor Rectangle

    @Override                                  // anotasi bahwa method ini meng-override method area() dari Shape
    public double area() {                     // implementasi konkret method area() untuk Rectangle
        return width * height;                 // menghitung luas persegi panjang: width * height
    }                                          // akhir method area di Rectangle
}                                              // akhir kelas Rectangle

class Circle extends Shape {                   // kelas Circle sebagai turunan dari Shape
    private double radius;                     // properti radius untuk jari-jari lingkaran

    public Circle(double radius) {             // konstruktor Circle dengan parameter radius
        super("Lingkaran");                    // memanggil konstruktor Shape dan memberi nama "Lingkaran"
        this.radius = radius;                  // menyimpan nilai radius ke properti objek
    }                                          // akhir konstruktor Circle

    @Override                                  // menandai bahwa area() di sini meng-override area() dari Shape
    public double area() {                     // implementasi konkret method area() untuk Circle
        return Math.PI * radius * radius;      // menghitung luas lingkaran: π * r * r menggunakan Math.PI
    }                                          // akhir method area di Circle
}                                              // akhir kelas Circle

class Triangle extends Shape {                 // kelas Triangle sebagai turunan dari Shape
    private double base;                       // properti base untuk alas segitiga
    private double height;                     // properti height untuk tinggi segitiga

    public Triangle(double base, double height) { // konstruktor Triangle dengan parameter base dan height
        super("Segitiga");                     // memanggil konstruktor Shape dan memberi nama "Segitiga"
        this.base = base;                      // menyimpan nilai base ke properti objek
        this.height = height;                  // menyimpan nilai height ke properti objek
    }                                          // akhir konstruktor Triangle

    @Override                                  // menandai bahwa area() di sini meng-override area() dari Shape
    public double area() {                     // implementasi konkret method area() untuk Triangle
        return 0.5 * base * height;            // menghitung luas segitiga: 1/2 * alas * tinggi
    }                                          // akhir method area di Triangle
}                                              // akhir kelas Triangle

public class Main {                            // kelas Main sebagai kelas utama program
    public static void main(String[] args) {   // method main, titik awal eksekusi program Java
        Shape[] shapes = new Shape[] {         // membuat array Shape yang berisi objek-objek turunan Shape
                new Rectangle(4, 5),           // elemen pertama: objek Rectangle dengan width 4 dan height 5
                new Circle(3),                 // elemen kedua: objek Circle dengan radius 3
                new Triangle(4, 6)             // elemen ketiga: objek Triangle dengan base 4 dan height 6
        };                                     // akhir inisialisasi array shapes

        for (Shape shape : shapes) {           // perulangan for-each untuk setiap objek Shape di dalam array shapes
            System.out.println(                // mencetak ke layar menggunakan System.out.println
                    shape.describe()           // memanggil describe(); di dalamnya ada area() yang bersifat polymorphic
            );                                 // akhir pemanggilan println
        }                                      // akhir blok perulangan for-each
    }                                          // akhir method main
}                                              // akhir kelas Main
