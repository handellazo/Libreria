package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
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
    public LectorEntity guardarLector(LectorEntity lectorEntity) {
        try {
            LectorEntity nuevoLector = new LectorEntity();
            nuevoLector.setDnilector(lectorEntity.getDnilector());
            nuevoLector.setNombre(lectorEntity.getNombre());
            nuevoLector.setTelefono(lectorEntity.getTelefono());
            nuevoLector.setDireccion(lectorEntity.getDireccion());
            nuevoLector.setCodigopostal(lectorEntity.getCodigopostal());
            nuevoLector.setObservaciones(lectorEntity.getObservaciones());
            return lectorInterface.save(nuevoLector);
        } catch (DataIntegrityViolationException e){
            throw new IllegalArgumentException("Se repite el Dni pe causa: " + e);
        }
    }

    @Override
    public LectorEntity editarLector(int dnilector, LectorEntity lectorEntity) {
        LectorEntity lectorEncontrado = lectorInterface.findById(dnilector).orElse(null);
        if (lectorEncontrado != null){
            lectorEncontrado.setNombre(lectorEntity.getNombre());
            lectorEncontrado.setTelefono(lectorEntity.getTelefono());
            lectorEncontrado.setDireccion(lectorEntity.getDireccion());
            lectorEncontrado.setCodigopostal(lectorEntity.getCodigopostal());
            lectorEncontrado.setObservaciones(lectorEntity.getObservaciones());

            return lectorInterface.save(lectorEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarLector(int dnilector) {
        lectorInterface.deleteById(dnilector);
    }
}
