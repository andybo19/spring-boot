package com.example.demo.controller;

import com.example.demo.concurrent.SoulThreadFactory;
import com.example.demo.domain.User;
import com.example.demo.service.user.IUserService;
import com.example.demo.util.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/30 19:26
 */
@Controller
@Slf4j
public class AsyncController {

    private final ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1,
            SoulThreadFactory.create("long-polling", true));

    /**
     * The maximum timeout of server block is 60s.
     */
    public static final long SERVER_MAX_HOLD_TIMEOUT = TimeUnit.SECONDS.toMillis(10);

    @Autowired
    private IUserService userService;


    @RequestMapping("/longPolling")
    public void longPolling(HttpServletRequest request, HttpServletResponse response){
        AsyncContext asyncContext = request.startAsync();
        // AsyncContext.settimeout() does not timeout properly, so you have to control it yourself
        //asyncContext.setTimeout(20*1000L);
        asyncContext.setTimeout(0L);
        System.out.println("++++++++++++++++++");
        scheduler.execute(new AsyncThreadTask(asyncContext));
        /*generateResponse(response,"{\n" +
                "  \"timeLine\": 3,\n" +
                "  \"historyCount\": 3,\n" +
                "  \"historyDays\": 14\n" +
                "}");*/

    }

    class AsyncThreadTask implements Runnable {

        private AsyncContext asyncContext;

        public AsyncThreadTask(AsyncContext asyncContext){
            this.asyncContext = asyncContext;
        }

        @Override
        public void run() {
            HttpServletRequest request = (HttpServletRequest) asyncContext.getRequest();
            String userName = request.getParameter("userName");
            User user = getUser(userName);
            try {
                Thread.sleep(SERVER_MAX_HOLD_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            generateResponse((HttpServletResponse) asyncContext.getResponse(), GsonUtils.getInstance().toJson(user));
            asyncContext.complete();
        }
    }

    User getUser(String name){
        User user = new User();
        user.setUserName("andy");
        user.setMobileNumber("123");
        return user;
        //return userService.findByName(name);
    }


    /**
     * Send response datagram.
     *
     * @param response      the response
     */
     void generateResponse(final HttpServletResponse response,String json) {
        try {
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-cache,no-store");
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(json);
        } catch (IOException ex) {
            log.error("Sending response failed.", ex);
        }
    }


}
