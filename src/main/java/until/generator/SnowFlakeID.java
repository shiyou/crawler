package until.generator;

public class SnowFlakeID {

	private long sequence = 0L;
	private long lastTimestamp = -1L;
	private final long workerId;
	private final static long DEFAULT_WORKER_ID = 2;
	private final static long TWEPOCH = 1288834974657L;
	private final static long WORKER_ID_BITS = 4L;
	private final static long MAX_WORKER_ID = -1L ^ -1L << WORKER_ID_BITS;
	private final static long SEQUENCE_BITS = 10L;
	private final static long WORKER_ID_SHIFT = SEQUENCE_BITS;
	private final static long TIMESTAMPLE_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
	private final static long SEQUENCE_MASK = -1L ^ -1L << SEQUENCE_BITS;

	public SnowFlakeID() {
		this(DEFAULT_WORKER_ID);
	}
	
	public SnowFlakeID(final long workerId) {
		super();
		if (workerId > MAX_WORKER_ID || workerId < 0) {
			throw new IllegalArgumentException(
					String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
		}
		this.workerId = workerId;
	}

	public synchronized long nextId() {
		long timestamp = this.timeGen();
		if (this.lastTimestamp == timestamp) {
			this.sequence = (this.sequence + 1) & SEQUENCE_MASK;
			if (this.sequence == 0) {
				timestamp = this.tilNextMillis(this.lastTimestamp);
			}
		} else {
			this.sequence = 0;
		}
		if (timestamp < this.lastTimestamp) {
			try {
				throw new Exception(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",
						this.lastTimestamp - timestamp));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.lastTimestamp = timestamp;
		long nextId = ((timestamp - TWEPOCH << TIMESTAMPLE_LEFT_SHIFT)) | (this.workerId << WORKER_ID_SHIFT)
				| (this.sequence);
		return nextId;
	}

	private long tilNextMillis(final long lastTimestamp) {
		long timestamp = this.timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = this.timeGen();
		}
		return timestamp;
	}

	private long timeGen() {
		return System.currentTimeMillis();
	}
	
	public static void main(String[] args) {
		SnowFlakeID worker2 = new SnowFlakeID();
		System.out.println("generated id = " + worker2.nextId());
		System.out.println(1288834974657L << 14L);
//		SnowFlakeID worker= new SnowFlakeID();
		SnowFlakeID worker = SnowFlakeFactory.getSnowFlakeID();
			for (int i = 0; i < 98; i++) {
				System.out.println(worker.nextId());
			}
	}

}