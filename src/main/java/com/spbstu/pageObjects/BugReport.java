package com.spbstu.pageObjects;

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

    int reproducibility;

    int severity;

    int priority;

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

}
