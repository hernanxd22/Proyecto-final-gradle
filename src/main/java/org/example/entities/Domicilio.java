package org.example.entities;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Domicilio {
    private String calle;
    private Integer numero;
    private Integer cp;
    private Localidad localidad;
}
