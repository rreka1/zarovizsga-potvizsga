package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private final DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?")
        ) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.executeUpdate();
            return selectIpByPreparedStatement(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not select!", sqle);
        }
    }

    private String selectIpByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("ip_address");
            }
            throw new IllegalArgumentException("Ip address not found!");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not select", sqle);
        }
    }
}
