public class Suanshu {
    public static void main(String[] args) {
        int i,j,k,l;
        i=1;
        j=1;
        k=1;
        l=1;
        outloop:
        for(i=1;i<8;i++){
            for(j=1;j<8;j++){
                for(k=1;k<14;k++){
                    for(l=1;l<10;l++){
                        if((i+j==8)&&(k-l==6)&&(i+k==14)&&(j+l==10)){
                            System.out.println("i="+i+' '+"j="+j+' '+"k="+k+' '+"l="+l+' ');
                            break outloop;
                        }
                    }
                }
            }
        }

    }
}
