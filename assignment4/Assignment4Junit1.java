package ASSIGNMENT4;

import ASSIGNMENT4.BusLine;
import ASSIGNMENT4.District;
import ASSIGNMENT4.Station;
import ASSIGNMENT4.Polynomial;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment4Junit1 {

    @Test
    public void question01_task01_constructor() {
        Polynomial p1 = new Polynomial(new int[]{1, 2, 3, 4, 5, 6, 0, 0});
        Polynomial p2 = new Polynomial(new int[]{0, 0, 1, 3, 0, 0, 1});
    }

    @Test
    public void question01_task02_toString1() {
        Polynomial p1 = new Polynomial(new int[]{1, 2, 3, 4, 5, 6, 0, 0, 2});
        assertEquals("0:1 1:2 2:3 3:4 4:5 5:6 8:2", p1.toString().trim());
    }

    @Test
    public void question01_task03_toString2() {
        Polynomial p1 = new Polynomial(new int[]{0, 2, -3, 4, 5, -6, 0, 0});
        assertEquals("1:2 2:-3 3:4 4:5 5:-6", p1.toString().trim());
    }

    @Test
    public void question01_task04_add1() throws NoSuchMethodException {
        Polynomial p1 = new Polynomial(new int[]{4, 5, 7, 0, 3, 0, 0});
        Polynomial p2 = new Polynomial(new int[]{0, 1, 0, 0, 2, 1, 0});
        Polynomial p3 = new Polynomial(new int[]{-2, -2, 0, -3});

        Polynomial p4 = p1.add(p2);
        assertEquals("0:4 1:6 2:7 4:5 5:1", p4.toString().trim());
        assertEquals("0:4 1:6 2:7 4:5 5:1", p1.toString().trim());

        Polynomial p5 = p1.add(p3);
        assertEquals("0:2 1:4 2:7 3:-3 4:5 5:1", p5.toString().trim());
        assertEquals("0:2 1:4 2:7 3:-3 4:5 5:1", p1.toString().trim());

        Class<Polynomial> clazz = Polynomial.class;
        Method method = clazz.getDeclaredMethod("add", Polynomial.class);
        assertTrue("ASSIGNMENT4.Polynomial.add is not public", Modifier.isPublic(method.getModifiers()));
    }

    @Test
    public void question01_task05_add2() throws NoSuchMethodException {
        Polynomial p1 = new Polynomial(new int[]{-2, 8, 10, 999, 0, 2, 3, 1, 4});
        Polynomial p2 = new Polynomial(new int[]{2, -8, -5, -998, 0, -2, -4,});

        Polynomial p3 = Polynomial.add(p1, p2);
        assertEquals("2:5 3:1 6:-1 7:1 8:4", p3.toString().trim());

        // To ensure p3 is a new ASSIGNMENT4.Polynomial, p1 and p2 not change
        assertEquals("0:-2 1:8 2:10 3:999 5:2 6:3 7:1 8:4", p1.toString().trim());
        assertEquals("0:2 1:-8 2:-5 3:-998 5:-2 6:-4", p2.toString().trim());

        Class<Polynomial> clazz = Polynomial.class;
        Method method = clazz.getDeclaredMethod("add", Polynomial.class, Polynomial.class);
        assertTrue("ASSIGNMENT4.Polynomial.add is not public", Modifier.isPublic(method.getModifiers()));
    }

    @Test
    public void question01_task06_minus1() throws NoSuchMethodException {
        Polynomial p1 = new Polynomial(new int[]{1, 2, 3, 4, 0, -1, -2, -3, -4});
        Polynomial p2 = new Polynomial(new int[]{-1, 2, 3, -4, 1, 2, -3});

        Polynomial p3 = p1.minus(p2);
        assertEquals("0:2 3:8 4:-1 5:-3 6:1 7:-3 8:-4", p3.toString().trim());
        assertEquals("0:2 3:8 4:-1 5:-3 6:1 7:-3 8:-4", p1.toString().trim());

        Class<Polynomial> clazz = Polynomial.class;
        Method method = clazz.getDeclaredMethod("minus", Polynomial.class);
        assertTrue("ASSIGNMENT4.Polynomial.minus is not public", Modifier.isPublic(method.getModifiers()));
    }

    @Test
    public void question01_task07_minus2() throws NoSuchMethodException {
        Polynomial p1 = new Polynomial(new int[]{1});
        Polynomial p2 = new Polynomial(new int[]{-1, -2, -3, 4, 0, 8});

        Polynomial p3 = Polynomial.minus(p1, p2);
        assertEquals("0:2 1:2 2:3 3:-4 5:-8", p3.toString().trim());

        // To ensure p3 is a new ASSIGNMENT4.Polynomial, p1 and p2 not change
        assertEquals("0:1", p1.toString().trim());
        assertEquals("0:-1 1:-2 2:-3 3:4 5:8", p2.toString().trim());

        Class<Polynomial> clazz = Polynomial.class;
        Method method = clazz.getDeclaredMethod("minus", Polynomial.class, Polynomial.class);
        assertTrue("ASSIGNMENT4.Polynomial.minus is not public", Modifier.isPublic(method.getModifiers()));
    }

    @Test
    public void question01_task99_bonus_multiply() throws InvocationTargetException, IllegalAccessException {
        Class<Polynomial> clazz = Polynomial.class;
        Method method = null;
        Method staticMethod = null;

        try {
            method = clazz.getDeclaredMethod("multiply", Polynomial.class);
            staticMethod = clazz.getDeclaredMethod("multiply", Polynomial.class, Polynomial.class);
        } catch (NoSuchMethodException e) {
            fail("no ASSIGNMENT4.Polynomial.multiply(ASSIGNMENT4.Polynomial) or ASSIGNMENT4.Polynomial.multiply(ASSIGNMENT4.Polynomial, ASSIGNMENT4.Polynomial). bonus is not finish");
        }

        assertTrue("ASSIGNMENT4.Polynomial.multiply(ASSIGNMENT4.Polynomial) is not public", Modifier.isPublic(method.getModifiers()));
        assertTrue("ASSIGNMENT4.Polynomial.multiply(ASSIGNMENT4.Polynomial, ASSIGNMENT4.Polynomial) is not public", Modifier.isPublic(staticMethod.getModifiers()));

        Polynomial p1 = new Polynomial(new int[]{3, 2, -1, 3, 1, 2});
        Polynomial p2 = new Polynomial(new int[]{-2, 0, 4, -3, 0, 0, 1});

        Polynomial p3 = (Polynomial) staticMethod.invoke(null, p1, p2);
        Polynomial p4 = (Polynomial) method.invoke(p1, p2);

        assertEquals("0:-6 1:-4 2:14 3:-7 4:-12 5:11 6:-2 7:7 8:-7 9:3 10:1 11:2", p3.toString().trim());
        assertEquals("0:-6 1:-4 2:14 3:-7 4:-12 5:11 6:-2 7:7 8:-7 9:3 10:1 11:2", p4.toString().trim());
        assertEquals("0:-6 1:-4 2:14 3:-7 4:-12 5:11 6:-2 7:7 8:-7 9:3 10:1 11:2", p1.toString().trim());
    }

    @Test
    public void question02_task01_district_fields() {
        Class clazz = District.class;
        assertTrue("ASSIGNMENT4.District is not a Enum", clazz.isEnum());

        try {
            Field name = clazz.getDeclaredField("name");
            assertEquals("ASSIGNMENT4.District.name is not String", name.getType(), String.class);
            assertTrue("ASSIGNMENT4.District.name is not private", Modifier.isPrivate(name.getModifiers()));
        } catch (NoSuchFieldException e) {
            fail("cannot find name field in ASSIGNMENT4.District");
        }

        try {
            Field stationCount = clazz.getDeclaredField("stationCount");
            assertEquals("ASSIGNMENT4.District.stationCount is not int", stationCount.getType(), int.class);
            assertTrue("ASSIGNMENT4.District.stationCount is not private", Modifier.isPrivate(stationCount.getModifiers()));
        } catch (NoSuchFieldException e) {
            fail("cannot find stationCount field in ASSIGNMENT4.District");
        }
    }

    @Test
    public void question02_task02_district_enum() throws NoSuchFieldException, IllegalAccessException {
        Class clazz = District.class;
        Field name = clazz.getDeclaredField("name");
        Field stationCount = clazz.getDeclaredField("stationCount");
        name.setAccessible(true);
        stationCount.setAccessible(true);

        assertEquals("Bao'an", name.get(District.BAOAN));
        assertEquals("Futian", name.get(District.FUTIAN));
        assertEquals("Longgang", name.get(District.LONGGANG));
        assertEquals("Longhua", name.get(District.LONGHUA));
        assertEquals("Luohu", name.get(District.LUOHU));
        assertEquals("Nanshan", name.get(District.NANSHAN));

        assertEquals(25, stationCount.getInt(District.BAOAN));
        assertEquals(51, stationCount.getInt(District.FUTIAN));
        assertEquals(22, stationCount.getInt(District.LONGGANG));
        assertEquals(9, stationCount.getInt(District.LONGHUA));
        assertEquals(23, stationCount.getInt(District.LUOHU));
        assertEquals(49, stationCount.getInt(District.NANSHAN));
    }

    @Test
    public void question02_task03_station_fields() {
        Class clazz = Station.class;

        String[] names = {"name", "district", "latitude", "longitude", "next"};
        Class[] classes = {String.class, District.class, double.class, double.class, Station.class};

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            Class type = classes[i];
            try {
                Field field = clazz.getDeclaredField(name);
                assertEquals("ASSIGNMENT4.Station." + name + " is not " + type.getName(), field.getType(), type);
                assertTrue("ASSIGNMENT4.Station." + name + " is not private", Modifier.isPrivate(field.getModifiers()));
            } catch (NoSuchFieldException e) {
                fail("cannot find " + name + " field in ASSIGNMENT4.Station");
            }
        }

    }

    @Test
    public void question02_task04_station_constructor() throws NoSuchMethodException {
        Station s1 = new Station();
        Station s2 = new Station("testX", District.FUTIAN, 22.0, 119.82);

        Class<Station> clazz = Station.class;
        assertTrue("Constructor of ASSIGNMENT4.Station is not public", Modifier.isPublic(
                clazz.getDeclaredConstructor().getModifiers()
        ));
        assertTrue("Constructor of ASSIGNMENT4.Station is not public", Modifier.isPublic(
                clazz.getDeclaredConstructor(String.class, District.class, double.class, double.class).getModifiers()
        ));
    }

    @Test
    public void question02_task05_station_equals1() {
        Station s1 = new Station("testXtest", District.LONGHUA, 22.0, 119.82);
        Station s2 = new Station("testXtest", District.LONGHUA, 22.0, 119.82);

        assertTrue(s1.equals(s2));

        s1.setNext(s2);
        assertTrue(s1.equals(s2));

        Station s3 = new Station("testYtest", District.LONGHUA, 22.0, 119.82);
        Station s4 = new Station("testtest", District.FUTIAN, 22.0, 119.82);
        Station s5 = new Station("testtest", District.LONGHUA, 22.02, 119.82);
        Station s6 = new Station("testtest", District.LONGHUA, 22.0, 119.825);

        assertFalse(s1.equals(s3));
        assertFalse(s1.equals(s4));
        assertFalse(s1.equals(s5));
        assertFalse(s1.equals(s6));
    }

    @Test
    public void question02_task06_station_equals2() {
        Station s1 = new Station("test_null", District.LONGGANG, 23.4, 123.4);
        assertFalse(s1.equals(null));
    }

    @Test
    public void question02_task07_busline_fields() {

        Class clazz = BusLine.class;

        String[] names = {"head", "tail", "number", "size"};
        Class[] classes = {Station.class, Station.class, String.class, int.class};

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            Class type = classes[i];
            try {
                Field field = clazz.getDeclaredField(name);
                assertEquals("ASSIGNMENT4.BusLine." + name + " is not " + type.getName(), field.getType(), type);
                assertTrue("ASSIGNMENT4.BusLine." + name + " is not private", Modifier.isPrivate(field.getModifiers()));
            } catch (NoSuchFieldException e) {
                fail("cannot find " + name + " field in ASSIGNMENT4.BusLine");
            }
        }

        assertEquals("You defined other fields in ASSIGNMENT4.BusLine", 4, clazz.getDeclaredFields().length);

    }

    @Test
    public void question02_task08_busline_constructor() throws NoSuchMethodException {
        checkField();

        BusLine s1 = new BusLine();
        BusLine s2 = new BusLine("81");

        Class<BusLine> clazz = BusLine.class;
        assertTrue("Constructor of ASSIGNMENT4.BusLine is not public", Modifier.isPublic(
                clazz.getDeclaredConstructor().getModifiers()
        ));
        assertTrue("Constructor of ASSIGNMENT4.BusLine is not public", Modifier.isPublic(
                clazz.getDeclaredConstructor(String.class).getModifiers()
        ));
    }


    @Test
    public void question02_task09_busline_addStation1() throws NoSuchMethodException {
        checkField();

        BusLine busLine = new BusLine("81");
        int size = 0;
        assertEquals(size, busLine.size());

        List<Station> stations = testStations1();
        for (Station station : stations) {
            busLine.addStation(station);
            size++;
            assertEquals(size, busLine.size());
            assertEquals(station.getName(), busLine.getTail().getName());
        }

        Class<BusLine> clazz = BusLine.class;
        Method method = clazz.getDeclaredMethod("addStation", Station.class);
        assertTrue("ASSIGNMENT4.BusLine.addStation is not public", Modifier.isPublic(method.getModifiers()));
    }

    @Test
    public void question02_task10_busline_addStation2() {
        checkField();

        BusLine busLine = new BusLine("80");
        int size = 0;
        assertEquals(size, busLine.size());

        List<Station> stations = testStations2();
        for (Station station : stations) {
            busLine.addStation(station);
            size++;
            assertEquals(size, busLine.size());
            assertEquals(station.getName(), busLine.getTail().getName());
        }

    }


    @Test
    public void question02_task11_busline_isEmpty() throws NoSuchMethodException {
        checkField();

        BusLine busLine = new BusLine("81");
        assertTrue(busLine.isEmpty());

        List<Station> list = testStations1();
        for (Station station : list) {
            busLine.addStation(station);
            assertFalse(busLine.isEmpty());
        }

        Class<BusLine> clazz = BusLine.class;
        Method method = clazz.getDeclaredMethod("isEmpty");
        assertTrue("ASSIGNMENT4.BusLine.isEmpty is not public", Modifier.isPublic(method.getModifiers()));
    }

    @Test
    public void question02_task12_busline_size() throws NoSuchMethodException {
        checkField();

        BusLine busLine = new BusLine("81");
        int size = 0;
        assertEquals(size, busLine.size());

        List<Station> list = testStations1();
        for (Station station : list) {
            busLine.addStation(station);
            size++;
            assertEquals(size, busLine.size());
        }

        Class<BusLine> clazz = BusLine.class;
        Method method = clazz.getDeclaredMethod("size");
        assertTrue("ASSIGNMENT4.BusLine.size is not public", Modifier.isPublic(method.getModifiers()));
    }

    @Test
    public void question02_task13_busline_printStation1() throws NoSuchMethodException {
        checkField();

        BusLine busLine = new BusLine("81");

        List<Station> list = testStations1();
        for (Station station : list) {
            busLine.addStation(station);
        }

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream(1024 * 1024);
        System.setOut(new PrintStream(byteArray));

        busLine.printStation();
        assertEquals("Minle Changlingpi University Town Xili Chaguang Shenzhen University", new String(byteArray.toByteArray()).trim());
        System.out.close();

        Class<BusLine> clazz = BusLine.class;
        Method method = clazz.getDeclaredMethod("printStation");
        assertTrue("ASSIGNMENT4.BusLine.printStation is not public", Modifier.isPublic(method.getModifiers()));
    }

    @Test
    public void question02_task14_busline_printStation2() {
        checkField();

        BusLine busLine = new BusLine("80");

        List<Station> list = testStations2().stream().limit(8).collect(Collectors.toList());
        for (Station station : list) {
            busLine.addStation(station);
        }

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream(1024 * 1024);
        System.setOut(new PrintStream(byteArray));

        busLine.printStation();
        assertEquals("Baigelong Sungang Hongling Yannan Huaqiang North Gangxia North Gangxia Yitian", new String(byteArray.toByteArray()).trim());
        System.out.close();
    }

    @Test
    public void question02_task15_busline_nearestStation1() throws NoSuchMethodException {
        checkField();

        Station s1 = new Station("TestStation1", District.NANSHAN, 0, 0);
        Station s2 = new Station("TestStation2", District.LUOHU, 1, 0);
        Station s3 = new Station("TestStation3", District.LONGHUA, 1, 1);
        Station s4 = new Station("TestStation4", District.BAOAN, 0, 1);
        Station s5 = new Station("TestStation5", District.FUTIAN, 0, 2);

        Station s6 = new Station("TestStation6", District.LUOHU, 0, 1.2);
        Station s7 = new Station("TestStation7", District.LUOHU, 0, 1.8);
        Station s8 = new Station("TestStation8", District.BAOAN, 1, 1.1);

        BusLine busLine = new BusLine("Test1");
        List<Station> list = Arrays.asList(s1, s2, s3, s4, s5);
        for (Station station : list) {
            busLine.addStation(station);
        }

        assertEquals(s4.getName(), busLine.nearestStation(s6).getName());
        assertEquals(s5.getName(), busLine.nearestStation(s7).getName());
        assertEquals(s3.getName(), busLine.nearestStation(s8).getName());


        Class<BusLine> clazz = BusLine.class;
        Method method = clazz.getDeclaredMethod("printStation");
        assertTrue("ASSIGNMENT4.BusLine.nearestStation is not public", Modifier.isPublic(method.getModifiers()));
    }

    @Test
    public void question02_task16_busline_nearestStation2() {
        checkField();

        Station s1 = new Station("TestStation1", District.NANSHAN, 22.0, 120.5);
        Station s2 = new Station("TestStation2", District.NANSHAN, 23.5, 120.5);
        Station s3 = new Station("TestStation3", District.NANSHAN, 23.5, 120.9);
        Station s4 = new Station("TestStation4", District.NANSHAN, 22.1, 120.4);
        Station s5 = new Station("TestStation5", District.NANSHAN, 22.0, 121.0);

        BusLine busLine = new BusLine("Test2");
        List<Station> list = Arrays.asList(s1, s2, s3, s4, s5);
        for (Station station : list) {
            busLine.addStation(station);
        }

        assertEquals(s4.getName(), busLine.nearestStation(s1).getName());
        assertNotEquals(s2.getName(), busLine.nearestStation(s1).getName());

        assertEquals(s1.getName(), busLine.nearestStation(s5).getName());
        assertEquals(s3.getName(), busLine.nearestStation(s2).getName());
    }

    @Test
    public void question02_task17_busline_ratioOfDistrict1() throws NoSuchMethodException {
        checkField();

        BusLine busLine = new BusLine("81");

        List<Station> list = testStations1();
        for (Station station : list) {
            busLine.addStation(station);
        }

        assertEquals(0.102, busLine.ratioOfDistrict(District.NANSHAN), 0.001);
        assertEquals(0.111, busLine.ratioOfDistrict(District.LONGHUA), 0.001);

        assertEquals(0, busLine.ratioOfDistrict(District.FUTIAN), 0.00001);
        assertEquals(0, busLine.ratioOfDistrict(District.LUOHU), 0.00001);
        assertEquals(0, busLine.ratioOfDistrict(District.LONGGANG), 0.00001);


        Class<BusLine> clazz = BusLine.class;
        Method method = clazz.getDeclaredMethod("ratioOfDistrict", District.class);
        assertTrue("ASSIGNMENT4.BusLine.ratioOfDistrict is not public", Modifier.isPublic(method.getModifiers()));
    }

    @Test
    public void question02_task18_busline_ratioOfDistrict2() {
        checkField();

        BusLine busLine = new BusLine("80");

        List<Station> list = testStations2();
        for (Station station : list) {
            busLine.addStation(station);
        }

        assertEquals(0.157, busLine.ratioOfDistrict(District.FUTIAN), 0.001);
        assertEquals(0.045, busLine.ratioOfDistrict(District.LONGGANG), 0.001);
        assertEquals(0.043, busLine.ratioOfDistrict(District.LUOHU), 0.001);
        assertEquals(0.102, busLine.ratioOfDistrict(District.NANSHAN), 0.001);

        assertEquals(0, busLine.ratioOfDistrict(District.BAOAN), 0.00001);

    }

    @Test
    public void question02_task99_bonus_busline_addStation() throws InvocationTargetException, IllegalAccessException {
        checkField();

        Class<BusLine> clazz = BusLine.class;
        Method method = null;
        try {
            method = clazz.getDeclaredMethod("addStation", Station.class, int.class);
        } catch (NoSuchMethodException e) {
            fail("no addStation(ASSIGNMENT4.Station, int) found. bonus is not finish.");
        }
        assertTrue("ASSIGNMENT4.BusLine.addStation is not public", Modifier.isPublic(method.getModifiers()));

        Station s1 = new Station("Minle", District.LONGHUA, 22.59389, 114.04889);
        Station s2 = new Station("Changlingpi", District.NANSHAN, 22.59917, 114.01111);
        Station s3 = new Station("University Town", District.NANSHAN, 22.58194, 113.965);
        Station s4 = new Station("Xili", District.NANSHAN, 22.58056, 113.95444);
        Station s5 = new Station("Chaguang", District.NANSHAN, 22.57694, 113.94944);
        Station s6 = new Station("Shenzhen University", District.NANSHAN, 22.53861, 113.94417);

        BusLine busLine = new BusLine("81");

        busLine.addStation(s1);
        busLine.addStation(s4);
        method.invoke(busLine, s2, 1);
        assertEquals(s2.getName(), busLine.getHead().getNext().getNext().getName());

        method.invoke(busLine, s3, 2);
        assertEquals(s3.getName(), busLine.getHead().getNext().getNext().getNext().getName());

        busLine.addStation(s5);
        assertEquals(s5.getName(), busLine.getHead().getNext().getNext().getNext().getNext().getNext().getName());
    }

    private void checkField() {
        try {
            question02_task07_busline_fields();
        } catch (Throwable e) {
            fail("Please finish task07 first");
        }
    }

    private List<Station> testStations1() {
        return Arrays.asList(
                new Station("Minle", District.LONGHUA, 22.59389, 114.04889),
                new Station("Changlingpi", District.NANSHAN, 22.59917, 114.01111),
                new Station("University Town", District.NANSHAN, 22.58194, 113.965),
                new Station("Xili", District.NANSHAN, 22.58056, 113.95444),
                new Station("Chaguang", District.NANSHAN, 22.57694, 113.94944),
                new Station("Shenzhen University", District.NANSHAN, 22.53861, 113.94417)
        );
    }

    private List<Station> testStations2() {
        return Arrays.asList(
                new Station("Baigelong", District.LONGGANG, 22.59528, 114.13028),
                new Station("Sungang", District.LUOHU, 22.56972, 114.11778),
                new Station("Hongling", District.FUTIAN, 22.5553306, 114.1102833),
                new Station("Yannan", District.FUTIAN, 22.54444, 114.0925),
                new Station("Huaqiang North", District.FUTIAN, 22.54417, 114.08528),
                new Station("Gangxia North", District.FUTIAN, 22.54083, 114.06889),
                new Station("Gangxia", District.FUTIAN, 22.53778, 114.06306),
                new Station("Yitian", District.FUTIAN, 22.51639, 114.05139),
                new Station("Shawei", District.FUTIAN, 22.52667, 114.04917),
                new Station("Shangsha", District.FUTIAN, 22.53028, 114.0425),
                new Station("Xiasha", District.NANSHAN, 22.53528, 114.03083),
                new Station("Shenzhen Bay Park", District.NANSHAN, 22.52778, 113.99917),
                new Station("Dongjiaotou", District.NANSHAN, 22.48583, 113.93139),
                new Station("Shekou Port", District.NANSHAN, 22.47944, 113.90667),
                new Station("Chiwan", District.NANSHAN, 22.47944, 113.89889)
        );
    }
}
