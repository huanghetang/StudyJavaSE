package thinkinjava;

/**
 * ö������Ҳ�����һ��
 * ordinal()Ϊ��ǰ���͵�����λ��
 * values()�õ�����ö����������
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
		separate(PaperMoney.һ��Ԫ);
	}
	static void separate(PaperMoney enumDemo){
		switch(enumDemo){
			case yy:
			case wy:
			case sy:
				System.out.println("ʮԪ��ʮԪ���µ�ֽ��:"+enumDemo+",�����:"+enumDemo.ordinal());
				break;
			case esy:
			case wsy:
			case yby:
			case һ��Ԫ:
				System.out.println("�����ֽ��:"+enumDemo+",�����:"+enumDemo.ordinal());
				break;
				default:
					System.out.println("�޷�ʶ���ֽ��");
					break;
					
		}
	}
}
