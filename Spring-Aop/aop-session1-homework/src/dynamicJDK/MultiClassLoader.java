package dynamicJDK;

import java.util.ArrayList;
import java.util.List;

public class MultiClassLoader extends ClassLoader {

    private final List<ClassLoader> classLoaders = new ArrayList<>();

    public void addLoader(ClassLoader classLoader) {
        if(classLoader != null) {
            classLoaders.add(classLoader);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        for(ClassLoader classLoader : classLoaders) {
            try {
                return classLoader.loadClass(name);
            }
            catch(ClassNotFoundException ignore) {}
        }
        throw new ClassNotFoundException(name);
    }
}
