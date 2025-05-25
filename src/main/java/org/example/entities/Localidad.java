package org.example.entities;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Localidad extends Base  {
    private String nombre;
    private Provincia provicia;
}
