package naves;

public class NaveDeExploracion extends Nave implements Explorable {

    private TipoMision tipoMision;

    public NaveDeExploracion(TipoMision tipoMision, String nombre,
            int cantidadTripulacion, int anoLanzamiento) {

        super(nombre, cantidadTripulacion, anoLanzamiento);
        this.tipoMision = tipoMision;
    }

    public TipoMision getTipoMision() {
        return tipoMision;
    }

    @Override
    public void iniciarExploracion() {
        System.out.println("La nave de exploración " + nombre
                + " inició una misión de " + tipoMision + ".");
    }
}