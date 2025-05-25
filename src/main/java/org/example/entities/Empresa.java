package org.example.entities;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Empresa extends Base {
    private String nombre;
    private int cuil;
    private String razonSocial;
    @Builder.Default
    private Set<Sucursal> sucursals=new HashSet<>();

    public void addSucursal(Sucursal sucursal){
        this.sucursals.add(sucursal);

    }
}
