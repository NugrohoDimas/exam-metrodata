/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.daos;

import its.nugrohodimas.models.Job;
import java.util.List;

/**
 *
 * @author Dony Tri P
 */
public interface JobDAO {
    public List<Job> getAllJobs();

    public boolean deleteJob(String id);

    public Job getById(String id);

    public boolean saveJob(Job job);
}
