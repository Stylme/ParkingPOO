package parking;

import java.util.Scanner;


public class Menu {
    
    //Método main
    
    public static void main(String [] args){
        Menu menu = new Menu();
        menu.desplegarMenu();
    }
    
    // Declaración de atributos.
    
    private final Scanner scanner = new Scanner(System.in);    
    
    private Parqueadero parqueadero = new Parqueadero();

    // Creación del constructor de la clase.
    
    public Menu() {
    
    }
    
    // Creación de métodos de la clase, definidos como comportamientos u operaciones.
    
    public void desplegarMenu() {
        mostrarOpciones();
        int opcionSeleccionada = Integer.parseInt(scanner.nextLine());
        ejecutarOpcion(opcionSeleccionada);
        desplegarMenu();
    }    

    private void mostrarOpciones() {
        
        String strMenu = "\nMenú, digite una de las siguientes opciones:";
        strMenu += "\n1. Inicializar/Reiniciar parqueadero.";
        strMenu += "\n2. Agregar vehículo a espacio.";
        strMenu += "\n3. Agregar tiempo a vehículo.";
        strMenu += "\n4. Cambiar espacio de vehículo.";
        strMenu += "\n5. Registrar salida de vehiculo.";
        strMenu += "\n6. Dar ingresos totales.";
        strMenu += "\n7. Mostrar parqueadero.";
        strMenu += "\n11. Hackear parqueadero.";
        strMenu += "\n12. Mostrar vehículos milenials.";
        strMenu += "\n13. Eliminar vehículos por marca.";
        strMenu += "\n0. Salir.";
        strMenu += "\n\nIngrese la opción: ";
        System.out.print(strMenu);
    }

    private void ejecutarOpcion(int opcionSeleccionada) {
        
        switch (opcionSeleccionada) {
            case 0:
                System.exit(0);
                break;
            case 1:
                iniciarParqueadero();
                break;
            case 2:
                ingresarVehiculo();
                break;
            case 3:
                agregarTiempoAVehiculo();
                break;
            case 4:
                cambiarEspacioVehiculo();
                break;
            case 5:
                registrarSalidaVehiculo();
                break;
            case 6:
                darIngresosTotales();
                break;
            case 7:
                mostrarParqueadero();
                break;
            case 11:
                hackearParqueadero();
                break;
            case 12:
                mostrarMilenials();
                break;
            case 13:
                eliminarMarca();
                break;
        }
        
    }
    
    private void iniciarParqueadero(){
        System.out.println("Inicializar parqueadero.");
        System.out.print("Ingrese el número de espacios: ");
        int n = Integer.parseInt(scanner.nextLine());
        parqueadero.inciarParqueadero(n);
        System.out.println("\nSalida: \nSe ha creado un nuevo parqueadero con " + n + " espacios.");
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
    
    private void hackearParqueadero(){
        System.out.println("Hackear Sistema \n\nSalida: ");
        System.out.println("Se ha modificado la información de " + parqueadero.hackearParqueadero() 
                + " carros. Ahora todos tienen 0 minutos.");
    }
    
    private void mostrarMilenials(){
        System.out.println("Mostrar vehículos milenials. \n\nSalida:");
        System.out.println(parqueadero.mostrarMilenials());
    }
    
    private void eliminarMarca(){
        System.out.println("Eliminar vehículos por marca.");
        System.out.print("Ingrese la marca: ");
        String datos = scanner.nextLine();
        System.out.println("Se han eliminado " + parqueadero.eliminarMarca(datos) 
                + " vehículos de la marca " + datos);
    }
}
