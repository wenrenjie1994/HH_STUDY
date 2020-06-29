package com.spdb.study.design.pattern.prototype.deep;

/**
 *
 * @author Mr.Longyx
 * @date 2020年06月26日 0:02
 */
public class DeepCloneTest {
    public static void main(String[] args) {
        GreatSageEquallingHeaven greatSageEquallingHeaven = new GreatSageEquallingHeaven();
        try{
            GreatSageEquallingHeaven copy = (GreatSageEquallingHeaven)greatSageEquallingHeaven.clone();
            System.out.println("深克隆："+(greatSageEquallingHeaven.goldenCudgel == copy.goldenCudgel));
        }catch (Exception e){
            e.printStackTrace();
        }

        GreatSageEquallingHeaven sageEquallingHeaven = new GreatSageEquallingHeaven();
        GreatSageEquallingHeaven n = sageEquallingHeaven.shallowClone(sageEquallingHeaven);
        System.out.println("浅克隆："+(sageEquallingHeaven.goldenCudgel == n.goldenCudgel));
    }
}
