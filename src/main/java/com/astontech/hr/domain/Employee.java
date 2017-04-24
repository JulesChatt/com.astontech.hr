package com.astontech.hr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Julian.Chatterton on 4/18/2017.
 */

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee extends Person {

    private String background;

    @OneToMany
    private List<Project> projects;

    public Employee() {

    }

    public Employee(String background) {
        this.background = background;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
