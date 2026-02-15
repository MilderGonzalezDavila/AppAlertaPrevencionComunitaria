package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Membresia;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Usuario;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.utilidades.Rol;

@Dao
public interface DaoMembresia {

    @Insert
    void insertar(Membresia mebresia);

    @Update
    void actualizar(Membresia membresia);

    @Delete
    void eliminar(Membresia membresia);

    @Query("SELECT * FROM membresia WHERE membresia_id = :id")
    Membresia obtenerPorId(int id);

    @Query("SELECT * FROM membresia WHERE usuario_id = :usuarioId AND comunidad_id = :comunidadId")
    Membresia obtenerPorUsuarioComunidad(String usuarioId, String comunidadId);

    @Query("SELECT * FROM membresia WHERE usuario_id = :usuarioId")
    List<Membresia> obtenerPorUsuario(String usuarioId);

    @Query("SELECT * FROM membresia WHERE usuario_id =:usuarioId AND comunidad_id = :comunidadId AND rol IN ('administrador', 'miembro')")
    int esMiembro(String usuarioId, String comunidadId);

    //Listar miembros de comunidad
    @Query("SELECT * FROM membresia WHERE comunidad_id = :comunidadId AND notificaciones_activas = 1")
    List<Membresia> obtenerMiembrosActivos(String comunidadId);

}
