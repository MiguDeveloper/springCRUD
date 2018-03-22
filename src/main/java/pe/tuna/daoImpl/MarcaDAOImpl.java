package pe.tuna.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.tuna.beans.Marca;
import pe.tuna.dao.IMarcaDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class MarcaDAOImpl implements IMarcaDAO {

    @Autowired
    private DataSource dataSource;

    public void registrar(Marca marca) throws Exception {
        String sql = "INSERT INTO marca(nombre) VALUES(?)";
        Connection cn = null;

        try{
            cn = dataSource.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1 , marca.getNombre());
            ps.executeUpdate();
            ps.close();

        }catch(Exception ex){
            throw ex;
        }finally {
            if (cn != null){
                cn.close();
            }
        }
    }
}
