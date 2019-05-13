package repository;

import model.Sensor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SensorRepository extends BaseRepository {
    public List<Sensor> getSensorListByProjectId(Long projectId) {
        List<Sensor>      sensorList = new ArrayList<>();
        ArrayList<Object> parameters = new ArrayList<>();
        this.setQuery("select * from Sensors where status = ?");
        parameters.add(1);
        this.runQuery(parameters);
        try {
            while (this.resultSet.next()) {
                Sensor sensor = new Sensor();
                sensor.setId(this.resultSet.getLong("id"));
                sensor.setLabel(this.resultSet.getString("name"));
                sensor.setLabel(this.resultSet.getString("description"));
                sensor.setxLocation(this.resultSet.getDouble("x_location"));
                sensor.setyLocation(this.resultSet.getDouble("y_location"));
                sensor.setType(this.resultSet.getInt("type"));
                sensor.setProjectId(this.resultSet.getLong("project_id"));
                sensorList.add(sensor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getSQLState();
        } finally {
            this.cleanResources();
        }
        return sensorList;
    }

    public Sensor getSpecificSensorById(Long id) {

        Sensor            sensor     = new Sensor();
        ArrayList<Object> parameters = new ArrayList<>();
        this.setQuery("select * from Sensors where status = ? and id = ?");
        parameters.add(1);
        parameters.add(id);
        this.runQuery(parameters);
        try {
            if (this.resultSet.next()) {
                sensor.setId(this.resultSet.getLong("id"));
                sensor.setLabel(this.resultSet.getString("name"));
                sensor.setLabel(this.resultSet.getString("description"));
                sensor.setxLocation(this.resultSet.getDouble("x_location"));
                sensor.setyLocation(this.resultSet.getDouble("y_location"));
                sensor.setType(this.resultSet.getInt("type"));
                sensor.setProjectId(this.resultSet.getLong("project_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.cleanResources();
        }
        return sensor;
    }

    public boolean deleteSensor(Long sensorId, Long projectId) {
        ArrayList<Object> parameters = new ArrayList<>();
        this.setQuery("update Sensors set status = 0 where project_id = ? and id = ?");
        parameters.add(projectId);
        parameters.add(sensorId);
        this.runQuery(parameters);
        return this.resultForExecuteUpdate == 1;
    }

    public boolean addNewSensor(Sensor sensor) {
        ArrayList<Object> parameters = new ArrayList<>();
        this.setQuery("");
        this.runQuery(parameters);
        return true;
    }

    public boolean updateSensor(Sensor sensor) {
        ArrayList<Object> parameters = new ArrayList<>();
        this.setQuery("update Sensors set ???? where project_id = ?");
        this.runQuery(parameters);
        return this.resultForExecuteUpdate == 1;
    }
}
