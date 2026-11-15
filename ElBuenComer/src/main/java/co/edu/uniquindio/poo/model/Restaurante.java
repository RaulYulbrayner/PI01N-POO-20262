package co.edu.uniquindio.poo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurante {

    private String nombreComercial;
    private String nit;
    private String direccion;
    private List<Producto> ListProductos;
    private List<Cliente> ListClientes;
    private List<Pedido> ListPedidos;

    /**
     * Metodo constructor de la clase restaurnate
     * @param nombreComercial nombre del establecimiento
     * @param nit número de identificación tributaria
     * @param direccion dirección del establecimiento
     */
    public Restaurante(String nombreComercial, String nit, String direccion) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        ListProductos = new ArrayList<>();
        ListClientes = new ArrayList<>();
        ListPedidos = new ArrayList<>();
    }

    /**
     * Metodo que registra un producto con código único. Los productos que incumplen la
     * calidad se conservan en el menú para poder identificarlos en la consulta.
     * @param producto producto que se desea registrar
     * @return true si el producto quedó registrado
     */
    public boolean registrarProducto(Producto producto) {
        boolean registrado = false;
        if (producto != null && tieneTexto(producto.getCodigo())
                && buscarProducto(producto.getCodigo()) == null) {
            registrado = ListProductos.add(producto);
        }
        return registrado;
    }

    /**
     * Metodo que registra un cliente con un documento único.
     * @param cliente cliente que se desea registrar
     * @return true si el cliente quedó registrado
     */
    public boolean registrarCliente(Cliente cliente) {
        boolean registrado = false;
        if (cliente != null && tieneTexto(cliente.getNumeroDocumento())
                && buscarCliente(cliente.getNumeroDocumento()) == null) {
            registrado = ListClientes.add(cliente);
        }
        return registrado;
    }

    /**
     * Metodo que registra un pedido pendiente para un cliente existente.
     * @param codigo código único del pedido
     * @param documento documento del cliente
     * @param modalidad modalidad de entrega
     * @return pedido registrado, o null si los datos son inválidos, el cliente no existe o el código ya está registrado
     */
    public Pedido registrarPedido(String codigo, String documento, ModalidadEntrega modalidad) {
        Pedido pedido = null;
        Cliente cliente = buscarCliente(documento);
        if (tieneTexto(codigo) && cliente != null && modalidad != null && buscarPedido(codigo) == null) {
            pedido = new Pedido(codigo.trim(), LocalDateTime.now(), cliente, modalidad);
            ListPedidos.add(pedido);
        }
        return pedido;
    }

    /**
     * Metodo que agrega un producto del menú a un pedido pendiente.
     * @param codigoPedido código del pedido
     * @param codigoProducto código del producto del menú
     * @param cantidad número de unidades solicitadas
     * @return true si se agregó el producto
     */
    public boolean agregarProductoAPedido(String codigoPedido, String codigoProducto, int cantidad) {
        Pedido pedido = buscarPedido(codigoPedido);
        Producto producto = buscarProducto(codigoProducto);
        boolean agregado = false;
        if (pedido != null && producto != null) {
            agregado = pedido.agregarProducto(producto, cantidad);
        }
        return agregado;
    }

    /**
     * Metodo que solicita el domicilio para un pedido mediante la interfaz común.
     * @param codigoPedido código del pedido
     * @param empresa empresa de domicilio seleccionada
     * @param distanciaKm distancia del recorrido en kilómetros
     * @return true si se registró un domicilio aceptado
     */
    public boolean solicitarDomicilio(String codigoPedido, ServicioDomicilio empresa, double distanciaKm) {
        Pedido pedido = buscarPedido(codigoPedido);
        boolean aceptado = false;
        if (pedido != null) {
            aceptado = pedido.solicitarDomicilio(empresa, distanciaKm);
        }
        return aceptado;
    }

    /**
     * Metodo que confirma un pedido pendiente después de validar el cliente, los detalles
     * y la aceptación del domicilio cuando corresponde.
     * @param codigo código del pedido
     * @return true si el pedido quedó confirmado
     */
    public boolean confirmarPedido(String codigo) {
        Pedido pedido = buscarPedido(codigo);
        boolean confirmado = false;
        if (pedido != null && pedido.getEstado() == EstadoPedido.PENDIENTE && buscarCliente(pedido.getCliente().getNumeroDocumento()) == pedido.getCliente() && detallesValidos(pedido) && (pedido.getModalidad() == ModalidadEntrega.CONSUMO_EN_RESTAURANTE || pedido.getDomicilioAceptado() != null)) {
            confirmado = pedido.marcarComoConfirmado();
        }
        return confirmado;
    }

    /**
     * Metodo que comprueba que el pedido tenga detalles y que cada detalle corresponda
     * al producto registrado, tenga cantidad positiva y cumpla la calidad.
     * @param pedido pedido que se desea validar
     * @return true si todos los detalles son válidos
     */
    private boolean detallesValidos(Pedido pedido) {
        List<DetallePedido> detalles = pedido.getDetalles();
        boolean validos = !detalles.isEmpty();
        for (int i = 0; i < detalles.size() && validos; i++) {
            DetallePedido detalle = detalles.get(i);
            Producto producto = detalle.getProducto();
            validos = detalle.getCantidad() > 0 && buscarProducto(producto.getCodigo()) == producto && producto.cumpleCondicionesCalidad();
        }
        return validos;
    }

    /**
     * Metodo que marca un pedido confirmado como entregado.
     * @param codigo código del pedido
     * @return true si se actualizó el estado
     */
    public boolean marcarPedidoComoEntregado(String codigo) {
        Pedido pedido = buscarPedido(codigo);
        boolean entregado = pedido != null && pedido.marcarComoEntregado();
        return entregado;
    }

    /**
     * Metodo que cancela un pedido pendiente o confirmado.
     * @param codigo código del pedido
     * @return true si se canceló el pedido
     */
    public boolean cancelarPedido(String codigo) {
        Pedido pedido = buscarPedido(codigo);
        boolean cancelado = pedido != null && pedido.cancelar();
        return cancelado;
    }

    /**
     * Metodo que busca un producto por su código.
     * @param codigo código del producto
     * @return producto encontrado, o null si no existe
     */
    public Producto buscarProducto(String codigo) {
        Producto encontrado = null;
        if (tieneTexto(codigo)) {
            for (int i = 0; i < ListProductos.size() && encontrado == null; i++) {
                Producto producto = ListProductos.get(i);
                if (producto.getCodigo().trim().equalsIgnoreCase(codigo.trim())) {
                    encontrado = producto;
                }
            }
        }
        return encontrado;
    }

    /**
     * Metodo que busca un cliente por su documento.
     * @param documento número de documento del cliente
     * @return cliente encontrado, o null si no existe
     */
    public Cliente buscarCliente(String documento) {
        Cliente encontrado = null;
        if (tieneTexto(documento)) {
            for (int i = 0; i < ListClientes.size() && encontrado == null; i++) {
                Cliente cliente = ListClientes.get(i);
                if (cliente.getNumeroDocumento().trim().equals(documento.trim())) {
                    encontrado = cliente;
                }
            }
        }
        return encontrado;
    }

    /**
     * Metodo que busca un pedido por su código, independientemente de su estado.
     * @param codigo código del pedido
     * @return pedido encontrado, o null si no existe
     */
    public Pedido buscarPedido(String codigo) {
        Pedido encontrado = null;
        if (tieneTexto(codigo)) {
            for (int i = 0; i < ListPedidos.size() && encontrado == null; i++) {
                Pedido pedido = ListPedidos.get(i);
                if (pedido.getCodigo().equalsIgnoreCase(codigo.trim())) {
                    encontrado = pedido;
                }
            }
        }
        return encontrado;
    }

    /**
     * Metodo que consulta los pedidos del cliente que llegaron a confirmarse.
     * Si un pedido se cancela después de la confirmación, permanece visible
     * con su estado CANCELADO.
     * @param documento número de documento del cliente
     * @return historial de pedidos, o lista vacía si no hay historial o cliente
     */
    public List<Pedido> consultarHistorialCliente(String documento) {
        List<Pedido> historial = new ArrayList<>();
        Cliente cliente = buscarCliente(documento);
        if (cliente != null) {
            for (Pedido pedido : ListPedidos) {
                if (pedido.getCliente() == cliente && pedido.getFechaConfirmacion() != null) {
                    historial.add(pedido);
                }
            }
        }
        return historial;
    }

    /**
     * Metodo que consulta la canidad de productos disponibles
     * @return productos del menú que cumplen las condiciones de calidad
     */
    public List<Producto> consultarProductosDisponibles() {
        List<Producto> disponibles = new ArrayList<>();
        for (Producto producto : ListProductos) {
            if (producto.cumpleCondicionesCalidad()) {
                disponibles.add(producto);
            }
        }
        return disponibles;
    }

    /**
     * Metodo que consulta productos con fallas de calidad
     * @return productos del menú que incumplen las condiciones de calidad
     */
    public List<Producto> consultarProductosConFallasDeCalidad() {
        List<Producto> productosConFallas = new ArrayList<>();
        for (Producto producto : ListProductos) {
            if (!producto.cumpleCondicionesCalidad()) {
                productosConFallas.add(producto);
            }
        }
        return productosConFallas;
    }

    /**
     * Metodo que calcula los ingresos propios del restaurante
     * @return
     */
    public double calcularIngresosPropios() {
        double ingresos = 0;
        for (Pedido pedido : ListPedidos) {
            if (pedido.cuentaComoVenta()) {
                ingresos += pedido.calcularSubtotalProductos();
            }
        }
        return ingresos;
    }

    /**
     * Metodo que calcula el total de los domicilios
     * @return valor de los domicilios de pedidos confirmados o entregados
     */
    public double calcularTotalDomicilios() {
        double totalDomicilios = 0;
        for (Pedido pedido : ListPedidos) {
            if (pedido.cuentaComoVenta()) {
                totalDomicilios += pedido.calcularCostoDomicilio();
            }
        }
        return totalDomicilios;
    }

    /**
     * Metodo que identifica el producto con más unidades vendidas. En caso de empate
     * devuelve el primero según el orden de registro en el menú.
     * @return producto más vendido, o null si no hay unidades vendidas
     */
    public Producto obtenerProductoMasVendido() {
        Producto masVendido = null;
        int mayorCantidad = 0;
        for (Producto producto : ListProductos) {
            int unidades = contarUnidadesVendidas(producto);
            if (unidades > mayorCantidad) {
                mayorCantidad = unidades;
                masVendido = producto;
            }
        }
        return masVendido;
    }

    /**
     * Metodo que suma las unidades de un producto en los pedidos que cuentan como venta.
     * @param producto producto que se desea consultar
     * @return total de unidades vendidas
     */
    private int contarUnidadesVendidas(Producto producto) {
        int unidades = 0;
        for (Pedido pedido : ListPedidos) {
            if (pedido.cuentaComoVenta()) {
                for (DetallePedido detalle : pedido.getDetalles()) {
                    if (detalle.getProducto() == producto) {
                        unidades += detalle.getCantidad();
                    }
                }
            }
        }
        return unidades;
    }

    /**
     * Metodo que identifica la categoría con mayores ingresos por productos.
     * En caso de empate devuelve la primera según el orden de la enumeración.
     * @return categoría con mayores ingresos, o null si no hay ingresos positivos
     */
    public CategoriaProducto obtenerCategoriaConMayoresIngresos() {
        CategoriaProducto mejorCategoria = null;
        double mayorIngreso = 0;
        for (CategoriaProducto categoria : CategoriaProducto.values()) {
            double ingreso = calcularIngresosPorCategoria(categoria);
            if (ingreso > mayorIngreso) {
                mayorIngreso = ingreso;
                mejorCategoria = categoria;
            }
        }
        return mejorCategoria;
    }

    /**
     * Metodo que suma los subtotales vendidos de la categoría solicitada.
     * @param categoria categoría que se desea consultar
     * @return ingresos por productos de esa categoría
     */
    public double calcularIngresosPorCategoria(CategoriaProducto categoria) {
        double ingresos = 0;
        for (Pedido pedido : ListPedidos) {
            if (pedido.cuentaComoVenta()) {
                for (DetallePedido detalle : pedido.getDetalles()) {
                    if (detalle.getProducto().obtenerCategoria() == categoria) {
                        ingresos += detalle.calcularSubtotal();
                    }
                }
            }
        }
        return ingresos;
    }

    /**
     * Metodo que comprueba que un dato de identificación contenga texto.
     * @param texto dato que se desea verificar
     * @return true si contiene al menos un carácter distinto de espacio
     */
    private boolean tieneTexto(String texto) {
        boolean valido = texto != null && !texto.trim().isEmpty();
        return valido;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }
}