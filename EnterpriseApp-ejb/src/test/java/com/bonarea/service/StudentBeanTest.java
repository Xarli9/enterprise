/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.service;

import com.bonarea.model.Student;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author traiandida
 */
public class StudentBeanTest {
    
    static EJBContainer container = null;
    static IStudentBeanLocal instance = null;
    
    public StudentBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", "/Users/Carles/Library/Application Support/Payara Server/glassfish");
        properties.put("org.glassfish.ejb.embedded.glassfish.configuration.file", "domain-universe.xml");
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer(properties);
        instance = (IStudentBeanLocal)container.getContext().lookup("java:global/classes/StudentBean");
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        container.close();
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class StudentBean.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Student model = new Student();
        model.setStudent_id(46001000);
        model.setName("Carles");
        model.setSurname("Noguera");
        model.setCard_id("12345678Z");
        
       
        int expResult = 1;
        int result = instance.add(model);
        assertEquals(expResult, result);
        
        
    }
    @Test
    public void testGetAll() throws Exception{
        
        System.out.println("getAll");
        
        List<Student> studentList = instance.getAll();
        
        assertTrue(studentList.size() > 0);
        
    
        
    }
    @Test
    public void testDelete() throws Exception {
        
        System.out.println("delete");
        Student model = new Student();
        model.setStudent_id(46001000);
        model.setCard_id("12345678Z");

        int expResult = 1;
        
        int resultDelete = instance.delete(model);
        
        assertEquals(expResult, resultDelete);
        
        
    }
    
    
    
}
