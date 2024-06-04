package org.mywire.temiroapp.model;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("productId")
    private int idproducto;

    @SerializedName("Descripcion")
    private String descripcion;

    @SerializedName("idtipoproducto")
    private int idtipoproducto;

    @SerializedName("Preciocosto")
    private int preciocosto;

    @SerializedName("Precio")
    private int precio;

    @SerializedName("Fechaingreso")
    private String fechaingreso;

    @SerializedName("ProductDetalle")
    private String detalle;

    @SerializedName("ProductDescripcion")
    private String especificaciones;

    @SerializedName("ProductImage")
    private String imagen;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdtipoproducto() {
        return idtipoproducto;
    }

    public void setIdtipoproducto(int idtipoproducto) {
        this.idtipoproducto = idtipoproducto;
    }

    public int getPreciocosto() {
        return preciocosto;
    }

    public void setPreciocosto(int preciocosto) {
        this.preciocosto = preciocosto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}