package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import com.google.gson.Gson;
import java.util.List;

import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.*;

@Dao
public interface DaoSistema {

    //COLA DE SINCRONIZACION
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarCola(ColaSincronizacion cola);

    @Update
    void actualizarCola(ColaSincronizacion cola);

    @Delete
    void eliminarCola(ColaSincronizacion cola);

    @Query("SELECT * FROM cola_sincronizacion WHERE cola_id = :id")
    ColaSincronizacion obtenerColaPorId(int id);

    // Pendientes por tipo
    @Query("SELECT * FROM cola_sincronizacion WHERE tipo_entidad = :tipo AND intentos < 5 ORDER BY fecha_creacion ASC")
    List<ColaSincronizacion> obtenerNoSincronizadasPorTipo(String tipo);

    // Todas pendientes
    @Query("SELECT * FROM cola_sincronizacion WHERE intentos < 5 ORDER BY fecha_creacion ASC")
    List<ColaSincronizacion> obtenerTodasNoSincronizadas();

    // Incrementar intentos (para reintentos)
    @Query("UPDATE cola_sincronizacion SET intentos = intentos + 1 WHERE cola_id = :id")
    void incrementarIntentosCola(int id);

    @Query("DELETE FROM cola_sincronizacion WHERE cola_id = :id")
    void marcarColaCompletado(int id);

    // CONTADOR_ID
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertarContador(ContadorId contador);

    @Update
    void actualizarContador(ContadorId contador);

    @Query("SELECT * FROM contador_id WHERE entidad = :entidad")
    ContadorId obtenerContadorPorEntidad(String entidad);

    // Incrementar secuencia (para generar IDs únicos locales)
    @Query("UPDATE contador_id SET secuencia = secuencia + 1 WHERE entidad = :entidad")
    void incrementarSecuencia(String entidad);

    @Transaction
    default  String ponerEnColaConNuevoId(String tipoEntidad, String operacion, Object entidad, Gson gson){
        //Generamos el ID
        ContadorId contador = obtenerContadorPorEntidad(tipoEntidad);

        if(contador == null){
            contador = new ContadorId();
            contador.entidad = tipoEntidad;
            contador.secuencia = 1;
            insertarContador(contador);
        }
        else{
            incrementarSecuencia(tipoEntidad);
            contador = obtenerContadorPorEntidad(tipoEntidad); //Obtenemos el valor actualizado
        }

        //Generamos un ID único
        String nuevaId = tipoEntidad + "_" + contador.secuencia;

        ColaSincronizacion cola = new ColaSincronizacion();
        cola.tipoEntidad = tipoEntidad;
        cola.entidadId = nuevaId;
        cola.operacion = operacion;

        cola.datosJson = gson.toJson(entidad);

        cola.FechaCreacion = System.currentTimeMillis();
        cola.intentos = 0;

        insertarCola(cola);
        return nuevaId;
    }

}