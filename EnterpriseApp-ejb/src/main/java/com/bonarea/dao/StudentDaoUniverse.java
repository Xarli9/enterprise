/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.dao;

import com.bonarea.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author traiandida
 */
@RequestScoped
@UniverseDao
public class StudentDaoUniverse implements IDao<Student>{
    
    @Resource(name="jdbc/Universe")
    private javax.sql.DataSource dataSource;

    
    @Override
    public int add(Student model) throws SQLException {
        
        Connection con = dataSource.getConnection();
        
        String query = "INSERT INTO student (student_id, name, surname, dni) VALUES (? ,?, ?, ?)";
        
        
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, model.getStudent_id());
        preparedStmt.setString (2, model.getName());
        preparedStmt.setString (3, model.getSurname());
        preparedStmt.setString (4, model.getCard_id());
        
        int result = preparedStmt.executeUpdate();
        
        con.close();
        System.out.println("Affected rows: "+result);
        
        return result;
      
    }
    
    @Override
    public int delete(Student model) throws SQLException{
        
        Connection con = dataSource.getConnection();
        
        String query = "DELETE FROM student WHERE dni = ?";
        
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString (1, model.getCard_id());
        
        int result = preparedStmt.executeUpdate();
        
        con.close();
        System.out.println("Affected rows: "+result);
        
        return result;
    }
    
    
    @Override
    public List<Student> getAll() throws SQLException {
        
        try {
            Connection con = dataSource.getConnection();
            
            String query = "SELECT * FROM student;";
            
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            List<Student> studentList = new ArrayList<Student>();
            
            while(rs.next()){
                Student student = new Student();
                student.setStudent_id(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setCard_id(rs.getString("dni"));
                
                studentList.add(student);
            }
            
            return studentList;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public int update(Student model) throws SQLException {
                
        Connection con = dataSource.getConnection();
        
        String query = "UPDATE student SET name = ?, surname = ?, nif = ?"
                + " WHERE student_id = ?";
        
        
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString (1, model.getName());
        preparedStmt.setString (2, model.getSurname());
        preparedStmt.setString (3, model.getCard_id());
        preparedStmt.setInt (4, model.getStudent_id());
        
        int result = preparedStmt.executeUpdate();
        
        con.close();
        System.out.println("Affected rows: "+result);
        
        return result;
    }
    
   
}
