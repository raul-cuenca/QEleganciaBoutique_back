package pe.cuenca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.cuenca.dto.ClienteDTO;
import pe.cuenca.model.Cliente;
import pe.cuenca.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public List<ClienteDTO> listar() {

		List<ClienteDTO> listadto = new ArrayList<>();
		ClienteDTO dto = null;

		for (Cliente cliente : repository.findAll()) {

			dto = new ClienteDTO();

			dto.setIdCliente(cliente.getIdCliente());
			dto.setNombre(cliente.getNombre());
			dto.setNroDocumento(cliente.getNroDocumento());
			dto.setContacto(cliente.getContacto());
			dto.setTelefono(cliente.getTelefono());
			dto.setCorreo(cliente.getCorreo());
			dto.setDireccion(cliente.getDireccion());
			dto.setFoto(cliente.getFoto());
			dto.setEstado(cliente.getEstado());

			listadto.add(dto);
		}

		return listadto;
	}

	@Override
	public ClienteDTO obtenerId(Integer id) {

		Cliente cliente = repository.findById(id).orElse(null);
		ClienteDTO dto = new ClienteDTO();

		dto.setIdCliente(cliente.getIdCliente());
		dto.setNombre(cliente.getNombre());
		dto.setNroDocumento(cliente.getNroDocumento());
		dto.setContacto(cliente.getContacto());
		dto.setTelefono(cliente.getTelefono());
		dto.setCorreo(cliente.getCorreo());
		dto.setDireccion(cliente.getDireccion());
		dto.setFoto(cliente.getFoto());
		dto.setEstado(cliente.getEstado());

		return dto;

	}

	@Override
	public void guardar(ClienteDTO dto) {

		Cliente cliente = new Cliente();

		cliente.setIdCliente(dto.getIdCliente());
		cliente.setNombre(dto.getNombre());
		cliente.setNroDocumento(dto.getNroDocumento());
		cliente.setContacto(dto.getContacto());
		cliente.setTelefono(dto.getTelefono());
		cliente.setCorreo(dto.getCorreo());
		cliente.setDireccion(dto.getDireccion());
		cliente.setFoto(dto.getFoto());
		cliente.setEstado(dto.getEstado());

		repository.save(cliente);

	}

	@Override
	public void eliminar(Integer id) {

		ClienteDTO dto = obtenerId(id);

		Cliente cliente = new Cliente();

		cliente.setIdCliente(id);
		cliente.setNombre(dto.getNombre());
		cliente.setNroDocumento(dto.getNroDocumento());
		cliente.setContacto(dto.getContacto());
		cliente.setTelefono(dto.getTelefono());
		cliente.setCorreo(dto.getCorreo());
		cliente.setDireccion(dto.getDireccion());
		cliente.setFoto(dto.getFoto());
		cliente.setEstado(false);

		repository.saveAndFlush(cliente);

	}

	@Override
	public void actualizar(Integer id, ClienteDTO dto) {

		Cliente cliente = new Cliente();

		cliente.setIdCliente(id);
		cliente.setNombre(dto.getNombre());
		cliente.setNroDocumento(dto.getNroDocumento());
		cliente.setContacto(dto.getContacto());
		cliente.setTelefono(dto.getTelefono());
		cliente.setCorreo(dto.getCorreo());
		cliente.setDireccion(dto.getDireccion());
		cliente.setFoto(dto.getFoto());
		cliente.setEstado(dto.getEstado());

		repository.saveAndFlush(cliente);

	}

}
