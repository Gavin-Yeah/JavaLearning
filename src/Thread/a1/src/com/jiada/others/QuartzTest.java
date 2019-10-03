/* 
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */
 
package Thread.a1.src.com.jiada.others;

import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * This Example will demonstrate how to start and shutdown the Quartz scheduler and how to schedule a job to run in
 * Quartz.
 * 
 * @author Bill Kratzer
 */
public class QuartzTest {

  public void run() throws Exception {
    //Logger log = LoggerFactory.getLogger(SimpleExample.class);

 //   log.info("------- Initializing ----------------------");

    // First we must get a reference to a scheduler
  //创建scheduler工厂
	  SchedulerFactory sf = new StdSchedulerFactory();
	  //从工厂获得调度器
    Scheduler sched = sf.getScheduler();


    // computer a time that is on the next round minute
    Date runTime = evenSecondDateAfterNow();

   

    // define the job and tie it to our HelloJob class
    //3.创建jobdetail
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
    //4.触发器
    // Trigger the job to run on the next round minute
   // Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).withSchedule(simpleSchedule().withIntervalInSeconds(5).withRepeatCount(3)).build();

    // Tell quartz to schedule the job using our trigger
    //注册任务和触发条件
    sched.scheduleJob(job, trigger);
  //  log.info(job.getKey() + " will run at: " + runTime);

    // Start up the scheduler (nothing can actually run until the
    // scheduler has been started)
    //启动
    sched.start();

  //  log.info("------- Started Scheduler -----------------");

    // wait long enough so that the scheduler as an opportunity to
    // run the job!
   // log.info("------- Waiting 65 seconds... -------------");
    try {
      // wait 5 seconds to show job
      Thread.sleep(50L * 1000L);
      // executing...
    } catch (Exception e) {
      //
    }

    // shut down the scheduler
  //  log.info("------- Shutting Down ---------------------");
    sched.shutdown(true);
  //  log.info("------- Shutdown Complete -----------------");
  }

  public static void main(String[] args) throws Exception {

    QuartzTest example = new QuartzTest();
    example.run();

  }

}
