package naves;

import java.util.Scanner;

public class Naves {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AgenciaEspacial agencia = new AgenciaEspacial();

        int opcion;

        do {
            System.out.println("===== SISTEMA DE NAVES =====");
            System.out.println("1. Agregar nave");
            System.out.println("2. Mostrar todas las naves");
            System.out.println("3. Iniciar misión de exploración");
            System.out.println("4. Mostrar naves ordenadas por nombre");
            System.out.println("5. Mostrar naves ordenadas por año");
            System.out.println("6. Mostrar naves ordenadas por tripulación");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    cargarNave(sc, agencia);
                    break;

                case 2:
                    agencia.mostrarNaves();
                    break;

                case 3:
                    agencia.iniciarExploracion();
                    break;

                case 4:
                    agencia.mostrarOrdenadasPorNombre();
                    break;

                case 5:
                    agencia.mostrarOrdenadasPorAnio();
                    break;

                case 6:
                    agencia.mostrarOrdenadasPorTripulacion();
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);
    }

    public static void cargarNave(Scanner sc, AgenciaEspacial agencia) {

        System.out.println("Tipo de nave:");
        System.out.println("1. Nave de exploración");
        System.out.println("2. Carguero");
        System.out.println("3. Crucero estelar");
        System.out.print("Tipo: ");

        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo inválido.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Capacidad de tripulación: ");
        int tripulacion = sc.nextInt();

        if (tripulacion <= 0) {
            System.out.println("La capacidad debe ser mayor a cero.");
            return;
        }

        System.out.print("Año de lanzamiento: ");
        int anio = sc.nextInt();

        if (anio <= 0) {
            System.out.println("El año debe ser válido.");
            return;
        }

        if (tipo == 1) {
            System.out.println("Misión:");
            System.out.println("1. CARTOGRAFIA");
            System.out.println("2. INVESTIGACION");
            System.out.println("3. CONTACTO");
            System.out.print("Opción: ");

            int opcionMision = sc.nextInt();

            TipoMision tipoMision;

            if (opcionMision == 1) {
                tipoMision = TipoMision.CARTOGRAFIA;
            } else if (opcionMision == 2) {
                tipoMision = TipoMision.INVESTIGACION;
            } else if (opcionMision == 3) {
                tipoMision = TipoMision.CONTACTO;
            } else {
                System.out.println("Tipo de misión inválido.");
                return;
            }

            agencia.agregarNave(
                    new NaveDeExploracion(tipoMision, nombre, tripulacion, anio));

        } else if (tipo == 2) {
            System.out.print("Capacidad de carga: ");
            int carga = sc.nextInt();

            if (carga < 100) {
                System.out.println("Carga menor a 100. Se asigna 100.");
                carga = 100;
            } else if (carga > 500) {
                System.out.println("Carga mayor a 500. Se asigna 500.");
                carga = 500;
            }

            agencia.agregarNave(
                    new Carguero(carga, nombre, tripulacion, anio));

        } else if (tipo == 3) {
            System.out.print("Cantidad de pasajeros: ");
            int pasajeros = sc.nextInt();

            if (pasajeros <= 0) {
                System.out.println("La cantidad de pasajeros debe ser mayor a cero.");
                return;
            }

            agencia.agregarNave(
                    new CruceroEstelar(pasajeros, nombre, tripulacion, anio));
        }
    }
}