package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Alerta;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.ColaSincronizacion;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Comentario;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Comunidad;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Contacto;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.ContadorId;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Dispositivo;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.HistorialUbicacion;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Membresia;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.MultimediaPublicacion;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Publicacion;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Usuario;


import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db.dao.DaoAlerta;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db.dao.DaoComunidad;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db.dao.DaoPublicacion;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db.dao.DaoSistema;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db.dao.DaoUsuario;

// 3. CONFIGURACIÓN DE LA BASE DE DATOS
@Database(
        entities = {
                Usuario.class,
                Comunidad.class,
                Membresia.class,
                Alerta.class,
                Contacto.class,
                Publicacion.class,
                MultimediaPublicacion.class,
                Comentario.class,
                HistorialUbicacion.class,
                 Dispositivo.class,
                ContadorId.class,
                ColaSincronizacion.class
        },
        version = 1,
        exportSchema = false // Ponlo en true si luego quieres exportar el esquema JSON
)
public abstract class BaseDeDatosApp extends RoomDatabase {

    // 4. DECLARAMOS LOS GETTERS ABSTRACTOS PARA CADA DAO
    public abstract DaoUsuario daoUsuario();
    public abstract DaoComunidad daoComunidad();
    public abstract DaoAlerta daoAlerta();
    public abstract DaoPublicacion daoPublicacion();
    public abstract DaoSistema daoSistema();

    // 5. PATRÓN SINGLETON (Para tener una única instancia de la DB)
    private static volatile BaseDeDatosApp INSTANCE;

    public static BaseDeDatosApp obtenerInstancia(final Context context) {
        if (INSTANCE == null) {
            synchronized (BaseDeDatosApp.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    BaseDeDatosApp.class,
                                    "SeguridadVecinal_Room.db" // Nombre del archivo de la base de datos
                            )
                            // IMPORTANTE PARA DESARROLLO:
                            // Si cambias algo en los modelos (añades una columna),
                            // esta línea borra la base de datos antigua y crea una nueva
                            // para evitar que la app se cierre por errores de versión.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}