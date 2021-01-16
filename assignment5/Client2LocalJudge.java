package ASSIGNMENT5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(Alphanumeric.class)
class Client2LocalJudge {
    private static final String ls = System.lineSeparator();
    private Random random = new Random();

    @Test
    void task000_detectClassInfo() {
        StringBuilder output = new StringBuilder();
        String[] requiredMethods = {
                "public void MyArrayList.add(java.lang.Object,int)",
                "public void MyArrayList.add(java.lang.Object)",
                "public java.lang.Object MyArrayList.get(int)",
                "public boolean MyArrayList.isEmpty()",
                "public int MyArrayList.size()"
        };
        try {
            Class<?> c = Class.forName("MyArrayList");
            Field[] fields = c.getDeclaredFields();
            boolean hasArray = false;
            for(Field field : fields) {
                if(field.toString().contains("java.lang.Object[]")) {
                    hasArray = true;
                    break;
                }
            }
            if(!hasArray) output.append("Cannot find Array Structure.").append(ls);
            List<String> declaredMethods = Arrays.stream(c.getDeclaredMethods()).map(Method::toString).collect(Collectors.toList());
            for(String method : requiredMethods) {
                if (!declaredMethods.contains(method)) output.append(method).append(" is missing").append(ls);
            }
        } catch(ClassNotFoundException e) {
            output.append(e.toString());
        }
        assertEquals(0, output.length(), ls + output.toString());
    }

    @Test
    void test001_detectSuperClass() throws Exception {
        Class<?> c = Class.forName("MyArrayList");
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields) {
            for(Class<?> cl : field.getType().getInterfaces()) {
                assertNotEquals(cl, Collection.class, ls + "subclass of java.util.Collection cannot appear" + ls);
                assertNotEquals(cl, List.class, ls + "subclass of java.util.List cannot appear" + ls);
            }
        }
    }

    @Test
    void test002_testCapacity() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        assertEquals(0, myArrayList.size(), ls + "Initial capacity should be 0" + ls);
        assertTrue(myArrayList.isEmpty(), ls + "isEmpty() Error, should be true" + ls);
        for(int i = 0; i < 20; i++) myArrayList.add(random.nextInt());
        assertEquals(20, myArrayList.size());
        assertFalse(myArrayList.isEmpty(), ls + "isEmpty() Error, should be false" + ls);
        for(int i = 0; i < 20; i++) {
            myArrayList.add(random.nextInt());
            assertEquals(20, myArrayList.size());
        }
    }

    @Test
    void test003_testMethods() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        List<Integer> list = new LinkedList<>();
        for(int i = 0, tmp = random.nextInt(); i < 10; i++, tmp = random.nextInt()) {
            myArrayList.add(tmp);
            list.add(tmp);
            assertEquals(list.get(i), myArrayList.get(i), ls + "Add Error" + ls);
        }
        for(int i = 0; i < 10; i++) assertEquals(list.get(i), myArrayList.get(i), ls + "Order Error" + ls);
        for(int i = 0, tmp = random.nextInt(), pos = random.nextInt(list.size()); i < 10; i++, tmp = random.nextInt(), pos = random.nextInt(list.size())) {
            myArrayList.add(tmp, pos);
            list.add(pos, tmp);
        }
        for(int i = 0; i < 20; i++) assertEquals(list.get(i), myArrayList.get(i), ls + "Order Error" + ls);
    }

    /*
    @Test
    void test004_moreTest() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        List<String> list = new LinkedList<>();
        String[] dejavu = {
                "See your body into the moonlight",
                "Even if I try to cancel",
                "All the pictures into the mind",
                "There's a flashing in my eyes",
                "Don't you see my commission, the nation",
                "Has gone running again",
                "Can't you see now, illusions",
                "Right into your mind"
        };
        for(String str : dejavu) {
            myArrayList.add(str);
            list.add(str);
        }
        for(int i = 0; i < 8; i++) {
            myArrayList.add(dejavu[i], i);
            list.add(i, dejavu[i]);
        }
        for(int i = 7; i >= 0; i--) {
            myArrayList.add(dejavu[i], i);
            if(list.size() < 20) list.add(i, dejavu[i]);
        }
        for(int i = 0; i < 20; i++) assertEquals(list.get(i), myArrayList.get(i));
    }
     */
}
