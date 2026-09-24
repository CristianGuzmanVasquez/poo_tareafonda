package cl.dsy1102.fonda;

public class BebidaAlcoholica extends Bebida implements ConsumoResponsable {
    public static final int LIMITE_UNIDADES_POR_CLIENTE = 3;
    private static final double PRECIO_BASE = 3500.0;
    private static final double SIN_CERTIFICACION = 1.20;
    private double gradosAlcohol;
    private boolean certificada;
    private boolean ventaRestringida;

    public BebidaAlcoholica(String nombre, int volumenMl, int stock , double gradosAlcohol, boolean isCertificada){
        super(nombre,volumenMl,stock);
        setGradosAlcohol(gradosAlcohol);
        this.certificada= isCertificada;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(double gradosAlcohol) {
        if(gradosAlcohol < 0.5 || gradosAlcohol > 45){
            throw new IllegalArgumentException("Debe tener entre 0.5 y 45 grados de alcohol");
        }
        this.gradosAlcohol = gradosAlcohol;
    }

    public boolean isCertificada() {
        return certificada;
    }

    public void setCertificada(boolean certificada) {
        this.certificada = certificada;
    }

    public boolean tieneVentaRestringida() {
        return ventaRestringida;
    }

    public void restringirVenta(){
        ventaRestringida = true;
    }

    @Override
    public boolean superaLimite(int unidades){
      return unidades > LIMITE_UNIDADES_POR_CLIENTE;
    }

    @Override
    public double calcularPrecio(){
        double precio = PRECIO_BASE;
        if(!isCertificada()){
            precio *= SIN_CERTIFICACION;
        }
        return precio;
    }

    @Override
    public String obtenerDetalle() {
        return "Tipo: Bebida Alcoholica | Nombre: " + getNombre()
                + " | Volumen: " + getVolumenML() + " ml"
                + " | Stock: " + getStock()
                + " | Grados: " + getGradosAlcohol()
                + " | Certificada: " + (isCertificada() ? "Si" : "No")
                + "\n  Venta restringida: " + (tieneVentaRestringida() ? "Si" : "No")
                + " | Precio: $" + (int) calcularPrecio();
    }
}
