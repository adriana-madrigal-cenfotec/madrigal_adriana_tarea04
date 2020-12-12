package madrigal.adriana.tarea03.persistencia;

import madrigal.adriana.tarea03.bl.entidades.Administrativo;
import madrigal.adriana.tarea03.bl.entidades.Persona;
import madrigal.adriana.tarea03.bl.entidades.Profesor;
import madrigal.adriana.tarea03.bl.tipos.TipoContracto;
import madrigal.adriana.tarea03.bl.tipos.TipoNombramiento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO extends PersonaDAO{
    Connection cnx;
    public ProfesorDAO(Connection cnx){ this.cnx = cnx;}

    public void salvarProfesor(Profesor nuevoProfesor) throws SQLException{
        Statement stmt = cnx.createStatement();
        int id = autogeneracion();
        StringBuilder cmdLinea = new StringBuilder("Insert into TProfesor (id,nombre,apellido,tipoContrato,fechaContratacion) values ('");
        cmdLinea.append(id);
        cmdLinea.append("','");
        cmdLinea.append(nuevoProfesor.getNombre());
        cmdLinea.append("','");
        cmdLinea.append(nuevoProfesor.getApellido());
        cmdLinea.append("','");
        cmdLinea.append(nuevoProfesor.getTipoContrato());
        cmdLinea.append("','");
        cmdLinea.append(nuevoProfesor.getFechaContratacion());
        cmdLinea.append("')");
        stmt.execute(cmdLinea.toString());

    }

    public List<Profesor> findAllProfesor() throws SQLException{
        ArrayList<Profesor> listaProfesor = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM TProfesor");
        while (result.next()){
            Profesor uno = new Profesor();
            uno.setId(result.getInt("id"));
            uno.setNombre(result.getString("nombre"));
            uno.setApellido(result.getString("apellido"));
            uno.setTipoContrato(TipoContracto.valueOf(result.getString("tipoContrato")));
            uno.setFechaContratacion(result.getDate("fechaContratacion").toLocalDate());
            listaProfesor.add(uno);
        }
        return listaProfesor;
    }
    private int autogeneracion() throws SQLException {
        int id = 1;
        PreparedStatement ps = cnx.prepareStatement("SELECT MAX(id) FROM TProfesor");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            id = rs.getInt(1) + 1;
        }
        return id;
    }


    @Override
    public boolean salvarPersona(Persona nuevaPersona) throws SQLException{
        return false;
    }

    @Override
    public List<Persona> findAllPersona() throws SQLException {
        return null;
    }
}
