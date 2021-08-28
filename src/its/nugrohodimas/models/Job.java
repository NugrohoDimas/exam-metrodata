/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.models;

/**
 *
 * @author Dony Tri P
 */
public class Job {
    private String id;
    private String title;
    private Float minSalary;
    private Float maxSalary;

    public Job() {
    }

    public Job(String id, String title, Float minSalary, Float maxSalary) {
        this.id = id;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Float minSalary) {
        this.minSalary = minSalary;
    }

    public Float getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Float maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + 
                ", title=" + title + 
                ", minSalary=" + minSalary + 
                ", maxSalary=" + maxSalary + '}';
    }
}
