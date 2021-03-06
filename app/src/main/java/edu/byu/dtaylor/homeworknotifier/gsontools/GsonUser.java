
package edu.byu.dtaylor.homeworknotifier.gsontools;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

import edu.byu.dtaylor.homeworknotifier.database.Course;

public class GsonUser {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("courses")
    @Expose
    private List<Course> courses = new ArrayList<Course>();

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public GsonUser withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * 
     * @param courses
     *     The courses
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public GsonUser withCourses(List<Course> courses) {
        this.courses = courses;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(courses).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GsonUser) == false) {
            return false;
        }
        GsonUser rhs = ((GsonUser) other);
        return new EqualsBuilder().append(id, rhs.id).append(courses, rhs.courses).isEquals();
    }

}
