package pe.tuna.principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.tuna.beans.Camiseta;
import pe.tuna.beans.Equipo;
import pe.tuna.beans.Jugador;
import pe.tuna.beans.Marca;
import pe.tuna.service.IJugadorService;
import pe.tuna.service.IMarcaService;

public class App {
    public static void main(String[] args) {
        /*
         * para la creacion de una marca
        Marca marca = new Marca();
        marca.setNombre("Nike");

        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        IMarcaService marcaService = (IMarcaService) appContext.getBean("marcaServiceImpl"); // Recordar ponerlo en minuscula

        try{
            marcaService.registrar(marca);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        */

        Equipo equipo = new Equipo();
        equipo.setId(1);
        Camiseta camiseta = new Camiseta();
        camiseta.setId(1);

        Jugador jugador = new Jugador();
        jugador.setNombre("Micky");
        jugador.setEquipo(equipo);
        jugador.setCamiseta(camiseta);

        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        IJugadorService jugadorService = (IJugadorService) appContext.getBean("jugadorServiceImpl");

        try{
            jugadorService.registrar(jugador);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
