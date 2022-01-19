package Service;

import Config.DbConnect;


import java.sql.*;
import java.util.Scanner;

public class MechanismService {
    public static void createNewParent(String fullName,String address) throws SQLException {
        Connection connection = DbConnect.connectDb();
        PreparedStatement statement = connection.prepareStatement("insert into parents ( fullname,address) values (?, ?)");
        statement.setString(1, fullName);
        statement.setString(2, address);
        statement.executeUpdate();
    }
    public static void createNewChild(String fullName,int parent_id,int educationalInstitution_id ) throws  SQLException{
        Connection connection = DbConnect.connectDb();
        PreparedStatement selectTable=connection.prepareStatement("select * from educational_institution");
        ResultSet rs=selectTable.executeQuery();
        while (rs.next()){
            System.out.printf(rs.getString(1));
            System.out.printf("%20s",rs.getString(2));
            System.out.printf("%20s",rs.getString(3));
        }
        PreparedStatement statement = connection.prepareStatement("insert into children ( fullname,parent_id,educationalInstitution_id) values (?, ?, ?)");
        statement.setString(1, fullName);
        statement.setLong(2,parent_id);
        statement.setLong(3, educationalInstitution_id);
        statement.executeUpdate();
    }
    public static void changeAddressAndEducationalInstitutionToChild(int id,int educationalInstitution_id,
                                                              String address) throws SQLException {
        Connection connection = DbConnect.connectDb();
        PreparedStatement selectTable=connection.prepareStatement("select * from children");
        ResultSet rs=selectTable.executeQuery();
        System.out.println();
        while (rs.next()){
            System.out.printf(rs.getString(1));
            System.out.printf("%20s",rs.getString(2));
            System.out.printf("%20s",rs.getString(3));
            System.out.printf("%20s",rs.getString(4));
            System.out.println();
        }
        PreparedStatement statement = connection.prepareStatement("update children set educationalInstitution_id =? where id=?");
        statement.setLong(1,educationalInstitution_id);
        statement.setLong(2, id);
        statement.executeUpdate();
        PreparedStatement selectRow=connection.prepareStatement("select * from educationalInstitution where id=?");
        selectRow.setLong(1,id);
        ResultSet result=selectTable.executeQuery();
        String parent_id=null;
        if(result.next()){
            parent_id=result.getString("parent_id");
        }
        PreparedStatement changeAddress = connection.prepareStatement("update parents set address =? where id=?");
        changeAddress.setString(1,address);
        changeAddress.setLong(2, Long.parseLong(parent_id));
        changeAddress.executeUpdate();
    }
}
