package pe.cuenca.service;

import java.util.List;

import pe.cuenca.dto.ProveedorDTO;

public interface ProveedorService {

	List<ProveedorDTO> listar();

	ProveedorDTO obtenerId(Integer id);

	void guardar(ProveedorDTO a);

	void eliminar(Integer id);

	void actualizar(Integer id, ProveedorDTO a);
	
}
