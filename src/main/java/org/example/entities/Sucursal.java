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

public class Sucursal {
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private Domicilio domicilio;
    @Builder.Default
    private Set<Categoria> categorias= new HashSet<>();
    @Builder.Default
    private Set<Promocion>promocions=new HashSet<>();


    public void addCtegoia(Categoria categoria){
        this.categorias.add(categoria);
    }

    public void addPromocion(Promocion promocion){
        this.promocions.add(promocion);
    }
}
