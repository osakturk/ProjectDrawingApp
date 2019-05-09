package repository;

import model.Sensor;

import java.util.ArrayList;
import java.util.List;

public class SensorRepository {
    public List<Sensor> getSensorListByProjectId(Long projectId){

        return new ArrayList<>();
    }

    public Sensor getSpecificSensorById(Long SensorId){

        return new Sensor();
    }

    public boolean deleteSensor(Sensor sensor){

        return true;
    }

    public boolean addNewSensor(Sensor sensor){

        return true;
    }

    public boolean updateSensor(Sensor sensor){

        return true;
    }
}
