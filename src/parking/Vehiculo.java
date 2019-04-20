package parking;


public class Vehiculo {
    
    // Declaración de atributos
    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private int minutos =0;
    
    // Creación del contructor

    public Vehiculo(String placa, String marca, String modelo, int anio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }
    
    // Creación de los métodos

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public int getMinutos() {
        return minutos;
    }
    
    public void agregarTiempo(int minutos){
        this.minutos = minutos;
    }
    
    public int darTiempo(){
        return this.minutos;
    }
    
    // llamado a la clase String

    @Override
    public String toString() {
        String mensaje = "{\"placa\": " + "\"" + placa + "\", \"Marca\": " +
                "\"" + marca + "\", \"Modelo\":" + "\"" + modelo + "\", \"año\": " + anio + ", \"minutos\": " +
                minutos + "}";
        return mensaje;
    }
    
}
