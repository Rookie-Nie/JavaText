package homework.BirdBoot05;

import java.io.File;

public class Test3 {
    public static void main(String[] args) throws Exception {
        File dir = new File(Test3.class.getResource(".").toURI());
        String[] fileName = dir.list();
        String packageName = Test3.class.getPackage().getName();
        for (String className : fileName){
            if (className.endsWith(".class")){
                Class cls = Class.forName(packageName+"."+className.substring(0,className.indexOf(".")));
                Object obj = cls.newInstance();
                System.out.println(obj);
            }
        }
    }
}
