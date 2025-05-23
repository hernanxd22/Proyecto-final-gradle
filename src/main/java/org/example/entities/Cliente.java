package org.example.entities;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimineto;
    @Builder.Default
    private Set<Pedido> pedidos=new HashSet<>();
    @Builder.Default
    private Set<Domicilio> domicilios=new HashSet<>();
    private Imagen imagen;
    private Usuario usuario;


    public void addPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public void addDomicilio(Domicilio domicilio){
        this.domicilios.add(domicilio);
    }
}
