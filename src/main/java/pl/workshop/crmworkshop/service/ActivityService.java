package pl.workshop.crmworkshop.service;


import pl.workshop.crmworkshop.entity.Activity;
import pl.workshop.crmworkshop.entity.Role;

import java.util.List;


public interface ActivityService {

    List<Activity> findTop25ByOrderByTimeDesc();
}
