import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        int days = Integer.parseInt(parts[0]);
        String startDay = parts[1];
        Map<String, Integer> daysMap = new HashMap<>();
        daysMap.put("Monday", 0);
        daysMap.put("Tuesday", 1);
        daysMap.put("Wednesday", 2);
        daysMap.put("Thursday", 3);
        daysMap.put("Friday", 4);
        daysMap.put("Saturday", 5);
        daysMap.put("Sunday", 6);

        int startOffset = daysMap.get(startDay);
        String[] calendar = new String[days + startOffset];

        for (int i = 0; i < startOffset; i++) {
            calendar[i] = "..";
        }

        for (int i = 1; i <= days; i++) {
            if (i < 10) {
                calendar[startOffset + i - 1] = "." + i;
            } else {
                calendar[startOffset + i - 1] = String.valueOf(i);
            }
        }

        for (int i = 0; i < calendar.length; i++) {
            writer.write(calendar[i]);

            if ((i + 1) % 7 == 0 || i == calendar.length - 1) {
                writer.write("\n");
            } else {
                writer.write(" ");
            }
        }

        reader.close();
        writer.close();
    }
}