//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import entities.Movie;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Main lab9 = new Main();
        lab9.compulsory();
    }

    private void compulsory() {
        Movie m = new Movie(4);
        m.setTitle("Anabelle");
        m.setScore(10);
        MovieRepository repo = new MovieRepository();
        repo.create(m);
    }
}
