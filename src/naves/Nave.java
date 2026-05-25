package naves;

public abstract class Nave implements Comparable<Nave> {

    protected String nombre;
    protected int cantidadTripulacion;
    protected int anoLanzamiento;

    public Nave(String nombre, int cantidadTripulacion, int anoLanzamiento) {
        this.nombre = nombre;
        this.cantidadTripulacion = cantidadTripulacion;
        this.anoLanzamiento = anoLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadTripulacion() {
        return cantidadTripulacion;
    }

    public int getAnoLanzamiento() {
        return anoLanzamiento;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Nave)) {
            return false;
        }

        Nave otra = (Nave) obj;

        return this.nombre.equalsIgnoreCase(otra.nombre)
                && this.anoLanzamiento == otra.anoLanzamiento;
    }

    @Override
    public int compareTo(Nave otra) {
        return this.nombre.compareToIgnoreCase(otra.nombre);
    }
}