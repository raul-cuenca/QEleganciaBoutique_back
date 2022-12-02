package pe.cuenca.dto;

import lombok.Data;

@Data
public class ProveedorDTO {

	private Integer idProveedor;

	private String nombre;
	private String nroDocumento;
	private String contacto;
	private String telefono;
	private String correo;
	private String direccion;
	private String foto;
	private Boolean estado;
	
}
