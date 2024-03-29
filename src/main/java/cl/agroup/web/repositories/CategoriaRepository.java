package cl.agroup.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.agroup.web.models.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
