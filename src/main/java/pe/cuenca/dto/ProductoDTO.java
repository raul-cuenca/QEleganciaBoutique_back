package pe.cuenca.dto;

import lombok.Data;

@Data
public class ProductoDTO {

	private Integer idProducto;

	private String nombre;
	private String descripcion;
	private Double precioCompra;
	private Double precioVenta;
	private Integer stock;
	private String foto;
	private Boolean estado;
}
