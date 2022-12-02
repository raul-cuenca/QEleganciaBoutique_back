package pe.cuenca.dto;

import lombok.Data;

@Data
public class ClienteDTO {
	
	private Integer idCliente;

	private String nombre;
	private String nroDocumento;
	private String contacto;
	private String telefono;
	private String correo;
	private String direccion;
	private String foto;
	private Boolean estado;

}
