package madrigal.adriana.tarea03.persistencia;

import madrigal.adriana.tarea03.bl.entidades.Audio;
import madrigal.adriana.tarea03.bl.entidades.Materiales;
import madrigal.adriana.tarea03.bl.tipos.TipoAudio;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AudioDAO extends MaterialDAO{

    Connection cnx;
    public AudioDAO(Connection cnx){ this.cnx = cnx;}

    public void saveAudio(Audio newAudio) throws SQLException{
        Statement insertCmd = cnx.createStatement();
        int id = autogeneracion();
        StringBuilder cmdLinea = new StringBuilder("Insert into TAudio (id,fechaCompra,restringido,tema,duracionAudio,idiomaAudio,tipoAudio) values ('");
        cmdLinea.append(id);
        cmdLinea.append("','");
        cmdLinea.append(newAudio.getFechaCompra());
        cmdLinea.append("',");
        cmdLinea.append(newAudio.isRestringido());
        cmdLinea.append(",'");
        cmdLinea.append(newAudio.getTema());
        cmdLinea.append("','");
        cmdLinea.append(newAudio.getDuracionAudio());
        cmdLinea.append("','");
        cmdLinea.append(newAudio.getIdiomaAudio());
        cmdLinea.append("','");
        cmdLinea.append(newAudio.getTipoAudio());
        cmdLinea.append("')");
        insertCmd.execute(cmdLinea.toString());
    }

    public List<Audio> findAllAudio() throws SQLException {
        ArrayList<Audio> listaAudios = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM TAudio");
        while (result.next()){
            Audio uno = new Audio();
            uno.setId(result.getInt("id"));
            uno.setFechaCompra(result.getDate("fechaCompra").toLocalDate());
            uno.setRestringido(result.getBoolean("restringido"));
            uno.setTema(result.getString("tema"));
            uno.setDuracionAudio(result.getInt("duracionAudio"));
            uno.setIdiomaAudio(result.getString("idiomaAudio"));
            uno.setTipoAudio(TipoAudio.valueOf(result.getString("tipoAudio")));
            listaAudios.add(uno);
        }
        return listaAudios;
    }

    public int autogeneracion() throws SQLException {
        int id = 1;
        PreparedStatement ps = cnx.prepareStatement("SELECT MAX(id) FROM TAudio");
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

    public List<Materiales> findAll() throws SQLException {
        return null;
    }

}
