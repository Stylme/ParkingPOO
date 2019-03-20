package parking;

import java.util.Scanner;


public class Menu {
    
    //Método main
    
    public static void main(String [] args){
        Menu menu = new Menu();
        menu.desplegarMenu();
    }
    
    // Se declara el atributo scanner como Objeto de la clase Scanner, 
    //final para que sea const y no se pueda sobreescribir en otros metodos
    
    private final Scanner scanner = new Scanner(System.in);
    
    /* Atributos de -->
       Asociacion unidireccional con multiplicidad 1*/
    
    private Parqueadero parqueadero = new Parqueadero();

    // Creacion del constructor de la clase
    
    public Menu() {
    
    }
    
    // Creacion de métodos de la clase, definidos como comportamientos u operaciones
    
    public void desplegarMenu() {
        mostrarOpciones();
        int opcionSeleccionada = Integer.parseInt(scanner.nextLine());
        ejecutarOpcion(opcionSeleccionada);
        desplegarMenu();
    }    

    private void mostrarOpciones() {
        
        String strMenu = "\n--- Sistema calificaciones ---";
        strMenu += "\n0. Salir.";
        strMenu += "\n1. Asignar vehículo a espacio.";
        strMenu += "\n2. Agregar tiempo a vehículo.";
        strMenu += "\n3. Cambiar espacio de vehículo.";
        strMenu += "\n4. Registrar salida de vehiculo.";
        strMenu += "\n5. Dar ingresos totales.";
        strMenu += "\n6. Mostrar parqueadero.";
        strMenu += "\n\nIngrese la opción: ";
        
        System.out.print(strMenu);
    }

    private void ejecutarOpcion(int opcionSeleccionada) {
        
        switch (opcionSeleccionada) {
            case 0:
                System.exit(0);
                break;
            case 1:
                ingresarVehiculo();
                break;
            case 2:
                agregarTiempoAVehiculo();
                break;
            case 3:
                cambiarEspacioVehiculo();
                break;
            case 4:
                registrarSalidaVehiculo();
                break;
            case 5:
                darIngresosTotales();
                break;
            case 6:
                mostrarParqueadero();
                break;
        }
        
    }
    
    private void ingresarVehiculo(){
        System.out.println("Agregar vehículo.");
        System.out.print("Ingrese los datos: ");
        String datos = scanner.nextLine();
        String [] datosVehiculo = datos.split("&");
        int espacio = Integer.parseInt(datosVehiculo[0]);
        int anio = Integer.parseInt(datosVehiculo[4]);
        System.out.println("\nSalida:");
        parqueadero.ingresarVehiculo(espacio, datosVehiculo[1], datosVehiculo[2], datosVehiculo[3], anio);      
    }
    
    private void agregarTiempoAVehiculo(){
        System.out.println("Agregar tiempo a vehículo.");
        System.out.print("Ingrese los datos: ");
        String datos = scanner.nextLine();
        String [] datosVehiculo = datos.split("&");
        int tiempo = Integer.parseInt(datosVehiculo[1]);
        System.out.println("\nSalida:");
        parqueadero.agregarTiempoAVehiculo(datosVehiculo[0], tiempo);
        System.out.println("Minutos actualizados, el nuevo estado del vehículo es " 
                + parqueadero.buscarCarro(datosVehiculo[0]));
    }
    
    private void cambiarEspacioVehiculo(){
        System.out.println("Cambiar espacio a vehículo.");
        System.out.print("Ingrese los datos: ");
        String datos = scanner.nextLine();
        String [] datosVehiculo = datos.split("&");
        int nuevoEspacio = Integer.parseInt(datosVehiculo[1]);
        parqueadero.cambiarEspacioAVehiculo(datosVehiculo[0], nuevoEspacio);
    }
    
    private void registrarSalidaVehiculo(){
        System.out.println("Registrar salida de vehículo.");
        System.out.print("Ingrese los datos: ");
        String datos = scanner.nextLine();
        System.out.print("\nSalida: \n");
        System.out.println("Se ha registrado la salida del vehículo " 
                + parqueadero.buscarCarro(datos) + " debe cancelar " 
                + "$"+ (parqueadero.buscarCarro(datos).getMinutos() * 100));
        parqueadero.registrarSalidaDeVehiculo(datos);
    }

    private void darIngresosTotales(){
        System.out.println("Consultar ingresos del parqueadero.");
        System.out.print("\nSalida: \n");
        System.out.println("Los ingresos totales son: $" + parqueadero.getIngresosTotales());
    }
    
    private void mostrarParqueadero(){
        String msj = "Mostrar parqueadero.\n\nSalida:" + parqueadero.toString();
        System.out.println(msj);
    }
    
}
