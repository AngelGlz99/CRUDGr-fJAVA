package crudmaterias;

class Materia{
    private int clave;
    private String nombre;
    private String semestre;
    private int creditos;

    public Materia(int exp, String nombre, String sexo,int creditos) {
        this.clave = exp;
        this.nombre = nombre;
        this.semestre = sexo;
        this.creditos=creditos;
    }

    
    public int getClave() {
        return clave;
    }

    public void setClave(int exp) {
        this.clave = exp;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String sexo) {
        this.semestre = sexo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    
    
    @Override
    public String toString() {
        return this.nombre;
    }

}
