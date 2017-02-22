/*
 * Copyright (C) 2017 Till Uhlig <till.uhlig@student.uni-halle.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ostepu.structure;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author Till Uhlig <till.uhlig@student.uni-halle.de>
 */
public class exercise extends structure {

    private String id = null;
    private String courseId = null;
    private String sheetId = null;
    private String maxPoints = null;
    private String type = null;
    private String link = null;
    private String bonus = null;
    private String linkName = null;
    private String submittable = null;
    private String resultVisibility = null;

    /**
     * wandelt eine Textdarstellung in ein Objekt um
     *
     * @param content die Texteingabe
     * @return das Objekt
     */
    public static Object decode(String content) {
        JsonElement obj = new JsonParser().parse(String.join("", content));
        if (obj.isJsonNull()) {
            return null;
        }
        JsonObject newObj = obj.getAsJsonObject();
        return new exercise(newObj);
    }

    /**
     * wandelt eine Textdarstellung in ein Objekt um
     *
     * @param content als JSON Objekt (Eingabe)
     * @return das Objekt
     */
    public static Object decode(JsonObject content) {
        return new exercise(content);
    }

    /**
     *
     */
    public exercise() {

    }

    /**
     *
     * @param content
     */
    public exercise(JsonObject content) {
        id = handleStringEntry(content, "id", id);
        courseId = handleStringEntry(content, "courseId", courseId);
        sheetId = handleStringEntry(content, "sheetId", sheetId);
        maxPoints = handleStringEntry(content, "maxPoints", maxPoints);
        type = handleStringEntry(content, "type", type);
        link = handleStringEntry(content, "link", link);
        bonus = handleStringEntry(content, "bonus", bonus);
        linkName = handleStringEntry(content, "linkName", linkName);
        submittable = handleStringEntry(content, "submittable", submittable);
        resultVisibility = handleStringEntry(content, "resultVisibility", resultVisibility);
    }

    /**
     *
     * @return
     */
    @Override
    public String encode() {
        JsonObject tmp = new JsonObject();
        addIfSet(tmp, "id", id);
        addIfSet(tmp, "courseId", courseId);
        addIfSet(tmp, "sheetId", sheetId);
        addIfSet(tmp, "maxPoints", maxPoints);
        addIfSet(tmp, "type", type);
        addIfSet(tmp, "link", link);
        addIfSet(tmp, "bonus", bonus);
        addIfSet(tmp, "linkName", linkName);
        addIfSet(tmp, "submittable", submittable);
        addIfSet(tmp, "resultVisibility", resultVisibility);
        tmp = super.encodeToObject(tmp);
        return tmp.toString();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the sheetId
     */
    public String getSheetId() {
        return sheetId;
    }

    /**
     * @param sheetId the sheetId to set
     */
    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }

    /**
     * @return the maxPoints
     */
    public String getMaxPoints() {
        return maxPoints;
    }

    /**
     * @param maxPoints the maxPoints to set
     */
    public void setMaxPoints(String maxPoints) {
        this.maxPoints = maxPoints;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the bonus
     */
    public String getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    /**
     * @return the linkName
     */
    public String getLinkName() {
        return linkName;
    }

    /**
     * @param linkName the linkName to set
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    /**
     * @return the submittable
     */
    public String getSubmittable() {
        return submittable;
    }

    /**
     * @param submittable the submittable to set
     */
    public void setSubmittable(String submittable) {
        this.submittable = submittable;
    }

    /**
     * @return the resultVisibility
     */
    public String getResultVisibility() {
        return resultVisibility;
    }

    /**
     * @param resultVisibility the resultVisibility to set
     */
    public void setResultVisibility(String resultVisibility) {
        this.resultVisibility = resultVisibility;
    }

}
