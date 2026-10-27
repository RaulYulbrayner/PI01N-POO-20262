package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Cine {
    private String nombre;
    private String nit;
    private String direccion;
    private List<Pelicula> listCinePeliculas;
    private List<Persona> listCinePersonas;
    private List<Sala> listCineSalas;
    private List<Funcion> listCineFunciones;
    private List<Venta> listCineVentas;
    private int consecutivoBoleta;

    /**
     * Metodo constructor de la calse Cine
     * @param nombre del cine
     * @param nit del cine
     * @param direccion del cine
     */
    public Cine(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        listCinePeliculas = new ArrayList<>();
        listCinePersonas = new ArrayList<>();
        listCineSalas = new ArrayList<>();
        listCineFunciones = new ArrayList<>();
        listCineVentas = new ArrayList<>();
        consecutivoBoleta = 1;
    }

    /**
     * Metodo que permite registrar una película si su código no está en uso.
     * @return true si se agregó; false si el código ya existe.
     */
    public boolean registrarPelicula(Pelicula pelicula) {
        boolean registrado = false;
        if (pelicula != null && buscarPelicula(pelicula.getCodigo()) == null) {
            listCinePeliculas.add(pelicula);
            registrado = true;
        }
        return registrado;
    }

    /**
     * Metodo que permite buscar una pelicula por codigo
     * @param codigo de la pelicula
     * @return pelicula
     */
    public Pelicula buscarPelicula(String codigo) {
        Pelicula encontrada = null;
        for (Pelicula pelicula : listCinePeliculas) {
            if (pelicula.getCodigo().equalsIgnoreCase(codigo)) {
                encontrada = pelicula;
            }
        }
        return encontrada;
    }

    /**
     * Metodo que permite registrar un cliente
     * @return true si se agregó.
     */
    public boolean registrarCliente(Cliente cliente) {
        boolean registrado = false;
        if (cliente != null && buscarPersona(cliente.getDocumento()) == null) {
            listCinePersonas.add(cliente);
            registrado = true;
        }
        return registrado;
    }

    /**
     * Metodo que permite registrar un operario
     * @param operario
     * @return
     */
    public boolean registrarOperario(Operario operario) {
        boolean registrado = false;
        if (operario != null && buscarPersona(operario.getDocumento()) == null) {
            listCinePersonas.add(operario);
            registrado = true;
        }
        return registrado;
    }

    /**
     * Metodo que permite buscarPersona por documento
     * @param documento de la persona
     * @return persona
     */
    public Persona buscarPersona(String documento) {
        Persona encontrada = null;
        for (Persona persona : listCinePersonas) {
            if (persona.getDocumento().equalsIgnoreCase(documento)) {
                encontrada = persona;
            }
        }
        return encontrada;
    }

    /**
     * Metodo que permite buscar un cliente por documento
     * @param documento del cliente
     * @return cliente
     */
    public Cliente buscarCliente(String documento) {
        Cliente encontrado = null;
        Persona persona = buscarPersona(documento);
        if (persona instanceof Cliente) {
            encontrado = (Cliente) persona;
        }
        return encontrado;
    }

    /**
     * Metodo que permite buscar un Operario por documento
     * @param codigoEmpleado del Operario
     * @return operario
     */
    public Operario buscarOperario(String codigoEmpleado) {
        Operario encontrado = null;
        for (Persona persona : listCinePersonas) {
            if (persona instanceof Operario) {
                Operario operario = (Operario) persona;
                if (operario.getCodigoEmpleado().equalsIgnoreCase(codigoEmpleado)) {
                    encontrado = operario;
                }
            }
        }
        return encontrado;
    }

    /**
     * Metodo que permite registrar una sala
     * @param sala
     * @return
     */
    public boolean registrarSala(Sala sala) {
        boolean registrado = false;
        if (sala != null && buscarSala(sala.getCodigo()) == null) {
            listCineSalas.add(sala);
            registrado = true;
        }
        return registrado;
    }

    /**
     * Metodo que permite buscar una sala por codigo
     * @param codigo de la sala
     * @return sala
     */
    public Sala buscarSala(String codigo) {
        Sala encontrada = null;
        for (Sala sala : listCineSalas) {
            if (sala.getCodigo().equalsIgnoreCase(codigo)) {
                encontrada = sala;
            }
        }
        return encontrada;
    }

    /**
     * Metodo que permite registrar una función, sin permitir códigos repetidos ni horarios superpuestos.
     * @param funcion Función ya asociada a una película y una sala del cine.
     * @return true si se pudo programar.
     */
    public boolean programarFuncion(Funcion funcion) {
        boolean programada = funcion != null && buscarFuncion(funcion.getCodigo()) == null;
        if (programada) {
            programada = buscarPelicula(funcion.getThePeliculaFuncion().getCodigo()) == funcion.getThePeliculaFuncion()
                    && buscarSala(funcion.getTheSalaFuncion().getCodigo()) == funcion.getTheSalaFuncion();
        }
        if (programada) {
            for (Funcion actual : listCineFunciones) {
                if (funcion.tieneConflictoCon(actual)) {
                    programada = false;
                }
            }
        }
        if (programada) {
            listCineFunciones.add(funcion);
        }
        return programada;
    }

    /**
     * Metodo que permite buscar una función por codigo
     * @param codigo de la funcion
     * @return funcion
     */
    public Funcion buscarFuncion(String codigo) {
        Funcion encontrada = null;
        for (Funcion funcion : listCineFunciones) {
            if (funcion.getCodigo().equalsIgnoreCase(codigo)) {
                encontrada = funcion;
            }
        }
        return encontrada;
    }

    /**
     * Metodo que permite buscar una venta por codigo
     * @param codigo de la venta
     * @return venta
     */
    public Venta buscarVenta(String codigo) {
        Venta encontrada = null;
        for (Venta venta : listCineVentas) {
            if (venta.getCodigo().equalsIgnoreCase(codigo)) {
                encontrada = venta;
            }
        }
        return encontrada;
    }

    /**
     * Metodo que permite indicar si existe una boleta vendida para ese asiento y esa función.
     * @return true cuando el asiento ya se vendió en la función consultada.
     */
    public boolean estaOcupado(Funcion funcion, Asiento asiento) {
        boolean ocupado = false;
        for (Venta venta : listCineVentas) {
            if (venta.getTheFuncionVenta() == funcion) {
                for (Boleta boleta : venta.getListVentaBoletas()) {
                    if (boleta.theBoletaAsiento() == asiento) {
                        ocupado = true;
                    }
                }
            }
        }
        return ocupado;
    }

    /**
     * Metodo que permite calcular el precio final de una boleta, aplicando primero el recargo
     * del tipo de sala y después el descuento del cliente.
     * @return Valor a pagar por una boleta.
     */
    public double calcularValorBoleta(Funcion funcion, Cliente cliente) {
        double precioConRecargo = funcion.getPrecioBase() * (1 + funcion.getTheSalaFuncion().getTipoSala().getRecargo());
        return precioConRecargo * (1 - cliente.getPorcentajeDescuento() / 100.0);
    }

    /**
     * Metodo que permite validar todos los asientos antes de guardar una venta para impedir
     * Verifica que los asientos existan, estén disponibles
     * y no se repitan dentro de la misma venta.
     * @param codigoVenta código único de la venta.
     * @param cliente cliente que realiza la compra.
     * @param operario operario que registra la venta.
     * @param funcion función cinematográfica.
     * @param seleccion lista de asientos seleccionados.
     * @return venta registrada o null si no se puede realizar.
     */
    public Venta realizarVenta(String codigoVenta, Cliente cliente, Operario operario, Funcion funcion, List<Asiento> seleccion) {
        Venta venta = null;
        boolean valido = true;
        if (codigoVenta == null || buscarVenta(codigoVenta) != null
                || cliente == null || operario == null
                || funcion == null || seleccion == null || seleccion.isEmpty()) {
            valido = false;
        }
        if (valido) {
            List<Asiento> revisados = new ArrayList<>();
            for (Asiento asiento : seleccion) {
                if (asiento == null
                        || funcion.getTheSalaFuncion().buscarAsiento(
                        asiento.getFila(), asiento.getNumero()) != asiento
                        || revisados.contains(asiento)
                        || estaOcupado(funcion, asiento)) {
                    valido = false;
                }
                revisados.add(asiento);
            }
        }
        if (valido) {
            venta = new Venta(codigoVenta, LocalDate.now(), cliente, operario, funcion);
            double valor = calcularValorBoleta(funcion, cliente);
            for (Asiento asiento : seleccion) {
                String codigoBoleta = "B" + consecutivoBoleta;
                consecutivoBoleta++;
                Boleta boleta = new Boleta(codigoBoleta, asiento, valor);
                venta.agregarBoleta(boleta);
            }
            listCineVentas.add(venta);
        }
        return venta;
    }

    /**
     * Método que permite calcular el porcentaje de ocupación
     * de una función a partir de su código, contando las boletas vendidas.
     * @param codigoFuncion Código de la función cinematográfica.
     * @return Porcentaje de ocupación entre 0 y 100.
     */
    public double calcularOcupacion(String codigoFuncion) {
        double porcentaje = 0;
        int vendidas = 0;
        Funcion funcion = buscarFuncion(codigoFuncion);
        if (funcion != null) {
            for (Venta venta : listCineVentas) {
                if (venta.getTheFuncionVenta() == funcion) {
                    vendidas += venta.getListVentaBoletas().size();
                }
            }
            if (funcion.getTheSalaFuncion().getCapacidadMaxima() > 0) {
                porcentaje = vendidas * 100.0 / funcion.getTheSalaFuncion().getCapacidadMaxima();
            }
        }
        return porcentaje;
    }

    @Override
    public String toString() {
        return "Cine{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", peliculas=" + listCinePeliculas +
                ", personas=" + listCinePersonas +
                ", salas=" + listCineSalas +
                ", funciones=" + listCineFunciones +
                ", ventas=" + listCineVentas +
                ", consecutivoBoleta=" + consecutivoBoleta +
                '}';
    }
}
