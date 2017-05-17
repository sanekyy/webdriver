package com.spbstu.pageObjects;

import com.mifmif.common.regex.Generex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by ihb on 11.04.17.
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BugReport {

    int id;

    int categoryId;

    String categoryText;

    int reproducibilityId;

    String reproducibilityText;

    int severityId;

    String severityText;

    int priorityId;

    String priorityText;

    String platform;

    String os;

    String osBuild;

    int handlerId;

    String reporter;

    String assignTo;

    String summary;

    String description;

    String stepsToReproduce;

    String additionalInfo;

    String tagString;

    String status;

    public void initFields() {
        summary = new Generex(summary).random();
        description = new Generex(description).random();
        stepsToReproduce = new Generex(stepsToReproduce).random();
        additionalInfo = new Generex(additionalInfo).random();
        tagString = new Generex(tagString).random();
    }
}
