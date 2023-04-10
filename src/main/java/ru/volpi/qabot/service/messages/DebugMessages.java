package ru.volpi.qabot.service.messages;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DebugMessages {
    public static final String CATEGORY_WAS_UPDATED_IN_SERVICE
        = "Category was updated in service :{}";
    public static final String CATEGORY_WAS_SAVED_IN_SERVICE
        = "Category was saved in service :{}";

    public static final String QUESTION_WAS_UPDATED_IN_SERVICE
        = "Question was updated in service :{}";

    public static final String DELETION_CALL_IN_SERVICE
        = "Question deletion requested in service :{}";

    public static final String FIND_BY_ID_CALL_IN_SERVICE
        = "Find by id for id = ':{}' requested in service";

    public static final String FIND_ALL_IN_SERVICE
        = "Find all was called in service";
}
