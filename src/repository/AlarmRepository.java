package repository;

import model.Alarm;

import java.util.ArrayList;
import java.util.List;

public class AlarmRepository {
    public List<Alarm> getAlarmListByProjectId(Long projectId){

        return new ArrayList<>();
    }

    public Alarm getSpecificAlarmById(Long alarmId){

        return new Alarm();
    }

    public boolean deleteAlarm(Alarm alarm){

        return true;
    }

    public boolean addNewAlarm(Alarm alarm){

        return true;
    }

    public boolean updateAlarm(Alarm alarm){

        return true;
    }
}
