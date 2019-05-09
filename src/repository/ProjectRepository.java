package repository;

import model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    public List<Project> getProjectList(){

        return new ArrayList<>();
    }

    public Project getSpecificProject(Long id){

        return new Project();
    }

    public boolean deleteProject(Project project){

        return true;
    }

    public boolean addNewProject(Project project){

        return true;
    }

    public boolean updateProject(Project project){

        return true;
    }
}
