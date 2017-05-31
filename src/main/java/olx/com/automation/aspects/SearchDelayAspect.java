package olx.com.automation.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import olx.com.automation.utils.PageUtils;

@Aspect
public class SearchDelayAspect {

	private static int DEFAULT_WAITING_TIME = 3000;
	
	@Pointcut("execution(* olx.com.automation.pages.components.HeaderSearch.perform(..))")
	public void waitPageLoad() {}

	@After("waitPageLoad()")
	public void after(JoinPoint joinPoint) {
		System.out.println("waitPageLoad() " + joinPoint.toLongString());
		/*try {
			Thread.sleep(DEFAULT_WAITING_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		PageUtils.checkPageIsReady();
	}
}
