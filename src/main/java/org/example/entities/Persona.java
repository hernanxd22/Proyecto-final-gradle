package org.example.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Persona extends Base {
    private String nombre;
    private Domicilio domicilio;
}
