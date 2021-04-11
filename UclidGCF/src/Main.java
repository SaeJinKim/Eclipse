import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		
		long gcf = GCF_algorithm(input[0], input[1]);
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		for(int i =1; i<=gcf; i++) {
			if(gcf%i==0) {
				num.add(i);
			}
		}
		
		for(int i = 1; i<=num.size(); i++) {
			System.out.println(num.get(i-1)+" "+input[0]/num.get(i-1)+" "+input[1]/num.get(i-1));
		}
	}
	
	
	//�ִ� ����� �˰��� (��Ŭ����)
	public static long GCF_algorithm(long a, long b) {
		long tmp;
		long result;
		
		//ū�� ����
		if(a<b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		
		//��Ŭ���� ��� ���ϱ�
		long n = a%b;
		
		if(n == 0) {
			return b;
		}else {
			result = GCF_algorithm(b, n);
			return result;
		}
		
		
	}
}
