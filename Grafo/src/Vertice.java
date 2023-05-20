import java.util.ArrayList;

public class Vertice<T> {
    private T id;
    private ArrayList<Vertice<T>> adyacentes;

    public Vertice(T id) {
        this.id = id;
        adyacentes = new ArrayList<Vertice<T>>();
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public ArrayList<Vertice<T>> getAdyacentes() {
        return adyacentes;
    }
    public void setAdyacentes(ArrayList<Vertice<T>> adyacentes) {
        this.adyacentes = adyacentes;
    }
    public void agregarAdyacente(Vertice<T> adyacente) {
        adyacentes.add(adyacente);
    }

}

