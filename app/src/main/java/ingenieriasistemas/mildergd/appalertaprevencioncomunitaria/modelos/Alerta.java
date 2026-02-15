package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "alerta",
        foreignKeys = {
                @ForeignKey(entity = Comunidad.class, parentColumns = "comunidad_id", childColumns = "comunidad_id", onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Usuario.class, parentColumns = "usuario_id", childColumns = "usuario_id", onDelete = ForeignKey.CASCADE)
        })
public class Alerta {

    //Id de la alerta, por ejemplo: alerta_mgonz_2026_001
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "alerta_id")
    public String alertaId;

    @NonNull
    @ColumnInfo(name = "comunidad_id")
    public String comunidadId;

    @NonNull
    @ColumnInfo(name = "usuario_id")
    public String usuarioId;

    //Estado de la alerta: "activa", "resuelta", "cancelada"
    @ColumnInfo(name = "estado", defaultValue = "activa")
    public String estado;

    @ColumnInfo(name = "latitud")
    public double latitud;

    @ColumnInfo(name = "longitud")
    public double longitud;

    @ColumnInfo(name = "ubicacion_texto")
    public String ubicacionTexto;

    @ColumnInfo(name = "fecha_creacion")
    public long fechaCreacion;

    @ColumnInfo(name = "fecha_actualizacion")
    public long fechaActualizacion;

    @ColumnInfo(name = "sincronizado", defaultValue = "0")
    public int sincronizado;

    @ColumnInfo(name = "fecha_resolucion")
    public long fechaResolucion;

    public Alerta() {}

}