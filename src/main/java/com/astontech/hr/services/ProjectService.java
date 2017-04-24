package com.astontech.hr.services;

import com.astontech.hr.domain.Project;

/**
 * Created by Julian.Chatterton on 4/18/2017.
 */
public interface ProjectService {

    Iterable<Project> listAllProjects();

    Project getProjectById(Integer id);

    Project saveProject(Project project);

    Iterable<Project> saveProjectList(Iterable<Project> projectIterable);

    void deleteEmployee(Integer id);


}
