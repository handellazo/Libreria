package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.dto.LectorDto;
import pe.edu.upeu.libreria.entity.LectorEntity;

import java.util.List;

public interface LectorService {
    List<LectorEntity> lectorListar();
    LectorEntity buscarLectorPorID(int dnilector);
    LectorEntity guardarLector(LectorDto lectorDto);
    LectorEntity editarLector(int dnilector, LectorDto lectorDto);
    void eliminarLector(int dnilector);
}
