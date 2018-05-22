package pl.workshop.crmworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.workshop.crmworkshop.entity.Project;
import pl.workshop.crmworkshop.entity.Task;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {



}
