package pro;

import java.io.*;
import java.util.StringTokenizer;

public class SectionSum_2042_3 {

    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int updateCnt = Integer.parseInt(st.nextToken());
        int renderCnt = Integer.parseInt(st.nextToken());

        int[] nums = new int[numCnt + 1];
        for (int i = 1; i <= numCnt; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int cnt = updateCnt + renderCnt;
        int pow = (int) (Math.ceil(Math.log(numCnt) / Math.log(2))) + 1;
        int size = (int) Math.pow(2, pow);
        tree = new int[size];

        init(1, 1, numCnt, nums);

        while (cnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int diff = val - nums[idx];
                nums[idx] = val;
                update(1, idx, 1, numCnt, diff);
            } else {
                int sum = sum(1, idx, val, 1, numCnt);
                bw.write(sum+"\n");
            }
        }


        br.close();
        bw.close();

    }

    static int init(int node, int s, int e, int[] nums) {
        if (s >= e)
            return tree[node] = nums[s];

        int mid = (s + e) / 2;
        return tree[node] = init(node * 2, s, mid, nums) + init(node * 2 + 1, mid + 1, e, nums);
    }

    static void update(int node, int idx, int s, int e, int diff) {
        if (idx < s || e < idx)
            return;

        if (s <= idx && idx <= e)
            tree[node] += diff;

        if (s >= e)
            return;

        int mid = (s + e) / 2;
        update(node*2, idx, s, mid, diff);
        update(node*2+1, idx, mid+1, e, diff);
    }

    static int sum(int node, int left, int right, int s, int e) {
        if (e < left || s > right)
            return 0;

        if (left <= s && e <= right)
            return tree[node];

        int mid = (s + e) / 2;
        return sum(node * 2, left, right, s, mid) + sum(node * 2 + 1, left, right, mid + 1, e);
    }

}