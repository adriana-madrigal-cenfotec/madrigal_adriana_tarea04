package madrigal.adriana.tarea03.persistencia;

import madrigal.adriana.tarea03.bl.entidades.Administrativo;
import madrigal.adriana.tarea03.bl.entidades.Persona;
import madrigal.adriana.tarea03.bl.tipos.TipoNombramiento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends PersonaDAO {
    Connection cnx;
    public AdminDAO(Connection cnx){ this.cnx = cnx;}

    public void salvarAdmin(Administrativo nuevaPersona) throws SQLException {
        Statement stmt = cnx.createStatement();
        int id = autogeneracion();
        StringBuilder cmdLinea = new StringBuilder("Insert into TAdministrativos (id,nombre,apellido,tipoNombramiento,cantidadHorasSemana) values ('");
        cmdLinea.append(id);
        cmdLinea.append("','");
        cmdLinea.append(nuevaPersona.getNombre());
        cmdLinea.append("','");
        cmdLinea.append(nuevaPersona.getApellido());
        cmdLinea.append("','");
        cmdLinea.append(nuevaPersona.getTipoNombramiento());
        cmdLinea.append("','");
        cmdLinea.append(nuevaPersona.getCantidadHorasSemanales());
        cmdLinea.append("')");
        stmt.execute(cmdLinea.toString());
    }

    public List<Administrativo> findAllAdministrativo() throws SQLException {
        ArrayList<Administrativo> listaAdmin = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM TAdministrativos");
        while (result.next()){
            Administrativo uno = new Administrativo();
            uno.setId(result.getInt("id"));
            uno.setNombre(result.getString("nombre"));
            uno.setApellido(result.getString("apellido"));
            uno.setTipoNombramiento(TipoNombramiento.valueOf(result.getString("tipoNombramiento")));
            uno.setCantidadHorasSemanales(result.getInt("cantidadHorasSemana"));
            listaAdmin.add(uno);
        }
        return listaAdmin;
    }
    private int autogeneracion() throws SQLException {
        int id = 1;
        PreparedStatement ps = cnx.prepareStatement("SELECT MAX(id) FROM TAdministrativos");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            id = rs.getInt(1) + 1;
        }
        return id;
    }

    @Override
    public boolean salvarPersona(Persona nuevaPersona) throws SQLException {
        return false;
    }

    @Override
    public List<Persona> findAllPersona() throws SQLException {
        return null;
    }
}
