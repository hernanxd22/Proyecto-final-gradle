package org.example.entities;

import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Categoria extends Base  {
    @ToString.Exclude
    private Categoria categoriaPadre;
    @Builder.Default
    private Set<Categoria> subCategorias=new HashSet<>();
    private String denominacion;

    @Builder.Default
    private Set<Articulo > articulos=new HashSet<>();

    public Categoria(String denominacion) {
        this.denominacion = denominacion;
    }

    public void addSubcategoria(Categoria scategoria){
        this.subCategorias.add(scategoria);
        scategoria.setCategoriaPadre(this);
    }
    public void addArticulo(Articulo articulo) {
        if (articulos == null) {
            articulos = new HashSet<>();
        }
        articulos.add(articulo);
    }
}
