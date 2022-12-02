package pe.cuenca.service;

import java.util.List;

import pe.cuenca.dto.ClienteDTO;

public interface ClienteService {

	List<ClienteDTO> listar();

	ClienteDTO obtenerId(Integer id);

	void guardar(ClienteDTO a);

	void eliminar(Integer id);

	void actualizar(Integer id, ClienteDTO a);

}
