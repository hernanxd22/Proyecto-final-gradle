package org.example.entities;

import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Imagen extends Base  {
    private String denominacion;
}
