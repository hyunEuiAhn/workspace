package sample02;

public class HelloSpring {
	public static void main(String[] args) {
		MessageBean messageBean = new MessageBeanKo();//부모= 모든 자식클래스 참조 가능, 다형성, 결합도가 낮아진다.
		messageBean.sayHello("Spring");
		
	}
}
