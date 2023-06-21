package basic;


// 1.19
// 1시간 이내에 F(N)을 구할 수 있는 N의 최댓값
// 연산 시간이 줄도록 계산 결과를 배열에 저장해서 재활용하는 코드를 추가해보라
public class FIbonacci {

    // 연산 결과를 미리 저장해두는 배열 추가

    // 배열 원소 n의 값은 F(n)
    // ex. resultArr[82] = F(82)
    private static long[] resultArr = new long[90];
    static {
        resultArr[0] = 0;
        resultArr[1] = 1;
    }

    public static long F(int N){
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }
    public static long F_(int N){
        /*if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);*/

        if(N <= 1){
            return resultArr[N];
        }
        // 1보다 크면 먼저 해당 값이 있는지 조사
        // 있으면 해당 값 리턴
        if(resultArr[N] != 0){
            return resultArr[N];
        }
        // 아직 없으면 연산
        resultArr[N] = F_(N-1) + F_(N-2);
        return resultArr[N];
    }
    /**
     * 0    0
     * 1    1
     * 2    F1+F0
     *      1 + 0 = 1
     * 3    F2 + F1
     *      1 + 1  = 2
     *      ...
     * */

    public static void main(String[] args) {
        for (int N = 0; N < 90; N++)
            System.out.println(N + " " + F_(N));
    }
}
