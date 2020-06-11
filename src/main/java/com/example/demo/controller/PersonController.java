package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.example.demo.entities.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    //查询所有person
    @RequestMapping("/getAllPerson")
    public Object getAllPerson() {
        List<Person> personList = personService.selectAllPerson();
        return personList;
    }

    //新增person
    @RequestMapping("/insert")
    public String insertPerson(Person person) {
        int k=personService.insert(person);
        if(k==1)  return "成功";
        return "失败";
    }
    //批量新增person
    @RequestMapping("/insertMany")
    public String insertManyPerson(List<Person> person) {
        int k=personService.insertManyPerson(person);
        if(k==1)  return "成功";
        return "失败";
    }
    //删除一个person
    @RequestMapping("/delete")
    public String deletePerson(int id) {
        int k=personService.delete(id);
        if(k==1)  return "成功";
        return "失败";
    }

    //批量通过id删除person
    @RequestMapping("/deleteManyPerson")
    public String deleteManyPerson(List<Integer> ids) {
        int k=personService.deleteManyPerson(ids);
        if(k==1)  return "成功";
        return "失败";
    }


    //修改person
    @RequestMapping("/update")
    public String updatePerson(Person person) {
        int k=personService.updateById(person);
        if(k==1)  return "成功";
        return "失败";
    }
}