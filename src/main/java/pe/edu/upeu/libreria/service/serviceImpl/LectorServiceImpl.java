package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.dto.LectorDto;
import pe.edu.upeu.libreria.entity.LectorEntity;
import pe.edu.upeu.libreria.repository.LectorInterface;
import pe.edu.upeu.libreria.service.LectorService;

import java.util.List;
@Service
public class LectorServiceImpl implements LectorService {
    @Autowired
    private LectorInterface lectorInterface;

    @Override
    public List<LectorEntity> lectorListar() {
        return lectorInterface.findAll();
    }

    @Override
    public LectorEntity buscarLectorPorID(int dnilector) {
        return lectorInterface.findById(dnilector)
                .orElse(null);
    }

    @Override
    public LectorEntity guardarLector(LectorDto lectorDto) {
        try {
            LectorEntity nuevoLector = new LectorEntity();
            nuevoLector.setDnilector(lectorDto.getDnilector());
            nuevoLector.setNombre(lectorDto.getNombre());
            nuevoLector.setTelefono(lectorDto.getTelefono());
            nuevoLector.setDireccion(lectorDto.getDireccion());
            nuevoLector.setCodigopostal(lectorDto.getCodigopostal());
            nuevoLector.setObservaciones(lectorDto.getObservaciones());
            return lectorInterface.save(nuevoLector);
        } catch (DataIntegrityViolationException e){
            throw new IllegalArgumentException("El DNI ya existe: " + e);
        }
    }

    @Override
    public LectorEntity editarLector(int dnilector, LectorDto lectorDto) {
        LectorEntity lectorEncontrado = lectorInterface.findById(dnilector).orElse(null);
        if (lectorEncontrado != null){
            lectorEncontrado.setNombre(lectorDto.getNombre());
            lectorEncontrado.setTelefono(lectorDto.getTelefono());
            lectorEncontrado.setDireccion(lectorDto.getDireccion());
            lectorEncontrado.setCodigopostal(lectorDto.getCodigopostal());
            lectorEncontrado.setObservaciones(lectorDto.getObservaciones());

            return lectorInterface.save(lectorEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarLector(int dnilector) {
        lectorInterface.deleteById(dnilector);
    }
}
