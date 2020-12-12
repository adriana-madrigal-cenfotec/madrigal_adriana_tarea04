package madrigal.adriana.tarea03.persistencia;

import madrigal.adriana.tarea03.bl.entidades.Audio;
import madrigal.adriana.tarea03.bl.entidades.Materiales;
import madrigal.adriana.tarea03.bl.entidades.Texto;
import madrigal.adriana.tarea03.bl.tipos.TipoAudio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TextoDAO extends MaterialDAO{
    Connection cnx;
    public TextoDAO(Connection cnx){ this.cnx = cnx;}

    public void saveTexto(Texto nuevoTexto) throws SQLException {

        Statement insertCmd = cnx.createStatement();
        int id = autogeneracionTexto();
        StringBuilder cmdLinea = new StringBuilder("Insert into TTexto (id,fechaCompra,restringido,tema,titulo,autor,fechaPublicado,numeroPaginas,idioma) values ('");
        cmdLinea.append(id);
        cmdLinea.append("','");
        cmdLinea.append(nuevoTexto.getFechaCompra());
        cmdLinea.append("',");
        cmdLinea.append(nuevoTexto.isRestringido());
        cmdLinea.append(",'");
        cmdLinea.append(nuevoTexto.getTema());
        cmdLinea.append("','");
        cmdLinea.append(nuevoTexto.getTitulo());
        cmdLinea.append("','");
        cmdLinea.append(nuevoTexto.getNombreAutor());
        cmdLinea.append("','");
        cmdLinea.append(nuevoTexto.getFechaPublicacion());
        cmdLinea.append("','");
        cmdLinea.append(nuevoTexto.getNumeroPaginas());
        cmdLinea.append("','");
        cmdLinea.append(nuevoTexto.getIdiomaTexto());
        cmdLinea.append("')");
        insertCmd.execute(cmdLinea.toString());

    }

    public List<Texto> findAllTexto() throws SQLException {
        ArrayList<Texto> listaTextos = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM TTexto");
        while (result.next()){
            Texto uno = new Texto();
            uno.setId(result.getInt("id"));
            uno.setFechaCompra(result.getDate("fechaCompra").toLocalDate());
            uno.setRestringido(result.getBoolean("restringido"));
            uno.setTema(result.getString("tema"));
            uno.setTitulo(result.getString("titulo"));
            uno.setNombreAutor(result.getString("autor"));
            uno.setFechaPublicacion(result.getDate("fechaPublicado").toLocalDate());
            uno.setNumeroPaginas(result.getInt("numeroPaginas"));
            uno.setIdiomaTexto(result.getString("idioma"));
            listaTextos.add(uno);
        }
        return listaTextos;
    }

    public int autogeneracionTexto() throws SQLException {
        int id = 1;
        PreparedStatement ps = cnx.prepareStatement("SELECT MAX(id) FROM TTexto");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            id = rs.getInt(1) + 1;
        }
        return id;
    }

    @Override
    public boolean save(Materiales newMaterial) {
        return false;
    }

    @Override
    public List<Materiales> findAll() throws SQLException {
        return null;
    }
}
