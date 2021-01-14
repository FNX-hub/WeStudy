package logic.control;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import logic.model.Meeting;
import logic.model.Observer;
import logic.model.Parent;
import logic.model.Professor;
import logic.model.bean.MeetingBean;
import logic.model.dao.DaoFactory;

/**
 * @author Simone
 */
public class ManageMeetingControl implements Runnable {

	private Thread daemon;
	private final AtomicBoolean running = new AtomicBoolean(false);
	private final AtomicBoolean stopped = new AtomicBoolean(true);
	private static final int INTERVAL = 600000;
	
	public List<MeetingBean> getUserMeeting() {
		return null;
	}
	
	public void newMeeting(MeetingBean bean) {
		start();
	}
	
	private void abortMeeting() {
		stop();
	}
	
	public Boolean confirmMeeting() {
		if(isRunning()) {
			stop();
			//meetingDao.addMeeting(meeting);
			SimpleLogger.info("Meeting confirmed");
			return true;
		}
		return false;
	}
	
	public void deleteMeeting(MeetingBean bean) {
	}

//	Thread management
	
	/**
	 * Start a new {@link Thread} 
	 */
	public synchronized void start() {
		this.daemon =  new Thread(this);
		SimpleLogger.info("Start daemon...");
		daemon.start();
	}
	
	/**
	 * Stop the {@link Thread}
	 */
	public void stop() {
		SimpleLogger.info("Interrupting daemon...");
		running.set(false);
		daemon.interrupt();
		SimpleLogger.info("Daemon is interrupted");
	}
	
	public boolean isRunning() {
		return running.get();
	}
	
	public boolean isStopped() {
		return stopped.get();
	}
	
	/**
	 * Define the behavior of the {@link Thread}: it runs until it's killed by 
	 * confirmation of a {@link Meeting} or the interval expires.
	 * @implSpec It's synchronized so that only one {@link Thread} can execute at a time 
	 */
	@Override
	public synchronized void run() {
		running.set(true);
		SimpleLogger.info("Daemon is running...");
		stopped.set(false);
		while(running.get()) {
			try {
				wait(INTERVAL);
				abortMeeting();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		stopped.set(true);
	}
	
//	// TODO eliminare metodo statico serve solo da debud
//	public static void main(String[] args) {
//		ManageMeetingControl c = new ManageMeetingControl();
//		Meeting m = c.newMeeting(null, null, null, null);		
//		Thread t = new Thread() {
//			@Override
//			public void run() {
//					try {
//							
//						while(true) {
//							sleep(10);
//							c.confirmMeeting(m);
//							c.confirmMeeting(m);
//							c.confirmMeeting(m);
//							c.confirmMeeting(m);
//							c.confirmMeeting(m);
//							Thread.currentThread().interrupt();
//						}
//					} catch(Exception e) {}
//			}	
//		};
//		t.start();
//	}
}
