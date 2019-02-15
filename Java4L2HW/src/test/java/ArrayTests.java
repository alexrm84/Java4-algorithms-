import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;


public class ArrayTests {
    public static final int INVALID_VALUE = 777;
    private Array<Integer> array1 = new ArrayImplement<Integer>();
    private Array<Integer> array2 = new ArrayImplement<Integer>();
    private Array<Integer> array3 = new ArrayImplement<Integer>();
    private Array<Integer> array4 = new SortedArray<Integer>();
    private Array<Integer> array5 = new SortedArray<Integer>();


    public ArrayTests(){

        for (int i = 0; i < 100000; i++) {
            int temp =(int) (Math.random()*1000);
            array1.add(temp);
            array2.add(temp);
            array3.add(temp);
//            array4.add(i);
//            array5.add(i);
        }
    }

    @Test
    public void test_runtime(){
        long start, finish;
        start = System.currentTimeMillis();
        array1.sortBubble();
        finish = System.currentTimeMillis();
        System.out.println("Пузырьковая сортировка занимает "+(finish - start)+" милисекунд");

        start = System.currentTimeMillis();
        array2.sortSelect();
        finish = System.currentTimeMillis();
        System.out.println("Сортировка выборкой занимает "+(finish - start)+" милисекунд");

        start = System.currentTimeMillis();
        array3.sortInsert();
        finish = System.currentTimeMillis();
        System.out.println("Сортировка вставкой занимает "+(finish - start)+" милисекунд");
    }

/* Что то не смог понять почему методы из ArrayImplement нормально видны а методы из SortedArray (в частности indexOfRec) не виден.
    @Test
    public void test_runtime_binary_search(){
        long start, finish;
        start = System.currentTimeMillis();
        array4.indexOf(1);
        finish = System.currentTimeMillis();
        System.out.println("Бинарный поиск с массивом занимает "+(finish - start)+" милисекунд");

        start = System.currentTimeMillis();
        array5.inde();
        finish = System.currentTimeMillis();
        System.out.println("Бинарный поиск с рекурсией занимает "+(finish - start)+" милисекунд");
    }
*/

/*
    @Test
    public void test_init_array() {
        Array<Integer> array = new ArrayImplement<Integer>();
        array.add(1);
        array.add(2);
        Assert.assertThat(array.getSize(), Is.is(2));
        Assert.assertThat(array.get(0), Is.is(1));
        Assert.assertThat(array.get(1), Is.is(2));

    }

    @Test
    public void test_init_array_fixed_size() {
        Array<Integer> array = new ArrayImplement<Integer>(2);
        array.add(1);
        array.add(2);
        array.add(3);
        Assert.assertThat(array.getSize(), Is.is(3));
        Assert.assertThat(array.get(0), Is.is(1));
        Assert.assertThat(array.get(1), Is.is(2));
        Assert.assertThat(array.get(2), Is.is(3));
    }

    @Test
    public void test_search() {
        Array<Integer> array = new ArrayImplement<Integer>();
        array.add(10);
        array.add(20);
        array.add(70);

        Assert.assertTrue(array.contains(10));
        Assert.assertTrue(array.contains(20));
        Assert.assertTrue(array.contains(70));

        Assert.assertFalse(array.contains(INVALID_VALUE));

        Assert.assertThat(array.indexOf(10), Is.is(0));
        Assert.assertThat(array.indexOf(20), Is.is(1));
        Assert.assertThat(array.indexOf(70), Is.is(2));

        Assert.assertThat(array.indexOf(INVALID_VALUE), Is.is(-1));
    }

    @Test
    public void test_remove_by_index() {
        Array<Integer> array = new ArrayImplement<Integer>();
        array.add(10);
        array.add(20);
        array.add(70);

        array.remove(0);
        Assert.assertThat(array.getSize(), Is.is(2));
        Assert.assertThat(array.get(0), Is.is(20));
        Assert.assertThat(array.get(1), Is.is(70));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_remove_by_invalid_index() {
        Array<Integer> array = new ArrayImplement<Integer>();
        array.add(10);
        array.add(20);
        array.add(70);

        array.remove(50);
    }

    @Test
    public void test_remove_by_value() {
        Array<Integer> array = new ArrayImplement<Integer>();
        array.add(10);
        array.add(20);
        array.add(70);

        Assert.assertFalse(array.remove(Integer.valueOf(INVALID_VALUE)));
        Assert.assertTrue(array.remove(Integer.valueOf(20)));

        Assert.assertThat(array.getSize(), Is.is(2));
        Assert.assertThat(array.get(0), Is.is(10));
        Assert.assertThat(array.get(1), Is.is(70));
    }

    @Test
    public void test_sorted_array() {
        Array<Integer> array = new SortedArray<Integer>();
        array.add(20);
        array.add(10);
        array.add(70);

        Assert.assertThat(array.getSize(), Is.is(3));
        Assert.assertThat(array.get(0), Is.is(10));
        Assert.assertThat(array.get(1), Is.is(20));
        Assert.assertThat(array.get(2), Is.is(70));
    }


    @Test
    public void test_binary_search() {
        Array<Integer> array = new SortedArray<Integer>();
        array.add(20);
        array.add(10);
        array.add(70);

        Assert.assertTrue(array.contains(10));
        Assert.assertTrue(array.contains(20));
        Assert.assertTrue(array.contains(70));

        Assert.assertFalse(array.contains(INVALID_VALUE));

        Assert.assertThat(array.indexOf(10), Is.is(0));
        Assert.assertThat(array.indexOf(20), Is.is(1));
        Assert.assertThat(array.indexOf(70), Is.is(2));

        Assert.assertThat(array.indexOf(INVALID_VALUE), Is.is(-1));
    }

    @Test
    public void test_sort_bubble() {
        ArrayImplement<Integer> array = new ArrayImplement<Integer>();
        array.add(20);
        array.add(10);
        array.add(70);
        array.add(50);
        array.add(7);

        array.sortBubble();
        Assert.assertThat(array.get(0), Is.is(7));
        Assert.assertThat(array.get(1), Is.is(10));
        Assert.assertThat(array.get(2), Is.is(20));
        Assert.assertThat(array.get(3), Is.is(50));
        Assert.assertThat(array.get(4), Is.is(70));
    }


    @Test
    public void test_sort_select() {
        ArrayImplement<Integer> array = new ArrayImplement<Integer>();
        array.add(20);
        array.add(10);
        array.add(70);
        array.add(50);
        array.add(7);

        array.sortSelect();
        Assert.assertThat(array.get(0), Is.is(7));
        Assert.assertThat(array.get(1), Is.is(10));
        Assert.assertThat(array.get(2), Is.is(20));
        Assert.assertThat(array.get(3), Is.is(50));
        Assert.assertThat(array.get(4), Is.is(70));
    }


    @Test
    public void test_sort_insert() {
        ArrayImplement<Integer> array = new ArrayImplement<Integer>();
        array.add(20);
        array.add(10);
        array.add(70);
        array.add(50);
        array.add(7);

        array.sortInsert();
        Assert.assertThat(array.get(0), Is.is(7));
        Assert.assertThat(array.get(1), Is.is(10));
        Assert.assertThat(array.get(2), Is.is(20));
        Assert.assertThat(array.get(3), Is.is(50));
        Assert.assertThat(array.get(4), Is.is(70));
    }
    */
}
