package pl.workshop.crmworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.workshop.crmworkshop.entity.Priority;
import pl.workshop.crmworkshop.entity.Project;

import java.util.List;


public interface PriorityRepository extends JpaRepository<Priority, Long> {



}
