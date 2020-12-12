package madrigal.adriana.tarea03.persistencia;

import madrigal.adriana.tarea03.bl.entidades.Audio;
import madrigal.adriana.tarea03.bl.entidades.Materiales;
import madrigal.adriana.tarea03.bl.entidades.Video;
import madrigal.adriana.tarea03.bl.tipos.TipoAudio;
import madrigal.adriana.tarea03.bl.tipos.TipoVideo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO extends MaterialDAO{
    Connection cnx;
    public VideoDAO(Connection cnx){ this.cnx = cnx;}

    public void saveVideo(Video nuevoVideo) throws SQLException {
        Statement insertCmd = cnx.createStatement();
        int id = autogeneracion();
        StringBuilder cmdLinea = new StringBuilder("Insert into TVideo (id,fechaCompra,restringido,tema,duracion,idioma,director,tipo) values ('");
        cmdLinea.append(id);
        cmdLinea.append("','");
        cmdLinea.append(nuevoVideo.getFechaCompra());
        cmdLinea.append("',");
        cmdLinea.append(nuevoVideo.isRestringido());
        cmdLinea.append(",'");
        cmdLinea.append(nuevoVideo.getTema());
        cmdLinea.append("','");
        cmdLinea.append(nuevoVideo.getDuracionVideo());
        cmdLinea.append("','");
        cmdLinea.append(nuevoVideo.getIdiomaVideo());
        cmdLinea.append("','");
        cmdLinea.append(nuevoVideo.getDirectorVideo());
        cmdLinea.append("','");
        cmdLinea.append(nuevoVideo.getTipoVideo());
        cmdLinea.append("')");
        insertCmd.execute(cmdLinea.toString());
    }

    public List<Video> findAllVideo() throws SQLException {
        ArrayList<Video> listaVideos = new ArrayList<>();
        Statement stmt = cnx.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM TVideo");
        while (result.next()){
            Video uno = new Video();
            uno.setId(result.getInt("id"));
            uno.setFechaCompra(result.getDate("fechaCompra").toLocalDate());
            uno.setRestringido(result.getBoolean("restringido"));
            uno.setTema(result.getString("tema"));
            uno.setDuracionVideo(result.getInt("duracion"));
            uno.setIdiomaVideo(result.getString("idioma"));
            uno.setDirectorVideo(result.getString("director"));
            uno.setTipoVideo(TipoVideo.valueOf(result.getString("tipo")));
            listaVideos.add(uno);
        }
        return listaVideos;

    }
    public int autogeneracion() throws SQLException {
        int id = 1;
        PreparedStatement ps = cnx.prepareStatement("SELECT MAX(id) FROM TVideo");
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
