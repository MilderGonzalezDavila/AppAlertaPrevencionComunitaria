package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "comentario",
        foreignKeys = {
                @ForeignKey(entity = Publicacion.class, parentColumns = "id_publicacion", childColumns = "id_publicacion", onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Usuario.class, parentColumns = "id_usuario", childColumns = "id_usuario", onDelete = ForeignKey.CASCADE)
        })
public class Comentario {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_comentario")
    public String idComentario;

    @NonNull
    @ColumnInfo(name = "id_publicacion")
    public String idPublicacion;

    @NonNull
    @ColumnInfo(name = "id_usuario")
    public String idUsuario;

    @ColumnInfo(name = "contenido")
    public String contenido;

    @ColumnInfo(name = "fecha_creacion")
    public long fechaCreacion;

    @ColumnInfo(name =  "sincronizado", defaultValue = "0")
    public int sincronizado;

    public Comentario() {}
}