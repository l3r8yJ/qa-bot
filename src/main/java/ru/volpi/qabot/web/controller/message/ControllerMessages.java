package ru.volpi.qabot.web.controller.message;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ControllerMessages {

    public static final String REQUESTED_ALL_IN_CONTROLLER
        = "#getAll() called in controller";

    public static final String REQUESTED_CATEGORY_IN_CONTROLLER
        = "Requested category in controller :{}";

    public static final String REGISTRATION_IN_CONTROLLER
        = "Requested registration in controller :{}";

    public static final String UPDATE_IN_CONTROLLER
        = "Requested update in controller :{} : :{}";

    public static final String DELETE_IN_CONTROLLER
        = "Requested delete in controller :{}";

}
