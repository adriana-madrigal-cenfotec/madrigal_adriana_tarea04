package madrigal.adriana.tarea03.persistencia;

import madrigal.adriana.tarea03.bl.entidades.Persona;

import java.sql.SQLException;
import java.util.List;

public abstract class PersonaDAO {
    public abstract boolean salvarPersona(Persona nuevaPersona) throws SQLException;
    public abstract List<Persona> findAllPersona() throws SQLException;
}
