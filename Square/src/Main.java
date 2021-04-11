import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp = br.readLine().split(" ");
		int[] input = new int[6];
		double shor;
		double lon;
		double result;
		List<Double> len = new ArrayList<Double>();
		
		for(int i=0; i<tmp.length; i++) {
			input[i] = Integer.parseInt(tmp[i]);
		}
		
		if((input[3]-input[1])*(input[4]-input[2]) != (input[5]-input[3])*(input[2]-input[0])) {
			len.add(Math.sqrt((Math.pow((input[2]-input[0]),2) + Math.pow((input[3]-input[1]),2))));
			len.add(Math.sqrt((Math.pow((input[4]-input[2]),2) + Math.pow((input[5]-input[3]),2))));
			len.add(Math.sqrt((Math.pow((input[4]-input[0]),2) + Math.pow((input[5]-input[1]),2))));
			Collections.sort(len);

			shor=len.get(0);
			lon=len.get(2);
			result = (lon*2-shor*2);
		
			System.out.println(result);
		}else {
			System.out.println(-1);
		}
		
	}
}
 