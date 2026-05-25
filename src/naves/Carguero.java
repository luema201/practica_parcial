package naves;

public class Carguero extends Nave implements Explorable {

    private int capacidadCarga;

    public Carguero(int capacidadCarga, String nombre,
            int cantidadTripulacion, int anoLanzamiento) {

        super(nombre, cantidadTripulacion, anoLanzamiento);
        this.capacidadCarga = capacidadCarga;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    @Override
    public void iniciarExploracion() {
        System.out.println("La misión del carguero " + nombre + " comenzó.");
    }
}
