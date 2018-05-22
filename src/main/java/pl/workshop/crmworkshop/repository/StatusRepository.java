package pl.workshop.crmworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.workshop.crmworkshop.entity.Project;
import pl.workshop.crmworkshop.entity.Status;

import java.util.List;


public interface StatusRepository extends JpaRepository<Status, Long> {



}
