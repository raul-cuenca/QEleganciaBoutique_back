package pe.cuenca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cuenca.dto.CategoriaDTO;
import pe.cuenca.model.Categoria;
import pe.cuenca.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public List<CategoriaDTO> listar() {

		List<CategoriaDTO> listadto = new ArrayList<>();
		CategoriaDTO dto = null;

		for (Categoria categoria : repository.findAll()) {

			dto = new CategoriaDTO();

			dto.setIdCategoria(categoria.getIdCategoria());
			dto.setNombre(categoria.getNombre());
			dto.setFoto(categoria.getFoto());
			dto.setEstado(categoria.getEstado());

			listadto.add(dto);
		}

		return listadto;
	}

	@Override
	public CategoriaDTO obtenerId(Integer id) {

		Categoria categoria = repository.findById(id).orElse(null);
		CategoriaDTO dto = new CategoriaDTO();

		dto.setIdCategoria(categoria.getIdCategoria());
		dto.setNombre(categoria.getNombre());
		dto.setFoto(categoria.getFoto());
		dto.setEstado(categoria.getEstado());

		return dto;

	}

	@Override
	public void guardar(CategoriaDTO dto) {

		Categoria categoria = new Categoria();

		categoria.setIdCategoria(dto.getIdCategoria());
		categoria.setNombre(dto.getNombre());
		categoria.setFoto(dto.getFoto());
		categoria.setEstado(dto.getEstado());

		repository.save(categoria);

	}

	@Override
	public void eliminar(Integer id) {

		CategoriaDTO dto = obtenerId(id);

		Categoria categoria = new Categoria();

		categoria.setIdCategoria(id);
		categoria.setNombre(dto.getNombre());
		categoria.setFoto(dto.getFoto());
		categoria.setEstado(false);

		repository.saveAndFlush(categoria);

	}

	@Override
	public void actualizar(Integer id, CategoriaDTO dto) {

		Categoria categoria = new Categoria();

		categoria.setIdCategoria(id);
		categoria.setNombre(dto.getNombre());
		categoria.setFoto(dto.getFoto());
		categoria.setEstado(dto.getEstado());

		repository.saveAndFlush(categoria);

	}

}
