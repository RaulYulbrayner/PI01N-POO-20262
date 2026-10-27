package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Cine cine = new Cine("CinePlus", "900123456-7", "Armenia, Quindío");

        // Registrar salas inicialmente
        Sala sala1 = new Sala("S01", "Sala Tradicional", 20, 10, TipoSala.TRADICIONAL);
        Sala sala2 = new Sala("S02", "Sala VIP", 15, 10, TipoSala.VIP);
        Sala sala3 = new Sala("S03", "Sala 3D", 25, 10, TipoSala.TRES_D);
        cine.registrarSala(sala1);
        cine.registrarSala(sala2);
        cine.registrarSala(sala3);

        // Registrar operario inicialmente
        Operario operario = new Operario("1094000000", "Carlos Ramírez", "carlos@cineplus.com", "3101234567", "OP001", LocalDate.of(2024, 2, 10), 1800000);

        cine.registrarOperario(operario);

        int opcion = 0;

        while (opcion != 7) {

            opcion = Integer.parseInt(
                    JOptionPane.showInputDialog(null, """
                            ========== CINEPLUS ==========
                            1. Registrar película
                            2. Registrar cliente
                            3. Programar función
                            4. Realizar venta de boletas
                            5. Calcular valor total de una venta
                            6. Calcular porcentaje de ocupación
                            7. Salir
                            Seleccione una opción:
                            """)
            );

            if (opcion == 1) {
                String codigo = JOptionPane.showInputDialog(null, "Ingrese el código de la película");
                String titulo = JOptionPane.showInputDialog(null, "Ingrese el título de la película");
                int duracion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la duración en minutos"));
                int opcionGenero = Integer.parseInt(
                        JOptionPane.showInputDialog(null, """
                                Seleccione el género:
                                1. Acción
                                2. Comedia
                                3. Drama
                                4. Terror
                                5. Animación
                                """)
                );
                Genero genero = null;
                if (opcionGenero == 1) {
                    genero = Genero.ACCION;
                } else if (opcionGenero == 2) {
                    genero = Genero.COMEDIA;
                } else if (opcionGenero == 3) {
                    genero = Genero.DRAMA;
                } else if (opcionGenero == 4) {
                    genero = Genero.TERROR;
                } else if (opcionGenero == 5) {
                    genero = Genero.ANIMACION;
                }
                int edadMinima = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la clasificación por edad minima de la pelicula"));
                Pelicula pelicula = new Pelicula(codigo, titulo, duracion, genero, edadMinima);

                boolean registrado = cine.registrarPelicula(pelicula);

                if (registrado) {
                    JOptionPane.showMessageDialog(null, "Película registrada correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe una película con ese código");
                }
            } else if (opcion == 2) {
                String documento = JOptionPane.showInputDialog(null, "Ingrese el documento del cliente");
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo");
                String correo = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico");
                String telefono = JOptionPane.showInputDialog(null, "Ingrese el número de teléfono");
                String codigoAfiliacion = JOptionPane.showInputDialog(null, "Ingrese el código de afiliación");
                double descuento = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el porcentaje de descuento"));

                Cliente cliente = new Cliente(documento, nombre, correo, telefono, codigoAfiliacion, descuento);

                boolean registrado = cine.registrarCliente(cliente);

                if (registrado) {
                    JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe una persona con ese documento");
                }

            } else if (opcion == 3) {
                String codigo = JOptionPane.showInputDialog(null, "Ingrese el código de la función");
                String codigoPelicula = JOptionPane.showInputDialog(null, "Ingrese el código de la película");
                Pelicula pelicula = cine.buscarPelicula(codigoPelicula);
                String codigoSala = JOptionPane.showInputDialog(null, "Ingrese el código de la sala");

                Sala sala = cine.buscarSala(codigoSala);

                if (pelicula != null && sala != null) {
                    String fechaTexto = JOptionPane.showInputDialog(null, "Ingrese la fecha (AAAA-MM-DD)");
                    LocalDate fecha = LocalDate.parse(fechaTexto);
                    String horaTexto = JOptionPane.showInputDialog(null, "Ingrese la hora (HH:MM)");
                    LocalTime hora = LocalTime.parse(horaTexto);
                    double precioBase = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio base de la boleta"));
                    Funcion funcion = new Funcion(codigo, fecha, hora, precioBase, pelicula, sala);
                    boolean registrado = cine.programarFuncion(funcion);

                    if (registrado) {
                        JOptionPane.showMessageDialog(null, "Función programada correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "No se puede programar la función. "
                                        + "Existe un conflicto de horario "
                                        + "o el código está duplicado."
                        );
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "La película o la sala no existe");
                }

            } else if (opcion == 4) {
                String codigoVenta = JOptionPane.showInputDialog(null, "Ingrese el código de la venta");
                String documentoCliente = JOptionPane.showInputDialog(null, "Ingrese el documento del cliente");

                Cliente cliente = cine.buscarCliente(documentoCliente);

                String codigoFuncion = JOptionPane.showInputDialog(null, "Ingrese el código de la función");

                Funcion funcion = cine.buscarFuncion(codigoFuncion);

                if (cliente != null && funcion != null) {
                    int cantidad = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Ingrese la cantidad de boletas")
                    );
                    List<Asiento> asientosSeleccionados = new ArrayList<>();
                    for (int i = 0; i < cantidad; i++) {
                        String fila = JOptionPane.showInputDialog(null, "Ingrese la fila de la boleta " + (i + 1));
                        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de asiento " + (i + 1)));

                        Asiento asiento = funcion.getTheSalaFuncion().buscarAsiento(fila, numero);

                        if (asiento != null) {
                            asientosSeleccionados.add(asiento);
                        } else {
                            JOptionPane.showMessageDialog(null, "El asiento " + fila + numero + " no existe en la sala");
                        }
                    }

                    if (asientosSeleccionados.size() == cantidad) {
                        Venta venta = cine.realizarVenta(
                                codigoVenta,
                                cliente,
                                operario,
                                funcion,
                                asientosSeleccionados
                        );
                        if (venta != null) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Venta registrada correctamente\n"
                                            + "Código: " + venta.getCodigo()
                                            + "\nTotal: $" + venta.calcularTotal()
                            );
                        } else {
                            JOptionPane.showMessageDialog(null, "La venta no se realizó porque " + "uno o varios asientos no existen");
                        }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente o la función no existe");
                    }

                } else if (opcion == 5) {
                    String codigoVenta = JOptionPane.showInputDialog(null, "Ingrese el código de la venta");
                    Venta venta = cine.buscarVenta(codigoVenta);
                    if (venta != null) {
                        double total = venta.calcularTotal();
                        JOptionPane.showMessageDialog(
                                null,
                                "Código de venta: " + venta.getCodigo()
                                        + "\nCliente: " + venta.getTheClienteVenta().getNombreCompleto()
                                        + "\nCantidad de boletas: "
                                        + venta.getListVentaBoletas().size()
                                        + "\nValor total: $" + total
                        );
                    } else {
                        JOptionPane.showMessageDialog(null, "La venta no existe");
                    }

                } else if (opcion == 6) {
                    String codigoFuncion = JOptionPane.showInputDialog(null, "Ingrese el código de la función");
                    Funcion funcion = cine.buscarFuncion(codigoFuncion);

                    if (funcion != null) {
                        double porcentaje = cine.calcularOcupacion(codigoFuncion);
                        JOptionPane.showMessageDialog(
                                null,
                                "Película: " + funcion.getThePeliculaFuncion().getTitulo()
                                        + "\nSala: " + funcion.getTheSalaFuncion().getNombre()
                                        + "\nCapacidad: "
                                        + funcion.getTheSalaFuncion().getCapacidadMaxima()
                                        + "\nPorcentaje de ocupación: "
                                        + porcentaje + "%"
                        );
                    } else {
                        JOptionPane.showMessageDialog(null, "La función no existe");
                    }
                } else if (opcion == 7) {
                    JOptionPane.showMessageDialog(null, "Saliendo del programa CinePlus");
                } else {
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                }
            }
        }

}