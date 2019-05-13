package repository;

import model.Project;
import model.Sensor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository extends BaseRepository {
    public List<Project> getProjectList(){
        List<Project> projectList = new ArrayList<>();
        ArrayList<Object> parameters = new ArrayList<>();
        this.setQuery("select * from Projects where status = ?");
        parameters.add(1);
        this.runQuery(parameters);
        try {
            while (this.resultSet.next()){
                Project project = new Project();
                project.setId(this.resultSet.getLong("id"));
                project.setName(this.resultSet.getString("name"));
                project.setCreateDate(this.resultSet.getDate("created_time"));
                project.setPlanImage(this.resultSet.getBytes("plan_image"));
                projectList.add(project);
            }
        }catch (SQLException e){
            e.printStackTrace();
            e.getSQLState();
        }finally {
            this.cleanResources();
        }
        return projectList;
    }

    public Project getSpecificProject(Long id){
        Project project = new Project();
        ArrayList<Object> parameters = new ArrayList<>();
        this.setQuery("select * from Projects where status = ? and id = ?");
        parameters.add(1);
        parameters.add(id);
        this.runQuery(parameters);
        try {
            if (this.resultSet.next()){
                project.setId(this.resultSet.getLong("id"));
                project.setName(this.resultSet.getString("name"));
                project.setCreateDate(this.resultSet.getDate("created_time"));
                project.setPlanImage(this.resultSet.getBytes("plan_image"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.cleanResources();
        }
        parameters = new ArrayList<>();
        this.setQuery("select * from Sensors where project_id = ? ");
        parameters.add(id);
        this.runQuery(parameters);
        List<Sensor> sensorList = new ArrayList<>();
        try {
            while (this.resultSet.next()){
                Sensor sensor = new Sensor();
                sensor.setId(this.resultSet.getLong("id"));
                sensor.setLabel(this.resultSet.getString("name"));
                sensor.setLevel(this.resultSet.getString("level"));
                sensor.setxLocation(this.resultSet.getDouble("x_location"));
                sensor.setyLocation(this.resultSet.getDouble("y_location"));
                sensorList.add(sensor);
            }
            project.setSensorList(sensorList);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.cleanResources();
        }
        return project;
    }

    public boolean deleteProject(Long id){
        ArrayList<Object> parameters = new ArrayList<>();
        this.setQuery("update Project set status = 0 where project_id = ?");
        parameters.add(id);
        this.runQuery(parameters);
        return this.resultForExecuteUpdate == 1;
    }

    public boolean addNewProject(Project project){
        ArrayList<Object> parameters = new ArrayList<>();
        this.setQuery("");
        this.runQuery(parameters);
        return true;
    }

    public boolean updateProject(Project project){
        ArrayList<Object> parameters = new ArrayList<>();
        this.setQuery("update Project set ???? where project_id = ?");
        this.runQuery(parameters);
        return this.resultForExecuteUpdate == 1;
    }
}
