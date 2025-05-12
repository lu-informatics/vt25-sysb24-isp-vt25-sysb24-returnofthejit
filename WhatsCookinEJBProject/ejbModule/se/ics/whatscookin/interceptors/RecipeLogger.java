package se.ics.whatscookin.interceptors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class RecipeLogger {
	
	@AroundInvoke
	public Object logMethod(InvocationContext iCtx) throws Exception{
		System.out.println(" Interceptor körs:");
        System.out.println("Klass: " + iCtx.getTarget().getClass().getSimpleName());
        System.out.println("Metod: " + iCtx.getMethod().getName());
        return iCtx.proceed();
		
	}

}
