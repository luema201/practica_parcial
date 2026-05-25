package naves;

public class CruceroEstelar extends Nave {

    private int cantidadPasajeros;

    public CruceroEstelar(int cantidadPasajeros, String nombre,
            int cantidadTripulacion, int anoLanzamiento) {

        super(nombre, cantidadTripulacion, anoLanzamiento);
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }
}