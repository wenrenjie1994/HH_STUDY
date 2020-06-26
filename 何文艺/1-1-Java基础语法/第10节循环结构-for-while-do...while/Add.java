public class Add{
	public static void main(String[] args){
		int i;
		int sum = 0;
		for(i = 1; i <= 100 ; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("forÑ­»·£º" + sum);
		i = 1;
		sum = 0;
		while( i <= 100) {
			if(i % 2 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("whileÑ­»·£º" + sum);
		i = 1;
		sum = 0;
		do{
			if(i % 2 == 0) {
				sum += i;
			}
			i++;
		}while(i <= 100);
		System.out.println("do-whileÑ­»·£º" + sum);
	}
}