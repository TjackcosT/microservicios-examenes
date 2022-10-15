package pe.com.sistema.microservicios.app.examenes.services;

import org.springframework.stereotype.Service;

import pe.com.sistema.microservicios.app.examenes.models.entity.Examen;
import pe.com.sistema.microservicios.app.examenes.models.repository.ExamenRepository;
import pe.com.sistema.microservicios.commons.service.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {
	
}
