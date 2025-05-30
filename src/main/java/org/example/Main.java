package org.example;

import org.example.entities.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        Pais argentina = Pais.builder()
                .nombre("Argentina")
                .build();
        Pais brasil = Pais.builder()
                .nombre("Brasil")
                .build();
        System.out.println("País 1: " + argentina);
        System.out.println("País 2: " + brasil);
        System.out.println("---");

        Provincia mendoza = Provincia.builder()
                .nombre("Mendoza")
                .pais(argentina)
                .build();
        Provincia buenosAires = Provincia.builder()
                .nombre("Buenos Aires")
                .pais(argentina)
                .build();
        System.out.println("Provincia 1: " + mendoza);
        System.out.println("Provincia 2: " + buenosAires);
        System.out.println("---");

        Localidad lasHeras = Localidad.builder()
                .nombre("Las Heras")
                .provicia(mendoza)
                .build();
        Localidad capital = Localidad.builder()
                .nombre("Capital")
                .provicia(mendoza)
                .build();
        System.out.println("Localidad 1: " + lasHeras);
        System.out.println("Localidad 2: " + capital);
        System.out.println("---");

        Domicilio domicilio1 = Domicilio.builder()
                .calle("San Martín")
                .numero(123)
                .cp(5500)
                .localidad(lasHeras)
                .build();
        Domicilio domicilio2 = Domicilio.builder()
                .calle("Rivadavia")
                .numero(456)
                .cp(5501)
                .localidad(capital)
                .build();
        System.out.println("Domicilio 1: " + domicilio1);
        System.out.println("Domicilio 2: " + domicilio2);
        System.out.println("---");

        Empresa empresa1 = Empresa.builder()
                .cuil(30987)
                .nombre("Los Andes S.A.")
                .razonSocial("Restaurante Los Andes")
                .build();

        Empresa empresa2 = Empresa.builder()
                .cuil(30112)
                .nombre("Sabores del Sur SRL")
                .razonSocial("Sabores del Sur")
                .build();
        System.out.println("Empresa 1: " + empresa1);
        System.out.println("Empresa 2: " + empresa2);
        System.out.println("---");
        Sucursal sucursal1 = Sucursal.builder()
                .nombre("Sucursal Centro")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(23, 0))
                .domicilio(domicilio1)
                .build();

        Sucursal sucursal2 = Sucursal.builder()
                .nombre("Sucursal Norte")
                .horarioApertura(LocalTime.of(8, 30))
                .horarioCierre(LocalTime.of(22, 30))
                .domicilio(domicilio2)
                .build();

        empresa1.addSucursal(sucursal1);
        empresa2.addSucursal(sucursal2);

        System.out.println("Sucursal 1: " + sucursal1);
        System.out.println("Sucursal 2: " + sucursal2);
        System.out.println("---");

        UnidadMedida unidad1 = UnidadMedida.builder()
                .denominacion("Porción")
                .build();

        UnidadMedida unidad2 = UnidadMedida.builder()
                .denominacion("Litro")
                .build();

        System.out.println("Unidad de Medida 1: " + unidad1);
        System.out.println("Unidad de Medida 2: " + unidad2);
        System.out.println("---");

        Imagen imagen1 = Imagen.builder()
                .denominacion("pizza_muzzarella.jpg")
                .build();

        Imagen imagen2 = Imagen.builder()
                .denominacion("empanada_carne.jpg")
                .build();

        System.out.println("Imagen 1: " + imagen1);
        System.out.println("Imagen 2: " + imagen2);
        System.out.println("---");

        ArticuloInsumo harina = ArticuloInsumo.builder()
                .denominacion("Harina 000")
                .precioCompra(50.0)
                .unidadMedida(unidad1)
                .precioVenta(30.0)
                .stockMaximo(200)
                .esParaElaborar(true)
                .build();

        ArticuloInsumo quesoMuzzarella = ArticuloInsumo.builder()
                .denominacion("Queso Muzzarella")
                .precioCompra(500.0)
                .unidadMedida(unidad1)
                .precioVenta(350.0)
                .stockMaximo(100)
                .esParaElaborar(true)
                .build();

        System.out.println("Artículo Insumo 1: " + harina);
        System.out.println("Artículo Insumo 2: " + quesoMuzzarella);
        System.out.println("---");

        ArticuloManufacturado pizzaMuzzarella = ArticuloManufacturado.builder()
                .denominacion("Pizza Muzzarella")
                .precioVenta(800.0)
                .unidadMedida(unidad1)
                .descripcion("Clásica pizza de muzzarella")
                .tiempoEstimadoMinutos(30)
                .preparacion("Hornear")
                .build();

        ArticuloManufacturado empanadaCarne = ArticuloManufacturado.builder()
                .denominacion("Empanada de Carne")
                .precioVenta(150.0)
                .unidadMedida(unidad1)
                .descripcion("Empanada criolla de carne")
                .tiempoEstimadoMinutos(20)
                .preparacion("Hornear")
                .build();

        pizzaMuzzarella.addImagen(imagen1);
        empanadaCarne.addImagen(imagen2);

        sucursal1.addCtegoia(new Categoria("Pizzas"));
        sucursal1.addCtegoia(new Categoria("Empanadas"));

        System.out.println("Artículo Manufacturado 1: " + pizzaMuzzarella);
        System.out.println("Artículo Manufacturado 2: " + empanadaCarne);
        System.out.println("---");

        ArticuloManufacturadoDetalle detallePizza1 = ArticuloManufacturadoDetalle.builder()
                .cantidad(200)
                .articuloInsumo(harina)
                .build();

        ArticuloManufacturadoDetalle detallePizza2 = ArticuloManufacturadoDetalle.builder()
                .cantidad(300)
                .articuloInsumo(quesoMuzzarella)
                .build();

        pizzaMuzzarella.addArticuloDetalle(detallePizza1);
        pizzaMuzzarella.addArticuloDetalle(detallePizza2);

        System.out.println("Detalle Artículo Manufacturado 1: " + detallePizza1);
        System.out.println("Detalle Artículo Manufacturado 2: " + detallePizza2);
        System.out.println("---");

        Categoria pizzas = new Categoria("Pizzas");
        Categoria empanadas = new Categoria("Empanadas");
        pizzas.addArticulo(pizzaMuzzarella);
        empanadas.addArticulo(empanadaCarne);
        sucursal1.addCtegoia(pizzas);
        sucursal1.addCtegoia(empanadas);
        System.out.println("Categoría 1: " + pizzas);
        System.out.println("Categoría 2: " + empanadas);
        System.out.println("---");

        Promocion happyHour = Promocion.builder()
                .denomincacion("Happy Hour Pizza")
                .FechaDesde(LocalDate.now())
                .FechaHasta( LocalDate.now().plusDays(7))
                .HoraDesde(LocalTime.of(18, 0))
                .HoraHasta(LocalTime.of(20, 0))
                .descripcionDescuento("2x1 en Pizzas")
                .precioPromocional(800.0)
                .tipoPromocion(TipoPromocion.HAPPYHOUR)
                .build();

        Promocion martesLoco = Promocion.builder()
                .denomincacion("Martes de Empanadas")
                .FechaDesde(LocalDate.now().plusDays(2))
                .FechaHasta(LocalDate.now().plusDays(2))
                .HoraDesde(LocalTime.of(0, 0))
                .HoraHasta(LocalTime.of(23, 59))
                .descripcionDescuento("30% off en Empanadas")
                .precioPromocional(105.0)
                .tipoPromocion(TipoPromocion.PROMOCION1)
                .build();

        happyHour.addArticulo(pizzaMuzzarella);
        martesLoco.addArticulo(empanadaCarne);

        sucursal1.addPromocion(happyHour);
        sucursal2.addPromocion(martesLoco);

        System.out.println("Promoción 1: " + happyHour);
        System.out.println("Promoción 2: " + martesLoco);
        System.out.println("---");

        Usuario usuario1 = Usuario.builder()
                .auth0id("auth0|123")
                .username("juan123")
                .build();

        Usuario usuario2 = Usuario.builder()
                .auth0id("auth0|456")
                .username("maria456")
                .build();

        System.out.println("Usuario 1: " + usuario1);
        System.out.println("Usuario 2: " + usuario2);
        System.out.println("---");

        Cliente cliente1 = Cliente.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .telefono("2611234567")
                .email("juan.perez@email.com")
                .fechaNacimineto(LocalDate.of(1990, 5, 15))
                .build();

        Cliente cliente2 = Cliente.builder()
                .nombre("María")
                .apellido("González")
                .telefono("2617654321")
                .email("maria.gonzalez@email.com")
                .fechaNacimineto(LocalDate.of(1985, 10, 20))
                .build();

        cliente1.setUsuario(usuario1);
        cliente2.setUsuario(usuario2);

        System.out.println("Cliente 1: " + cliente1);
        System.out.println("Cliente 2: " + cliente2);
        System.out.println("---");

        Pedido pedido1 = Pedido.builder()
                .horaEstimadaFinalizacion(LocalTime.of(20, 0))
                .total(800.0)
                .totalcosto(450.0)
                .estado(Estado.PENDIENTE)
                .tipoEnvio(TipoEnvio.DELIVERY)
                .formaPago(FormaPago.EFECTIVO)
                .FechaPedido(LocalDate.now())
                .build();

        Pedido pedido2 = Pedido.builder()
                .horaEstimadaFinalizacion(LocalTime.of(21, 30))
                .total(300.0)
                .totalcosto(180.0)
                .estado(Estado.PREPARACION)
                .tipoEnvio(TipoEnvio.TAKEAWAY)
                .formaPago(FormaPago.MERCADOPAGO)
                .FechaPedido(LocalDate.now())
                .build();

        cliente1.addPedido(pedido1);
        cliente2.addPedido(pedido2);

        pedido1.setSucursal(sucursal1);
        pedido2.setSucursal(sucursal2);


        pedido1.setDomicilio(cliente1.getDomicilios().stream().findFirst().orElse(null));
        pedido2.setDomicilio(cliente2.getDomicilios().stream().findFirst().orElse(null));

        System.out.println("Pedido 1: " + pedido1);
        System.out.println("Pedido 2: " + pedido2);
        System.out.println("---");

        DetallePedido detalle1 = DetallePedido.builder()
                .cantidad(1)
                .subtotal(800.0)
                .articulo(pizzaMuzzarella)
                .build();

        DetallePedido detalle2 = DetallePedido.builder()
                .cantidad(2)
                .subtotal(300.0)
                .articulo(empanadaCarne)
                .build();

        pedido1.addDetallePedido(detalle1);
        pedido2.addDetallePedido(detalle2);

        System.out.println("Detalle Pedido 1: " + detalle1);
        System.out.println("Detalle Pedido 2: " + detalle2);
        System.out.println("---");

        Factura factura1 = Factura.builder()
                .fechaFacturacion(LocalDate.now())
                .totalVenta(800.0)
                .formaPago(FormaPago.EFECTIVO)
                .mpMerchantOrderID(12345)
                .build();

        Factura factura2 = Factura.builder()
                .fechaFacturacion(LocalDate.now())
                .totalVenta(300.0)
                .formaPago(FormaPago.MERCADOPAGO)
                .mpMerchantOrderID(67890)
                .mpPaymentID(54321)
                .mpPreferenceID("pref123")
                .mpPaymentType("credit_card")
                .build();

        pedido1.setFactura(factura1);
        pedido2.setFactura(factura2);

        System.out.println("Factura 1: " + factura1);
        System.out.println("Factura 2: " + factura2);
        System.out.println("---");
    }
}
