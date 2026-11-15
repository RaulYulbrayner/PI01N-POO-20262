package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.model.*;

import javax.swing.JOptionPane;

/** Menú interactivo del restaurante El Buen Comer. */
public class Main {
    /**
     * Ejecuta las cinco funcionalidades del restaurante.
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {

        Restaurante restaurante = new Restaurante("El Buen Comer", "900123456", "Armenia, Quindío");
        ServicioDomicilio rapidoExpress = new RapidoExpress();
        ServicioDomicilio entregaSegura = new EntregaSegura();

        int opcion = 0;

        while (opcion != 6) {
            String entrada = JOptionPane.showInputDialog(null, """
                    ============ EL BUEN COMER ============
                    1. Registrar producto del menú
                    2. Registrar cliente
                    3. Registrar y confirmar pedido
                    4. Consultar y actualizar pedido
                    5. Consultar ventas del restaurante
                    6. Salir

                    Seleccione una opción:
                    """);

            if (entrada == null) {
                opcion = 6;
                continue;
            }

            try {
                opcion = Integer.parseInt(entrada.trim());

                if (opcion == 1) {
                    int categoria = Integer.parseInt(JOptionPane.showInputDialog(null, """
                            1. Plato fuerte
                            2. Bebida
                            3. Postre

                            Seleccione la categoría:
                            """));

                    if (categoria < 1 || categoria > 3) {
                        JOptionPane.showMessageDialog(null, "Categoría inválida.");
                        continue;
                    }
                    String codigo = JOptionPane.showInputDialog(null, "Código:");
                    String nombre = JOptionPane.showInputDialog(null, "Nombre:");
                    String descripcion = JOptionPane.showInputDialog(null, "Descripción:");

                    if (codigo == null || nombre == null || descripcion == null) {
                        continue;
                    }

                    String entradaPrecio = JOptionPane.showInputDialog(null, "Precio base:");
                    if (entradaPrecio == null) {
                        continue;
                    }

                    double precio = Double.parseDouble(entradaPrecio);
                    int tiempo = Integer.parseInt(JOptionPane.showInputDialog(
                            null, "Tiempo de preparación en minutos:"));

                    Producto producto;

                    if (categoria == 1) {
                        int peso = Integer.parseInt(JOptionPane.showInputDialog(
                                null, "Peso en gramos:"));

                        TipoPreparacion preparacion = (TipoPreparacion) JOptionPane.showInputDialog(
                                null, "Tipo de preparación:", "Plato fuerte",
                                JOptionPane.QUESTION_MESSAGE, null,
                                TipoPreparacion.values(), TipoPreparacion.ASADO);

                        if (preparacion == null) {
                            continue;
                        }

                        int respuesta = JOptionPane.showConfirmDialog(
                                null, "¿Superó el control de cocción?",
                                "Plato fuerte", JOptionPane.YES_NO_CANCEL_OPTION);

                        if (respuesta != JOptionPane.YES_OPTION && respuesta != JOptionPane.NO_OPTION) {
                            continue;
                        }

                        boolean coccionAprobada = respuesta == JOptionPane.YES_OPTION;
                        producto = new PlatoFuerte(codigo, nombre, descripcion, precio,
                                tiempo, peso, preparacion, coccionAprobada);

                    } else if (categoria == 2) {
                        int volumen = Integer.parseInt(JOptionPane.showInputDialog(
                                null, "Volumen en mililitros:"));

                        String entradaTemperatura = JOptionPane.showInputDialog(
                                null, "Temperatura de servicio en °C:");
                        if (entradaTemperatura == null) {
                            continue;
                        }

                        double temperatura = Double.parseDouble(entradaTemperatura);

                        TipoBebida tipo = (TipoBebida) JOptionPane.showInputDialog(
                                null, "Tipo de bebida:", "Bebida",
                                JOptionPane.QUESTION_MESSAGE, null,
                                TipoBebida.values(), TipoBebida.FRIA);

                        if (tipo == null) {
                            continue;
                        }

                        int respuesta = JOptionPane.showConfirmDialog(
                                null, "¿Requiere preparación especial?",
                                "Bebida", JOptionPane.YES_NO_CANCEL_OPTION);

                        if (respuesta != JOptionPane.YES_OPTION && respuesta != JOptionPane.NO_OPTION) {
                            continue;
                        }

                        boolean especial = respuesta == JOptionPane.YES_OPTION;
                        producto = new Bebida(codigo, nombre, descripcion, precio,
                                tiempo, volumen, temperatura, tipo, especial);

                    } else {
                        int peso = Integer.parseInt(JOptionPane.showInputDialog(
                                null, "Peso en gramos:"));

                        String entradaTemperatura = JOptionPane.showInputDialog(
                                null, "Temperatura de almacenamiento en °C:");
                        if (entradaTemperatura == null) {
                            continue;
                        }

                        double temperatura = Double.parseDouble(entradaTemperatura);
                        int respuesta = JOptionPane.showConfirmDialog(
                                null, "¿Requiere refrigeración?",
                                "Postre", JOptionPane.YES_NO_CANCEL_OPTION);

                        if (respuesta != JOptionPane.YES_OPTION && respuesta != JOptionPane.NO_OPTION) {
                            continue;
                        }

                        boolean refrigeracion = respuesta == JOptionPane.YES_OPTION;
                        producto = new Postre(codigo, nombre, descripcion, precio,
                                tiempo, peso, temperatura, refrigeracion);
                    }

                    if (restaurante.registrarProducto(producto)) {
                        JOptionPane.showMessageDialog(null,
                                "Producto registrado. Precio de venta: $"
                                        + producto.calcularPrecioVenta());
                    } else {
                        JOptionPane.showMessageDialog(null, "Código vacío o repetido.");
                    }

                } else if (opcion == 2) {
                    String documento = JOptionPane.showInputDialog(null, "Documento:");
                    String nombre = JOptionPane.showInputDialog(null, "Nombre completo:");
                    String telefono = JOptionPane.showInputDialog(null, "Teléfono:");
                    String correo = JOptionPane.showInputDialog(null, "Correo electrónico:");
                    String direccion = JOptionPane.showInputDialog(null, "Dirección de residencia:");

                    if (documento != null && nombre != null && telefono != null
                            && correo != null && direccion != null) {
                        Cliente cliente = new Cliente(
                                documento, nombre, telefono, correo, direccion);

                        if (restaurante.registrarCliente(cliente)) {
                            JOptionPane.showMessageDialog(null, "Cliente registrado.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Documento vacío o repetido.");
                        }
                    }

                } else if (opcion == 3) {
                    String menu = "";
                    for (Producto producto : restaurante.consultarProductosDisponibles()) {
                        menu += producto.getCodigo() + " - " + producto.getNombre() + "\n";
                    }

                    if (menu.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay productos disponibles.");
                        continue;
                    }

                    String codigo = JOptionPane.showInputDialog(null, "Código del pedido:");
                    String documento = JOptionPane.showInputDialog(null, "Documento del cliente:");

                    ModalidadEntrega modalidad = (ModalidadEntrega) JOptionPane.showInputDialog(
                            null, "Modalidad de entrega:", "Pedido",
                            JOptionPane.QUESTION_MESSAGE, null, ModalidadEntrega.values(),
                            ModalidadEntrega.CONSUMO_EN_RESTAURANTE);

                    if (codigo == null || documento == null || modalidad == null) {
                        continue;
                    }

                    Pedido pedido = restaurante.registrarPedido(codigo, documento, modalidad);

                    if (pedido == null) {
                        JOptionPane.showMessageDialog(null,
                                "Verifique el código del pedido y el documento del cliente.");
                        continue;
                    }

                    int otro;
                    do {
                        String codigoProducto = JOptionPane.showInputDialog(
                                null, "Productos disponibles:\n" + menu + "\nCódigo del producto:");

                        if (codigoProducto == null) {
                            break;
                        }

                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(
                                null, "Cantidad de unidades:"));

                        if (!restaurante.agregarProductoAPedido(codigo, codigoProducto, cantidad)) {
                            JOptionPane.showMessageDialog(null,
                                    "Producto no disponible o cantidad inválida.");
                        }

                        otro = JOptionPane.showConfirmDialog(null,
                                "¿Desea agregar otro producto?",
                                "Pedido", JOptionPane.YES_NO_OPTION);
                    } while (otro == JOptionPane.YES_OPTION);

                    if (modalidad == ModalidadEntrega.DOMICILIO && !pedido.getDetalles().isEmpty()) {
                        boolean aceptado = false;

                        while (!aceptado) {
                            int seleccion = JOptionPane.showConfirmDialog(null,
                                    "¿Solicitar a RápidoExpress?\nSí: RápidoExpress\nNo: EntregaSegura",
                                    "Domicilio", JOptionPane.YES_NO_CANCEL_OPTION);

                            if (seleccion != JOptionPane.YES_OPTION && seleccion != JOptionPane.NO_OPTION) {
                                break;
                            }

                            ServicioDomicilio empresa = rapidoExpress;
                            if (seleccion == JOptionPane.NO_OPTION) {
                                empresa = entregaSegura;
                            }

                            String entradaDistancia = JOptionPane.showInputDialog(
                                    null, "Distancia en kilómetros:");
                            if (entradaDistancia == null) {
                                break;
                            }

                            double distancia = Double.parseDouble(entradaDistancia);
                            aceptado = restaurante.solicitarDomicilio(codigo, empresa, distancia);

                            if (!aceptado) {
                                JOptionPane.showMessageDialog(null, "La empresa no acepta el recorrido.");
                            }
                        }
                    }

                    if (restaurante.confirmarPedido(codigo)) {
                        JOptionPane.showMessageDialog(null,
                                "Pedido confirmado.\nTotal: $" + pedido.calcularTotal());
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "El pedido quedó pendiente. Puede consultarlo o cancelarlo en la opción 4.");
                    }

                } else if (opcion == 4) {
                    String codigo = JOptionPane.showInputDialog(null, "Código del pedido:");
                    if (codigo == null) {
                        continue;
                    }

                    Pedido pedido = restaurante.buscarPedido(codigo);

                    if (pedido == null) {
                        JOptionPane.showMessageDialog(null, "El pedido no existe.");
                    } else {
                        String resumen = "Pedido: " + pedido.getCodigo()
                                + "\nCliente: " + pedido.getCliente().getNombreCompleto()
                                + "\nEstado: " + pedido.getEstado()
                                + "\nTotal: $" + pedido.calcularTotal();

                        String accion = JOptionPane.showInputDialog(null, resumen + """

                                
                                1. Marcar como entregado
                                2. Cancelar pedido
                                3. Volver
                                """);

                        if ("1".equals(accion)) {
                            if (restaurante.marcarPedidoComoEntregado(codigo)) {
                                JOptionPane.showMessageDialog(null, "Pedido entregado.");
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Solo se pueden entregar pedidos confirmados.");
                            }
                        } else if ("2".equals(accion)) {
                            if (restaurante.cancelarPedido(codigo)) {
                                JOptionPane.showMessageDialog(null, "Pedido cancelado.");
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "El pedido no se puede cancelar en su estado actual.");
                            }
                        }
                    }

                } else if (opcion == 5) {
                    Producto producto = restaurante.obtenerProductoMasVendido();
                    CategoriaProducto categoria = restaurante.obtenerCategoriaConMayoresIngresos();

                    String nombreProducto = "Sin ventas";
                    if (producto != null) {
                        nombreProducto = producto.getNombre();
                    }

                    String nombreCategoria = "Sin ventas";
                    if (categoria != null) {
                        nombreCategoria = categoria.toString();
                    }

                    JOptionPane.showMessageDialog(null,
                            "Ingresos propios: $" + restaurante.calcularIngresosPropios()
                                    + "\nValores de domicilio: $" + restaurante.calcularTotalDomicilios()
                                    + "\nProducto más vendido: " + nombreProducto
                                    + "\nCategoría con mayores ingresos: " + nombreCategoria);

                } else if (opcion == 6) {
                    JOptionPane.showMessageDialog(null, "Saliendo de El Buen Comer.");
                } else {
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }
    }
}