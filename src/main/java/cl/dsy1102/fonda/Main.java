package cl.dsy1102.fonda;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        GestorFonda gestor = new GestorFonda();

        BebidaAlcoholica chicha = new BebidaAlcoholica("Chicha", 1000, 40, 12.0, false);
        BebidaAlcoholica piscoSour = new BebidaAlcoholica("Pisco Sour", 500, 25, 18.0, true);
        BebidaSinAlcohol chichaSinAlcohol = new BebidaSinAlcohol("Chicha", 1000, 60, 95);
        BebidaSinAlcohol moteConHuesillo = new BebidaSinAlcohol("Mote con Huesillo", 400, 50, 70);

        chicha.restringirVenta();
        gestor.registrar(chicha);
        gestor.registrar(piscoSour);
        gestor.registrar(chichaSinAlcohol);
        gestor.registrar(moteConHuesillo);

        System.out.println(" ");
        System.out.println("=== BUSQUEDA POR NOMBRE: Chicha ===" );
        List<Bebida> resultado = gestor.buscarPorNombre("Chicha");
        for(Bebida bebida : resultado){
            System.out.println(bebida.obtenerDetalle());
        }

        System.out.println(" ");
        System.out.println("=== VENTAS ===");
        gestor.vender("Pisco Sour", 2);
        gestor.vender("Pisco Sour", 5);
        gestor.vender("Chicha", 1);
        gestor.vender("Mote con Huesillo", 6);

        System.out.println(" ");
        System.out.println(" === LISTADO DE BEBIDAS ===");
        List<Bebida> todas = gestor.obtenerTodas();
        for (Bebida bebida : todas){
            System.out.println(bebida.toString());
        }

    }
}
