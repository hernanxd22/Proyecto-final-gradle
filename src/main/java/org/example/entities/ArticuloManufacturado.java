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
public class ArticuloManufacturado extends Articulo {
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;
    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles=new HashSet<>();

    public void addArticuloDetalle(ArticuloManufacturadoDetalle articuloManufacturadoDetalle){
        this.articuloManufacturadoDetalles.add(articuloManufacturadoDetalle);
    }

}
