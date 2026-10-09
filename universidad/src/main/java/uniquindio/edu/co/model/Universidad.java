package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Universidad {

    //Atributos de la clase Universidad
    public String direccion, ciudad;
    public String nombre;
    public int telefono;
    private int numEstudiante, cantProfesores;
    public String tipoUniversidad;

    //Relaciones de la clase Universidad
    private List<Curso> listUniversidadCursos;
    private List<Persona> listPersonas;
    private List<Profesor> listUniversidadProfesores;

    /**
     * Metodo constructor de la clase Universidad
     * @param direccion de la Universidad
     * @param nombre de la Universidad
     * @param telefono de la Universidad
     * @param numEstudiante de la Universidad
     * @param tipoUniversidad de la Universidad
     * @param ciudad de la Universidad
     * @param cantProfesores de la Universidad
     */
    public Universidad(String direccion, String nombre, int telefono,
                       int numEstudiante, String tipoUniversidad, String ciudad, int cantProfesores){
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.telefono = telefono;
        this.numEstudiante = numEstudiante;
        this.cantProfesores = cantProfesores;
        this.tipoUniversidad = tipoUniversidad;

        this.listUniversidadCursos = new ArrayList<>();
        this.listPersonas = new ArrayList<>();
        this.listUniversidadProfesores = new ArrayList<>();
    }

    /**
     * Metodo que permite matricular estudiantes en la Universidad
     * @param genero del estudiante matriculado
     * @param nombre del estudiante matriculado
     * @param fechaNacimiento del estudiante matriculado
     * @param carrera del estudiante matriculado
     * @param documento del estudiante matriculado
     * @return
     */
    public boolean matricularEstudiante(String genero, String nombre, String fechaNacimiento, String carrera, EstadoEstudiante estadoEstudiante, int documento, EstadoPersona estadoPersona){
        boolean existe = false;
        Persona estudiante = buscarEstudiante(documento);
        if(estudiante == null){
            Persona est = new Estudiante(genero,nombre,fechaNacimiento,carrera,estadoEstudiante, documento, estadoPersona);
            listPersonas.add(est);
            existe = true;
        }
        return existe;
    }

    public String matricularEstudianteV2(String genero, String nombre,
                                         String fechaNacimiento, String carrera,
                                         EstadoEstudiante estadoEstudiante,
                                         int documento, EstadoPersona estadoPersona){
        String existe = "";
        Persona estudiante = buscarEstudiante(documento);
        if(estudiante == null){
            Estudiante est = new Estudiante(genero,nombre,fechaNacimiento,carrera,estadoEstudiante, documento, estadoPersona);
            listPersonas.add(est);
            existe = "El estudiante " + nombre + " se registro exitosamente";
        }else{
            existe = "El estudiante " + nombre + " ya se encuentra matriculado";
        }
        return existe;
    }

    /**
     * Metodo que permite determinar si el nombre de un estudiante es palindromo
     * @param nombreEstudiante del estudiante
     * @return
     */
    public boolean nombrePalindroma(String nombreEstudiante){
        boolean esPalindromo = true;
        int inicio = 0;
        int fin = nombreEstudiante.length()-1;
        while (inicio < fin){
            if(nombreEstudiante.charAt(inicio) != nombreEstudiante.charAt(fin)){
                esPalindromo = false;
                break;
            }
            inicio++;
            fin--;
        }
        return esPalindromo;
    }

    /**
     * Metodo que permite obtener el nombre de todos los objetos que son palindromos
     * @return
     */
    public String obtenerEstudiantesConNombrePalindromo(){
        String mensaje = "";
        for(Persona estudiante : listPersonas){
            if(nombrePalindroma(estudiante.getNombre())){
                mensaje += estudiante.toString() + "\n";
            }
        }
        return mensaje;
    }

    /**
     * Metodo que permite determinar si el nombre de un estudiante es palindromo
     * @param nombreEstudiante del estudiante
     * @return
     */
    public String nombrePalindromaV2(String nombreEstudiante){
        String mensaje = "es palindromo";
        int inicio = 0;
        while (inicio < nombreEstudiante.length()){
            char letra = nombreEstudiante.charAt(inicio);
            char ultimaLetra = nombreEstudiante.charAt(nombreEstudiante.length()-1 - inicio);
            if(letra != ultimaLetra){
                mensaje = "No es palindromo";
                break;
            }
            inicio++;
        }
        return mensaje;
    }

    /**
     * Metodo que permite buscar un estudiante
     * @param codigo del estudiante a buscar
     * @return
     */
    public Persona buscarEstudiante(int codigo){
       Persona encontrado = null;
       for(int i = 0; i < listPersonas.size(); i++){
           Persona estudiante = listPersonas.get(i);
           if(estudiante.getDocumento() == codigo){
               encontrado = estudiante;
               break;
           }
       }
       return encontrado;
    }

    /**
     * Metodo que permite eliminar un estudiante
     * @param codigo del estudiante a eliminar
     */
    public void eliminarEstudiante(int codigo){
        Persona estudiante = buscarEstudiante(codigo);
        listPersonas.remove(estudiante);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNumEstudiante() {
        return numEstudiante;
    }

    public void setNumEstudiante(int numEstudiante) {
        this.numEstudiante = numEstudiante;
    }

    public int getCantProfesores() {
        return cantProfesores;
    }

    public void setCantProfesores(int cantProfesores) {
        this.cantProfesores = cantProfesores;
    }

    public String getTipoUniversidad() {
        return tipoUniversidad;
    }

    public void setTipoUniversidad(String tipoUniversidad) {
        this.tipoUniversidad = tipoUniversidad;
    }

    public List<Curso> getListUniversidadCursos() {
        return listUniversidadCursos;
    }

    public void setListUniversidadCursos(List<Curso> listUniversidadCursos) {
        this.listUniversidadCursos = listUniversidadCursos;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public List<Profesor> getListUniversidadProfesores() {
        return listUniversidadProfesores;
    }

    public void setListUniversidadProfesores(List<Profesor> listUniversidadProfesores) {
        this.listUniversidadProfesores = listUniversidadProfesores;
    }

    @Override
    public String toString() {
        return "Universidad{" +
                "direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", numEstudiante=" + numEstudiante +
                ", cantProfesores=" + cantProfesores +
                ", tipoUniversidad='" + tipoUniversidad + '\'' +
                ", listUniversidadCursos=" + listUniversidadCursos +
                ", listPersonas=" + listPersonas +
                ", listUniversidadProfesores=" + listUniversidadProfesores +
                '}';
    }
}
