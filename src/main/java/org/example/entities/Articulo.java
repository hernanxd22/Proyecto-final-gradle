package org.example.entities;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public abstract class Articulo extends Base  {
    protected String denominacion;
    protected Double precioVenta;
    @Builder.Default
    private Set<Imagen> imagens= new HashSet<>();
    private UnidadMedida unidadMedida;
    public void addImagen(Imagen imagen){
        this.imagens.add(imagen);
    }
}
