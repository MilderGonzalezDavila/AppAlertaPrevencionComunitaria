package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.MultimediaPublicacion;

@Dao
public interface DaoMultimediaPublicacion {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertar(MultimediaPublicacion multimedia);

    @Update
    void actualizar(MultimediaPublicacion multimedia);

    @Delete
    void eliminar(MultimediaPublicacion multimedia);

    @Query("SELECT * FROM multimedia_publicacion WHERE multimedia_id = :id")
    MultimediaPublicacion obtenerPorId(String id);

    // Fotos por publicación
    @Query("SELECT * FROM multimedia_publicacion WHERE publicacion_id = :publicacionId AND tipo_mime LIKE 'image/%'")
    List<MultimediaPublicacion> ObtenerFotosPublicacion(String publicacionId);

    // Pendientes de sincronizacion, para subir a Storage
    @Query("SELECT * FROM multimedia_publicacion WHERE sincronizado = 0")  // Asume agregar si no lo tiene
    List<MultimediaPublicacion> obtenerNoSincronizados();

}
