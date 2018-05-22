package pl.workshop.crmworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.workshop.crmworkshop.entity.Activity;
import pl.workshop.crmworkshop.entity.Project;

import java.util.List;


public interface ActivityRepository extends JpaRepository<Activity, Long> {



    List<Activity> findTop25ByOrderByTimeDesc();


}
