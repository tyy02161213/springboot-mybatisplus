package com.example.demo.service.impl;

import com.example.demo.dao.PersonMapper;
import com.example.demo.entities.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;
    //查询
    public List<Person> selectAllPerson(){
        List<Person> personList = personMapper.selectList(null);
        return personList;
    }
    //插入
    public int insert(Person person){
        try{
            personMapper.insert(person);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
    public int insertManyPerson(List<Person> person){
        try{
            for(Person p:person) personMapper.insert(p);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
    //删除
    public int delete(int id){
        try{
            personMapper.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    public int deleteManyPerson(List<Integer> ids){
        try{
            for(Integer id:ids) personMapper.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    //修改
    public int updateById(Person person){
        try{
            personMapper.updateById(person);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
}
