package lecture08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME05Html {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> html = new ArrayList<>();
        html.add("<h1>\n    " + scanner.nextLine() + "\n</h1>");
        html.add("<article>\n    " + scanner.nextLine() + "\n</article>");
        String comment = scanner.nextLine();
        while (!comment.equals("end of comments")){
            html.add("<div>\n    " + comment + "\n</div>");
            comment= scanner.nextLine();
        }
        html.forEach(System.out::println);

    }
}
