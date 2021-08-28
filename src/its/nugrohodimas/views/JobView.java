/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.views;

import its.nugrohodimas.models.Job;
import java.util.List;

/**
 *
 * @author Dony Tri P
 */
public class JobView {
    public void showAllJobs(List<Job> jobs) {
        for (Job j : jobs) {
            System.out.println(j.getId() + " - " + j.getTitle()+ " - "+
                                j.getMinSalary()+ " - " + j.getMaxSalary());
        }
    }
     public void showStatusJobs(boolean status) {
        System.out.println(status?"Query berhasil":"Query gagal");
    }
}
