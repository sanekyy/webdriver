package com.spbstu.webdriver.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spbstu.pageObjects.BugReport;
import com.spbstu.pageObjects.User;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Map;

/**
 * Created by ihb on 11.04.17.
 */
public class ResourceLoaderSTU {

    private static final String DATA_EPAM_USERS_JSON = "data/epam/users.json";
    private static final String DATA_MANTISBT_USERS_JSON = "data/mantisbt/users.json";
    private static final String DATA_BUG_REPORT_JSON = "data/mantisbt/bugReport.json";

    private static Map<String, User> epamUsers;
    private static Map<String, User> mantisbtUsers;
    private static BugReport bugReport;


    static {
        loadUsers();
        loadBugReport();
    }

    @SneakyThrows
    private static void loadBugReport() {
        String rawData = getRawData(DATA_BUG_REPORT_JSON);
        Type type = new TypeToken<BugReport>(){}.getType();
        bugReport = new Gson().fromJson(rawData, type);
    }

    @SneakyThrows
    private static void loadUsers(){
        String rawData = getRawData(DATA_EPAM_USERS_JSON);
        Type type = new TypeToken<Map<String, User>>(){}.getType();
        epamUsers = new Gson().fromJson(rawData, type);

        rawData = getRawData(DATA_MANTISBT_USERS_JSON);
        type = new TypeToken<Map<String, User>>(){}.getType();
        mantisbtUsers = new Gson().fromJson(rawData, type);
    }

    private static String getRawData(String path) throws IOException {
        URL resource = ResourceLoaderSTU.class.getClassLoader().getResource(path);
        return IOUtils.toString(resource, "utf-8");
    }

    public static User getEpamUser(String key) {
        return epamUsers.get(key);
    }

    public static User getMantisbtUser(String key) {
        return mantisbtUsers.get(key);
    }

    public static BugReport getBugReport() {
        return bugReport;
    }
}
