/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package its.nugrohodimas.controllers;

import its.nugrohodimas.daos.JobDAO;
import its.nugrohodimas.models.Job;
import its.nugrohodimas.views.JobView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dony Tri P
 */
public class JobController implements JobDAO{
    private JobView jobView;
    private Connection connection;

    public JobController(JobView jobView, Connection connection) {
        this.jobView = jobView;
        this.connection = connection;
    }

    @Override
    public List<Job> getAllJobs() {
          List<Job> jobs = new ArrayList<>();
        try {
            ResultSet resultSet = connection.prepareStatement("select * from jobs")
                    .executeQuery();
            while (resultSet.next()) {
                jobs.add(new Job(resultSet.getString(1), resultSet.getString(2), 
                            resultSet.getFloat(3), resultSet.getFloat(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    @Override
    public boolean deleteJob(String id) {
         try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from jobs where id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Job getById(String id) {
        Job job = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM jobs WHERE id=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                job = new Job(resultSet.getString(1), resultSet.getString(2),
                             resultSet.getFloat(3), resultSet.getFloat(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return job;
    }

    @Override
    public boolean saveJob(Job job) {
         try {
            boolean isInsert = getById(job.getId()) == null;
            String query = isInsert
                    ? "INSERT INTO jobs(title, min_salary, max_salary, id) VALUES(?,?,?,?)"
                    : "UPDATE jobs SET title = ?, min_salary = ? , max_salary = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, job.getTitle());
            preparedStatement.setFloat(2, job.getMinSalary());
            preparedStatement.setFloat(3, job.getMaxSalary());
            preparedStatement.setString(4, job.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public void showAllJobs() {
        this.jobView.showAllJobs(getAllJobs());
    }

    public void showSaveJob(Job job) {
        this.jobView.showStatusJobs(saveJob(job));
    }

    public void showDelete(String id) {
        this.jobView.showStatusJobs(deleteJob(id));
    }
}

