package com.orangehrm.sample;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.orangehrm.lib.BaseClass;

public class Testing  extends BaseClass {
public static void main(String[] args) throws FileNotFoundException, IOException {
	System.out.println(  System.getProperty("user.dir"));
	System.out.println(  new BaseClass().getValueFrmPropertyFile("browser"));
}
}


