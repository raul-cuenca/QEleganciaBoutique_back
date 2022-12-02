package pe.cuenca.service;

import java.util.List;

import pe.cuenca.dto.ProductoDTO;

public interface ProductoService {

	List<ProductoDTO> listar();

	ProductoDTO obtenerId(Integer id);

	void guardar(ProductoDTO a);

	void eliminar(Integer id);

	void actualizar(Integer id, ProductoDTO a);
	
}
