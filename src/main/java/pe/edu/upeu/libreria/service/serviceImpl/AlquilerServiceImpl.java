package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.entity.AlquilerEntity;
import pe.edu.upeu.libreria.repository.AlquilerInterface;
import pe.edu.upeu.libreria.service.AlquilerService;

import java.util.List;
@Service
public class AlquilerServiceImpl implements AlquilerService {
    @Autowired
    private AlquilerInterface alquilerInterface;

    @Override
    public List<AlquilerEntity> alquilerListar() {
        return alquilerInterface.findAll();
    }

    @Override
    public AlquilerEntity buscarAlquilerPorID(int id) {
        return alquilerInterface.findById(id)
                .orElseThrow(null);
    }

    @Override
    public AlquilerEntity guardarAlquiler(AlquilerEntity alquilerEntity) {
        AlquilerEntity nuevoAlquiler = new AlquilerEntity();
        nuevoAlquiler.setAlquiler(alquilerEntity.getAlquiler());
        nuevoAlquiler.setLibro(alquilerEntity.getLibro());
        nuevoAlquiler.setEntrada(alquilerEntity.getEntrada());
        nuevoAlquiler.setSalida(alquilerEntity.getSalida());
        nuevoAlquiler.setId_lector(alquilerEntity.getId_lector());
        return alquilerInterface.save(nuevoAlquiler);
    }

    @Override
    public AlquilerEntity editarAlquiler(int id, AlquilerEntity alquilerEntity) {
        AlquilerEntity alquilerEncontrado = alquilerInterface.findById(id).orElse(null);
        if (alquilerEncontrado != null){
            alquilerEncontrado.setAlquiler(alquilerEntity.getAlquiler());
            alquilerEncontrado.setLibro(alquilerEntity.getLibro());
            alquilerEncontrado.setEntrada(alquilerEntity.getEntrada());
            alquilerEncontrado.setSalida(alquilerEntity.getSalida());
            alquilerEncontrado.setId_lector(alquilerEntity.getId_lector());
            return alquilerInterface.save(alquilerEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarAlquiler(int id) {
        alquilerInterface.deleteById(id);
    }
}
