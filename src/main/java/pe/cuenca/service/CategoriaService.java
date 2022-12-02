package pe.cuenca.service;

import java.util.List;

import pe.cuenca.dto.CategoriaDTO;

public interface CategoriaService {

	List<CategoriaDTO> listar();

	CategoriaDTO obtenerId(Integer id);

	void guardar(CategoriaDTO a);

	void eliminar(Integer id);

	void actualizar(Integer id, CategoriaDTO a);

}
