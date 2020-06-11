package com.example.demo.service;

import com.example.demo.entities.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface PersonService {
    public List<Person> selectAllPerson();
    public int insert(Person person);
    public int insertManyPerson(List<Person> person);
    public int delete(int id);
    public int updateById(Person person);
    public int deleteManyPerson(List<Integer> ids);

}