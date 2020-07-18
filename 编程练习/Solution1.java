/**
 * @program: HH_STUDY
 * @description:构建成绩数组  https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&&tqId=11204&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @author: qiu haoran
 * @create: 2020-07-18 22:53
 */
import java.util.ArrayList;
public class Solution1 {
    public int[] multiply(int[] A){
        int len=A.length;
        int [] B=new int[len];
        for(int i=0;i<len;i++){
            B[i]=1;
            for(int j=0;j<len;j++){
                if(j!=i)
                    B[i]*=A[j];
            }
        }
        return B;
    }
}