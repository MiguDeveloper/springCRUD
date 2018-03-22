package pe.tuna.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.tuna.beans.Jugador;
import pe.tuna.dao.IJugadorDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class JugadorDAOImpl implements IJugadorDAO {

    @Autowired
    private DataSource dataSource;

    public void registrar(Jugador jugador) throws Exception {

        String sql = "INSERT INTO jugador(nombre, equipo_id, camiseta_id) VALUES(?,?,?)";
        Connection cn = null;

        try {
            cn = dataSource.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, jugador.getNombre());
            ps.setInt(2, jugador.getEquipo().getId());
            ps.setInt(3, jugador.getCamiseta().getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
    }
}
