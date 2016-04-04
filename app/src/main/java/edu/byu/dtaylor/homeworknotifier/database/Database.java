package edu.byu.dtaylor.homeworknotifier.database;

import android.content.Context;

import java.util.ArrayList;

import edu.byu.dtaylor.homeworknotifier.MainActivity;
import edu.byu.dtaylor.homeworknotifier.gsontools.GsonCourse;
import edu.byu.dtaylor.homeworknotifier.gsontools.GsonDatabase;

/**
 * Created by longl on 4/3/2016.
 */
public class Database {
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Task> tasks = new ArrayList<>();

    public Database(GsonDatabase db)
    {
        for(GsonCourse course : db.getUser().getCourses())
        {
            courses.add(new Course(course));
        }
    }

    public Database(ArrayList<Course> courses, ArrayList<Task> tasks) {
        this.courses = courses;
        this.tasks = tasks;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addTask(Task task, Context context)
    {
        tasks.add(task);
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        dbHelper.insertTask(task);
        dbHelper.close();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
