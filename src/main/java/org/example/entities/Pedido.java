package org.example.entities;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pedido extends Base  {
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalcosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate FechaPedido;
    private Factura factura;
    private Sucursal sucursal;
    private Domicilio domicilio;
    @Builder.Default
    private Set<DetallePedido>detallePedidos=new HashSet<>();

    public void addDetallePedido(DetallePedido detallePedido){
        this.detallePedidos.add(detallePedido);
    }
}
