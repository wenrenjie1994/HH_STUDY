package work;

import bean.Candidate;
import bean.CandidateList;
import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Action {
    public int addCandidate(Candidate candidate) {
        int line = 0;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "insert into candidate value ('" + candidate.getName() + "','"
                    + candidate.getAge() + "','" + candidate.getGender() + "','"
                    + candidate.getPhoneNumber() + "')";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(statement, connection);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        return line;
    }

    public int deleteCandidateByName(String name) {
        int line = 0;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "delete from candidate where name= '" + name + "'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(statement, connection);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        return line;
    }

    public int deleteCandidateByPhoneNumber(String phoneNumber) {
        int line = 0;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "delete from candidate where phoneNumber= '" + phoneNumber + "'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(statement, connection);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        return line;
    }

    public int updateCandidateByName(String oldName, String name) {
        int line = 0;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "update candidate set name= '" + name + "'where name = '" + oldName + "'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(statement, connection);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        return line;
    }

    public int updateCandidateByAge(String name, int age) {
        int line = 0;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "update candidate set age= '" + age + "'where name = '" + name + "'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(statement, connection);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        return line;
    }

    public int updateCandidateByGender(String name, String gender) {
        int line = 0;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "update candidate set gender= '" + gender + "'where name = '" + name + "'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(statement, connection);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        return line;
    }

    public int updateCandidateByPhoneNumber(String name, String phoneNumber) {
        int line = 0;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "update candidate set phoneNumber= '" + phoneNumber + "'where name = '" + name + "'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(statement, connection);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        return line;
    }


    public CandidateList searchCandidateByName(String name) {
        CandidateList candidates = new CandidateList();
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from candidate where name like '%" + name + "%'";
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                Candidate candidate = new Candidate(set.getString("name"),
                        set.getInt(2), set.getString(3),
                        set.getString(4));
                candidates.add(candidate);
            }
            DBConnection.closeConnection(set, statement, connection);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        return candidates;
    }

    public CandidateList searchCandidateByAge(int age) {
        CandidateList candidates = new CandidateList();
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from candidate where age='" + age + "'";
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                Candidate candidate = new Candidate(set.getString("name"),
                        set.getInt(2), set.getString(3),
                        set.getString(4));
                candidates.add(candidate);
            }
            DBConnection.closeConnection(set, statement, connection);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        return candidates;
    }

    public CandidateList searchCandidateByGender(String Gender) {
        CandidateList candidates = new CandidateList();
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from candidate where gender='" + Gender + "'";
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                Candidate candidate = new Candidate(set.getString("name"),
                        set.getInt(2), set.getString(3),
                        set.getString(4));
                candidates.add(candidate);
            }
            DBConnection.closeConnection(set, statement, connection);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        return candidates;
    }

    public CandidateList searchCandidateByPhoneNumber(String phoneNumber) {
        CandidateList candidates = new CandidateList();
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from candidate where phoneNumber=" + phoneNumber;
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                Candidate candidate = new Candidate(set.getString("name"),
                        set.getInt(2), set.getString(3),
                        set.getString(4));
                candidates.add(candidate);
            }
            DBConnection.closeConnection(set, statement, connection);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.toString());
        }
        return candidates;
    }

    public CandidateList searchCandidateAll() {
        CandidateList candidates = new CandidateList();
        try {
            //创建数据库连接
            Connection connection = DBConnection.getConnection();
            //创建一个Statement，用于将SQL语句发送到数据库
            Statement statement = connection.createStatement();
            String sql = "select * from candidate";
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                Candidate candidate = new Candidate(set.getString("name"),
                        set.getInt(2), set.getString(3),
                        set.getString(4));
                candidates.add(candidate);
            }
            DBConnection.closeConnection(set, statement, connection);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }
        return candidates;
    }
}
