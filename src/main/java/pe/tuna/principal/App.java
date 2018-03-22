package pe.tuna.principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.tuna.beans.Marca;
import pe.tuna.service.IMarcaService;

public class App {
    public static void main(String[] args) {
        Marca marca = new Marca();
        marca.setNombre("Nike");

        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        IMarcaService marcaService = (IMarcaService) appContext.getBean("marcaServiceImpl"); // Recordar ponerlo en minuscula

        try{
            marcaService.registrar(marca);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
