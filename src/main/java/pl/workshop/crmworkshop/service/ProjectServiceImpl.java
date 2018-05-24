package pl.workshop.crmworkshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workshop.crmworkshop.entity.Project;
import pl.workshop.crmworkshop.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project findFirstByIdent(String ident) {
        return projectRepository.findFirstByIdent(ident);
    }

    @Override
    public List<Project> findTop5ByOrderByCreatedDesc() {
        return projectRepository.findTop5ByIfActiveTrueOrderByCreatedDesc();
    }
}
