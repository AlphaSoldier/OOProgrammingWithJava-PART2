package reader;

import reader.criteria.*;

public class Main {

    public static void main(String[] args) {
        String address = "https://www.gutenberg.org/files/2554/2554-h/2554-h.htm";
        GutenbergReader book = new GutenbergReader(address);

        Criterion criterion = new EndsWithQuestionOrExclamationMark();

        for (String line : book.linesWhichComplyWith(criterion)) {
            System.out.println(line);
        }
    }
}
