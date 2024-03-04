package clase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private Long totalDeVentas;
    private String estado;


    public Cliente() {
        this.totalDeVentas = 0L;
        this.estado = "activo";
    }

    public Cliente( String nombre, Long totalDeVentas, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.totalDeVentas = totalDeVentas;
        this.estado = estado;
    }

    public Cliente(String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.totalDeVentas = 0L;
        this.estado = estado;
    }
    public Cliente(String nombre, Long totalDeVentas) {
        this.id = id;
        this.nombre = nombre;
        this.totalDeVentas = totalDeVentas;
        this.estado = "activo";
    }
    public Cliente(String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.totalDeVentas = 0L;
        this.estado = "activo";
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getTotalDeVentas() {
        return totalDeVentas;
    }

    public void setTotalDeVentas(Long totalDeVentas) {
        this.totalDeVentas = totalDeVentas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ventas totales=" + totalDeVentas +
                ", estado='" + estado + '\'' +
                '}';
    }
}
