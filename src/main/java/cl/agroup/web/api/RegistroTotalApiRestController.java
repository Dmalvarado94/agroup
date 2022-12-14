package cl.agroup.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.agroup.web.models.RegistroTotal;
import cl.agroup.web.services.RegistroTotalServicesImpl;




@RestController
public class RegistroTotalApiRestController {

	@Autowired // inyectar informacion del implement en este caso
	private RegistroTotalServicesImpl registroImpl;
	//localhost:9080/guardar/usuario
	@RequestMapping("/guardar/registro")
	//inyectando dependencias para hacer uso de metodos
	public RegistroTotal guardarRegistro(RegistroTotal registro) { //captura el cuerpo del mensaje del postman
		registroImpl.guardarRegistro(registro);
		return registroImpl.guardarRegistro(registro);
	}
	
	@RequestMapping("/eliminar/registro")
	//localhost:9080/eliminar/usuario
	public String eliminarUsuario(@RequestParam(value="id",required = false) Long id) {
		return registroImpl.eliminarRegistro(id);
	}
	
	public String actualizarUsuario(@RequestBody RegistroTotal registro) {
		if(registro.getId()!=null) {
			String mensaje=registroImpl.actualizarRegistro(registro);
			return mensaje;
		}
		return "No se actualiza ningun usuario";
	}
	
	@RequestMapping("/obtener/registro")
	public RegistroTotal obtenerRegistro(@RequestParam(value="id",required = false) Long id){
			return registroImpl.obtenerRegistro(id);		
	}
	
	@GetMapping("/listar/registros")
	public List<RegistroTotal> ListarRegistros(){
			return registroImpl.ListarRegistros();		
	}
}