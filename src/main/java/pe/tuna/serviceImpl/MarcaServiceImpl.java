package pe.tuna.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.tuna.beans.Marca;
import pe.tuna.dao.IMarcaDAO;
import pe.tuna.service.IMarcaService;

@Service
public class MarcaServiceImpl implements IMarcaService{

    @Autowired
    private IMarcaDAO iMarcaDAO;


    public void registrar(Marca marca) throws Exception {
        try{
            iMarcaDAO.registrar(marca);
        }catch(Exception ex){
            throw ex;
        }
    }
}
