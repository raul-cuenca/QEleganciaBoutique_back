package pe.cuenca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.cuenca.dto.ClienteDTO;
import pe.cuenca.service.ClienteService;

@Controller
@RequestMapping("/api/clientes/v1")
public class ClienteController {

	@Autowired
	private ClienteService servicio;

	@GetMapping("/listar")
	public @ResponseBody List<ClienteDTO> listar() {
		return servicio.listar();
	}

	@GetMapping("/listar/{id}")
	public @ResponseBody ClienteDTO obtenerId(@PathVariable Integer id) {
		return servicio.obtenerId(id);
	}

	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody ClienteDTO dto) {
		servicio.guardar(dto);
	}

	@PutMapping("/actualizar/{id}")
	public @ResponseBody void actualizar(@PathVariable Integer id, @RequestBody ClienteDTO dto) {
		servicio.actualizar(id, dto);
	}

	@PutMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		servicio.eliminar(id);
	}

}
