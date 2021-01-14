package TabuleiroSecreto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Integer[][] table = new Integer[n][n];
        List<List<Integer>> operations = new ArrayList<List<Integer>>();

        /** Writes zero to every element in the matrix */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = 0;
            }
        }

        /** Reads operations */
        for (int i = 0; i < q; i++) {
            String temp = br.readLine();
            operations.add(Arrays.stream(temp.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }

        for (int i = 0; i < q; i++) {
            switch (operations.get(i).get(0)) {
                case 1: {
                    for (int j = 0; j < n; j++) {
                        table[operations.get(i).get(1) - 1][j] = operations.get(i).get(2);
                    }
                    break;
                }
                case 2: {
                    for (int j = 0; j < n; j++) {
                        table[j][operations.get(i).get(1) - 1] = operations.get(i).get(2);
                    }
                    break;
                }
                case 3: {
                    System.out.println(getMostRepeatedKey(countRepeatedItems(table, operations.get(i).get(1) - 1, -1)));
                    break;
                }
                case 4: {
                    System.out.println(getMostRepeatedKey(countRepeatedItems(table, -1, operations.get(i).get(1) - 1)));
                    break;
                }
            }
        }
    }

    static int getMostRepeatedKey(Map<Integer, Integer> map) {

        Integer[] freqIndex = new Integer[51];
        Arrays.fill(freqIndex, 0);

        for (int i = 0; i < 51; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) > freqIndex[i]) {
                    freqIndex[i] = map.get(i);
                }
            }
        }
        return Arrays.asList(freqIndex).lastIndexOf(Collections.max(Arrays.asList(freqIndex)));
    }

    static Map<Integer, Integer> countRepeatedItems(Integer[][] table, int line, int column) {

        Map<Integer,Integer> counterMap = new HashMap<>();

        if (line != -1) {
            for (int i = 0; i < table.length; i++){
                if (counterMap.containsKey(table[line][i])){
                    counterMap.put(table[line][i], counterMap.get(table[line][i]) + 1 );
                }
                else {
                    counterMap.put(table[line][i], 1);
                }
            }
        }
        else {
            for (Integer[] integers : table) {
                if (counterMap.containsKey(integers[column])) {
                    counterMap.put(integers[column], counterMap.get(integers[column]) + 1);
                } else {
                    counterMap.put(integers[column], 1);
                }
            }
        }
        return counterMap;
    }
}
