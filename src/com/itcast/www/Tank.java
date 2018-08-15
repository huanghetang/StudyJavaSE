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
			System.out.println("当前对象将被回收，empty="+this.empty);
		}else{
			System.out.println("终结条件不成立，错误");
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
