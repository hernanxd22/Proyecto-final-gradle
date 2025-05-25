package org.example.entities;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Factura extends Base  {
    private LocalDate fechaFacturacion;
    private Integer mpPaymentID;
    private Integer mpMerchantOrderID;
    private String mpPreferenceID;
    private String mpPaymentType;
    private FormaPago formaPago;
    private Double totalVenta;
}
