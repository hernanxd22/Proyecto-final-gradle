package services;

import dao.PersonaDAO;
import org.example.entities.Persona;

import java.sql.SQLException;
import java.util.List;

public class PersonaService implements GenericService<Persona> {

    private final PersonaDAO personaDAO;

    public PersonaService(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    @Override
    public void guardar(Persona persona) throws SQLException {
        validar(persona);
        personaDAO.guardar(persona);
    }

    @Override
    public void actualizar(Persona persona) throws SQLException {
        validar(persona);
        personaDAO.actualizar(persona);
    }

    @Override
    public void eliminar(long id) throws SQLException {
        personaDAO.eliminar(id);
    }

    @Override
    public Persona buscarPorId(long id) throws SQLException {
        return personaDAO.buscarPorId(id);
    }

    @Override
    public List<Persona> buscarTodos() throws SQLException {
        return personaDAO.buscarTodos();
    }

    private void validar(Persona persona) {
        if (persona.getNombre() == null || persona.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (persona.getDomicilio() == null) {
            throw new IllegalArgumentException("El domicilio es obligatorio");
        }
    }
}