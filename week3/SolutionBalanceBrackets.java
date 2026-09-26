import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Result {
    public static String isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return "NO";
                }
            }
        }
        
        return stack.isEmpty() ? "YES" : "NO";
    }
}

public class SolutionBalanceBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so luong chuoi: ");
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            scanner.nextLine();
            
            for (int i = 0; i < t; i++) {
                String s = scanner.nextLine();
                System.out.println(Result.isBalanced(s));
            }
        }
        
        scanner.close();
    }
}
