package org.example.entities;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloManufacturadoDetalle {
    private Integer cantidad;
    private ArticuloInsumo articuloInsumo;
}
