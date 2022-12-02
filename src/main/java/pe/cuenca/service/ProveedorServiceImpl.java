package pe.cuenca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cuenca.dto.ProveedorDTO;
import pe.cuenca.model.Proveedor;
import pe.cuenca.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository repository;

	@Override
	public List<ProveedorDTO> listar() {

		List<ProveedorDTO> listadto = new ArrayList<>();
		ProveedorDTO dto = null;

		for (Proveedor proveedor : repository.findAll()) {

			dto = new ProveedorDTO();

			dto.setIdProveedor(proveedor.getIdProveedor());
			dto.setNombre(proveedor.getNombre());
			dto.setNroDocumento(proveedor.getNroDocumento());
			dto.setContacto(proveedor.getContacto());
			dto.setTelefono(proveedor.getTelefono());
			dto.setCorreo(proveedor.getCorreo());
			dto.setDireccion(proveedor.getDireccion());
			dto.setFoto(proveedor.getFoto());
			dto.setEstado(proveedor.getEstado());

			listadto.add(dto);
		}

		return listadto;
	}

	@Override
	public ProveedorDTO obtenerId(Integer id) {

		Proveedor proveedor = repository.findById(id).orElse(null);
		ProveedorDTO dto = new ProveedorDTO();

		dto.setIdProveedor(proveedor.getIdProveedor());
		dto.setNombre(proveedor.getNombre());
		dto.setNroDocumento(proveedor.getNroDocumento());
		dto.setContacto(proveedor.getContacto());
		dto.setTelefono(proveedor.getTelefono());
		dto.setCorreo(proveedor.getCorreo());
		dto.setDireccion(proveedor.getDireccion());
		dto.setFoto(proveedor.getFoto());
		dto.setEstado(proveedor.getEstado());

		return dto;

	}

	@Override
	public void guardar(ProveedorDTO dto) {

		Proveedor proveedor = new Proveedor();

		proveedor.setIdProveedor(dto.getIdProveedor());
		proveedor.setNombre(dto.getNombre());
		proveedor.setNroDocumento(dto.getNroDocumento());
		proveedor.setContacto(dto.getContacto());
		proveedor.setTelefono(dto.getTelefono());
		proveedor.setCorreo(dto.getCorreo());
		proveedor.setDireccion(dto.getDireccion());
		proveedor.setFoto(dto.getFoto());
		proveedor.setEstado(dto.getEstado());

		repository.save(proveedor);

	}

	@Override
	public void eliminar(Integer id) {

		ProveedorDTO dto = obtenerId(id);

		Proveedor proveedor = new Proveedor();

		proveedor.setIdProveedor(id);
		proveedor.setNombre(dto.getNombre());
		proveedor.setNroDocumento(dto.getNroDocumento());
		proveedor.setContacto(dto.getContacto());
		proveedor.setTelefono(dto.getTelefono());
		proveedor.setCorreo(dto.getCorreo());
		proveedor.setDireccion(dto.getDireccion());
		proveedor.setFoto(dto.getFoto());
		proveedor.setEstado(false);

		repository.saveAndFlush(proveedor);

	}

	@Override
	public void actualizar(Integer id, ProveedorDTO dto) {

		Proveedor proveedor = new Proveedor();

		proveedor.setIdProveedor(id);
		proveedor.setNombre(dto.getNombre());
		proveedor.setNroDocumento(dto.getNroDocumento());
		proveedor.setContacto(dto.getContacto());
		proveedor.setTelefono(dto.getTelefono());
		proveedor.setCorreo(dto.getCorreo());
		proveedor.setDireccion(dto.getDireccion());
		proveedor.setFoto(dto.getFoto());
		proveedor.setEstado(dto.getEstado());

		repository.saveAndFlush(proveedor);

	}

}
