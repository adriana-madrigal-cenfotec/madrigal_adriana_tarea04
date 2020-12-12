package madrigal.adriana.tarea03.persistencia;

import madrigal.adriana.tarea03.bl.entidades.Materiales;

import java.sql.SQLException;
import java.util.List;

public abstract class MaterialDAO {
    public abstract boolean save(Materiales newMaterial);
    public abstract List<Materiales> findAll() throws SQLException;
}
