package thinkinjava;

/**
 * 枚举类型也是类的一种
 * ordinal()为当前类型的排序位置
 * values()得到所有枚举类型数组
 * @author zhoumo
 *
 */
public class EnumTest {
	public static void main(String[] args) {
//		PaperMoney paperMoney1 = PaperMoney.yy;
//		for(PaperMoney money:PaperMoney.values()){
//			System.out.println(money+","+money.ordinal());
//		}
		separate(PaperMoney.wy);
		separate(PaperMoney.sy);
		separate(PaperMoney.esy);
		separate(PaperMoney.wsy);
		separate(PaperMoney.yby);
		separate(PaperMoney.一百元);
	}
	static void separate(PaperMoney enumDemo){
		switch(enumDemo){
			case yy:
			case wy:
			case sy:
				System.out.println("十元及十元以下的纸币:"+enumDemo+",序号是:"+enumDemo.ordinal());
				break;
			case esy:
			case wsy:
			case yby:
			case 一百元:
				System.out.println("大面额纸币:"+enumDemo+",序号是:"+enumDemo.ordinal());
				break;
				default:
					System.out.println("无法识别的纸币");
					break;
					
		}
	}
}
