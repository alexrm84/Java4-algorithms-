package stack;

public class Shifter {

    public String shift(String inputStr){
        Stack<Character> stack = new StackImplement<Character>(inputStr.length());
        for (int i = 0; i < inputStr.length(); i++) {
            stack.push(inputStr.charAt(i));
        }
        StringBuilder outputStr = new StringBuilder();
        while (!stack.isEmpty())
            outputStr.append(stack.pop());
        return outputStr.toString();
    }
}
