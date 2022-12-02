package pe.cuenca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.cuenca.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
