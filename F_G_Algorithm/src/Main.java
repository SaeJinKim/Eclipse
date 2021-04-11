import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static void main(String[] args) throws IOException {
		String[] temp = {};
		int n=0;
		int k=0;
		long t=0;

		
		/* N, T, K 가 주어지고, a~an까지  입력*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		t = Long.parseLong(temp[2]);
		
		int[] a = new int[n];
		int[] result = new int[k+1];
		

		temp = br.readLine().split(" ");
		for(int i = 0; i< temp.length; i++) {
			a[i] = Integer.parseInt(temp[i]);
		}
		
		
		
		String s = "";
		for(int i =0; i<k+1; i++) {
			result[i]=gx(t,i,a);
			s += result[i]+" ";
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(s);
		bw.flush();
		bw.close();
	}

	/* fx 알고리즘 전개 */
	public static int fx(int x,int k,int[] a) {
		int result = 0;
		
		for(int i =0; i< a.length;i++) {
			result += Math.pow(x+a[i], k);
		}
		
		return result;
	}
	
	/* gx 알고리즘 전개 */
	public static int gx(long t,int k,int[] a) {
		int result = 0;
	
		for(int i =0 ; i <= t; i++) {
			result += fx(i,k,a);
		}
		
		result %= (Math.pow(10, 9)+7);
		
		return  result;
	}
	
}
