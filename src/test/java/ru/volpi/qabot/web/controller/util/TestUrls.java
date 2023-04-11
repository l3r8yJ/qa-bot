package ru.volpi.qabot.web.controller.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TestUrls {

    public static final String CATEGORIES = "/api/v1/categories";

    public static final String CATEGORY_WITH_ID_102 = "/api/v1/categories/102";

    public static final String NOT_EXISTING_CATEGORY_ID = "/api/v1/categories/4213";

    public static final String NOT_EXISTING_CATEGORY_NAME = "/api/v1/categories/Meh";

    public static final String TEST_CATEGORY = "/api/v1/categories/Test category";

}
