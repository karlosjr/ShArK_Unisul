package dao;

public class SingletonBanco {
	static int flagFactory;
	
	private SingletonBanco(){
		
	}
	private static SingletonBanco singletonBanco = new SingletonBanco();
	
	
	public static SingletonBanco getInstance(){
		return singletonBanco;
		
	}
	
	public void setFlag(int valor){
		this.flagFactory = valor;
	}
	
	public int getFlag (){
		return flagFactory;		
	}
	
	
}
