package com.digiboy.firmco.web.error.handler;

import org.springframework.stereotype.Component;

@Component
public class AccessDeniedHandlerImpl {
}
/*
implements AccessDeniedHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessDeniedHandlerImpl.class);

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            LOGGER.warn("User '{}' attempted to access the protected URL: {}",
                    auth.getName(),
                    httpServletRequest.getRequestURI());
        }

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/access-denied");
    }
}
*/