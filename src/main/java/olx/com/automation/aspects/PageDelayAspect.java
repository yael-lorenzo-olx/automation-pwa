package olx.com.automation.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import olx.com.automation.utils.PageUtils;

@Aspect
public class PageDelayAspect {

	//private static int DEFAULT_WAITING_TIME = 500;
	
	@Pointcut("execution(* olx.com.automation.pages..*(..))")
	public void waitPageLoad() {}

	@After("waitPageLoad()")
	public void after(JoinPoint joinPoint) {
		System.out.println("waitPageLoad() " + joinPoint.toLongString());
		/*try {
			Thread.sleep(DEFAULT_WAITING_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		PageUtils.checkPageIsReady();
	}
}
