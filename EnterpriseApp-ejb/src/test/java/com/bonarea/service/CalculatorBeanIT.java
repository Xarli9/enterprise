/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.service;

import java.util.HashMap;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carles
 */
public class CalculatorBeanIT {
    
    public CalculatorBeanIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of suma method, of class CalculatorBean.
     */
    @Test
    public void testSuma() throws Exception {
        HashMap<String,Object> properties = new HashMap();
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", "/Applications/NetBeans/glassfish-4.1.1/glassfish");
        properties.put("org.glassfish.ejb.embedded.glassfish.configuration.file","domain.xml");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer(properties);
        Context ctx = container.getContext();                

        System.out.println("suma");
        int num1 = 2;
        int num2 = 2; 
        CalculatorBean instance = (CalculatorBean)ctx.lookup("java:global/classes/CalculatorBean");
        int expResult = 4;
        int result = instance.suma(num1, num2);
        assertEquals(expResult, result);
        container.close();
    }
    
}
