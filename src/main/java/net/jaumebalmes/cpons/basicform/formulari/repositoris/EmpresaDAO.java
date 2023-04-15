package net.jaumebalmes.cpons.basicform.formulari.repositoris;

import net.jaumebalmes.cpons.basicform.formulari.entitats.Alumne;
import net.jaumebalmes.cpons.basicform.formulari.entitats.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "empreses", path = "empreses")
public interface EmpresaDAO extends JpaRepository<Empresa, Long> {

    boolean existsByCif(String cif);

}
