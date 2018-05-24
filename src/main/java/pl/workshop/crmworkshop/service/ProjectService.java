package pl.workshop.crmworkshop.service;


import pl.workshop.crmworkshop.entity.Project;

import java.util.List;

public interface ProjectService {

    Project findFirstByIdent (String ident);

    List<Project> findTop5ByOrderByCreatedDesc ();

    List<Project> findAll();


}
