package com.myschool.web.branch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myschool.branch.dto.StateDto;
import com.myschool.branch.service.StateService;
import com.myschool.web.application.constants.ApplicationViewNames;
import com.myschool.web.framework.controller.ViewDelegationController;
import com.myschool.web.framework.handler.ViewErrorHandler;
import com.myschool.web.framework.util.HttpUtil;

/**
 * The Class StateController.
 */
@Controller
@RequestMapping("state")
public class StateController {

    /** The state service. */
    @Autowired
    private StateService stateService;

    /** The view error handler. */
    @Autowired
    private ViewErrorHandler viewErrorHandler;

    /**
     * List.
     *
     * @param request the request
     * @param response the response
     * @return the model and view
     * @throws Exception the exception
     */
    @RequestMapping(value="list")
    public ModelAndView list(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return ViewDelegationController.delegateWholePageView(request, ApplicationViewNames.VIEW_STATES);
    }

    /**
     * Json list.
     *
     * @param request the request
     * @param response the response
     * @return the model and view
     * @throws Exception the exception
     */
    @RequestMapping(value="jsonList")
    public ModelAndView jsonList(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        JSONArray data = new JSONArray();
        try {
            for(StateDto state : stateService.getAll()){
                JSONArray row = new JSONArray();
                row.put(state.getStateId());
                row.put(state.getStateName());
                data.put(row);
            }
        } finally {
            HttpUtil.wrapAndWriteAsAAData(response, data);
        }
        return null;
    }

}
