package cl.dsy1102.fonda;

public class BebidaSinAlcohol extends Bebida {
    private static final double PRECIO_BASE = 2000.0;
    private static final double AZUCAR_ALTA = 1.10;
    private static final int MAX_AZUCAR = 80;
    private int azucarPorLitro;

    public BebidaSinAlcohol(String nombre, int volumenML, int stock, int azucarPorLitro){
        super(nombre, volumenML, stock);
        setAzucarPorLitro(azucarPorLitro);
    }

    public int getAzucarPorLitro() {
        return azucarPorLitro;
    }

    public void setAzucarPorLitro(int azucarPorLitro) {
       if (azucarPorLitro < 0){
           throw new IllegalArgumentException("El azucar no puede ser menor a cero");
       }
       this.azucarPorLitro = azucarPorLitro;
    }

    @Override
    public double calcularPrecio(){
        double precio = PRECIO_BASE;
        if (azucarPorLitro > MAX_AZUCAR){
            return precio *= AZUCAR_ALTA;
        }
        return precio;
    }

    @Override
    public String obtenerDetalle() {
        return "Tipo: Bebida Sin Alcohol | Nombre: " + getNombre()
                + " | Volumen: " + getVolumenML() + " ml"
                + " | Stock: " + getStock()
                + " | Azucar: " + getAzucarPorLitro() + "g/l"
                + " | Precio: $" + (int) calcularPrecio();
    }
}
