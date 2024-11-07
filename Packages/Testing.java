import package_name.ClassOne;
import package_one.ClassTwo;

public class Testing {
    public static void main(String[] args)
    {
        ClassTwo a = new ClassTwo();
        ClassOne b = new ClassOne();
        a.methodClassTwo();
        b.methodClassOne();
    }
}
