package alexrm84;

public class DoubleHashTableImplement extends HashTableImplement{
    private static int DOUBLE_HASH_CONST = 5;

    public DoubleHashTableImplement(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int getStep(int key) {
        return HashFuncDouble(key);
    }

    private int HashFuncDouble(int key) {
        return DOUBLE_HASH_CONST -(key% DOUBLE_HASH_CONST);
    }
}
