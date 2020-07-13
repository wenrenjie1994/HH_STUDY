switch(表达式){
	case 常量值1：
		语句1；
		break；
	case 常量值2：
		语句2；
		break；
	。。。。。。
	default：	//类似于if_else中最后一个else
		语句n+1；
		break；//强烈建议不要省去

}
【注意】
1.多个case后面的数值不可重复；
2.switch后面小括号中只能是夏磊数据类型；
基本数据类型：byte、short、char、int；
引用数据类型：String字符串、enum枚举。
3.case的顺序可以交换。