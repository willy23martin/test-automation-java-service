package com.test.automation.project.testautomationjavaservicebackend.api.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import java.io.IOException;
import java.util.Map;

@Component
public class RestResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception exception) {
        try {
            if (exception instanceof IllegalArgumentException) {
                return handleIllegalArgument(
                        (IllegalArgumentException) exception, response);
            }
        } catch (Exception handlerException) {
        }
        return null;
    }

    private ModelAndView
    handleIllegalArgument(IllegalArgumentException exception, HttpServletResponse response)
            throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        View view = new View() {
            @Override
            public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(exception.getMessage());
                response.getWriter().flush();
            }
        };
        ModelAndView modelAndView = new ModelAndView(view);
        return modelAndView;
    }
}
