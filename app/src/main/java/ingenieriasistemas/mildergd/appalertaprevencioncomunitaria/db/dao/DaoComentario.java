package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Comentario;

@Dao
public interface DaoComentario {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Comentario comentario);

    @Update
    void update(Comentario comentario);

    @Delete
    void delete(Comentario comentario);

    @Query("SELECT * FROM comentario WHERE id_comentario = :id")
    Comentario getById(String id);

    // Comentarios por publicación, ordenados por fecha
    @Query("SELECT * FROM comentario WHERE id_publicacion = :publicacionId ORDER BY fecha_creacion ASC")
    List<Comentario> obtenerPorPublicacion(String publicacionId);

    // Pendientes de sincronizacion
    @Query("SELECT * FROM comentario WHERE sincronizado = 0")
    List<Comentario> ObtenerNoSincronizacion();

}
