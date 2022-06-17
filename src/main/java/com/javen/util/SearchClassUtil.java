package com.javen.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 扫描自定义servlet类的全路径名
 */
public class SearchClassUtil {
    public static List<String> classPaths = new ArrayList<String>();

    public static List<String> searchClass(){
        //需要扫描的包名
        String basePack = "com.javen.servlet";
        //将获取到的包名转换为路径
        String classPath = SearchClassUtil.class.getResource("/").getPath();
        basePack =  basePack.replace(".", File.separator);
        String searchPath = classPath + basePack;
        doPath(new File(searchPath),classPath);
        //这个时候我们已经得到了指定包下所有的类的绝对路径了。我们现在利用这些绝对路径和java的反射机制得到他们的类对象
        return classPaths;
    }

    /**
     * 该方法会得到所有的类，将类的绝对路径写入到classPaths中
     * @param file
     */
    private static void doPath(File file,String classpath) {
        if (file.isDirectory()) {//文件夹
            //文件夹我们就递归
            File[] files = file.listFiles();
            for (File f1 : files) {
                doPath(f1,classpath);
            }
        } else {//标准文件
            //标准文件我们就判断是否是class文件
            if (file.getName().endsWith(".class")) {
                String path = file.getPath().replace(classpath.replace("/","\\").
                                replaceFirst("\\\\",""),"").replace("\\",".").
                        replace(".class","");
                //如果是class文件我们就放入我们的集合中。
                classPaths.add(path);
            }
        }
    }

}
