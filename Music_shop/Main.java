package zxc;

public class Main {
    public static void main(String[] args) {
        Guitar guitar = new Guitar("g123",20000,1500);
        Piano piano = new Piano("k312",60000,4000);
        Violin violin = new Violin("a931",50000,10000);


        System.out.print(guitar);
        System.out.print(piano);
        System.out.print(violin);


        guitar.compare(piano);
        guitar.equal(violin);


    }
}
