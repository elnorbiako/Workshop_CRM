package pl.workshop.crmworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.workshop.crmworkshop.entity.Project;
import pl.workshop.crmworkshop.entity.Role;
import pl.workshop.crmworkshop.entity.User;

import java.util.List;
import java.util.Set;


public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query ("select p from Project p where p.indentificator = :ident")
    Project findFirstByIdent (String ident);

    List<Project> findTop5ByOrderByCreatedDesc ();


}
