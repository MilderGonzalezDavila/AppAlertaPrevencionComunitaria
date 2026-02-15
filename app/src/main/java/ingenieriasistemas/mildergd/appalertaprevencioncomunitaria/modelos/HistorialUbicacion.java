package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "historial_ubicacion",
        foreignKeys = @ForeignKey(entity = Usuario.class,
                parentColumns = "usuario_id",
                childColumns = "usuario_id",
                onDelete = ForeignKey.CASCADE))
public class HistorialUbicacion {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "historial_id")
    public int historialId;

    @NonNull
    @ColumnInfo(name = "usuario_id")
    public String usuarioId;

    @ColumnInfo(name = "comunidad_id")
    public String comunidadId;

    @ColumnInfo(name = "latitud")
    public double latitud;

    @ColumnInfo(name = "longitud")
    public double longitud;

    @ColumnInfo(name = "marca_tiempo")
    public long marcaTiempo;

    @ColumnInfo(name = "proveedor")
    public String proveedor;

    @ColumnInfo(name = "sincronizado", defaultValue = "0")
    public int sincronizado;

    public HistorialUbicacion() {}

}