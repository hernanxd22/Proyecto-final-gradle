package org.example.entities;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedido extends Base  {
    private Integer cantidad;
    private Double subtotal;
    private Articulo articulo;
}
