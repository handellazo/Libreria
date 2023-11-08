package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.dto.AlquilerDto;
import pe.edu.upeu.libreria.entity.AlquilerEntity;
import pe.edu.upeu.libreria.entity.LectorEntity;
import pe.edu.upeu.libreria.entity.LibroEntity;
import pe.edu.upeu.libreria.repository.AlquilerInterface;
import pe.edu.upeu.libreria.repository.LectorInterface;
import pe.edu.upeu.libreria.repository.LibroInterface;
import pe.edu.upeu.libreria.service.AlquilerService;

import java.util.List;
@Service
public class AlquilerServiceImpl implements AlquilerService {
    @Autowired
    private AlquilerInterface alquilerInterface;

    @Autowired //Verificar que exista el libro
    private LibroInterface libroInterface;

    @Autowired //Verificar que exista el Lector
    private LectorInterface lectorInterface;

    //Inicializacion de los objetos
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
    public AlquilerEntity guardarAlquiler(AlquilerDto alquilerDto) {
        LibroEntity libroEncontrado = libroInterface.findById(alquilerDto.getId_asin()).orElse(null);
        LectorEntity lectorEncontrado = lectorInterface.findById(alquilerDto.getDni_lector()).orElse(null);

        AlquilerEntity nuevoAlquiler = new AlquilerEntity();
        nuevoAlquiler.setAlquiler(alquilerDto.getAlquiler());
        nuevoAlquiler.setId_asin(libroEncontrado);
        nuevoAlquiler.setEntrada(alquilerDto.getEntrada());
        nuevoAlquiler.setSalida(alquilerDto.getSalida());
        nuevoAlquiler.setDni_lector(lectorEncontrado);
        return alquilerInterface.save(nuevoAlquiler);
    }

    @Override
    public AlquilerEntity editarAlquiler(int id, AlquilerDto alquilerDto) {
        AlquilerEntity alquilerEncontrado = alquilerInterface.findById(id).orElse(null);
        LibroEntity libroEncontrado = libroInterface.findById(alquilerDto.getId_asin()).orElse(null);
        LectorEntity lectorEncontrado = lectorInterface.findById(alquilerDto.getDni_lector()).orElse(null);

        if (alquilerEncontrado != null){
            alquilerEncontrado.setAlquiler(alquilerDto.getAlquiler());
            alquilerEncontrado.setId_asin(libroEncontrado);
            alquilerEncontrado.setEntrada(alquilerDto.getEntrada());
            alquilerEncontrado.setSalida(alquilerDto.getSalida());
            alquilerEncontrado.setDni_lector(lectorEncontrado);
            return alquilerInterface.save(alquilerEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarAlquiler(int id) {
        alquilerInterface.deleteById(id);
    }
}
