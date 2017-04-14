package cn.holter.ftpserver;

import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;  
  
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.impl.DefaultFtpServer;  
import org.springframework.web.context.WebApplicationContext;  
import org.springframework.web.context.support.WebApplicationContextUtils;  
  
public class FtpServerListener1 implements ServletContextListener {  
  
  public void contextDestroyed(ServletContextEvent sce) {  
    System.out.println("Stopping FtpServer");  
    DefaultFtpServer server = (DefaultFtpServer) sce.getServletContext().getAttribute("FtpConstants.FTPSERVER_CONTEXT_NAME");  
    if (server != null) {  
      server.stop();  
      sce.getServletContext().removeAttribute("FTPSERVER_CONTEXT_NAME");  
      System.out.println("FtpServer stopped");  
    } else {  
      System.out.println("No running FtpServer found");  
    }  
  }  
  
  public void contextInitialized(ServletContextEvent sce) {  
    System.out.println("Starting FtpServer");  
    WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());  
    DefaultFtpServer server = (DefaultFtpServer) ctx.getBean("StrongFTP");  
    sce.getServletContext().setAttribute("FTPSERVER_CONTEXT_NAME", server);  
    try {  
      server.start();  
      System.out.println("FtpServer started");  
    } catch (Exception e) {  
      throw new RuntimeException("Failed to start FtpServer", e);  
    }  
  }  
}  
