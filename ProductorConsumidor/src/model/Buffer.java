/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author macbook
 */
public class Buffer {
    private int idProductor;
    private int idConsumidor;
    private String fechaConsumo;

    public Buffer() {
    }
    

    public Buffer(int idProductor, int idConsumidor, String fechaConsumo) {
        this.idProductor = idProductor;
        this.idConsumidor = idConsumidor;
        this.fechaConsumo = fechaConsumo;
    }

    public int getIdProductor() {
        return idProductor;
    }

    public void setIdProductor(int idProductor) {
        this.idProductor = idProductor;
    }

    public int getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(int idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public String getFechaConsumo() {
        return fechaConsumo;
    }

    public void setFechaConsumo(String fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }

    @Override
    public String toString() {
        return "Buffer{" + "idProductor=" + idProductor + ", idConsumidor=" + idConsumidor + ", fechaConsumo=" + fechaConsumo + '}';
    }
    
    
}
