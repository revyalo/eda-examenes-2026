package es.urjc.grafo.EDA.CNP;

public class Notas implements Comparable<Notas> {

    double fisicas;
    double teoricas;
    double entrevista;
    double notaMedia;

    public Notas(double fisicas, double teoricas, double entrevista) {
        this.entrevista = entrevista;
        this.fisicas = fisicas;
        this.teoricas = teoricas;
        this.notaMedia = (fisicas + teoricas + entrevista) / 3;
    }

    public double getFisicas() {
        return fisicas;
    }

    public double getTeoricas() {
        return teoricas;
    }

    public double getEntrevista() {
        return entrevista;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    @Override
    public int compareTo(Notas o) {
        return Double.compare(this.notaMedia, o.notaMedia);
    }
}
