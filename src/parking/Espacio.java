package parking;


public class Espacio {
    
    // Declaracion de atributos
    
    private int id;
    private boolean ocupado = false;
    
    /* Atributos de -->
    Asociacion bidireccional con multiplicidad 0..1
    */
    
    private Vehiculo vehiculo;
    
    // Creacion del constructor
    
    public Espacio(int id) {
        this.id = id;
        vehiculo = null;
    }
    
    // Creacion de los metodos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public void agregarVehiculo(Vehiculo vehiculo){
        setVehiculo(vehiculo);
    }
    
    public boolean estaOcuapdo(){
        if (vehiculo != null) {
            return false;
        } else {
            return true;
        }
    }
    
    public Vehiculo desocupar(){
        return vehiculo = null;
    }
    
    
    // llamado a la clase string

    @Override
    public String toString() {
        String mensajeSi = " ha sido agregado al espacio " + id;
        return mensajeSi;
    }
    
    public String toString(String mensajeNo){
        return mensajeNo;
    }
    
}
