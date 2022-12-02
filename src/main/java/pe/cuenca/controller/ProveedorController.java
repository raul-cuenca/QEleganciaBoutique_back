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

import pe.cuenca.dto.ProveedorDTO;
import pe.cuenca.service.ProveedorService;

@Controller
@RequestMapping("/api/proveedores/v1")
public class ProveedorController {
	
	@Autowired
	private ProveedorService servicio;

	@GetMapping("/listar")
	public @ResponseBody List<ProveedorDTO> listar() {
		return servicio.listar();
	}

	@GetMapping("/listar/{id}")
	public @ResponseBody ProveedorDTO obtenerId(@PathVariable Integer id) {
		return servicio.obtenerId(id);
	}

	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody ProveedorDTO dto) {
		servicio.guardar(dto);
	}

	@PutMapping("/actualizar/{id}")
	public @ResponseBody void actualizar(@PathVariable Integer id, @RequestBody ProveedorDTO dto) {
		servicio.actualizar(id, dto);
	}

	@PutMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		servicio.eliminar(id);
	}

}
