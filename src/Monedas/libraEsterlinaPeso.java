/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Monedas;

import Strategy_Monedas.IConver;

/**
 *
 * @author hanse
 */
public class libraEsterlinaPeso implements IConver{
    @Override
    public double  conversorMoneda(double peso)
    {
        return Math.round(66.60 * peso) ;
    }
}
