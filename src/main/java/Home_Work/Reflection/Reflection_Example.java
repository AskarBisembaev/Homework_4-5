package Home_Work.Reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Reflection_Example {
    public static void main(String[] args) throws Exception {
        Class<?> catClass = Class.forName("Home_Work.Reflection.Cat");

        Constructor<?> constructor = catClass.getConstructor(int.class);

        Cat cat = (Cat) constructor.newInstance(3);

        Field[] fields = Animal.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals("name")) {
                field.set(cat, "Мурзик");
            } else if (field.getName().equals("age")) {
                field.setInt(cat, 5);
            }
        }

        System.out.println("Name: " + cat.getName());
        System.out.println("Age: " + cat.getAge());
    }
        }

