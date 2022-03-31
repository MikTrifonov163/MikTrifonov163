/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Trifonov
 */
public class Subject {

    public static final String tableName = "subject";

    private int subjectId;
    private String name;
    private Connection con;

    public Subject(int subjectId, String name) {
        this.subjectId = subjectId;
        this.name = name;

    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void load(int id ) throws SQLException{
        //Statement st = con.createStatement();
        //ResultSet rs = st.executeQuery("");
        
    }

    

}
