package org.example.entities;
import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UnidadMedida extends Base  {
    private String denominacion;
}
