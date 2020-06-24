java8实战训练
6.24 提交java8实战训练 第一、二章节基本内容
	基础知识
		第一章 java8主要变化
			Lambda表达式
				匿名函数的方式将函数作为值传递  （int x）-> x+1  参数x,返回x+1
			方法引用
				java8之前匿名类
                  File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
                        public boolean accept(File file) {
                        return file.isHidden();
                        }
                  });
				java8方法引用
                  File[] hiddenFiles = new File(".").listFiles(File::isHidden);
			流和默认方法
				Stream
				paralleStream
				默认方法 default
					可以不改变现有实现类的基础上扩充接口
		第二章 通过行为参数化传递代码
			应对不断变化的需求
				策略的设计模式
					申明接口，将具体类参数化传递到方法中
				Lambda表达
					Lambda和泛型编程结合在一起可以使代码复用更加灵活
			行为参数化
				一个方法接受多个不同的行为作为参数，在内部使用他们，完成不同行为的能力
			匿名类
				传递代码、为接口声明许多只用一次的实体类造成的啰嗦代码，可以在java8中采用匿名类减少
			Lambda表达式预览
			真实示例：Comparator、Runnable和GUI
