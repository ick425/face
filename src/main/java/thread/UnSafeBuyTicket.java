package thread;

/**
 * 不安全的买票
 */
public class UnSafeBuyTicket {
	public static void main(String[] args) {
		BuyTicket buyTicket = new BuyTicket();
		new Thread(buyTicket, "小明").start();
		new Thread(buyTicket, "app").start();
		new Thread(buyTicket, "黄牛").start();
	}
}

class BuyTicket implements Runnable {
	/**
	 * 总票数
	 */
	private int num = 10;
	/**
	 * 是否有票
	 */
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			try {
				buy();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 模拟买票
	 */
	private void buy() throws InterruptedException {
		if (num <= 0) {
			// 卖光了
			System.out.println("卖光了--》" + num);
			flag = false;
			return;
		}
		Thread.sleep(100);
		// 买票
		System.out.println(Thread.currentThread().getName() + "-->拿到了第" + num-- + "张票");
	}

}