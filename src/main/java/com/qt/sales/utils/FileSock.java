package com.qt.sales.utils;

import java.util.concurrent.ConcurrentHashMap;

public class FileSock {

	public static class Lock {
		int ref = 0;
		public String num;
	}

	public static class FileLock {
	    private static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();

		public FileLock() {
		}

		public Lock getLock(String fileName) {
			synchronized (this) {
				Lock lock;
				if (map.containsKey(fileName)) {
					lock = (Lock) map.get(fileName);
				} else {
					lock = new Lock();
					lock.num = fileName;
					map.put(fileName, lock);
				}
				lock.ref++;
				return lock;
			}
		}

		public void putLock(Lock lock) {
			synchronized (this) {
				lock.ref--;
				if (lock.ref == 0) {
					map.remove(lock.num);
				}
			}
		}
	}


}