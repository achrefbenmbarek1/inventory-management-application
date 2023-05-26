/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.mycompany.mavenproject3.transaction.vente.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author achref
 */
public record Client(Integer idClient ,Date dateDeNaissance, String email) implements Serializable {

}
