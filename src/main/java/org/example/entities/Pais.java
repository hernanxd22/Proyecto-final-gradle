package org.example.entities;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pais extends Base {
    private String nombre;
}
