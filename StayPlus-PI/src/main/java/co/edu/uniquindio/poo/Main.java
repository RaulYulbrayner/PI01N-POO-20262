package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.model.Habitacion;
import co.edu.uniquindio.poo.model.Hotel;
import co.edu.uniquindio.poo.model.Huesped;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.ServicioAdicional;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel("StayPlus", "900123456", "Armenia", "6067350000", "www.stayplus.com");

        int opcion = 0;

        while (opcion != 10) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                            ================ HOTEL STAYPLUS ================
                            1. Registrar huésped
                            2. Registrar habitación
                            3. Registrar servicio adicional
                            4. Registrar reserva
                            5. Agregar habitación a una reserva
                            6. Agregar servicio adicional a una reserva
                            7. Buscar huésped por teléfono
                            8. Verificar teléfono perfecto
                            9. Calcular ingresos por fecha
                            10. Salir

                            Seleccione una opción:
                            """));

            if (opcion == 1) {
                String documento = JOptionPane.showInputDialog(null, "Ingrese el documento de identidad:");
                String nombreCompleto = JOptionPane.showInputDialog(null, "Ingrese el nombre completo del huésped:");
                String telefono = JOptionPane.showInputDialog(null, "Ingrese el número de teléfono:");
                String correo = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico:");
                String paisProcedencia = JOptionPane.showInputDialog(null, "Ingrese el país de procedencia:");
                String resultado = hotel.registrarHuesped(documento, nombreCompleto, telefono, correo, paisProcedencia);
                JOptionPane.showMessageDialog(null, resultado);

            } else if (opcion == 2) {
                int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de la habitación:"));
                int piso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el piso de la habitación:"));
                String tipo = JOptionPane.showInputDialog(null, """
                    Ingrese el tipo de habitación:
                    Individual
                    Doble
                    Suite
                    """);
                int capacidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la capacidad máxima:"));
                double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio por noche:"));
                String resultado = hotel.registrarHabitacion(numeroHabitacion, piso, tipo, capacidad, precio);
                JOptionPane.showMessageDialog(null, resultado);

            } else if (opcion == 3) {
                String codigoServicio = JOptionPane.showInputDialog(null, "Ingrese el código del servicio:");
                String nombreServicio = JOptionPane.showInputDialog(null, "Ingrese el nombre del servicio:");
                String descripcion = JOptionPane.showInputDialog(null, "Ingrese la descripción del servicio:");
                double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio del servicio:"));
                String resultado = hotel.registrarServicio(codigoServicio, nombreServicio, descripcion, precio);
                JOptionPane.showMessageDialog(null, resultado);

            } else if (opcion == 4) {
                String documento = JOptionPane.showInputDialog(null, "Ingrese el documento del huésped:");
                Huesped huesped = hotel.buscarHuesped(documento);
                if (huesped != null) {
                    String codigoReserva = JOptionPane.showInputDialog(null, "Ingrese el código de la reserva:");
                    String fechaRealizacion = JOptionPane.showInputDialog(null, "Ingrese la fecha de realización:");
                    String fechaEntrada = JOptionPane.showInputDialog(null, "Ingrese la fecha de entrada:");
                    String fechaSalida = JOptionPane.showInputDialog(null, "Ingrese la fecha de salida:");
                    String metodoPago = JOptionPane.showInputDialog(null, """
                        Ingrese el método de pago:
        
                        Tarjeta de crédito
                        Transferencia bancaria
                        Efectivo
                        """);
                    String resultado = hotel.registrarReserva(codigoReserva, fechaRealizacion, fechaEntrada, fechaSalida, metodoPago, huesped);
                    JOptionPane.showMessageDialog(null, resultado);
                } else {
                JOptionPane.showMessageDialog(null, "El huésped no se encuentra registrado.");
                }

            } else if (opcion == 5) {
                String codigoReserva = JOptionPane.showInputDialog(null, "Ingrese el código de la reserva:");
                Reserva reserva = hotel.buscarReserva(codigoReserva);
                if (reserva != null) {
                    int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de la habitación:"));
                    Habitacion habitacion = hotel.buscarHabitacion(numeroHabitacion);

                    if (habitacion != null) {
                        if (habitacion.estaDisponible()) {
                            int cantidadNoches = Integer.parseInt(
                                    JOptionPane.showInputDialog(null, "Ingrese la cantidad de noches:"));
                            String resultado = String.valueOf(reserva.agregarHabitacion(habitacion, cantidadNoches));
                            JOptionPane.showMessageDialog(null, resultado);
                        } else {
                            JOptionPane.showMessageDialog(null, "La habitación no se encuentra disponible.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La habitación no existe.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La reserva no existe.");
                }
            } else if (opcion == 6) {
                String codigoReserva = JOptionPane.showInputDialog(null, "Ingrese el código de la reserva:");
                Reserva reserva = hotel.buscarReserva(codigoReserva);

                if (reserva != null) {
                    String codigoServicio = JOptionPane.showInputDialog(null, "Ingrese el código del servicio adicional:");
                    ServicioAdicional servicio = hotel.buscarServicio(codigoServicio);
                    if (servicio != null) {
                        if (servicio.isDisponible()) {
                            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad:"));
                            reserva.agregarServicio(servicio, cantidad);
                            JOptionPane.showMessageDialog(null, cantidad);
                        } else {
                            JOptionPane.showMessageDialog(null, "El servicio no se encuentra disponible.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El servicio adicional no existe.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La reserva no existe.");
                }

            } else if (opcion == 7) {
                String telefono = JOptionPane.showInputDialog(null, "Ingrese el teléfono del huésped:");
                Huesped huesped = hotel.buscarHuespedPorTelefono(telefono);
                if (huesped != null) {
                    JOptionPane.showMessageDialog(null, "Huésped encontrado:\n\n" + huesped.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un huésped con ese teléfono.");
                }

            } else if (opcion == 8) {
                String telefono = JOptionPane.showInputDialog(null, "Ingrese el teléfono del huésped:");
                Huesped huesped = hotel.buscarHuespedPorTelefono(telefono);
                if (huesped != null) {
                    String resultado = hotel.verificarNumeroPerfecto(huesped.getTelefono());
                    JOptionPane.showMessageDialog(null, "Nombre del huésped: " + huesped.getNombreCompleto() + "\nTeléfono: " + huesped.getTelefono() + "\nResultado: " + resultado);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un huésped con ese teléfono.");
                }

            } else if (opcion == 9) {
                String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de realización:");
                double ingresos = hotel.calcularIngresosFecha(fecha);
                JOptionPane.showMessageDialog(null, "Ingresos correspondientes a la fecha " + fecha + ":\n$" + ingresos);

            } else if (opcion == 10) {
                JOptionPane.showMessageDialog(null, "Saliendo del sistema StayPlus.");
            } else {
                JOptionPane.showMessageDialog(null, "La opción seleccionada no es válida."
                );
            }
        }
    }
}