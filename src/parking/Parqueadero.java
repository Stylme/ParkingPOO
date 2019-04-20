package parking;

import java.util.ArrayList;

public class Parqueadero {

    // Declaración de atributos
    private int ingresosTotales;

    private ArrayList<Espacio> espacios;

    public Vehiculo vehiculo;

    // Creación de los métodos
    public ArrayList<Espacio> inciarParqueadero(int numeroEspacios) {
        this.espacios = new ArrayList<>(numeroEspacios);
        Espacio e;
        for (int i = 1; i <= numeroEspacios; i++) {
            e = new Espacio(i);
            espacios.add(e);
        }
        return this.espacios;
    }

    public void ingresarVehiculo(int espacio, String placa, String marca, String modelo, int anio) {
        espacio--;
        vehiculo = new Vehiculo(placa, marca, modelo, anio);
        if (espacios.get(espacio).estaOcuapdo()) {
            espacios.get(espacio).agregarVehiculo(vehiculo);
            System.out.println("El vehículo " + Parqueadero.this.vehiculo.toString() + espacios.get(espacio).toString());
        } else {
            System.out.println("El vehículo " + Parqueadero.this.vehiculo.toString()
                    + espacios.get(espacio).toString(" no se puede agregar al espacio 1 porque esta ocupado por el vehículo")
                    + espacios.get(espacio).getVehiculo());
        }
    }

    private Espacio buscarEspacio(int id) {
        Espacio espacioRetornado = null;
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getId() == id) {
                espacioRetornado = espacios.get(i);
            }
        }
        return espacioRetornado;
    }

    public Vehiculo buscarCarro(String placa) {
        Vehiculo vehiculoRetornado = null;
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getVehiculo() != null) {
                if (espacios.get(i).getVehiculo().getPlaca().equals(placa)) {
                    vehiculoRetornado = espacios.get(i).getVehiculo();
                }
            }
        }
        return vehiculoRetornado;
    }

    public void agregarTiempoAVehiculo(String placa, int tiempo) {
        Vehiculo v = buscarCarro(placa);
        tiempo = tiempo + v.getMinutos();
        v.setMinutos(tiempo);
    }

    public void cambiarEspacioAVehiculo(String placa, int nuevoEspacio) {
        Vehiculo v = buscarCarro(placa);

        Espacio espacioAnterior = darEspacioDeVehiculo(v.getPlaca());
        Espacio espacioNuevo = buscarEspacio(nuevoEspacio);

        if (espacioNuevo.estaOcuapdo()) {
            espacioAnterior.desocupar();
            espacioNuevo.agregarVehiculo(v);
            String cambiado = "El vehículo " + v.toString() + " ha sido cambiado al espacio " + nuevoEspacio;
            System.out.println(cambiado);
        } else {
            String mismoEspacio = "El vehículo " + v.toString()
                    + " no se puede mover al espacio " + nuevoEspacio
                    + " porque ya esta en el espacio " + nuevoEspacio;
            String noCambiado = "El vehículo " + v.toString()
                    + " no se puede mover al espacio " + nuevoEspacio
                    + " porque esta ocupado por el vehículo " + espacioNuevo.getVehiculo();
            if (espacioAnterior == espacioNuevo) {
                System.out.println(mismoEspacio);
            } else {
                System.out.println(noCambiado);
            }
        }

    }

    private Espacio darEspacioDeVehiculo(String placa) {
        Vehiculo v = buscarCarro(placa);
        Espacio espacioVehiculo = null;
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getVehiculo() != null) {
                if (espacios.get(i).getVehiculo() == v) {
                    espacioVehiculo = espacios.get(i);
                }
            }
        }
        return espacioVehiculo;
    }

    public int hackearParqueadero() {
        int min = 0;
        int carros = 0;
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getVehiculo() != null) {
                carros++;
                espacios.get(i).getVehiculo().setMinutos(min);
            }
        }
        return carros;
    }

    public String mostrarMilenials() {
        String carros = "";
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getVehiculo() != null) {
                if (espacios.get(i).getVehiculo().getAnio() > 1990) {
                    carros += espacios.get(i).getVehiculo().toString() + "\n";
                }
            }
        }
        return carros;
    }

    public int eliminarMarca(String marca) {
        int num = 0;
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getVehiculo() != null) {
                if (espacios.get(i).getVehiculo().getMarca().equals(marca)) {
                    espacios.get(i).desocupar();
                    num++;
                }
            }
        }
        return num;
    }

    public void registrarSalidaDeVehiculo(String placa) {
        ingresosTotales += buscarCarro(placa).getMinutos() * 100;
        darEspacioDeVehiculo(placa).desocupar();
    }

    public int getIngresosTotales() {
        return ingresosTotales;
    }

    // llamado a la clase String
    @Override
    public String toString() {
        String strParking = new String();
        String strIngTo = String.valueOf(ingresosTotales);
        strParking += "\n{\n";
        strParking += "  \"ingresos\": $" + strIngTo + ",\n";
        strParking += "  \"espacios\": [\n";
        for (int i = 0; i < espacios.size(); i++) {
            if (espacios.get(i).getId() == espacios.size()){
                strParking += "     {\"id\": " + espacios.get(i).getId() + ", \"vehículo\":"
                    + espacios.get(i).getVehiculo() + "}\n";
            } else {
                strParking += "     {\"id\": " + espacios.get(i).getId() + ", \"vehículo\":"
                    + espacios.get(i).getVehiculo() + "},\n";
            }
        }
        strParking += "   ]\n";
        strParking += "}\n";

        return strParking;
    }

}
