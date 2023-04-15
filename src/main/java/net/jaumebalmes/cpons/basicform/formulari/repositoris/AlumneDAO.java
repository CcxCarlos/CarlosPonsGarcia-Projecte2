package net.jaumebalmes.cpons.basicform.formulari.repositoris;

import net.jaumebalmes.cpons.basicform.formulari.entitats.Alumne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "alumnes", path = "alumnes")
public interface AlumneDAO extends JpaRepository<Alumne, Long> {
    boolean existsByDni(String dni);
}
