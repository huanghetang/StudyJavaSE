package com.itcast.www;


public class Tank {
	private boolean empty=true;
	Tank(){
		empty=false;
	}
	public void drawOff(){
		empty = true;
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		if(empty){
			System.out.println("��ǰ���󽫱����գ�empty="+this.empty);
		}else{
			System.out.println("�ս�����������������");
		}
		super.finalize();

	}
	
	public static void main(String[] args) {
		for(int i=0;i<1000;i++){
			Tank tank = new Tank();
			tank.drawOff();
		}
		System.gc();
	
		
		
	}

}
