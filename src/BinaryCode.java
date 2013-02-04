import java.util.Arrays;

public class BinaryCode {
	
	int[] convertToIntArr(String m){
		int[] codes = new int[m.length()];
		for(int i = 0; i < m.length(); i++){
			codes[i] = Integer.parseInt(m.charAt(i)+"");
		}
		
		return codes;
	}
	
	String decodeSub(int[] Q, int qFirst){
		int[] P = new int[Q.length];
		P[0] = qFirst;
		for(int i = 0; i < Q.length-1; i++){
			if(i == 0){
				P[i+1] = Q[i] - qFirst;
				if(P[i+1] >1 || P[i+1]< 0) return "NULL";
			}else if (i == Q.length-2){
				P[i+1] = Q[i+1] - P[i];
				if(P[i+1] >1 || P[i+1]< 0) return "NULL";
			}else{
				P[i+1] = Q[i] - P[i] - P[i-1];
				if(P[i+1] >1 || P[i+1]< 0) return "NULL";
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int d:P){
			sb.append(d);
		}
		return sb.toString();
		
	}
	
	public String[] decode(String message){
		int[] Q = convertToIntArr(message);
		if(Q.length == 1 && Q[0]>1){
			return new String[]{"NULL", "NULL"};
		}
		String P1 = decodeSub(Q, 0);
		String P2 = decodeSub(Q, 1);
		
		return new String[]{P1, P2};
	}
	
	public static void main(String[] args){
		String t = "123210120";
		BinaryCode b = new BinaryCode();
		String[] r = b.decode(t);
		System.out.println(r[0]+"\n"+r[1]);
	}
}
