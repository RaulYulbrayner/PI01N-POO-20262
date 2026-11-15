package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String codigo;
    private LocalDate fecha;
    private Cliente theClienteVenta;
    private Operario theOperarioVenta;
    private Funcion theFuncionVenta;
    private List<Boleta> listVentaBoletas;

    /** Construye una venta sin boletas iniciales. */
    public Venta(String codigo, LocalDate fecha, Cliente theClienteVenta, Operario theOperarioVenta, Funcion theFuncionVenta) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.theClienteVenta = theClienteVenta;
        this.theOperarioVenta = theOperarioVenta;
        this.theFuncionVenta = theFuncionVenta;
        this.listVentaBoletas = new ArrayList<>();
    }

    /**
     * Metodo que permite sumar el valor de todas las boletas.
     * @return Valor total de la venta.
     */
    public double calcularTotal() {
        double total = 0;
        for (Boleta boleta : listVentaBoletas) {
            total += boleta.valorPagado();
        }
        return total;
    }

    /**
     * Metodo que permite agregar    una boleta a la lista de boletas de la venta.
     * @param boleta boleta que se desea agregar.
     */
    public void agregarBoleta(Boleta boleta) {
        listVentaBoletas.add(boleta);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getTheClienteVenta() {
        return theClienteVenta;
    }

    public void setTheClienteVenta(Cliente theClienteVenta) {
        this.theClienteVenta = theClienteVenta;
    }

    public Operario getTheOperarioVenta() {
        return theOperarioVenta;
    }

    public void setTheOperarioVenta(Operario theOperarioVenta) {
        this.theOperarioVenta = theOperarioVenta;
    }

    public Funcion getTheFuncionVenta() {
        return theFuncionVenta;
    }

    public void setTheFuncionVenta(Funcion theFuncionVenta) {
        this.theFuncionVenta = theFuncionVenta;
    }

    public List<Boleta> getListVentaBoletas() {
        return listVentaBoletas;
    }

    public void setListVentaBoletas(List<Boleta> listVentaBoletas) {
        this.listVentaBoletas = listVentaBoletas;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", theClienteVenta=" + theClienteVenta +
                ", theOperarioVenta=" + theOperarioVenta +
                ", theFuncionVenta=" + theFuncionVenta +
                ", listVentaBoletas=" + listVentaBoletas +
                '}';
    }


    public boolean esPalindromo(String palabra) {
        palabra = palabra.toLowerCase();
        int inicio = 0;
        int fin = palabra.length() - 1;
        while (inicio < fin) {
            if (palabra.charAt(inicio) != palabra.charAt(fin)) {
                return false;
            }
            inicio++;
            fin--;
        }
        return true;
    }

    public int factorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado = resultado * i;
        }
        return resultado;
    }

    public String esPalindromo2(String palabra) {
        String invertida = "";
        for (int i = palabra.length() - 1; i >= 0; i--) {
            invertida += palabra.charAt(i);
        }
        if (palabra.equalsIgnoreCase(invertida)) {
            return "Es palindromo";
        } else {
            return "No es palindromo";
        }
    }

    public String convertirMinusculas(String palabra) {
        return palabra.toLowerCase();
    }

    public double dividir(int num1, int num2){
        double valor = num1 / num2;
        return valor;
    }

}

