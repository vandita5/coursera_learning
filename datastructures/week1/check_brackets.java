import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        Bracket instance_brack = new Bracket();
        Bracket to_push;
        Bracket popped;
        boolean result = true;

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                to_push.type = next;
                to_push.position = position;
                opening_brackets_stack.push(to_push);
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                popped = opening_brackets_stack.pop();
                result = instance_brack.Match(popped.type);
                if (!result) {
                  break;
                }
            }
        }

        // Printing answer, write your code here
        if (result) {
          System.out.println("Success");
        }
        else {
          System.out.println(popped.position+1);
        }
    }
}
