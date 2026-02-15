package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "dispositivo",
        foreignKeys = @ForeignKey(entity = Usuario.class,
                parentColumns = "usuario_id",
                childColumns = "usuario_id",
                onDelete = ForeignKey.CASCADE),
                indices = {
                    @Index(value = "token_fcm", unique = true)
                }
)
public class Dispositivo {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "dispositivo_id")
    public String dispositivoId;

    @NonNull
    @ColumnInfo(name = "usuario_id")
    public String usuarioId;

    // Token de mensajería en la nube de Firebase
    @ColumnInfo(name = "token_fcm")
    public String tokenFcm;

    @ColumnInfo(name = "plataforma", defaultValue = "android")
    public String plataforma;

    // última vez que el dispositivo estuvo activo
    @ColumnInfo(name = "ultima_actividad")
    public long ultimaActividad;

    @ColumnInfo(name = "fecha_creacion")
    public long fechaCreacion;

    @ColumnInfo(name = "fecha_actualizacion")
    public long fechaActualizacion;

    @ColumnInfo(name = "sincronizado", defaultValue = "0")
    public int sincronizado; // 0 = pendiente, 1 = sincronizado

    public Dispositivo() {}

}