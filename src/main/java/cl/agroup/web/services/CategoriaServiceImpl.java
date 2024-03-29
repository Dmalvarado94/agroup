package cl.agroup.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.agroup.web.models.Categoria;
import cl.agroup.web.repositories.CategoriaRepository;




@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Categoria guardarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public String eliminarCategoria(Long id) {
		Boolean existe = categoriaRepository.existsById(id);
		if(existe) {
		categoriaRepository.deleteById(id);
		}else {
			return "La categoria no existe";
		}
			
		return "Categoria eliminada";
	}

	@Override
	public String actualizarCategoria(Categoria categoria) {
		Boolean existe = categoriaRepository.existsById(categoria.getId());
		if (existe) {
			categoriaRepository.save(categoria);
			return "Categoria actualizada";
		}
		return "Categoria no actualizada";
	}

	@Override
	public Categoria obtenerCategoria(Long id) {
		return categoriaRepository.findById(id).get();
	}

	@Override
	public List<Categoria> listaCategoria() {
		return categoriaRepository.findAll();
	}
	
	@Override
	public Categoria editarCategoria(Long id, Categoria categoria) {
		Optional<Categoria> categoriaParaEditar = categoriaRepository.findById(id);
		Categoria categoriaEditado = categoriaParaEditar.get();
		categoriaEditado.setNombreCategoria(categoria.getNombreCategoria());
		categoriaEditado.setValorCaja(categoria.getValorCaja());
		categoriaEditado.setCantidadCajas(categoria.getCantidadCajas());
		categoriaRepository.save(categoriaEditado);
		return categoriaEditado;
	}


}
