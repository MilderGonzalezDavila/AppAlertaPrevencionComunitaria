package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos;

//Herramientas de Room y Android
import androidx.room.ColumnInfo;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cola_sincronizacion")
public class ColaSincronizacion {

   //Identificador único de la tarea pendiente
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cola_id")
    public int ColaId;

    //Etiqueta, indentificada el tipo de entidad a manjear, por ejemplo: "alerta", "publicación"
    @NonNull
    @ColumnInfo(name = "tipo_entidad")
    public String tipoEntidad;

    //El ID del objeto real que queremos sincronizar
    @NonNull
    @ColumnInfo(name = "entidad_id")
    public String entidadId;

    //Dice la acción que debe de hacer Firebase: "crear", "actualiza", "eliminar"
    @NonNull
    @ColumnInfo(name = "operacion")
    public String operacion;

    //Convertimos el objeto a formato JSON (Guardamos los datos de la entidad correspondiente)
    @ColumnInfo(name = "datos_json")
    public String datosJson;

    //Guarda el momento exacto (en milisegundos) en el que se intentó hacer la acción
    @ColumnInfo(name = "fecha_creacion")
    public long FechaCreacion;

    //Contador simple: Número de intentos que se quiere realizar la operación en caso de errores de conexión
    @ColumnInfo(name = "intentos", defaultValue = "0")
    public int intentos;

    public ColaSincronizacion() {}

}