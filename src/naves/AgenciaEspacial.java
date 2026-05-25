package naves;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AgenciaEspacial {

    private ArrayList<Nave> naves;

    public AgenciaEspacial() {
        this.naves = new ArrayList<>();
    }

    public void agregarNave(Nave nave) {
        for (Nave n : naves) {
            if (nave.equals(n)) {
                System.out.println("Ya existe una nave con ese nombre y año de lanzamiento.");
                return;
            }
        }

        naves.add(nave);
        System.out.println("Nave agregada correctamente.");
    }

    public void mostrarNaves() {
        mostrarLista(naves);
    }

    public void iniciarExploracion() {
        for (Nave nave : naves) {
            if (nave instanceof Explorable) {
                Explorable explorable = (Explorable) nave;
                explorable.iniciarExploracion();
            } else {
                System.out.println("El crucero " + nave.getNombre()
                        + " no participa en misiones de exploración.");
            }
        }
    }

    public void mostrarOrdenadasPorNombre() {
        ArrayList<Nave> copia = new ArrayList<>(naves);
        Collections.sort(copia);
        mostrarLista(copia);
    }

    public void mostrarOrdenadasPorAnio() {
        ArrayList<Nave> copia = new ArrayList<>(naves);

        Collections.sort(copia, new Comparator<Nave>() {
            @Override
            public int compare(Nave n1, Nave n2) {
                return n2.getAnoLanzamiento() - n1.getAnoLanzamiento();
            }
        });

        mostrarLista(copia);
    }

    public void mostrarOrdenadasPorTripulacion() {
        ArrayList<Nave> copia = new ArrayList<>(naves);

        Collections.sort(copia, new Comparator<Nave>() {
            @Override
            public int compare(Nave n1, Nave n2) {
                return n2.getCantidadTripulacion() - n1.getCantidadTripulacion();
            }
        });

        mostrarLista(copia);
    }

    private void mostrarLista(ArrayList<Nave> lista) {
        for (Nave nave : lista) {
            System.out.println("----------------------------");
            System.out.println("Nombre: " + nave.getNombre());
            System.out.println("Tripulación: " + nave.getCantidadTripulacion());
            System.out.println("Año lanzamiento: " + nave.getAnoLanzamiento());

            if (nave instanceof NaveDeExploracion) {
                NaveDeExploracion exploracion = (NaveDeExploracion) nave;
                System.out.println("Tipo misión: " + exploracion.getTipoMision());
            } else if (nave instanceof Carguero) {
                Carguero carguero = (Carguero) nave;
                System.out.println("Capacidad carga: " + carguero.getCapacidadCarga());
            } else if (nave instanceof CruceroEstelar) {
                CruceroEstelar crucero = (CruceroEstelar) nave;
                System.out.println("Pasajeros: " + crucero.getCantidadPasajeros());
            }
        }
    }
}