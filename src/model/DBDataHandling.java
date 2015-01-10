package model;

import org.javalite.activejdbc.*;
import model.tabels.ArtifactType;
import model.tabels.Employee;
import model.tabels.Group;

import java.util.List;

/**
 * Created by Andrey on 05.01.2015.
 */
public class DBDataHandling {
    public static void main(String[] args) {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1/InformationDB", "andrfas", "59722795");
    }

    public void addEmployee(String first_name, String last_name) {
        Employee employee = new Employee();
        employee.set("first_name", first_name, "last_name", last_name);
        employee.saveIt();
    }

    public void addGroup(String name) {
        Group group = new Group();
        group.set("name", name);
        group.saveIt();
    }

    public Integer getGroupName(int id) {
        List<Group> groupList = Group.where("id ='"+id+"'");
        Group group = groupList.get(0);
        return (Integer)group.get("name");
    }

    public Integer getGroupId(String name) {
        List<Group> groupList = Group.where("name ='"+name+"'");
        Group group = groupList.get(0);
        return (Integer)group.get("id");
    }

    public void addArtifactType(String name, int groupId) {
        ArtifactType artifType = new ArtifactType();
        artifType.set("name", name, "group_id", groupId);
        artifType.saveIt();
    }

}
