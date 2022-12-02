package pe.cuenca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cuenca.dto.ProductoDTO;
import pe.cuenca.model.Producto;
import pe.cuenca.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	public List<ProductoDTO> listar() {

		List<ProductoDTO> listadto = new ArrayList<>();
		ProductoDTO dto = null;

		for (Producto producto : repository.findAll()) {

			dto = new ProductoDTO();

			dto.setIdProducto(producto.getIdProducto());
			dto.setNombre(producto.getNombre());
			dto.setDescripcion(producto.getDescripcion());
			dto.setPrecioCompra(producto.getPrecioCompra());
			dto.setPrecioVenta(producto.getPrecioVenta());
			dto.setStock(producto.getStock());
			dto.setFoto(producto.getFoto());
			dto.setEstado(producto.getEstado());

			listadto.add(dto);
		}

		return listadto;
	}

	@Override
	public ProductoDTO obtenerId(Integer id) {

		Producto producto = repository.findById(id).orElse(null);
		ProductoDTO dto = new ProductoDTO();

		dto.setIdProducto(producto.getIdProducto());
		dto.setNombre(producto.getNombre());
		dto.setDescripcion(producto.getDescripcion());
		dto.setPrecioCompra(producto.getPrecioCompra());
		dto.setPrecioVenta(producto.getPrecioVenta());
		dto.setStock(producto.getStock());
		dto.setFoto(producto.getFoto());
		dto.setEstado(producto.getEstado());

		return dto;

	}

	@Override
	public void guardar(ProductoDTO dto) {

		Producto producto = new Producto();

		producto.setIdProducto(dto.getIdProducto());
		producto.setNombre(dto.getNombre());
		producto.setDescripcion(dto.getDescripcion());
		producto.setPrecioCompra(dto.getPrecioCompra());
		producto.setPrecioVenta(dto.getPrecioVenta());
		producto.setStock(dto.getStock());
		producto.setFoto(dto.getFoto());
		producto.setEstado(dto.getEstado());

		repository.save(producto);

	}

	@Override
	public void eliminar(Integer id) {

		ProductoDTO dto = obtenerId(id);

		Producto producto = new Producto();

		producto.setIdProducto(id);
		producto.setNombre(dto.getNombre());
		producto.setDescripcion(dto.getDescripcion());
		producto.setPrecioCompra(dto.getPrecioCompra());
		producto.setPrecioVenta(dto.getPrecioVenta());
		producto.setStock(dto.getStock());
		producto.setFoto(dto.getFoto());
		producto.setEstado(false);

		repository.saveAndFlush(producto);

	}

	@Override
	public void actualizar(Integer id, ProductoDTO dto) {

		Producto producto = new Producto();

		producto.setIdProducto(id);
		producto.setNombre(dto.getNombre());
		producto.setDescripcion(dto.getDescripcion());
		producto.setPrecioCompra(dto.getPrecioCompra());
		producto.setPrecioVenta(dto.getPrecioVenta());
		producto.setStock(dto.getStock());
		producto.setFoto(dto.getFoto());
		producto.setEstado(dto.getEstado());

		repository.saveAndFlush(producto);
	}

}
