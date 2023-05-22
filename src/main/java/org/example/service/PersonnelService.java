package org.example.service;

import org.example.dao.PersonnelDao;
import org.example.entity.Personnel;

import java.util.List;

public class PersonnelService {
    public static Personnel create(Personnel personnel) {
        return PersonnelDao.creatQuery(personnel);
    }

    public static List<Personnel> findAll() {

        return PersonnelDao.findAll();
    }

    public static Personnel findById(int id) {

        return PersonnelDao.findById(id);
    }

    public static void updateQuery(Personnel personnel) {

        PersonnelDao.updateQuery(personnel);

    }

    public static void deleteByID(int id) {
        PersonnelDao.deleteByID(id);

    }
}
