import java.io.*;
import java.util.*;

public class SolutionSimpleTextEditor {

    static class UndoOp {
        int type;
        int len;
        String str;

        UndoOp(int type, int len) {
            this.type = type;
            this.len = len;
        }

        UndoOp(int type, String str) {
            this.type = type;
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        int q = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();
        Deque<UndoOp> stack = new ArrayDeque<>();

        for (int i = 0; i < q; i++) {
            String req = br.readLine();
            if (req == null) break;

            int spaceIdx = req.indexOf(' ');
            int type;
            String arg = "";

            if (spaceIdx != -1) {
                type = Integer.parseInt(req.substring(0, spaceIdx));
                arg = req.substring(spaceIdx + 1);
            } else {
                type = Integer.parseInt(req.trim());
            }

            if (type == 1) {
                // Operation 1: Append
                sb.append(arg);
                stack.push(new UndoOp(1, arg.length()));
            } else if (type == 2) {
                int k = Integer.parseInt(arg);
                String deletedStr = sb.substring(sb.length() - k);
                sb.delete(sb.length() - k, sb.length());
                stack.push(new UndoOp(2, deletedStr));
            } else if (type == 3) {
                int k = Integer.parseInt(arg);
                System.out.println(sb.charAt(k - 1));
            } else if (type == 4) {
                UndoOp op = stack.pop();
                if (op.type == 1) {
                    sb.delete(sb.length() - op.len, sb.length());
                } else if (op.type == 2) {
                    sb.append(op.str);
                }
            }
        }
    }
}