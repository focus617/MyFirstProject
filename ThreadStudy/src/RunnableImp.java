
class RunnableImpl implements Runnable {
	int i = 10;

	public void run() {
		while (true) {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName() + "--->" + i--);
				if (i <= 0) {
					break;
				}

				try {
					Thread.sleep(50);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		}
	}
}
