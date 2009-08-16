package org.doubleit.service.handlers;

import java.io.PrintStream;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.ws.handler.MessageContext;

public class BaseHandler<T extends MessageContext> {
	   protected String HandlerName = null;

	   protected PrintStream out = System.out;

	   @PostConstruct
	   public void init() {
	      out.println("------------------------------------");
	      out.println("In Handler " + HandlerName + ":init()");
	      out.println("Exiting Handler " + HandlerName + ":init()");
	      out.println("------------------------------------");
	   }

	   @PreDestroy
	   public void destroy() {
	      out.println("------------------------------------");
	      out.println("In Handler " + HandlerName + ":destroy()");
	      out.println("Exiting Handler " + HandlerName + ":destroy()");
	      out.println("------------------------------------");
	   }


	   public boolean handleFault(T mc) {
	      out.println("------------------------------------");
	      out.println("In Handler " + HandlerName + ":handleFault()");
	      out.println("Exiting Handler " + HandlerName + ":handleFault()");
	      out.println("------------------------------------");
	      return true;
	   }
	   
	   public void close(MessageContext mc) {
	      out.println("------------------------------------");
	      out.println("In Handler " + HandlerName + ":close()");
	      out.println("Exiting Handler " + HandlerName + ":close()");
	      out.println("------------------------------------");
	   }

	   public void setHandlerName(String handlerName) {
	      HandlerName = handlerName;
	   }
	   
	}
