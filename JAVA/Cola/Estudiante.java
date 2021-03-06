package JAVA.Cola;

public class Estudiante {
    private String nombres;
    private String apellidos;
    private String tipoIdentificacion;
    private int numeroIdentificacion;
    private String email;
    private String telefono;
    private String direccion;
    private String fechaNacimiento;
    private String fechaIngreso;
    private String fechaEgreso;
    private String estado;
    private int semestre;
    private String carrera;

    public Estudiante(String nombres, String apellidos, String tipoIdentificacion, int numeroIdentificacion,
            String email, String telefono, String direccion, String fechaNacimiento, String fechaIngreso,
            String fechaEgreso, String estado, int semestre, String carrera) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.estado = estado;
        this.semestre = semestre;
        this.carrera = carrera;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(String fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public String isActivo() {
        return estado;
    }

    public void setActivo(String estado) {
        this.estado = estado;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Nombres: " + nombres + "\nApellidos: " + apellidos + "\nTipo de Identificacion: "
                + tipoIdentificacion + "\nN??mero de "+tipoIdentificacion +": "+ numeroIdentificacion + "\nEmail: " + email
                + "\nTelefono: " + telefono + "\nDireccion: " + direccion + "\nFecha de nacimiento: " + fechaNacimiento
                + "\nFecha de ingreso: " + fechaIngreso + "\nFecha de egreso: " + fechaEgreso + "\nEstado: " + estado
                + "\nSemestre: " + semestre + "\nCarrera: " + carrera;
    }

    public String getFechaIngresoFormateada() {
        return fechaIngreso.substring(0, 4) + "-" + fechaIngreso.substring(4, 6) + "-" + fechaIngreso.substring(6, 8);
    }
}
