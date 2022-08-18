/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ajanuser
 */
public class AjaFile implements Serializable{

int CutStartObjNo=0,CutEndObjNo=0;
boolean CutStartEndEnabled=false;
boolean MicroJointEnable=false;    

List<MicroJointList> microjointlistesi=new ArrayList<>();

public java.util.ArrayList<DxfEssi> dxfVect = new java.util.ArrayList<>();
public java.util.ArrayList<DxfEssi> dxfVectWithOff = new java.util.ArrayList<>();


 


}


