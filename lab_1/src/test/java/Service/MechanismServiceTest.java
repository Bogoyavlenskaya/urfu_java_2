package Service;

import Config.DbConnect;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


class MechanismServiceTest {

    @Test
    @Rollback
    void testCreateNewParent() throws SQLException {
        String fullName="Igor";
        String address="Street Pushkin";
        MechanismService.createNewParent(fullName,address);
        Connection connection = DbConnect.connectDb();
        PreparedStatement selectRow=connection.prepareStatement("select * from parents where fullname=? and address=?");
        selectRow.setString(1,fullName);
        selectRow.setString(2, address);
        ResultSet resultSet=selectRow.executeQuery();
        if(resultSet.next()==true){
         assert true;
        }
        else assert false;
    }

    @Test
    @Rollback
    void createNewChild() throws SQLException {
        String fullName="Marlen";
        int parent_id=1;
        int educationInstitution_id=1;
        MechanismService.createNewChild(fullName,parent_id,educationInstitution_id);
        Connection connection = DbConnect.connectDb();
        PreparedStatement selectRow=connection.prepareStatement("select * from children where fullname=? and parent_id=? and educationalinstitution_id=? ");
        selectRow.setString(1,fullName);
        selectRow.setInt(2, parent_id);
        selectRow.setInt(3, educationInstitution_id);
        ResultSet resultSet=selectRow.executeQuery();
        if(resultSet.next()==true){
            assert true;
        }
        else assert false;

    }

    @Test
    @Rollback
    void changeAddressAndEducationalInstitutionToChild() throws SQLException {
        int childId=1;
        String address="Kutuzov";
        int educationInstitution_id=1;
        MechanismService.changeAddressAndEducationalInstitutionToChild(childId,educationInstitution_id,address);
        Connection connection = DbConnect.connectDb();
        PreparedStatement selectRow=connection.prepareStatement("select * from children join parents p on p.id = children.parent_id\n" +
                "where children.id=? and address=? and educationalinstitution_id=?");
        selectRow.setInt(1,childId);
        selectRow.setString(2, address);
        selectRow.setInt(3, educationInstitution_id);
        ResultSet resultSet=selectRow.executeQuery();
        if(resultSet.next()==true){
            assert true;
        }
        else assert false;
    }
}