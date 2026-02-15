package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contador_id")
public class ContadorId {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "entidad")
    public String entidad;

    @ColumnInfo(name = "secuencia", defaultValue = "0")
    public int secuencia;

    public ContadorId() {}
}
