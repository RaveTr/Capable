package com.slepmel.capable.api;

import com.slepmel.capable.Capable;

public class CapableReflection {
	
    public static void classLoad(String classNamePath) {
        try {
            Class.forName(classNamePath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Capable.error("CLASSLOAD", "Failed to load a class. This error probably happened due to file corruption, so please try downloading the mod again. If you're running dataGen, ignore this message");
        }
    }

}
