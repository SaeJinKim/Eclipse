import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input_num = Integer.parseInt(br.readLine());
		int[][] rgb = new int[input_num][3];
		int[][] tmp = new int[input_num][3];
		int result = Integer.MAX_VALUE;
		
		for(int i=0 ; i<input_num; i++) {
			rgb[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		tmp[0][0]=rgb[0][0];
		tmp[0][1]=rgb[0][1];
		tmp[0][2]=rgb[0][2];
		
		
		for(int i=1; i<rgb.length; i++) {
			tmp[i][0] = min(tmp[i-1][1],tmp[i-1][2])+rgb[i][0];
			tmp[i][1] = min(tmp[i-1][0],tmp[i-1][2])+rgb[i][1];
			tmp[i][2] = min(tmp[i-1][0],tmp[i-1][1])+rgb[i][2];
		}
		
		for(int i=0; i<3; i++) {
			if(tmp[input_num-1][i] < result) {
				result = tmp[input_num-1][i];
			}
		}
		

		System.out.println(result);
	}
	
	public static int min (int a, int b) {
		return a<b?a:b;
	}
}
