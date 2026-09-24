package cl.dsy1102.fonda;

import java.util.ArrayList;
import java.util.List;

public class GestorFonda {
    private final List<Bebida> bebidas;

    public GestorFonda(){
        this.bebidas =new ArrayList<>();
    }

    public void registrar(Bebida bebida){
        bebidas.add(bebida);
        System.out.println(bebida.getNombre() + " Registrada con exito");
    }

    public List<Bebida> buscarPorNombre(String nombre){
        List<Bebida> resultados = new ArrayList<>();
        for (Bebida bebida : bebidas){
           if (bebida.getNombre().equalsIgnoreCase(nombre)) {
               resultados.add(bebida);
           }
        }
        return resultados;
    }

    public void vender(String nombre, int unidades){
        List<Bebida> resultados = buscarPorNombre(nombre);

        if (resultados.isEmpty()){
            throw new IllegalArgumentException("Bebida no encontrada");
        }
        Bebida bebida = resultados.get(0);

        if (unidades<=0){
            throw new IllegalArgumentException("Las unidades deben ser mayores a 0");
        }

        if (unidades > bebida.getStock()){
            throw new IllegalArgumentException("Stock insuficiente");
        }

        if (bebida instanceof ConsumoResponsable){
            ConsumoResponsable consumo = (ConsumoResponsable) bebida;

            if (consumo.tieneVentaRestringida()){
                System.out.println("Venta rechazada: " + bebida.getNombre()+ " tiene la venta restringida");
                return;
            }

            if (consumo.superaLimite(unidades)){
                System.out.println("Venta rechazada: " + unidades +" unidades de "
                        + bebida.getNombre() + " superan el limite de 3 por cliente");
                return;
            }
        }
        bebida.setStock(bebida.getStock()-unidades);
        double total = bebida.calcularPrecio()* unidades;
        System.out.println("Venta autorizada: " + unidades + " x " + bebida.getNombre() + " | Total: $" +(int) total);
    }

    public List<Bebida> obtenerTodas(){
        return bebidas;
    }
}
