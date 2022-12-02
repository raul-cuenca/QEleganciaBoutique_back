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

import pe.cuenca.dto.CategoriaDTO;
import pe.cuenca.service.CategoriaService;

@Controller
@RequestMapping("/api/categorias/v1")
public class CategoriaController {

	@Autowired
	private CategoriaService servicio;

	@GetMapping("/listar")
	public @ResponseBody List<CategoriaDTO> listar() {
		return servicio.listar();
	}

	@GetMapping("/listar/{id}")
	public @ResponseBody CategoriaDTO obtenerId(@PathVariable Integer id) {
		return servicio.obtenerId(id);
	}

	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody CategoriaDTO dto) {
		servicio.guardar(dto);
	}

	@PutMapping("/actualizar/{id}")
	public @ResponseBody void actualizar(@PathVariable Integer id, @RequestBody CategoriaDTO dto) {
		servicio.actualizar(id, dto);
	}

	@PutMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		servicio.eliminar(id);
	}

}
