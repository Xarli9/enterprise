/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bonarea.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Carles
 */
@Stateless
@LocalBean
public class CalculatorBean {
    
    @Inject
    @Named("calculator")
    ICalculator calculator;

    public int suma(int num1, int num2) {
        return calculator.suma(num1, num2);
    }
}
