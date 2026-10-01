package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Hotel {

    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefono;
    private String paginaWeb;

    private ArrayList<Huesped> listHotelHuespedes;
    private ArrayList<Habitacion> listHotelHabitaciones;
    private ArrayList<Reserva> listHotelReservas;
    private ArrayList<ServicioAdicional> listHotelServiciosAdicionales;

    /**
     * Método constructor de la clase Hotel.
     * @param nombreComercial nombre comercial del hotel
     * @param nit identificación tributaria del hotel
     * @param direccion ubicación del hotel
     * @param telefono número telefónico
     * @param paginaWeb página web institucional
     */
    public Hotel(String nombreComercial, String nit, String direccion, String telefono, String paginaWeb) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;

        listHotelHuespedes = new ArrayList<>();
        listHotelHabitaciones = new ArrayList<>();
        listHotelReservas = new ArrayList<>();
        listHotelServiciosAdicionales = new ArrayList<>();
    }

    /**
     * Método que permite registrar un nuevo huésped en el hotel.
     * @param documento documento de identidad del huésped
     * @param nombreCompleto nombre completo del huésped
     * @param telefono número telefónico
     * @param correo correo electrónico
     * @param paisProcedencia país de procedencia
     * @return mensaje indicando el resultado del registro
     */
    public String registrarHuesped(String documento, String nombreCompleto, String telefono, String correo, String paisProcedencia) {
        String mensaje = "";
        Huesped huesped = buscarHuesped(documento);
        if (huesped == null) {
            Huesped nuevoHuesped = new Huesped(documento, nombreCompleto, telefono, correo, paisProcedencia);
            listHotelHuespedes.add(nuevoHuesped);
            mensaje = "El huésped " + nombreCompleto + " se registró exitosamente";
        } else {
            mensaje = "El huésped con documento " + documento + " ya se encuentra registrado";
        }
        return mensaje;
    }

    /**
     * Método que permite buscar un huésped mediante su documento.
     * @param documento documento del huésped
     * @return huésped encontrado o null si no existe
     */
    public Huesped buscarHuesped(String documento) {
        Huesped encontrado = null;
        for(int i = 0; i < listHotelHuespedes.size(); i++) {
            Huesped huesped = listHotelHuespedes.get(i);
            if (huesped.getDocumento().equals(documento)) {
                encontrado = huesped;
                break;
            }
        }
        return encontrado;
    }

    /**
     * Método que permite buscar un huésped mediante su número de teléfono.
     * @param telefono número telefónico del huésped
     * @return huésped encontrado o null si no existe
     */
    public Huesped buscarHuespedPorTelefono(String telefono) {
        Huesped encontrado = null;
        for (int i = 0; i < listHotelHuespedes.size(); i++) {
            Huesped huesped = listHotelHuespedes.get(i);
            if (huesped.getTelefono().equals(telefono)) {
                encontrado = huesped;
                break;
            }
        }
        return encontrado;
    }

    /**
     * Método que permite registrar una nueva habitación en el hotel.
     * @param numero número de la habitación
     * @param piso piso donde se encuentra ubicada
     * @param tipo tipo de habitación
     * @param capacidad capacidad máxima de huéspedes
     * @param precio precio por noche
     * @return mensaje indicando el resultado del registro
     */
    public String registrarHabitacion(int numero, int piso, String tipo, int capacidad, double precio) {
        String mensaje = "";
        Habitacion habitacion = buscarHabitacion(numero);
        if (habitacion == null) {
            Habitacion nuevaHabitacion = new Habitacion(numero, piso, tipo, capacidad, precio);
            listHotelHabitaciones.add(nuevaHabitacion);
            mensaje = "La habitación " + numero + " fue registrada exitosamente";
        } else {
            mensaje = "La habitación " + numero + " ya existe";
        }
        return mensaje;
    }

    /**
     * Método que permite buscar una habitación mediante su número.
     * @param numero número de la habitación
     * @return habitación encontrada o null si no existe
     */
    public Habitacion buscarHabitacion(int numero) {
        Habitacion encontrada = null;
        for(int i = 0; i < listHotelHabitaciones.size(); i++) {
            Habitacion habitacion = listHotelHabitaciones.get(i);
            if (habitacion.getNumero() == numero) {
                encontrada = habitacion;
                break;
            }
        }
        return encontrada;
    }

    /**
     * Método que permite registrar un servicio adicional ofrecido por el hotel.
     * @param codigo código del servicio
     * @param nombre nombre del servicio
     * @param descripcion descripción del servicio
     * @param precio valor del servicio
     * @return mensaje indicando el resultado del registro
     */
    public String registrarServicio(String codigo, String nombre, String descripcion, double precio) {
        String mensaje = "";
        ServicioAdicional servicio = buscarServicio(codigo);
        if (servicio == null) {
            ServicioAdicional nuevoServicio = new ServicioAdicional(codigo, nombre, descripcion, precio);
            listHotelServiciosAdicionales.add(nuevoServicio);
            mensaje = "El servicio " + nombre + " fue registrado exitosamente";
        } else {
            mensaje = "El servicio con código " + codigo + " ya existe";
        }
        return mensaje;
    }

    /**
     * Método que permite buscar un servicio adicional mediante su código.
     * @param codigo código del servicio
     * @return servicio encontrado o null si no existe
     */
    public ServicioAdicional buscarServicio(String codigo) {
        ServicioAdicional encontrado = null;
        for(int i = 0; i < listHotelServiciosAdicionales.size(); i++) {
            ServicioAdicional servicio = listHotelServiciosAdicionales.get(i);
            if(servicio.getCodigo().equals(codigo)) {
                encontrado = servicio;
                break;
            }
        }
        return encontrado;
    }

    /**
     * Método que permite registrar una nueva reserva asociando directamente el huésped que realiza la reserva.
     * @param codigo código de la reserva
     * @param fechaRealizacion fecha en la cual se realiza la reserva
     * @param fechaEntrada fecha de entrada al hotel
     * @param fechaSalida fecha de salida del hotel
     * @param metodoPago método de pago seleccionado
     * @param huesped huésped que realiza la reserva
     * @return mensaje indicando el resultado del registro
     */
    public String registrarReserva(String codigo, String fechaRealizacion, String fechaEntrada, String fechaSalida, String metodoPago, Huesped huesped) {
        String mensaje = "";
        Reserva reserva = buscarReserva(codigo);
        if (reserva == null && huesped != null) {
            Reserva nuevaReserva = new Reserva(codigo, fechaRealizacion, fechaEntrada, fechaSalida, metodoPago, huesped);
            listHotelReservas.add(nuevaReserva);
            mensaje = "La reserva " + codigo + " fue creada exitosamente";
        } else if (reserva != null) {
            mensaje = "La reserva con código " + codigo + " ya existe";
        } else {
            mensaje = "No fue posible crear la reserva";
        }
        return mensaje;
    }

    /**
     * Método que permite buscar una reserva mediante su código.
     * @param codigo código de la reserva
     * @return reserva encontrada o null si no existe
     */
    public Reserva buscarReserva(String codigo) {
        Reserva encontrada = null;
        for(int i = 0; i < listHotelReservas.size(); i++) {
            Reserva reserva = listHotelReservas.get(i);
            if (reserva.getCodigoReserva().equals(codigo)) {
                encontrada = reserva;
                break;
            }
        }
        return encontrada;
    }

    /**
     * Método que permite calcular los ingresos generados por las reservas realizadas en una fecha determinada.
     * @param fecha fecha de realización de las reservas
     * @return valor total de los ingresos
     */
    public double calcularIngresosFecha(String fecha) {
        double total = 0;
        for (int i = 0; i < listHotelReservas.size(); i++) {
            Reserva reserva = listHotelReservas.get(i);
            if (reserva.getFechaRealizacion().equals(fecha)) {
                total += reserva.getValorTotal();
            }
        }
        return total;
    }

    /**
     * Método que permite verificar si el número de teléfono de un huésped corresponde a un número perfecto.
     * Un número perfecto es aquel que es igual a la suma de
     * sus divisores propios positivos, sin incluir el mismo número.
     * @param telefono número de teléfono del huésped almacenado como String
     * @return mensaje indicando si el número es perfecto o no
     */
    public String verificarNumeroPerfecto(String telefono) {
        int numero = Integer.parseInt(telefono);
        int suma = 0;
        String mensaje = "El número no es perfecto";
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        if (suma == numero) {
            mensaje = "El número es perfecto";
        }
        return mensaje;
    }

    public ArrayList<Huesped> getListHotelHuespedes() {
        return listHotelHuespedes;
    }

    public ArrayList<Habitacion> getListHotelHabitaciones() {
        return listHotelHabitaciones;
    }

    public ArrayList<Reserva> getListHotelReservas() {
        return listHotelReservas;
    }

    public ArrayList<ServicioAdicional> getListHotelServiciosAdicionales() {
        return listHotelServiciosAdicionales;
    }

    @Override
    public String toString() {

        return "Hotel{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", paginaWeb='" + paginaWeb + '\'' +
                '}';
    }
}