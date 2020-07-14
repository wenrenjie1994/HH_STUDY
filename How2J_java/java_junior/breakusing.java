// break结束当前循环
public class HelloWorld {
	public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                System.out.println(i+":"+j);
                if(0 == j % 2) break;
            }
        }
    }
}

// 使用 boolean 变量结束外部循环
public class HelloWorld {
	public static void main(String[] args) {
		boolean breakout = false;
		for (int i = 0; i < 10; ++j ) {
			for (int j = 0; j < 10; ++j ) {
				System.out.println(i + ":" +j);
				if (0 == j % 2) {
					breakout = true;
					break;				
				}
			}
			if (breakout) {
				break;
			}
		}
	}
}

// 使用标签结束外部循环
public class HelloWorld {
	public static void main(String[] args) {
		outloop:
		for (int i = 0; i <10; ++i) {
			for (int j = 0; j <10; ++j) {
				System.out.println(i + ":" + j);
				if(0 == j % 2) 
					break outloop;
			}
		}
	}
}