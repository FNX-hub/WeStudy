package logic.control;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import logic.model.Meeting;
import logic.model.Observer;
import logic.model.User;
import logic.model.bean.MeetingBean;
import logic.model.bean.UserBean;
import logic.model.bean.UserType;
import logic.model.dao.DaoFactory;

/**
 * @author Simone
 */
public class ManageMeetingControl implements Runnable, Observer {

	private Thread daemon;
	private final AtomicBoolean running = new AtomicBoolean(false);
	private final AtomicBoolean stopped = new AtomicBoolean(true);
	private static final int INTERVAL = 600000;
	private MeetingBean bean;
	
	/**
	 * Query the DB to get a list of Meetings 
	 * @param userId - {@link Integer}
	 * @param type - {@link UserType}
	 * @return {@code List<}{@link MeetingBean} {@code >}
	 * @return {@code List<}{@link MeetingBean} {@code >}
	 */
	public List<MeetingBean> getUserMeeting(Integer userId, UserType type) {
		List<Meeting> meetingList;
		if(type.equals(UserType.PARENT)) {
			meetingList = DaoFactory.getMeetingDao().getFromParent(userId);
		}
		else {
			meetingList = DaoFactory.getMeetingDao().getFromProfessor(userId);
		}
		List<MeetingBean> beanList = new ArrayList<>();
		meetingList.forEach(m -> 
		{
			String parent = DaoFactory.getParentDao().getFromId(m.getParentId()).getSurname();
			String professor = DaoFactory.getProfessorDao().getFromId(m.getProfessorId()).getSurname();
			beanList.add(new MeetingBean(m.getParentId(), m.getProfessorId(), m.getDate(), m.getMessage(), parent, professor));
		});
		return beanList;
	}
	
	/**
	 * Query the DB to get a list of possible Users that can be meet
	 * @param bean - {@link UserBean}
	 * @return {@code List<}{@link UserBean} {@code >} 
	 */
	public List<UserBean> getUserToMeet(UserBean bean) {
		List<User> userList = new ArrayList<>();
		List<UserBean> beanList = new ArrayList<>();
		if(bean.getType().equals(UserType.PARENT)) {
			userList.addAll(DaoFactory.getProfessorDao().getAll());
			userList.forEach(user -> beanList.add(new UserBean(UserType.PARENT, user.getId(), user.getSurname())));
		} else {
			userList.addAll(DaoFactory.getParentDao().getAll());
			userList.forEach(user -> beanList.add(new UserBean(UserType.PROFESSOR, user.getId(), user.getSurname())));
		}
		return beanList;
	}
	
	
	
	/**
	 * Start the thread initializing the booking process
	 * @param bean - {@link MeetingBean}
	 */
	public void newMeeting(MeetingBean bean) {
		this.bean = bean;
		this.bean.attach(this);
		start();
	}
	
	/**
	 * Kill the thread and abort the booking  
	 */
	private void abortMeeting() {
		stop();
		this.bean = null;
	}
	
	/**
	 * Save in persistence the Meeting
	 * @param bean - {@link MeetingBean}
	 */
	public void deleteMeeting(MeetingBean bean) {
		Meeting m = new Meeting(bean.getParentId(), bean.getProfessorId(), bean.getDate(), bean.getMessage());
		DaoFactory.getMeetingDao().delete(m);
	}
	
	@Override
	public void update() {
		try{
		if(bean.getConfirmed().booleanValue()) {
			Meeting m = new Meeting(bean.getParentId(), bean.getProfessorId(), bean.getDate(), bean.getMessage());
			DaoFactory.getMeetingDao().save(m);
			this.bean = null;
		} else {
			this.bean = null;
		}
		} catch (NullPointerException e) {
			SimpleLogger.severe(e.getLocalizedMessage());
		}
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
	 * a {@link Meeting} confirmation or the interval expires.
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

}
