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
public class Promocion extends Base  {
    private String denomincacion;
    private LocalDate FechaDesde;
    private LocalDate FechaHasta;
    private LocalTime HoraDesde;
    private LocalTime HoraHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;
    @Builder.Default
    private Set<Imagen> imagens=new HashSet<>();
    @Builder.Default
    private Set<Articulo>articulos=new HashSet<>();


    public void addArticulo(Articulo articulo){
        this.articulos.add(articulo);
    }
    public void addImagen(Imagen imagen){
        this.imagens.add(imagen);
    }
}
