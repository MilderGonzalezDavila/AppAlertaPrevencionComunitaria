package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.*;

@Dao
public interface DaoUsuario {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertar(Usuario usuario);

    @Update
    void actualizar(Usuario usuario);

    @Query("SELECT * FROM usuario WHERE usuario_id = :id")
    Usuario obtenerPorId(String id);

    @Query("SELECT * FROM usuario WHERE correo= :correo")
    Usuario obtenerPorCorreo(String correo);

    @Query("SELECT * FROM usuario WHERE activo = 1 ORDER BY nombres ASC")
    List<Usuario> obtenerTodosActivos();

    @Query("SELECT * FROM usuario WHERE usuario_id = :id")
    Usuario obtenerAutorPorId(String id);

    @Query("UPDATE usuario SET fecha_actualizacion = :marcaTiempo  ,sincronizado = 1 WHERE usuario_id = :id")
    void marcarSincronizacion(String id, long marcaTiempo);

}