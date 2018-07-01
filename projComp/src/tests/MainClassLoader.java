package tests;

/**
 * Created by pooria on 7/1/2018.
 */
public class MainClassLoader extends ClassLoader {
    public Class defineClass(String name, byte[] b) {
        return defineClass(name, b, 0, b.length);
    }
}