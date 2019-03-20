package parking;

public class Parqueadero {

    // Declaracion de atributos
    private int ingresosTotales;

    /* Atributos de -->
     Asociacion bidireccional con multiplicidad 1
     */
    private Espacio espacio1;
    private Espacio espacio2;
    private Espacio espacio3;
    private Espacio espacio4;

    public Vehiculo vehiculo;

    public Parqueadero() {
        espacio1 = new Espacio(1);
        espacio2 = new Espacio(2);
        espacio3 = new Espacio(3);
        espacio4 = new Espacio(4);
    }

    // Creacion de los metodos
    public void ingresarVehiculo(int espacio, String placa, String marca, String modelo, int anio) {

        vehiculo = new Vehiculo(placa, marca, modelo, anio);

        switch (espacio) {
            case 1:
                if (espacio1.estaOcuapdo()) {
                    espacio1.agregarVehiculo(vehiculo);
                    System.out.println("El vehículo " + Parqueadero.this.vehiculo.toString() + espacio1.toString());
                } else {
                    System.out.println("El vehículo " + Parqueadero.this.vehiculo.toString()
                            + espacio1.toString(" no se puede agregar al espacio 1 porque esta ocupado por el vehículo")
                            + espacio1.getVehiculo());
                }
                break;
            case 2:
                if (espacio2.estaOcuapdo()) {
                    espacio2.agregarVehiculo(vehiculo);
                    System.out.println("El vehículo " + Parqueadero.this.vehiculo.toString() + espacio2.toString());
                } else {
                    System.out.println("El vehículo " + Parqueadero.this.vehiculo.toString()
                            + espacio2.toString(" no se puede agregar al espacio 2 porque esta ocupado por el vehículo")
                            + espacio2.getVehiculo());
                }
                break;
            case 3:
                if (espacio3.estaOcuapdo()) {
                    espacio3.agregarVehiculo(vehiculo);
                    System.out.println("El vehículo " + Parqueadero.this.vehiculo.toString() + espacio3.toString());
                } else {
                    System.out.println("El vehículo " + Parqueadero.this.vehiculo.toString()
                            + espacio3.toString(" no se puede agregar al espacio 3 porque esta ocupado por el vehículo")
                            + espacio3.getVehiculo());
                }
                break;
            case 4:
                if (espacio4.estaOcuapdo()) {
                    espacio4.agregarVehiculo(vehiculo);
                    System.out.println("El vehículo " + Parqueadero.this.vehiculo.toString() + espacio4.toString());
                } else {
                    System.out.println("El vehículo " + Parqueadero.this.vehiculo.toString()
                            + espacio4.toString(" no se puede agregar al espacio 4 porque esta ocupado por el vehículo")
                            + espacio4.getVehiculo());
                }
                break;
            default:
                System.out.println("No existe el espacio " + espacio);
                return;
        }

    }

    private Espacio buscarEspacio(int id) {
        Espacio espacio = null;
        Espacio espacios[] = {Parqueadero.this.espacio1,
            Parqueadero.this.espacio2,
            Parqueadero.this.espacio3,
            Parqueadero.this.espacio4};
        for (int i = 0; i < espacios.length; i++) {
            if (espacios[i].getId() == id) {
                espacio = espacios[i];
            }
        }
        return espacio;
    }

    public void agregarTiempoAVehiculo(String placa, int tiempo) {
        Vehiculo v = buscarCarro(placa);
        tiempo = tiempo + v.getMinutos();
        v.setMinutos(tiempo);
    }

    public Vehiculo buscarCarro(String placa) {
        Vehiculo vehiculoR = null;
        Vehiculo vehiculos[] = {Parqueadero.this.espacio1.getVehiculo(),
            Parqueadero.this.espacio2.getVehiculo(),
            Parqueadero.this.espacio3.getVehiculo(),
            Parqueadero.this.espacio4.getVehiculo()};
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] != null) {
                if (vehiculos[i].getPlaca().equals(placa)) {
                    vehiculoR = vehiculos[i];
                }
            }
        }
        return vehiculoR;
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
        Espacio espacioV = null;
        Espacio espacios[] = {Parqueadero.this.espacio1,
            Parqueadero.this.espacio2,
            Parqueadero.this.espacio3,
            Parqueadero.this.espacio4};
        for (int i = 0; i < espacios.length; i++) {
            if (espacios[i] != null) {
                if (espacios[i].getVehiculo() == v) {
                    espacioV = espacios[i];
                }
            }
        }
        return espacioV;
    }

    public void registrarSalidaDeVehiculo(String placa) {
        darEspacioDeVehiculo(placa).desocupar();
    }

    public int darIngresosTotales() {
        Vehiculo array[] = {Parqueadero.this.espacio1.getVehiculo(),
            Parqueadero.this.espacio2.getVehiculo(),
            Parqueadero.this.espacio3.getVehiculo(),
            Parqueadero.this.espacio4.getVehiculo()
        };
        for (Vehiculo array1 : array) {
            if (array1 != null) {
                this.ingresosTotales = this.ingresosTotales + (array1.getMinutos() * 100);
            }
        }
        return ingresosTotales;
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
        strParking += "     {\"id\": " + espacio1.getId() + ", \"vehículo\":" + espacio1.getVehiculo() + "},\n";
        strParking += "     {\"id\": " + espacio2.getId() + ", \"vehículo\":" + espacio2.getVehiculo() + "},\n";
        strParking += "     {\"id\": " + espacio3.getId() + ", \"vehículo\":" + espacio3.getVehiculo() + "},\n";
        strParking += "     {\"id\": " + espacio4.getId() + ", \"vehículo\":" + espacio4.getVehiculo() + "}}";
        strParking += "\n   ]\n";
        strParking += "}\n";

        return strParking;
    }

}
