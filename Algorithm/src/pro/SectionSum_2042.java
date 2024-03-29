package pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SectionSum_2042 {	
	static int N;
	static int nQuery;
	
	static int[] arr;
	static long[] treeArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		nQuery = Integer.parseInt(st.nextToken());
		nQuery+= Integer.parseInt(st.nextToken());
		
		arr = new int[N]; //���� �޴� ����Ʈ 
		
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//// �˰��� ����!! /////////
		
		//���׸�Ʈ Ʈ�� ��� ����� 
		//Ʈ���� ũ�⸦ ����ؼ� Ʈ���� �ʱ�ȭ ���ش�.
		int x = (int) Math.ceil(Math.log(N)/Math.log(2));
		int size = (int)Math.pow(2, x)*2;
		
		treeArr = new long[size];
		
		//�ʱⰪ�� ������ �ִ� �޼ҵ�
		init(arr,0,N-1,1);
		
		long result=0;
		
		while(nQuery-- > 0){
			st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int idx1 = Integer.parseInt(st.nextToken());
			int idx2 = Integer.parseInt(st.nextToken());
			
			if(t == 1){
				int diff=idx2 - arr[idx1-1]; 
				arr[idx1-1] = idx2; //arr�� ���� ������Ʈ �ؾ� �Ѵ�!!
				update(1,0,N-1,idx1-1,diff);
			}else{
				//result = sum(1,0,N-1,idx1-1,idx2-1);
				
				System.out.println(sum(1,0,N-1,idx1-1,idx2-1));
			}
		}	
	}
	
	/////// �ʱ�ȭ  ////////////
	static long init(int[] arr, int start, int end, int node) {
		if(start==end){
			return treeArr[node] = arr[start];
		}
		int mid = (start+end)/2;
		
		return treeArr[node]=init(arr,start,mid,node*2) + init(arr,mid+1,end,node*2+1);
	}
	
	////// 
	static void update(int node, int start, int end, int index, long diff){
		if(!(start<=index && end >= index)){
			return;
		}
		
		treeArr[node] += diff;
		
		if(start != end){
			int mid = (start + end) / 2;
			update(node*2, start, mid, index, diff);
			update(node*2+1, mid+1, end, index, diff);
		}
	}
	////////////
	static long sum(int node, int start, int end, int left, int right){
		if(left > end || right < start){
			return 0;
		}
		if(left <= start && end <= right){
			return treeArr[node];
		}
		int mid=(start+end)/2;
		return sum(node*2,start,mid,left,right)+sum(node*2+1,mid+1,end,left,right);
	}
}
