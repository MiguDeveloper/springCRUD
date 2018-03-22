package pe.tuna.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.tuna.beans.Jugador;
import pe.tuna.dao.IJugadorDAO;
import pe.tuna.service.IJugadorService;

@Service
public class JugadorServiceImpl implements IJugadorService{

    @Autowired
    private IJugadorDAO iJugadorDAO;

    public void registrar(Jugador jugador) throws Exception {
        try{
            iJugadorDAO.registrar(jugador);
        }catch (Exception ex){
            throw ex;
        }
    }
}
