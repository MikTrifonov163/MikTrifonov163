package beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 *
 * @author Trifonov
 */

public class StudDir {

   private String findStr;
    private ArrayList<Stud> studs; 

    public StudDir(){
        this.findStr="";
        studs =     new ArrayList<>();
        
    }
    
    public int getStudsCount(){
        return studs.size();
    }
    
    public Stud[] getStuds(){
        Stud[] res =new Stud[studs.size()];
        studs.toArray(res);
        return  res;
    }
            
  public Stud getStuds(int i) {
        if (i < 0 || i >= studs.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return studs.get(i);
    }

    public void setStuds(int i, Stud ob) {
        if (i < 0 || i >= studs.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        studs.set(i, ob);
    }
    

    public void fill(DataSource ds) throws SQLException {
        studs.clear();
        Connection con = ds.getConnection();
        Statement st = con.createStatement();
        String qu = "SELECT stud_id, age, first_name, last_name, name FROM " + Stud.tableName + " WHERE name LIKE '%" + findStr + "%'";
        ResultSet rs = st.executeQuery(qu);
        while (rs.next()) {
            studs.add(new Stud(rs.getInt("stud_id"), rs.getInt("age"),rs.getString("first_name") ,rs.getString("last_name")));
        }
        rs.close();
        st.close();
        con.close();

    }
}