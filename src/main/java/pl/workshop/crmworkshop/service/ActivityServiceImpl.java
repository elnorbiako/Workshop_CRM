package pl.workshop.crmworkshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workshop.crmworkshop.entity.Activity;
import pl.workshop.crmworkshop.repository.ActivityRepository;
import pl.workshop.crmworkshop.repository.RoleRepository;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    @Override
    public List<Activity> findTop25ByOrderByTimeDesc() {
        return activityRepository.findTop25ByOrderByTimeDesc();
    }
}
