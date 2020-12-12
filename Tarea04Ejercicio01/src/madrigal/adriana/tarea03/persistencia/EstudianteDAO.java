package madrigal.adriana.tarea03.persistencia;

import com.mysql.cj.result.SqlDateValueFactory;
import madrigal.adriana.tarea03.bl.entidades.Administrativo;
import madrigal.adriana.tarea03.bl.entidades.Estudiante;
import madrigal.adriana.tarea03.bl.entidades.Persona;
import madrigal.adriana.tarea03.bl.tipos.TipoNombramiento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO extends PersonaDAO {
    Connection cnx;
    public EstudianteDAO(Connection cnx){ this.cnx = cnx;}

    public void salvarEstudiante(Estudiante nuevoEstudiante) throws SQLException{
        Statement stmt = cnx.createStatement();
        int id = autogeneracion();
        StringBuilder cmdLinea = new StringBuilder("Insert into TEstudiante (id,nombre,apellido,carrera,creditosMatriculados) values ('");
        cmdLinea.append(id);
        cmdLinea.append("','");
        cmdLinea.append(nuevoEstudiante.getNombre());
        cmdLinea.append("','");
        cmdLinea.append(nuevoEstudiante.getApellido());
        cmdLinea.append("','");
        cmdLinea.append(nuevoEstudiante.getCarrera());
        cmdLinea.append("','");
        cmdLinea.append(nuevoEstudiante.getCreditosMatriculados());
        cmdLinea.append("')");
        stmt.execute(cmdLinea.toString());
    }

    public List<Estudiante> findAllEstudiante() throws SQLException{
        ArrayList<Estudiante> listaEstudiante = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM TEstudiante");
        while (result.next()){
            Estudiante uno = new Estudiante();
            uno.setId(result.getInt("id"));
            uno.setNombre(result.getString("nombre"));
            uno.setApellido(result.getString("apellido"));
            uno.setCarrera(result.getString("carrera"));
            uno.setCreditosMatriculados(result.getInt("creditosMatriculados"));
            listaEstudiante.add(uno);
        }
        return listaEstudiante;
    }

    private int autogeneracion() throws SQLException {
        int id = 1;
        PreparedStatement ps = cnx.prepareStatement("SELECT MAX(id) FROM TEstudiante");
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
