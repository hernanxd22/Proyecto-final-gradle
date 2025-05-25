package org.example.entities;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Provincia extends Base  {
    private String nombre;
    private Pais pais;
}
