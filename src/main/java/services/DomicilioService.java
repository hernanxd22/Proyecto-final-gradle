package services;

import dao.DomicilioDAO;
import org.example.entities.Domicilio;

import java.sql.SQLException;
import java.util.List;

public class DomicilioService implements GenericService<Domicilio> {

    private final DomicilioDAO domicilioDAO;

    public DomicilioService(DomicilioDAO domicilioDAO) {
        this.domicilioDAO = domicilioDAO;
    }

    @Override
    public void guardar(Domicilio domicilio) throws SQLException {
        validar(domicilio);
        domicilioDAO.guardar(domicilio);
    }

    @Override
    public void actualizar(Domicilio domicilio) throws SQLException {
        validar(domicilio);
        domicilioDAO.actualizar(domicilio);
    }

    @Override
    public void eliminar(long id) throws SQLException {
        domicilioDAO.eliminar(id);
    }

    @Override
    public Domicilio buscarPorId(long id) throws SQLException {
        return domicilioDAO.buscarPorId(id);
    }

    @Override
    public List<Domicilio> buscarTodos() throws SQLException {
        return domicilioDAO.buscarTodos();
    }

    private void validar(Domicilio domicilio) {
        if (domicilio.getCalle() == null || domicilio.getCalle().isEmpty()) {
            throw new IllegalArgumentException("La calle no puede ser vacía");
        }
        if (domicilio.getNumero() == null || domicilio.getNumero() <= 0) {
            throw new IllegalArgumentException("El número debe ser mayor que 0");
        }
    }
}

