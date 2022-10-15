package pe.com.sistema.microservicios.app.examenes.controllers;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.com.sistema.microservicios.app.examenes.models.entity.Examen;
import pe.com.sistema.microservicios.app.examenes.services.ExamenService;
import pe.com.sistema.microservicios.commons.controllers.CommonController;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id){
		Optional<Examen> o = service.findById(id);
		
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Examen examenDB = o.get();
		examenDB.setNombre(examen.getNombre());
		
		examenDB.getPreguntas()
		.stream()
		.filter(pdb -> !examen.getPreguntas().contains(pdb))
		.forEach(examenDB::removePregunta);
		
		examenDB.setPreguntas(examen.getPreguntas());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDB));
	}
	
}
