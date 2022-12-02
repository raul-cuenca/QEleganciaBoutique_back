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

import pe.cuenca.dto.ProductoDTO;
import pe.cuenca.service.ProductoService;

@Controller
@RequestMapping("/api/productos/v1")
public class ProductoController {

	@Autowired
	private ProductoService servicio;

	@GetMapping("/listar")
	public @ResponseBody List<ProductoDTO> listar() {
		return servicio.listar();
	}

	@GetMapping("/listar/{id}")
	public @ResponseBody ProductoDTO obtenerId(@PathVariable Integer id) {
		return servicio.obtenerId(id);
	}

	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody ProductoDTO dto) {
		servicio.guardar(dto);
	}

	@PutMapping("/actualizar/{id}")
	public @ResponseBody void actualizar(@PathVariable Integer id, @RequestBody ProductoDTO dto) {
		servicio.actualizar(id, dto);
	}

	@PutMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		servicio.eliminar(id);
	}

}
